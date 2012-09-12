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

class Incausado extends JPanel implements ActionListener{
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
    
    public Incausado(String user){
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

        echoChekCriterio.get(15).addActionListener(this);
        echoChekCriterio.get(16).addActionListener(this);
        verticalMainA.add(echoChekCriterio.get(15));
        verticalMainA.add(echoChekCriterio.get(16));

        echoChekCriterio.get(1).addActionListener(this);
        verticalMainB.add(echoChekCriterio.get(1));
        verticalMainB.add(echoChekCriterio.get(4));
        verticalMainB.add(echoChekCriterio.get(5));
        verticalMainB.add(echoChekCriterio.get(6));
        verticalMainB.add(echoChekCriterio.get(7));
        verticalMainB.add(echoChekCriterio.get(8));
        verticalMainB.add(echoChekCriterio.get(9));
        verticalMainB.add(echoChekCriterio.get(10));
        verticalMainB.add(echoChekCriterio.get(11));
        verticalMainB.add(echoChekCriterio.get(12));
        verticalMainB.add(echoChekCriterio.get(13));
        verticalMainB.add(echoChekCriterio.get(14));        

        verticalMain.add(verticalMainA);
        verticalMain.add(verticalMainB);

        evaluar = new JButton("Evaluar");
        evaluar.addActionListener(this);
        refrescar = new JButton("Refrescar");
        refrescar.addActionListener(this);
        
        horizontalMain.add(evaluar);
        horizontalMain.add(refrescar);

        ImageIcon imagen = new ImageIcon("imagenes/incausado.png");
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
            //--IC
            consulta = new Query("criterio('IC',X)");
            echoIdCriterio.add("'IC'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC1
            consulta = new Query("criterio('IC1',X)");
            echoIdCriterio.add("'IC1'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC1.1
            consulta = new Query("criterio('IC1.1',X)");
            echoIdCriterio.add("'IC1.1'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC1.2
            consulta = new Query("criterio('IC1.2',X)");
            echoIdCriterio.add("'IC1.2'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC2
            consulta = new Query("criterio('IC2',X)");
            echoIdCriterio.add("'IC2'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC3
            consulta = new Query("criterio('IC3',X)");
            echoIdCriterio.add("'IC3'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC4
            consulta = new Query("criterio('IC4',X)");
            echoIdCriterio.add("'IC4'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC5
            consulta = new Query("criterio('IC5',X)");
            echoIdCriterio.add("'IC5'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC6
            consulta = new Query("criterio('IC6',X)");
            echoIdCriterio.add("'IC6'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC7
            consulta = new Query("criterio('IC7',X)");
            echoIdCriterio.add("'IC7'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC8
            consulta = new Query("criterio('IC8',X)");
            echoIdCriterio.add("'IC8'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC9
            consulta = new Query("criterio('IC9',X)");
            echoIdCriterio.add("'IC9'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC10
            consulta = new Query("criterio('IC10',X)");
            echoIdCriterio.add("'IC10'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC11
            consulta = new Query("criterio('IC11',X)");
            echoIdCriterio.add("'IC11'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC12
            consulta = new Query("criterio('IC12',X)");
            echoIdCriterio.add("'IC12'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC13
            consulta = new Query("criterio('IC13',X)");
            echoIdCriterio.add("'IC13'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--IC14
            consulta = new Query("criterio('IC14',X)");
            echoIdCriterio.add("'IC14'");
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
        if(echoChekCriterio.get(15).isSelected()==true||echoChekCriterio.get(16).isSelected()==true){
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
            echoChekCriterio.get(11).setEnabled(false);
            echoChekCriterio.get(12).setEnabled(false);
            echoChekCriterio.get(13).setEnabled(false);
            echoChekCriterio.get(14).setEnabled(false);
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
            echoChekCriterio.get(11).setSelected(false);
            echoChekCriterio.get(12).setSelected(false);
            echoChekCriterio.get(13).setSelected(false);
            echoChekCriterio.get(14).setSelected(false);
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
            echoChekCriterio.get(11).setEnabled(true);
            echoChekCriterio.get(12).setEnabled(true);
            echoChekCriterio.get(13).setEnabled(true);
            echoChekCriterio.get(14).setEnabled(true);
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
            verticalMainB.add(echoChekCriterio.get(11));
            verticalMainB.add(echoChekCriterio.get(12));
            verticalMainB.add(echoChekCriterio.get(13));
            verticalMainB.add(echoChekCriterio.get(14));
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
            verticalMainB.add(echoChekCriterio.get(11));
            verticalMainB.add(echoChekCriterio.get(12));
            verticalMainB.add(echoChekCriterio.get(13));
            verticalMainB.add(echoChekCriterio.get(14));
        }
        updateUI();
        //--JButtons de Evaluacion
        //--Evaluar
        if(e.getSource() == evaluar){
            //--Cargamos Archivo
            String archivo = "consult('justicia.pl')";
            Query consulta = new Query(archivo);
            if(consulta.hasSolution()){
                //--IC
                    consulta = new Query("assert(resH('IC',si))");
                    consulta.hasSolution();
                //--IC1
                if(echoChekCriterio.get(1).isSelected()==true){
                    consulta = new Query("assert(resH('IC1',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC1',no))");
                    consulta.hasSolution();
                }
                //--IC1.1
                if(echoChekCriterio.get(2).isSelected()==true){
                    consulta = new Query("assert(resH('IC1.1',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC1.1',no))");
                    consulta.hasSolution();
                }
                //--IC1.2
                if(echoChekCriterio.get(3).isSelected()==true){
                    consulta = new Query("assert(resH('IC1.2',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC1.2',no))");
                    consulta.hasSolution();
                }
                //--IC2
                if(echoChekCriterio.get(4).isSelected()==true){
                    consulta = new Query("assert(resH('IC2',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC2',no))");
                    consulta.hasSolution();
                }
                //--IC3
                if(echoChekCriterio.get(5).isSelected()==true){
                    consulta = new Query("assert(resH('IC3',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC3',no))");
                    consulta.hasSolution();
                }
                //--IC4
                if(echoChekCriterio.get(6).isSelected()==true){
                    consulta = new Query("assert(resH('IC4',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC4',no))");
                    consulta.hasSolution();
                }
                //--IC5
                if(echoChekCriterio.get(7).isSelected()==true){
                    consulta = new Query("assert(resH('IC5',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC5',no))");
                    consulta.hasSolution();
                }
                //--IC6
                if(echoChekCriterio.get(8).isSelected()==true){
                    consulta = new Query("assert(resH('IC6',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC6',no))");
                    consulta.hasSolution();
                }
                //--IC7
                if(echoChekCriterio.get(9).isSelected()==true){
                    consulta = new Query("assert(resH('IC7',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC7',no))");
                    consulta.hasSolution();
                }
                //--IC8
                if(echoChekCriterio.get(10).isSelected()==true){
                    consulta = new Query("assert(resH('IC8',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC8',no))");
                    consulta.hasSolution();
                }
                //--IC9
                if(echoChekCriterio.get(11).isSelected()==true){
                    consulta = new Query("assert(resH('IC9',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC9',no))");
                    consulta.hasSolution();
                }
                //--IC10
                if(echoChekCriterio.get(12).isSelected()==true){
                    consulta = new Query("assert(resH('IC10',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC10',no))");
                    consulta.hasSolution();
                }
                //--IC11
                if(echoChekCriterio.get(13).isSelected()==true){
                    consulta = new Query("assert(resH('IC11',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC11',no))");
                    consulta.hasSolution();
                }
                //--IC12
                if(echoChekCriterio.get(14).isSelected()==true){
                    consulta = new Query("assert(resH('IC12',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC12',no))");
                    consulta.hasSolution();
                }
                //--IC13
                if(echoChekCriterio.get(15).isSelected()==true){
                    consulta = new Query("assert(resH('IC13',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC13',no))");
                    consulta.hasSolution();
                }
                //--IC14
                if(echoChekCriterio.get(16).isSelected()==true){
                    consulta = new Query("assert(resH('IC14',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('IC14',no))");
                    consulta.hasSolution();
                }

                if(band>=1){
                    band=0;
                    consulta = new Query("reglaEsCorrecta('ReglaPorIncausado')");
                    if(consulta.hasSolution()){
                        ExplicacionJ mensaje = new ExplicacionJ(Boolean.TRUE,echoIdCriterio,echoChekCriterio,"'ReglaPorIncausado'",usuario);
                        mensaje.setVisible(true);
                    }else{
                        ExplicacionJ mensaje = new ExplicacionJ(Boolean.FALSE,echoIdCriterio,echoChekCriterio,"'ReglaPorIncausado'",usuario);
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
            verticalMainB.add(echoChekCriterio.get(11));
            verticalMainB.add(echoChekCriterio.get(12));
            verticalMainB.add(echoChekCriterio.get(13));
            verticalMainB.add(echoChekCriterio.get(14));
            verticalMainA.add(echoChekCriterio.get(15));
            verticalMainA.add(echoChekCriterio.get(16));
            updateUI();
        }
    }
    public ArrayList echoDesCriterio()
    {
        return echoDesCriterio;
    }

}    