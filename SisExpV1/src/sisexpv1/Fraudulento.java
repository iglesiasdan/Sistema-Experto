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

class Fraudulento extends JPanel implements ActionListener{
    //--Diseño
    private JLabel jlImagen;
    private Box verticalMain;
    private Box verticalMainA;
    private Box verticalMainB;
    private JPanel horizontalMain;
    private JButton evaluar;
    private JButton refrescar;
    //--Datos
    private ArrayList<String> echoIdCriterio;
    private ArrayList<String> echoDesCriterio;
    private ArrayList<JCheckBox> echoChekCriterio;
    private String usuario;

    public Fraudulento(String user){
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

        verticalMainA = new Box(BoxLayout.Y_AXIS);
        verticalMainA.setBorder(new TitledBorder(new EtchedBorder(),"Previos"));

        verticalMainB = new Box(BoxLayout.Y_AXIS);
        verticalMainB.setBorder(new TitledBorder(new EtchedBorder(),"Posteriores"));
        
        horizontalMain = new JPanel(new FlowLayout(FlowLayout.CENTER));
        horizontalMain.setBackground(Color.white);
        horizontalMain.setBorder(new TitledBorder(new EtchedBorder()));

        echoChekCriterio.get(11).addActionListener(this);
        echoChekCriterio.get(12).addActionListener(this);
        verticalMainA.add(echoChekCriterio.get(11));
        verticalMainA.add(echoChekCriterio.get(12));

        echoChekCriterio.get(1).addActionListener(this);
        verticalMainB.add(echoChekCriterio.get(1));
        verticalMainB.add(echoChekCriterio.get(4));
        verticalMainB.add(echoChekCriterio.get(5));
        verticalMainB.add(echoChekCriterio.get(6));
        verticalMainB.add(echoChekCriterio.get(7));
        verticalMainB.add(echoChekCriterio.get(8));
        verticalMainB.add(echoChekCriterio.get(9));
        verticalMainB.add(echoChekCriterio.get(10));        

        verticalMain.add(verticalMainA);
        verticalMain.add(verticalMainB);

        evaluar = new JButton("Evaluar");
        evaluar.addActionListener(this);
        refrescar = new JButton("Refrescar");
        refrescar.addActionListener(this);        

        horizontalMain.add(evaluar);
        horizontalMain.add(refrescar);

        ImageIcon imagen = new ImageIcon("imagenes/fraudulento.png");
        jlImagen = new JLabel(imagen);

        add(jlImagen,BorderLayout.NORTH);
        add(verticalMain,BorderLayout.CENTER);        
        add(horizontalMain,BorderLayout.SOUTH);
    }
    private void cargarEchosDeCriterios() {
        //--Cargamos Archivo
        String archivo = "consult('justicia.pl')";
        Query consulta = new Query(archivo);        
        if(consulta.hasSolution()){
            //--F
            consulta = new Query("criterio('F',X)");
            echoIdCriterio.add("'F'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--F1
            consulta = new Query("criterio('F1',X)");
            echoIdCriterio.add("'F1'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--F1.1
            consulta = new Query("criterio('F1.1',X)");
            echoIdCriterio.add("'F1.1'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--F1.2
            consulta = new Query("criterio('F1.2',X)");
            echoIdCriterio.add("'F1.2'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--F2
            consulta = new Query("criterio('F2',X)");
            echoIdCriterio.add("'F2'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--F3
            consulta = new Query("criterio('F3',X)");
            echoIdCriterio.add("'F3'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--F4
            consulta = new Query("criterio('F4',X)");
            echoIdCriterio.add("'F4'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--F5
            consulta = new Query("criterio('F5',X)");
            echoIdCriterio.add("'F5'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--F6
            consulta = new Query("criterio('F6',X)");
            echoIdCriterio.add("'F6'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--F7
            consulta = new Query("criterio('F7',X)");
            echoIdCriterio.add("'F7'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--F8
            consulta = new Query("criterio('F8',X)");
            echoIdCriterio.add("'F8'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--F9
            consulta = new Query("criterio('F9',X)");
            echoIdCriterio.add("'F9'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--F10
            consulta = new Query("criterio('F10',X)");
            echoIdCriterio.add("'F10'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
        }else{
            JOptionPane.showMessageDialog(null,"No se pudo cargar el Motor de Inferencia");
        }
    }
    public void actionPerformed(ActionEvent e) {
        int band=0;
        //--CheckButtons
        //--F9 & F10
        if(echoChekCriterio.get(11).isSelected()==true||echoChekCriterio.get(12).isSelected()==true){                        
            echoChekCriterio.get(1).setEnabled(false);
            echoChekCriterio.get(2).setEnabled(false);
            echoChekCriterio.get(3).setEnabled(false);
            echoChekCriterio.get(4).setEnabled(false);
            echoChekCriterio.get(5).setEnabled(false);
            echoChekCriterio.get(6).setEnabled(false);
            echoChekCriterio.get(7).setEnabled(false);
            echoChekCriterio.get(8).setEnabled(false);
            echoChekCriterio.get(9).setEnabled(false);
            echoChekCriterio.get(10).setEnabled(false);
            echoChekCriterio.get(1).setSelected(false);
            echoChekCriterio.get(2).setSelected(false);
            echoChekCriterio.get(3).setSelected(false);
            echoChekCriterio.get(4).setSelected(false);
            echoChekCriterio.get(5).setSelected(false);
            echoChekCriterio.get(6).setSelected(false);
            echoChekCriterio.get(7).setSelected(false);
            echoChekCriterio.get(8).setSelected(false);
            echoChekCriterio.get(9).setSelected(false);
            echoChekCriterio.get(10).setSelected(false);
        }else{
            echoChekCriterio.get(1).setEnabled(true);
            echoChekCriterio.get(2).setEnabled(true);
            echoChekCriterio.get(3).setEnabled(true);
            echoChekCriterio.get(4).setEnabled(true);
            echoChekCriterio.get(5).setEnabled(true);
            echoChekCriterio.get(6).setEnabled(true);
            echoChekCriterio.get(7).setEnabled(true);
            echoChekCriterio.get(8).setEnabled(true);
            echoChekCriterio.get(9).setEnabled(true);
            echoChekCriterio.get(10).setEnabled(true);
        }
        //--F1
        verticalMainB.removeAll();
        if(echoChekCriterio.get(1).isSelected()==true){

            verticalMainB.add(echoChekCriterio.get(1));
            
            Box vertical1 = new Box(BoxLayout.Y_AXIS);
            vertical1.setBorder(new TitledBorder(new EtchedBorder()));
            vertical1.add(echoChekCriterio.get(2));
            vertical1.add(echoChekCriterio.get(3));            
            
            verticalMainB.add(vertical1);
            verticalMainB.add(echoChekCriterio.get(4));
            verticalMainB.add(echoChekCriterio.get(5));
            verticalMainB.add(echoChekCriterio.get(6));
            verticalMainB.add(echoChekCriterio.get(7));
            verticalMainB.add(echoChekCriterio.get(8));
            verticalMainB.add(echoChekCriterio.get(9));
            verticalMainB.add(echoChekCriterio.get(10));                                   
        }else{                      
            verticalMainB.add(echoChekCriterio.get(1));
            echoChekCriterio.get(2).setSelected(false);
            echoChekCriterio.get(3).setSelected(false);
            verticalMainB.add(echoChekCriterio.get(4));
            verticalMainB.add(echoChekCriterio.get(5));
            verticalMainB.add(echoChekCriterio.get(6));
            verticalMainB.add(echoChekCriterio.get(7));
            verticalMainB.add(echoChekCriterio.get(8));
            verticalMainB.add(echoChekCriterio.get(9));
            verticalMainB.add(echoChekCriterio.get(10));            
        }
        updateUI();
        //--JButtons de Evaluacion
        //--Evaluar
        if(e.getSource() == evaluar){
            //--Cargamos Archivo
            String archivo = "consult('justicia.pl')";
            Query consulta = new Query(archivo);
            if(consulta.hasSolution()){
                //--F                
                    consulta = new Query("assert(resH('F',si))");
                    consulta.hasSolution();                
                //--F1
                if(echoChekCriterio.get(1).isSelected()==true){
                    consulta = new Query("assert(resH('F1',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('F1',no))");
                    consulta.hasSolution();
                }
                //--F1.1
                if(echoChekCriterio.get(2).isSelected()==true){
                    consulta = new Query("assert(resH('F1.1',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('F1.1',no))");
                    consulta.hasSolution();
                }
                //--F1.2
                if(echoChekCriterio.get(3).isSelected()==true){
                    consulta = new Query("assert(resH('F1.2',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('F1.2',no))");
                    consulta.hasSolution();
                }
                //--F2
                if(echoChekCriterio.get(4).isSelected()==true){
                    consulta = new Query("assert(resH('F2',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('F2',no))");
                    consulta.hasSolution();
                }
                //--F3
                if(echoChekCriterio.get(5).isSelected()==true){
                    consulta = new Query("assert(resH('F3',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('F3',no))");
                    consulta.hasSolution();
                }
                //--F4
                if(echoChekCriterio.get(6).isSelected()==true){
                    consulta = new Query("assert(resH('F4',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('F4',no))");
                    consulta.hasSolution();
                }
                //--F5
                if(echoChekCriterio.get(7).isSelected()==true){
                    consulta = new Query("assert(resH('F5',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('F5',no))");
                    consulta.hasSolution();
                }
                //--F6
                if(echoChekCriterio.get(8).isSelected()==true){
                    consulta = new Query("assert(resH('F6',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('F6',no))");
                    consulta.hasSolution();
                }
                //--F7
                if(echoChekCriterio.get(9).isSelected()==true){
                    consulta = new Query("assert(resH('F7',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('F7',no))");
                    consulta.hasSolution();
                }
                //--F8
                if(echoChekCriterio.get(10).isSelected()==true){
                    consulta = new Query("assert(resH('F8',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('F8',no))");
                    consulta.hasSolution();
                }
                //--F9
                if(echoChekCriterio.get(11).isSelected()==true){
                    consulta = new Query("assert(resH('F9',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('F9',no))");
                    consulta.hasSolution();
                }
                //--F10
                if(echoChekCriterio.get(12).isSelected()==true){
                    consulta = new Query("assert(resH('F10',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('F10',no))");
                    consulta.hasSolution();
                }

                if(band>=1){
                    band=0;
                    consulta = new Query("reglaEsCorrecta('ReglaPorFraudulento')");
                    if(consulta.hasSolution()){
                        ExplicacionJ mensaje = new ExplicacionJ(Boolean.TRUE,echoIdCriterio,echoChekCriterio,"'ReglaPorFraudulento'",usuario);
                        mensaje.setVisible(true);
                    }else{
                        ExplicacionJ mensaje = new ExplicacionJ(Boolean.FALSE,echoIdCriterio,echoChekCriterio,"'ReglaPorFraudulento'",usuario);
                        mensaje.setVisible(true);
                    }                    
                }else{
                    JOptionPane.showMessageDialog(null,"Marque al menos una opción antes de evaluar");
                }
                for(int i=0;i<echoIdCriterio.size();i++){
                    consulta = new Query("retract(resH("+echoIdCriterio.get(i)+",si))");
                    consulta.hasSolution();
                    consulta = new Query("retract(resH("+echoIdCriterio.get(i)+",no))");
                    consulta.hasSolution();
                }
            }      
        }
        
        //--Refrescar
        if(e.getSource() == refrescar){
            for(int i=0;i<echoChekCriterio.size();i++){
                echoChekCriterio.get(i).setSelected(false);
                echoChekCriterio.get(i).setEnabled(true);
            }
            verticalMainA.removeAll();
            verticalMainB.removeAll();
            verticalMainB.add(echoChekCriterio.get(1));
            verticalMainB.add(echoChekCriterio.get(4));
            verticalMainB.add(echoChekCriterio.get(5));
            verticalMainB.add(echoChekCriterio.get(6));
            verticalMainB.add(echoChekCriterio.get(7));
            verticalMainB.add(echoChekCriterio.get(8));
            verticalMainB.add(echoChekCriterio.get(9));
            verticalMainB.add(echoChekCriterio.get(10));
            verticalMainA.add(echoChekCriterio.get(11));
            verticalMainA.add(echoChekCriterio.get(12));
            updateUI();
        }
    }

    public ArrayList echoDesCriterio()
    {
        return echoDesCriterio;
    }
}
