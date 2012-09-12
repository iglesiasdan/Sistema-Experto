/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sisexpv1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * 
 */
public class Principal implements ActionListener ,Runnable{
    //Diseño
    private JFrame jfMain;
    private JPanel jpNorte;
    private JPanel jpSur;
    private JPanel jpEste;
    private JPanel jpOeste;
    protected JPanel jpCentro;
    private JScrollPane jsPrincipal;
    private JToolBar tb;
    private JButton b[];
    private JButton btSession;
    private JTree tree;
    //Ayuda
    private HelpSet helpset;
    private URL hsURL;
    private File fichero;
    private HelpBroker hb;
    //Datos
    private   String usuario;
    //hilo de la hora
    Thread crono;
    
    private JLabel tiempo;
    public Principal(String user) throws MalformedURLException, HelpSetException {
        usuario = user;                
        InitComponent();
        InitAyuda();
    }
    public final void InitAyuda() throws MalformedURLException, HelpSetException{
        fichero = new File("help/help_set.hs");
        hsURL = fichero.toURI().toURL();
        helpset = new HelpSet(getClass().getClassLoader(), hsURL);
        hb = helpset.createHelpBroker();        
        hb.enableHelpOnButton(b[4], "aplicacion", helpset);
    }
    public final void InitComponent(){
        //--JFrame principal
        JFrame.setDefaultLookAndFeelDecorated(false);        
        jfMain = new JFrame("Sistema Experto Para Evaluar la Procedibilidad de las Demandas de Amparo Laboral (V 1.0)");
        jfMain.setLayout(new BorderLayout());
        jfMain.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height-30);
        
        //--JPanel Norte
        jpNorte = new JPanel();        
        jpNorte.setLayout(new BorderLayout());
        jpNorte.setBackground(Color.white);
        //--JPanel Este
        jpEste = new JPanel();
        jpEste.setLayout(new FlowLayout());
        jpEste.setBorder(new TitledBorder(new EtchedBorder(),"Ayuda"));        
        //--JPanel Cento
        jpCentro = new JPanel();
        jpCentro.setLayout(new BorderLayout());
        //jpCentro.setBorder(new BevelBorder(BevelBorder.LOWERED));
        jpCentro.setBackground(Color.white);
        jsPrincipal = new JScrollPane(jpCentro);
        //--JPanel Oeste
        jpOeste = new JPanel();
        jpOeste.setLayout(new FlowLayout());
        jpOeste.setBorder(new TitledBorder(new EtchedBorder(),"Arbol de Seguimiento"));
        //--JPanel Sur
        jpSur = new JPanel();
        jpSur.setLayout(new FlowLayout());
        jpSur.setBorder(new EtchedBorder());
        
        //--Init JPanels
        InitComponentNorte();
        //InitComponentEste();
        InitComponentCentro();
        //InitComponentOeste();
        InitComponentSur();

        jfMain.add(jpNorte,BorderLayout.NORTH);
        //jfMain.add(jpEste,BorderLayout.EAST);
        jfMain.add(jsPrincipal,BorderLayout.CENTER);
        //jfMain.add(jpOeste,BorderLayout.WEST);
        jfMain.add(jpSur,BorderLayout.SOUTH);
      
        jfMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        jfMain.setVisible(true);

