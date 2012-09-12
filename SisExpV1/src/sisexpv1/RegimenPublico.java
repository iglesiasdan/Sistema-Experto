package sisexpv1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import jpl.Query;

class RegimenPublico extends JPanel implements ActionListener{
    //--Diseño
    private JLabel jlImagen;
    private Box verticalMain;
    private JPanel horizontalMain;
    private JButton evaluar;
    private JButton refrescar;
    private JCheckBox Ninguno;
    //--Datos
    private ArrayList<String> echoIdCriterio;
    private ArrayList<String> echoDesCriterio;
    private ArrayList<JCheckBox> echoChekCriterio;
    private String usuario;
    
    public RegimenPublico(String user){
        echoIdCriterio = new ArrayList<String>();
        echoDesCriterio = new ArrayList<String>();
        echoChekCriterio = new ArrayList<JCheckBox>();
        usuario = user;
        cargarEchosDeCriterios();
        InitComponents();        
    }
    private void InitComponents() {
        setBackground(Color.white);
        setLayout(new BorderLayout());
        verticalMain = new Box(BoxLayout.Y_AXIS);
        verticalMain.setBorder(new TitledBorder(new EtchedBorder(),"Preguntas"));
        horizontalMain = new JPanel(new FlowLayout(FlowLayout.CENTER));
        horizontalMain.setBackground(Color.white);
        horizontalMain.setBorder(new TitledBorder(new EtchedBorder()));
        
        for(int i=1;i<echoChekCriterio.size();i++){
            verticalMain.add(echoChekCriterio.get(i));
        }
        //--Ninguno
        verticalMain.add(Ninguno);

        evaluar = new JButton("Evaluar");
        evaluar.addActionListener(this);
        refrescar = new JButton("Refrescar");
        refrescar.addActionListener(this);
        
        horizontalMain.add(evaluar);
        horizontalMain.add(refrescar);

        ImageIcon imagen = new ImageIcon("imagenes/publico.png");
        jlImagen = new JLabel(imagen);

        add(jlImagen,BorderLayout.NORTH);
        add(verticalMain,BorderLayout.CENTER);
        add(horizontalMain,BorderLayout.SOUTH);
    }
    private void cargarEchosDeCriterios() {
        //--Cargamos Archivo
        String archivo = "consult('justicia.pl')";
        Query consulta = new Query(archivo);
        //System.out.println( t1 + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        if(consulta.hasSolution()){
            //--P
            consulta = new Query("criterio('P',X)");
            echoIdCriterio.add("'P'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox(consulta.oneSolution().get("X").toString()));
            //--P1
            consulta = new Query("criterio('P1',X)");
            echoIdCriterio.add("'P1'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox(consulta.oneSolution().get("X").toString()));
            //--P2
            consulta = new Query("criterio('P2',X)");
            echoIdCriterio.add("'P2'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox(consulta.oneSolution().get("X").toString()));
            //--P3
            consulta = new Query("criterio('P3',X)");
            echoIdCriterio.add("'P3'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox(consulta.oneSolution().get("X").toString()));
            //--P4
            consulta = new Query("criterio('P4',X)");
            echoIdCriterio.add("'P4'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox(consulta.oneSolution().get("X").toString()));
            //--P5
            consulta = new Query("criterio('P5',X)");
            echoIdCriterio.add("'P5'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox(consulta.oneSolution().get("X").toString()));
            //--P6
            consulta = new Query("criterio('P6',X)");
            echoIdCriterio.add("'P6'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox(consulta.oneSolution().get("X").toString()));
            //--P7
            consulta = new Query("criterio('P7',X)");
            echoIdCriterio.add("'P7'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox(consulta.oneSolution().get("X").toString()));
            //--P8
            consulta = new Query("criterio('P8',X)");
            echoIdCriterio.add("'P8'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox(consulta.oneSolution().get("X").toString()));

            //--Check No cumple con las anteriores
            Ninguno = new JCheckBox("No cumple con ningún anterior");
            Ninguno.addActionListener(this);
        }else{
            JOptionPane.showMessageDialog(null,"No se pudo cargar el Motor de Inferencia");
        }
    }    
    public void actionPerformed(ActionEvent e) {
        int band = 0;
        //--Cargamos Archivo
        String archivo = "consult('justicia.pl')";
        Query consulta = new Query(archivo);
        if(Ninguno.isSelected() == true){
            band++;
            for(int i=1;i<echoChekCriterio.size();i++){
                echoChekCriterio.get(i).setSelected(false);
                echoChekCriterio.get(i).setEnabled(false);
            }
            updateUI();
        }else{
            for(int i=1;i<echoChekCriterio.size();i++){                
                echoChekCriterio.get(i).setEnabled(true);
            }
            updateUI();
        }
        if(e.getSource() == evaluar){            
            //--CheckButtons
            if(consulta.hasSolution()){
                //--P
                consulta = new Query("assert(resH('P',si))");
                consulta.hasSolution();
                //--P1
                if(echoChekCriterio.get(1).isSelected()==true){
                    consulta = new Query("assert(resH('P1',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('P1',no))");
                    consulta.hasSolution();
                }
                //--P2
                if(echoChekCriterio.get(2).isSelected()==true){
                    consulta = new Query("assert(resH('P2',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('P2',no))");
                    consulta.hasSolution();
                }
                //--P3
                if(echoChekCriterio.get(3).isSelected()==true){
                    consulta = new Query("assert(resH('P3',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('P3',no))");
                    consulta.hasSolution();
                }
                //--P4
                if(echoChekCriterio.get(4).isSelected()==true){
                    consulta = new Query("assert(resH('P4',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('P4',no))");
                    consulta.hasSolution();
                }
                //--P5
                if(echoChekCriterio.get(5).isSelected()==true){
                    consulta = new Query("assert(resH('P5',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('P5',no))");
                    consulta.hasSolution();
                }
                //--P6
                if(echoChekCriterio.get(6).isSelected()==true){
                    consulta = new Query("assert(resH('P6',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('P6',no))");
                    consulta.hasSolution();
                }
                //--P7
                if(echoChekCriterio.get(7).isSelected()==true){
                    consulta = new Query("assert(resH('P7',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('P7',no))");
                    consulta.hasSolution();
                }
                //--P8
                if(echoChekCriterio.get(8).isSelected()==true){
                    consulta = new Query("assert(resH('P8',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('P8',no))");
                    consulta.hasSolution();
                }

                if(band>=1){
                    //--JButtons de Evaluacion
                    //--Evaluar
                    consulta = new Query("reglaEsCorrecta('ReglaPorPublico')");
                    if(consulta.hasSolution()){
                        ExplicacionJ mensaje = new ExplicacionJ(Boolean.TRUE,echoIdCriterio,echoChekCriterio,"'ReglaPorPublico'",usuario);
                        mensaje.setVisible(true);
                    }else{
                        String rpt = "";
                        int resultado = JOptionPane.showConfirmDialog(null,"<html><p align='center'>Demanda es IMPROCEDENTE por no cumplir requisitos</p><br><p align='center'>Desea comenzar nuevamente?</p><br></html>","Alerta",JOptionPane.YES_NO_CANCEL_OPTION);
                        if(resultado == JOptionPane.NO_OPTION){
                            rpt= JOptionPane.showInputDialog(this,"<html><p align='center'>No se cumple con los Requisitos</p><br><p align='center'>Ingrese el Nro expediente para generar reporte</p><br></html>","Alerta", WIDTH);
                            if(!(rpt==null)){
                                ArrayList a =new ArrayList();
                                a.add("No procede la demanda por no cumplir ninguno de los criterios anteriormente señalados.");
                                ArrayList b =new ArrayList();
                                b.add("Criterios de procedencia mostrados dentro del Régimen Laboral Público.");

                                GenerarPDF aa=new GenerarPDF(true,false,usuario,rpt,a,b);

                                if(!(rpt.equals("")))
                                    aa.AbrirPDF();
                            }
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(this,"Marque al menos una opción antes de evaluar");
                }
            }
        }
        //--Refrescar
        if(e.getSource() == refrescar){
            for(int i=1;i<echoChekCriterio.size();i++){
                echoChekCriterio.get(i).setSelected(false);
                echoChekCriterio.get(i).setEnabled(true);
            }
            Ninguno.setSelected(false);            
        }
        for(int i=0;i<echoIdCriterio.size();i++){
            consulta = new Query("retract(resH("+echoIdCriterio.get(i)+",si))");
            consulta.hasSolution();
            consulta = new Query("retract(resH("+echoIdCriterio.get(i)+",no))");
            consulta.hasSolution();
        }
    }

    public ArrayList echoDesCriterio()
    {
        return echoDesCriterio;
    }
}