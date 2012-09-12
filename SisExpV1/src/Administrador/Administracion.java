/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Administrador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import sisexpv1.Inicio;
//import sun.util.calendar.BaseCalendar.Date;

/**
 *
 * 
 */
public class Administracion implements ActionListener ,Runnable {
    //Diseño
    private JFrame jfMain;
    private JPanel jpNorte;
    private JPanel jpSur;
    private JPanel jpEste;
    private JPanel jpOeste;
    private JPanel jpCentro;

    private JToolBar tb;
    private JButton b[];
    private JButton btSession;

    final ArchivoData archivo;
    final ArrayList<String> lista;

    //tabla
    ButtonGroup collecion;
    //Datos
    private String usuario;
    //hilo de la hora
    Thread crono;
    private JLabel tiempo;
    public Administracion(String user) throws IOException {
        usuario = user;
        archivo = new ArchivoData("archivos/usuarios.txt");
        lista = archivo.ListarContenidoUsuario(usuario);        
        InitComponent();
    }
    public final void InitComponent() throws IOException{
        //--JFrame principal
        jfMain = new JFrame("Sistema Experto - Módulo de Administración");
        jfMain.setLayout(new BorderLayout());
        jfMain.setLayout(new BorderLayout());
        jfMain.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height-30);
        
        //--JPanel Norte
        jpNorte = new JPanel();
        jpNorte.setLayout(new BorderLayout());
        jpNorte.setBackground(Color.WHITE);
        //--JPanel Este
        //jpEste = new JPanel();
        //jpEste.setLayout(new FlowLayout());
        //jpEste.setBorder(new TitledBorder(new EtchedBorder(),"Ayuda"));
        //--JPanel Cento
        jpCentro = new JPanel();
        jpCentro.setLayout(new BorderLayout());
        jpCentro.setBorder(new BevelBorder(BevelBorder.LOWERED));
        jpCentro.setBackground(Color.white);
        //--JPanel Oeste
        //jpOeste = new JPanel();
        //jpOeste.setLayout(new FlowLayout());
        //--JPanel Sur
        jpSur = new JPanel();
        jpSur.setLayout(new FlowLayout());
        jpSur.setBorder(new EtchedBorder());

        //--Init JPanels
        InitComponentNorte();
        InitComponentEste();
        InitComponentCentro();
        InitComponentOeste();
        InitComponentSur();

        jfMain.add(jpNorte,BorderLayout.NORTH);
        //jfMain.add(jpEste,BorderLayout.EAST);
        jfMain.add(jpCentro,BorderLayout.CENTER);
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
        b[1] = new JButton(new ImageIcon("imagenes/contact-new.png"));
        b[1].setText("Mi Info");
        b[1].addActionListener(this);
        tb.add(b[1]);
        //tb.addSeparator(new Dimension(20,32));
        b[2] = new JButton(new ImageIcon("imagenes/system-log-out.png"));
        b[2].setText("Usuarios");
        b[2].addActionListener(this);
        tb.add(b[2]);
        //tb.addSeparator(new Dimension(20,32));
        b[3] = new JButton(new ImageIcon("imagenes/address-book-new.png"));
        b[3].setText("Reportes");
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
        jpDatos.add(jpDelUsuario,BorderLayout.EAST);