        //hilo de la hora
        crono = new Thread(this);
	crono.start();
    }
    private void InitComponentNorte(){        
        ImageIcon imagen = new ImageIcon("imagenes/Banner.png");
        JLabel jlBanner = new JLabel(imagen,JLabel.LEFT);
        ImageIcon imagenUser = new ImageIcon("imagenes/cliente.png");
        JLabel lbUsuario = new JLabel(usuario+"  ",imagenUser,JLabel.RIGHT);
        ImageIcon imagenSession = new ImageIcon("imagenes/cerrar.gif");
        JToolBar jtSession = new JToolBar();
        jtSession.setFloatable(false);
        btSession = new JButton("Cerrar Sesión"+"  ",imagenSession);
        btSession.addActionListener(this);
        jtSession.add(btSession);
        ImageIcon imagenDate = new ImageIcon("imagenes/appointment-new.png");        
        tiempo = new JLabel(imagenDate,JLabel.RIGHT);

        tb = new JToolBar();
        tb.setFloatable(false);
        //tb.setBorder(new EtchedBorder());
        b = new JButton[6];
        b[0] = new JButton(new ImageIcon("imagenes/go-home.png"));
        b[0].setText("Inicio");
        b[0].addActionListener(this);
        tb.add(b[0]);
        //tb.addSeparator(new Dimension(20,32));
        b[1] = new JButton(new ImageIcon("imagenes/document-properties.png"));
        b[1].setText("Archivo");
        b[1].addActionListener(this);
        tb.add(b[1]);
        //tb.addSeparator(new Dimension(20,32));
        b[2] = new JButton(new ImageIcon("imagenes/document-print.png"));
        b[2].setText("Reporte Requisitos y Criterios");
        b[2].addActionListener(this);
        tb.add(b[2]);
        //tb.addSeparator(new Dimension(20,32));
        b[3] = new JButton(new ImageIcon("imagenes/system-search.png"));
        b[3].setText("Buscar");
        b[3].addActionListener(this);
        tb.add(b[3]);
        //tb.addSeparator(new Dimension(20,32));
        b[4] = new JButton(new ImageIcon("imagenes/help-faq.png"));
        b[4].setText("Ayuda");
        b[4].addActionListener(this);
        tb.add(b[4]);
        //tb.addSeparator(new Dimension(20,32));
        b[5] = new JButton(new ImageIcon("imagenes/system-lock-screen.png"));
        b[5].setText("Acerca de");
        b[5].addActionListener(this);
        tb.add(b[5]);

        JPanel jpDatos = new JPanel(new BorderLayout());
        jpDatos.setBorder(new EtchedBorder());

        JPanel jpDelUsuario = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jpDelUsuario.add(tiempo);
        jpDelUsuario.add(lbUsuario);
        jpDelUsuario.add(jtSession);
        
        jpDatos.add(tb,BorderLayout.WEST);
        jpDatos.add(jpDelUsuario,BorderLayout.CENTER);

        jpNorte.add(jlBanner,BorderLayout.NORTH);        
        jpNorte.add(jpDatos,BorderLayout.CENTER);
    }
    private void InitComponentEste(String nota){
        jpEste.removeAll();
        jfMain.add(jpEste,BorderLayout.EAST);
        JLabel lbN1 = new JLabel("<html><div style='width:150px' align='justify'>"+nota+"</div></html>");
        lbN1.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.gray),"Nota"));        
        jpEste.add(lbN1);
        jpEste.updateUI();
    }
    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode categoria = null;
        DefaultMutableTreeNode book = null;

        categoria = new DefaultMutableTreeNode("Requisitos");
        top.add(categoria);

        //Regimen laboral privado
        categoria = new DefaultMutableTreeNode("Régimen Laboral Privado");
        top.add(categoria);

        //despido fraudulento
        book = new DefaultMutableTreeNode("Despido Fraudulento");
        categoria.add(book);

        //despido nulo
        book = new DefaultMutableTreeNode("Despido Nulo");        
        categoria.add(book);        

        //despido incausado
        book = new DefaultMutableTreeNode("Despido Incausado");
        categoria.add(book);

        //despido injustificado
        book = new DefaultMutableTreeNode("Despido Injustificado");
        categoria.add(book);

        //Otros
        book = new DefaultMutableTreeNode("Improcedencia Liminar");
        categoria.add(book);

        //Regimen laboral publico
        categoria = new DefaultMutableTreeNode("Régimen Laboral Público");
        top.add(categoria);

        book = new DefaultMutableTreeNode("Régimen Laboral Público");
        categoria.add(book);

    }
    private void InitComponentOeste(){
        final Principal principal = this;
        //Creacion de nodos
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Amparo Laboral");
        createNodes(top);

        //Creacion del arbol
        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        //tree.setEnabled(false);
        //eventos del arbol
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)(e.getPath().getLastPathComponent());
                Object nodeInfo = node.getUserObject();                
                
                if (node.isRoot() || (node==null) ||!(node.isLeaf())) return;
                String nodoAlumno=node.getUserObject().toString();                
                        
                if(nodoAlumno.equals("Requisitos")){                    
                    jpCentro.removeAll();
                    jpCentro.add(new Requisitos(usuario,principal),BorderLayout.CENTER);
                    jpCentro.updateUI();
                    InitComponentEste("En esta parte podrá evaluar los requisitos tanto del Código Procesal Civil, de aplicación supletoria, como los señalados en los artículos pertinentes del Código Procesal Constitucional.");
                }                
                if(nodoAlumno.equals("Despido Fraudulento")){
                    jpCentro.removeAll();
                    jpCentro.add(new Fraudulento(usuario),BorderLayout.CENTER);
                    jpCentro.updateUI();
                    InitComponentEste("En esta parte se podrá evaluar los criterios señalados en los precedentes vinculantes del Tribunal Constitucional: STC 206-2005-PA/TC,(Caso Baylón Flores)y el recientemente publicado: STC 03052-2009-PA/TC, (caso Yolanda Lara Garay),además de la sentencia recaída en el expediente  STC  STC 976-2001-AA/TC, (Caso Llanos Huasco) para los casos del Régimen Laboral Privado.");
                }
                if(nodoAlumno.equals("Despido Nulo")){
                    jpCentro.removeAll();
                    jpCentro.add(new Nulo(usuario),BorderLayout.CENTER);
                    jpCentro.updateUI();
                    InitComponentEste("En esta parte se podrá evaluar los criterios señalados en los precedentes vinculantes del Tribunal Constitucional: STC 206-2005-PA/TC,(Caso Baylón Flores)y el recientemente publicado: STC 03052-2009-PA/TC, (caso Yolanda Lara Garay),además de la sentencia recaída en el expediente  STC  STC 976-2001-AA/TC, (Caso Llanos Huasco) para los casos del Régimen Laboral Privado.");
                }
                if(nodoAlumno.equals("Despido Injustificado")){
                    jpCentro.removeAll();
                    jpCentro.add(new Injustificado(usuario),BorderLayout.CENTER);
                    jpCentro.updateUI();
                    InitComponentEste("En esta parte se podrá evaluar los criterios señalados en los precedentes vinculantes del Tribunal Constitucional: STC 206-2005-PA/TC,(Caso Baylón Flores)y el recientemente publicado: STC 03052-2009-PA/TC, (caso Yolanda Lara Garay),además de la sentencia recaída en el expediente  STC  STC 976-2001-AA/TC, (Caso Llanos Huasco) para los casos del Régimen Laboral Privado.");
                }
                if(nodoAlumno.equals("Despido Incausado")){
                    jpCentro.removeAll();
                    jpCentro.add(new Incausado(usuario),BorderLayout.CENTER);
                    jpCentro.updateUI();
                    InitComponentEste("En esta parte se podrá evaluar los criterios señalados en los precedentes vinculantes del Tribunal Constitucional: STC 206-2005-PA/TC,(Caso Baylón Flores)y el recientemente publicado: STC 03052-2009-PA/TC, (caso Yolanda Lara Garay),además de la sentencia recaída en el expediente  STC  STC 976-2001-AA/TC, (Caso Llanos Huasco) para los casos del Régimen Laboral Privado.");
                }                
                if(nodoAlumno.equals("Improcedencia Liminar")){
                    jpCentro.removeAll();
                    ImageIcon imagen1 = new ImageIcon("imagenes/otros.png");
                    JLabel lbN2 = new JLabel(imagen1);                    
                    jpCentro.add(lbN2,BorderLayout.CENTER);
                    jpCentro.updateUI();
                    String rpt="";
                    rpt= JOptionPane.showInputDialog(null,"<html><p align='center'>No se cumple con los Requisitos</p><br><p align='center'>Ingrese el Nro expediente para generar reporte</p><br></html>","Alerta", JOptionPane.WIDTH);
                    if(!(rpt==null)){
                        ArrayList a =new ArrayList();
                        a.add("Improcedencia Liminar");
                        ArrayList b =new ArrayList();
                        b.add("TODAS ESTAS PRETENSIONES SERÁN DECLARADAS IMPROCEDENTES EN LA VIA DEL PROCESO DE AMPARO, CONFORME A LOS FUNDAMENTOS 17 Y 18  DEL PRECEDENTE VINCULANTE (SENTENCIA STC 206-2005-PA/TC) DEL TRIBUNAL CONSTITUCIONAL, LOS MISMOS QUE SEÑALAN A LA LEY 26636 COMO AQUELLA QUE PREVEIA LA COMPETENCIA POR RAZÓN DE L A MATERIA DE LOS JUZGADOS DE TRABAJO Y SALAS LABORALES, QUE A PARTIR DE LA VIGENCIA DE LA LEY Nº 29497 (14-01-2010) HA SIDO DEROGADA Y REGULADA DICHA COMPETENCIA POR ESTA NUEVA LEY.");
                        GenerarPDF aa=new GenerarPDF(true,false,usuario,rpt,a,b);
                        if(!(rpt.equals("")))
                            aa.AbrirPDF();
                    }
                    InitComponentEste("Esta parte del sistema no evalua la procedibilidad, sino solamente le advierte que en otros casos no considerados en las opciones anteriores la improcedencia es liminar");
                }
                if(nodoAlumno.equals("Régimen Laboral Público")){
                    jpCentro.removeAll();
                    jpCentro.add(new RegimenPublico(usuario),BorderLayout.CENTER);
                    jpCentro.updateUI();
                    InitComponentEste("En esta parte se podrá evaluar los criterios señalados en el precedente vinculantes del Tribunal Constitucional: STC 206-2005-PA/TC,(Caso Baylón Flores) para los casos del Régimen Laboral Público.");
                }
            }
        });
        JScrollPane treeView = new JScrollPane(tree);
        Dimension minimumSize = new Dimension(200, 100);        
        treeView.setMinimumSize(minimumSize);        
        jpOeste.add(treeView);        
    }
    protected void InitComponentCentro(){
        jpCentro.removeAll();
        jpOeste.removeAll();
        jpEste.removeAll();
        jfMain.remove(jpOeste);
        jfMain.remove(jpEste);        
        ImageIcon imagen = new ImageIcon("imagenes/bienvenida.png");
        JLabel lbN1 = new JLabel(imagen);        
        JButton ingresar = new JButton("Empezar procedimiento");
        ingresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InitComponentOeste();
                jfMain.add(jpOeste,BorderLayout.WEST);
                tree.setSelectionRow(1);
                tree.expandRow(1);
            }
        });
        JPanel paraboton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        paraboton.setBackground(Color.white);        
        paraboton.add(ingresar);
        
        jpCentro.add(lbN1,BorderLayout.CENTER);
        jpCentro.add(paraboton,BorderLayout.SOUTH);
        jpCentro.updateUI();        
    }
    protected void EscogerRegimenComponentCentro(){
        ImageIcon imagen = new ImageIcon("imagenes/escogerregimen.png");
        JLabel lbN1 = new JLabel(imagen);
        JButton Rprivado = new JButton("Regimen Privado");
        Rprivado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jpCentro.removeAll();
                RegimenPrivadoComponentCentro();
                tree.setSelectionRow(2);
                tree.expandRow(2);                                
                jpCentro.updateUI();
                InitComponentEste("En esta parte se podrá evaluar los criterios señalados en los precedentes vinculantes del Tribunal Constitucional: STC 206-2005-PA/TC,(Caso Baylón Flores)y el recientemente publicado: STC 03052-2009-PA/TC, (caso Yolanda Lara Garay),además de la sentencia recaída en el expediente  STC  STC 976-2001-AA/TC, (Caso Llanos Huasco) para los casos del Régimen Laboral Privado.");
            }
        });
        JButton Rpublico = new JButton("Regimen Publico");
        Rpublico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jpCentro.removeAll();
                RegimenPublicoComponentCentro();
                tree.setSelectionRow(3);
                //tree.setSelectionInterval(3,0);
                tree.expandRow(3);
                jpCentro.updateUI();
                InitComponentEste("En esta parte se podrá evaluar los criterios señalados en el precedente vinculantes del Tribunal Constitucional: STC 206-2005-PA/TC,(Caso Baylón Flores) para los casos del Régimen Laboral Público.");
            }
        });
        JPanel horizontal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        horizontal.setBackground(Color.white);
        horizontal.add(Rprivado);
        horizontal.add(Rpublico);                        

        jpCentro.add(lbN1,BorderLayout.CENTER);
        jpCentro.add(horizontal,BorderLayout.SOUTH);
    }
    protected void RegimenPrivadoComponentCentro(){        
        ImageIcon imagen = new ImageIcon("imagenes/regimenprivado.png");
        JLabel lbN1 = new JLabel(imagen);
        JButton Dfraudulento = new JButton("Despido Fraudulento");
        Dfraudulento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jpCentro.removeAll();                
                tree.setSelectionInterval(5,3);
                //jpCentro.add(new Fraudulento(usuario));
                jpCentro.updateUI();
            }
        });
        JButton Dnulo = new JButton("Despido Nulo");
        Dnulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jpCentro.removeAll();
                tree.setSelectionInterval(5,4);
                //jpCentro.add(new Nulo(usuario));
                jpCentro.updateUI();
            }
        });
        JButton Dincausado = new JButton("Despido Incausado");
        Dincausado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jpCentro.removeAll();
                tree.setSelectionInterval(5,5);
                //jpCentro.add(new Incausado(usuario));
                jpCentro.updateUI();
            }
        });
        JButton Dinjustificado = new JButton("Despido Injustificado");
        Dinjustificado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jpCentro.removeAll();
                //tree.setSelectionInterval(2,5);
                jpCentro.add(new Injustificado(usuario));
                jpCentro.updateUI();
            }
        });
        JButton Otros = new JButton("Improcedencia Liminar");


        Otros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jpCentro.removeAll();
                //tree.setSelectionInterval(2,2);
                ImageIcon imagen1 = new ImageIcon("imagenes/otros.png");
                JLabel lbN2 = new JLabel(imagen1);                            
                jpCentro.add(lbN2,BorderLayout.CENTER);
                jpCentro.updateUI();

            }
        });
        JPanel horizontal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        horizontal.setBackground(Color.white);        
        horizontal.add(Dfraudulento);
        horizontal.add(Dnulo);
        horizontal.add(Dincausado);
        horizontal.add(Dinjustificado);
        horizontal.add(Otros);        
        
        jpCentro.add(lbN1,BorderLayout.CENTER);
        jpCentro.add(horizontal,BorderLayout.SOUTH);
    }
    protected void RegimenPublicoComponentCentro(){
        jpCentro.removeAll();
        jpCentro.add(new RegimenPublico(usuario));
        jpCentro.updateUI();
    }
    private void InitComponentSur(){
        JLabel lbN1 = new JLabel("Sistema Experto en Amparo Laboral");
        jpSur.add(lbN1);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b[0]){                                    
            InitComponentCentro();            
        }
        if(ae.getSource() == b[1]){
            JOptionPane.showMessageDialog(jfMain,"En Proceso");
        }
        if(ae.getSource() == b[2]){
            GenerarAll a=new GenerarAll();
            a.AbrirPDF();
        }
        if(ae.getSource() == b[3]){
            JOptionPane.showMessageDialog(jfMain,"En Proceso");
        }
        if(ae.getSource() == b[4]){                                                                                               
            JFrame ayuda = new JFrame("Ayuda");            
            hb.enableHelpKey(ayuda.getContentPane(), "ventana_principal",helpset);
            hb.enableHelpKey(ayuda.getContentPane(), "ventana_secundaria",helpset);
        }
        if(ae.getSource() == b[5]){
            Acercade nuevo = new Acercade();
        }
        //cerrar sessión
        if(ae.getSource() == btSession){
            int result = JOptionPane.showConfirmDialog(null,"Esta seguro de cerrar la sesión actual?","Alerta",JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                jfMain.setVisible(false);
                jfMain.dispose();
                Inicio login = new Inicio();
            }            
        }
    }
    public void run() {
        int horas=0,minutos=0,segundos=0;
        GregorianCalendar calendario=new GregorianCalendar();
        horas=calendario.get(GregorianCalendar.HOUR);
        minutos=calendario.get(GregorianCalendar.MINUTE);
        segundos=calendario.get(GregorianCalendar.SECOND);
        try {
        for(;;)
        {
                if(segundos==59) { segundos=0; minutos++; }
                if(minutos==59) { minutos=0; horas++; }
                segundos++;
                tiempo.setText(horas+":"+minutos+":"+segundos+"   ");
                crono.sleep(1000);
        }
        }
        catch (InterruptedException e) { System.out.println(e.getMessage()); }
    }
}