        jpNorte.add(jlBanner,BorderLayout.NORTH);
        jpNorte.add(jpDatos,BorderLayout.CENTER);        
    }
    private void InitComponentEste(){
        //JLabel lbN1 = new JLabel("<html><div style='width:150px' align='justify'>Se tendra en cuenta las condiciones de uso de las preguntas con la responsabilidad pertinente del usuario.</div></html>");
        //lbN1.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.gray),"Nota"));
        //jpEste.add(lbN1);
    }    
    private void InitComponentOeste(){        
    }
    private void InitComponentCentro() throws IOException{
        jpCentro.removeAll();
        ArchivoData archivo = new ArchivoData("archivos/usuarios.txt");
        JLabel lbN1 = new JLabel("asdfdf"+archivo.MostrarContenido().get(0).get(0));
        lbN1.setBorder(BorderFactory.createEtchedBorder());
        jpCentro.add(lbN1,BorderLayout.CENTER);
        jpCentro.updateUI();
    }
    private void InitComponentSur(){
        JLabel lbN1 = new JLabel("Sistema Experto en Amparo Laboral");
        jpSur.add(lbN1);
    }
    public void actionPerformed(ActionEvent ae) {
        //Menu
        if(ae.getSource() == b[0]){
            try {
                InitComponentCentro();
            } catch (IOException ex) {
                Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ae.getSource() == b[1]){
            InitModuloPerfil();
        }
        if(ae.getSource() == b[2]){
            InitModuloUsuarios();
        }
        if(ae.getSource() == b[3]){
            InitModuloReportes();
        }
        if(ae.getSource() == b[4]){
            JOptionPane.showMessageDialog(jfMain,"Ayuda");
        }
        if(ae.getSource() == b[5]){
            JOptionPane.showMessageDialog(jfMain,"Acerca de");
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
    public void InitModuloUsuarios(){
        jpCentro.removeAll();
        ModeloTabla nuevo = new ModeloTabla();
        final JTable tablaDatos = new JTable(nuevo);
        tablaDatos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        //tablaDatos.setColumnSelectionAllowed(true);
        //tablaDatos.setCellSelectionEnabled(true);
        //tablaDatos.setRowSelectionAllowed(true);
        collecion = new ButtonGroup();        
        tablaDatos.setDefaultEditor(Volume.class,new TablaEditor(collecion));
        //tablaDatos.setColumnSelectionAllowed(true);
        tablaDatos.setDefaultRenderer(Volume.class,new TablaRenderer());
        tablaDatos.setRowHeight(20);
        JScrollPane scrolltabla = new JScrollPane(tablaDatos);
        JPanel contenido = new JPanel(new BorderLayout());
        ImageIcon imagenUsuarios = new ImageIcon("imagenes/system-log-out.png");
        JLabel imagen = new JLabel("Gestión de Usuarios", imagenUsuarios, JLabel.LEFT);
        Box panelButton = new Box(BoxLayout.X_AXIS);
        JButton opcion = new JButton("Editar",imagenUsuarios);
        opcion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int indice = tablaDatos.getSelectedRow();
                EditarUsuario(indice);
            }
        });
        panelButton.add(opcion);
        opcion = new JButton("Añadir",imagenUsuarios);
        panelButton.add(opcion);
        opcion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame ventana = new JFrame("Editar");
            }
        });
        opcion = new JButton("Eliminar",imagenUsuarios);
        opcion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                
                EditarUsuario(2);
            }
        });
        panelButton.add(opcion);
        contenido.add(imagen,BorderLayout.WEST);
        contenido.add(panelButton,BorderLayout.EAST);
        
        jpCentro.add(contenido,BorderLayout.NORTH);
        jpCentro.add(scrolltabla,BorderLayout.CENTER);
        jpCentro.updateUI();
    }
    public void EditarUsuario(final int indiceUser){
        final ArrayList<ArrayList<String>> listar = archivo.listar;
        JFrame ventana = new JFrame("Editar");
        ventana.setSize(600,400);
        
        JLabel jlUsuario = new JLabel("Usuario :",JLabel.RIGHT);
        final JTextField jtUsuario = new JTextField(listar.get(indiceUser).get(0),20);

        JLabel jlPassword = new JLabel("Password :",JLabel.RIGHT);
        final JTextField jtPassword = new JTextField(listar.get(indiceUser).get(1),20);

        JLabel jlPrivilegio = new JLabel("Privilegio :",JLabel.RIGHT);
        final JTextField jtPrivilegio = new JTextField(listar.get(indiceUser).get(2),20);

        JLabel jlEstado = new JLabel("Estado :",JLabel.RIGHT);
        final JTextField jtEstado = new JTextField(listar.get(indiceUser).get(3),20);

        JLabel jlNombres = new JLabel("Nombres :",JLabel.RIGHT);
        final JTextField jtNombres = new JTextField(listar.get(indiceUser).get(4),20);

        JLabel jlApellidos = new JLabel("Apellidos :",JLabel.RIGHT);
        final JTextField jtApellidos = new JTextField(listar.get(indiceUser).get(5),20);

        JLabel jlCargo = new JLabel("Cargo :",JLabel.RIGHT);
        final JTextField jtCargo = new JTextField(listar.get(indiceUser).get(6),20);

        JLabel jlTiempo_uso = new JLabel("Tiempo de Uso :",JLabel.RIGHT);
        final JTextField jtTiempo_uso = new JTextField(listar.get(indiceUser).get(7),20);

        final JPanel panelMiInfo = new JPanel(new GridLayout(8,2,50,10));
        panelMiInfo.setBackground(Color.white);
        panelMiInfo.add(jlUsuario);
        panelMiInfo.add(jtUsuario);
        panelMiInfo.add(jlPassword);
        panelMiInfo.add(jtPassword);
        panelMiInfo.add(jlPrivilegio);
        panelMiInfo.add(jtPrivilegio);
        panelMiInfo.add(jlEstado);
        panelMiInfo.add(jtEstado);
        panelMiInfo.add(jlNombres);
        panelMiInfo.add(jtNombres);
        panelMiInfo.add(jlApellidos);
        panelMiInfo.add(jtApellidos);
        panelMiInfo.add(jlCargo);
        panelMiInfo.add(jtCargo);
        panelMiInfo.add(jlTiempo_uso);
        panelMiInfo.add(jtTiempo_uso);

        JPanel panelMiInfoMain = new JPanel(new FlowLayout());
        panelMiInfoMain.setBackground(Color.white);
        panelMiInfoMain.add(panelMiInfo,FlowLayout.LEFT);

        JPanel contenido = new JPanel(new BorderLayout());
        ImageIcon imagenMiInfo = new ImageIcon("imagenes/contact-new.png");
        JLabel imagen = new JLabel("Mi Información", imagenMiInfo, JLabel.LEFT);
        contenido.add(imagen,BorderLayout.NORTH);

        JButton guardar = new JButton("Guardar");
        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,"Esta seguro de actualizar sus datos?","Alerta",JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    listar.get(indiceUser).set(0,jtUsuario.getText());
                    listar.get(indiceUser).set(1,jtPassword.getText());
                    listar.get(indiceUser).set(2,jtPrivilegio.getText());
                    listar.get(indiceUser).set(3,jtEstado.getText());
                    listar.get(indiceUser).set(4,jtNombres.getText());
                    listar.get(indiceUser).set(5,jtApellidos.getText());
                    listar.get(indiceUser).set(6,jtCargo.getText());
                    listar.get(indiceUser).set(7,jtTiempo_uso.getText());
                    archivo.EscribirContenido();
                    jpCentro.updateUI();
                }
            }
        });
        JButton reestablecer = new JButton("Reestablecer");
        reestablecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,"Esta seguro de realizar esta acción?","Alerta",JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    jtUsuario.setText(listar.get(indiceUser).get(0));
                    jtPassword.setText(listar.get(indiceUser).get(1));
                    jtPrivilegio.setText(listar.get(indiceUser).get(2));
                    jtEstado.setText(listar.get(indiceUser).get(3));
                    jtNombres.setText(listar.get(indiceUser).get(4));
                    jtApellidos.setText(listar.get(indiceUser).get(5));
                    jtCargo.setText(listar.get(indiceUser).get(6));
                    jtTiempo_uso.setText(listar.get(indiceUser).get(7));
                    jpCentro.updateUI();
                }
            }
        });
        JPanel panelButton = new JPanel();
        panelButton.add(guardar);
        panelButton.add(reestablecer);

        ventana.getContentPane().add(panelMiInfoMain,BorderLayout.WEST);
        ventana.getContentPane().add(panelButton,BorderLayout.SOUTH);
        ventana.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-(ventana.getWidth()/2),(Toolkit.getDefaultToolkit().getScreenSize().height/2)-(ventana.getHeight()/2));
        ventana.setVisible(true);        
    }
    public void InitModuloPerfil(){                
        jpCentro.removeAll();
        JLabel jlUsuario = new JLabel("Usuario :",JLabel.RIGHT);
        final JTextField jtUsuario = new JTextField(lista.get(0),20);

        JLabel jlPassword = new JLabel("Password :",JLabel.RIGHT);
        final JTextField jtPassword = new JTextField(lista.get(1),20);

        JLabel jlPrivilegio = new JLabel("Privilegio :",JLabel.RIGHT);
        final JTextField jtPrivilegio = new JTextField(lista.get(2),20);

        JLabel jlEstado = new JLabel("Estado :",JLabel.RIGHT);
        final JTextField jtEstado = new JTextField(lista.get(3),20);

        JLabel jlNombres = new JLabel("Nombres :",JLabel.RIGHT);
        final JTextField jtNombres = new JTextField(lista.get(4),20);

        JLabel jlApellidos = new JLabel("Apellidos :",JLabel.RIGHT);
        final JTextField jtApellidos = new JTextField(lista.get(5),20);

        JLabel jlCargo = new JLabel("Cargo :",JLabel.RIGHT);
        final JTextField jtCargo = new JTextField(lista.get(6),20);

        JLabel jlTiempo_uso = new JLabel("Tiempo de Uso :",JLabel.RIGHT);
        final JTextField jtTiempo_uso = new JTextField(lista.get(7),20);

        final JPanel panelMiInfo = new JPanel(new GridLayout(8,2,50,10));
        panelMiInfo.setBackground(Color.white);
        panelMiInfo.add(jlUsuario);
        panelMiInfo.add(jtUsuario);        
        panelMiInfo.add(jlPassword);
        panelMiInfo.add(jtPassword);
        panelMiInfo.add(jlPrivilegio);
        panelMiInfo.add(jtPrivilegio);
        panelMiInfo.add(jlEstado);                       
        panelMiInfo.add(jtEstado);        
        panelMiInfo.add(jlNombres);
        panelMiInfo.add(jtNombres);
        panelMiInfo.add(jlApellidos);
        panelMiInfo.add(jtApellidos);
        panelMiInfo.add(jlCargo);
        panelMiInfo.add(jtCargo);
        panelMiInfo.add(jlTiempo_uso);                                
        panelMiInfo.add(jtTiempo_uso);
                   
        JPanel panelMiInfoMain = new JPanel(new FlowLayout());
        panelMiInfoMain.setBackground(Color.white);
        panelMiInfoMain.add(panelMiInfo,FlowLayout.LEFT);

        JPanel contenido = new JPanel(new BorderLayout());
        ImageIcon imagenMiInfo = new ImageIcon("imagenes/contact-new.png");
        JLabel imagen = new JLabel("Mi Información", imagenMiInfo, JLabel.LEFT);
        contenido.add(imagen,BorderLayout.NORTH);

        JButton guardar = new JButton("Guardar");
        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,"Esta seguro de actualizar sus datos?","Alerta",JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    lista.set(0,jtUsuario.getText());
                    lista.set(1,jtPassword.getText());
                    lista.set(2,jtPrivilegio.getText());
                    lista.set(3,jtEstado.getText());
                    lista.set(4,jtNombres.getText());
                    lista.set(5,jtApellidos.getText());
                    lista.set(6,jtCargo.getText());
                    lista.set(7,jtTiempo_uso.getText());
                    archivo.EscribirContenido();                               
                }
            }
        });
        JButton reestablecer = new JButton("Reestablecer");
        reestablecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,"Esta seguro de realizar esta acción?","Alerta",JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    jtUsuario.setText(lista.get(0));
                    jtPassword.setText(lista.get(1));
                    jtPrivilegio.setText(lista.get(2));
                    jtEstado.setText(lista.get(3));
                    jtNombres.setText(lista.get(4));
                    jtApellidos.setText(lista.get(5));
                    jtCargo.setText(lista.get(6));
                    jtTiempo_uso.setText(lista.get(7));
                    panelMiInfo.updateUI();
                }                
            }
        });
        JPanel panelButton = new JPanel();
        panelButton.add(guardar);
        panelButton.add(reestablecer);

        jpCentro.add(contenido,BorderLayout.NORTH);
        jpCentro.add(panelMiInfoMain,BorderLayout.WEST);
        jpCentro.add(panelButton,BorderLayout.SOUTH);
        jpCentro.updateUI();
    }
    public void InitModuloReportes(){
        jpCentro.removeAll();
        ModeloTablaReporte nuevo = new ModeloTablaReporte();
        final JTable tablaDatos = new JTable(nuevo);
        tablaDatos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        //tablaDatos.setColumnSelectionAllowed(true);
        //tablaDatos.setCellSelectionEnabled(true);
        //tablaDatos.setRowSelectionAllowed(true);        
        tablaDatos.setDefaultEditor(Volume.class,new TablaEditorReporte());
        //tablaDatos.setColumnSelectionAllowed(true);
        tablaDatos.setDefaultRenderer(Volume.class,new TablaRendererReporte());
        tablaDatos.setRowHeight(20);                
        JScrollPane scrolltabla = new JScrollPane(tablaDatos);
        JPanel contenido = new JPanel(new BorderLayout());
        //ImageIcon imagenUsuarios = new ImageIcon("imagenes/system-log-out.png");
        //JLabel imagen = new JLabel("Gestión de Usuarios", imagenUsuarios, JLabel.LEFT);
                
        //contenido.add(imagen,BorderLayout.WEST);
        
        jpCentro.add(contenido,BorderLayout.NORTH);
        jpCentro.add(scrolltabla,BorderLayout.CENTER);
        jpCentro.updateUI();
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
