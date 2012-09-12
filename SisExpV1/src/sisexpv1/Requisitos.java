/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sisexpv1;


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
import jpl.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Requisitos extends JPanel implements ActionListener{
    //--Diseño    
    private JLabel jlImagen;
    private Box verticalMain;
    private JPanel horizontalMain;
    private JButton evaluar;
    private JButton refrescar;
    //--Datos
    private ArrayList<String> echoIdRequisito;
    private ArrayList<String> echoDesRequisito;
    private ArrayList<JCheckBox> echoChekRequisito;
    private String usuario;
    private Principal principal;

    public Requisitos(String user,Principal prin){
        principal = prin;
        echoIdRequisito = new ArrayList<String>();
        echoDesRequisito = new ArrayList<String>();
        echoChekRequisito = new ArrayList<JCheckBox>();
        usuario = user;
        cargarEchosDeRequisitos();
        InitComponents();
    }   
    public final void InitComponents(){
        setBackground(Color.white);
        setLayout(new BorderLayout());
        verticalMain = new Box(BoxLayout.Y_AXIS);
        verticalMain.setBorder(new TitledBorder(new EtchedBorder(),"Preguntas"));
        horizontalMain = new JPanel(new FlowLayout(FlowLayout.CENTER));
        horizontalMain.setBackground(Color.white);
        horizontalMain.setBorder(new TitledBorder(new EtchedBorder()));

        echoChekRequisito.get(1).addActionListener(this);
        echoChekRequisito.get(2).addActionListener(this);
        echoChekRequisito.get(3).addActionListener(this);
        echoChekRequisito.get(6).addActionListener(this);
        echoChekRequisito.get(7).addActionListener(this);
        echoChekRequisito.get(8).addActionListener(this);
        echoChekRequisito.get(9).addActionListener(this);
        echoChekRequisito.get(10).addActionListener(this);
        echoChekRequisito.get(15).addActionListener(this);
        echoChekRequisito.get(16).addActionListener(this);
        echoChekRequisito.get(17).addActionListener(this);
        
        verticalMain.add(echoChekRequisito.get(1));
        verticalMain.add(echoChekRequisito.get(2));
        verticalMain.add(echoChekRequisito.get(3));
        verticalMain.add(echoChekRequisito.get(6));
        verticalMain.add(echoChekRequisito.get(7));
        verticalMain.add(echoChekRequisito.get(8));
        verticalMain.add(echoChekRequisito.get(9));
        verticalMain.add(echoChekRequisito.get(10));
        verticalMain.add(echoChekRequisito.get(13));
        verticalMain.add(echoChekRequisito.get(14));
        verticalMain.add(echoChekRequisito.get(15));
        verticalMain.add(echoChekRequisito.get(16));
        verticalMain.add(echoChekRequisito.get(17));
        
        evaluar = new JButton("Evaluar");
        evaluar.addActionListener(this);
        refrescar = new JButton("Refrescar");
        refrescar.addActionListener(this);
        
        horizontalMain.add(evaluar);
        horizontalMain.add(refrescar);

        ImageIcon imagen = new ImageIcon("imagenes/requisitos.png");
        jlImagen = new JLabel(imagen);

        add(jlImagen,BorderLayout.NORTH);
        add(verticalMain,BorderLayout.CENTER);
        add(horizontalMain,BorderLayout.SOUTH);
    }
    public final void cargarEchosDeRequisitos(){        
        //--Cargamos Archivo
        String archivo = "consult('justicia.pl')";
        Query consulta = new Query(archivo);
        //System.out.println( t1 + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        if(consulta.hasSolution()){
            //--Requ
            consulta = new Query("requisito('Requ',X)");
            echoIdRequisito.add("'Requ'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ1.0
            consulta = new Query("requisito('Requ1.0',X)");
            echoIdRequisito.add("'Requ1.0'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ2.0
            consulta = new Query("requisito('Requ2.0',X)");
            echoIdRequisito.add("'Requ2.0'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ3.0
            consulta = new Query("requisito('Requ3.0',X)");
            echoIdRequisito.add("'Requ3.0'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ3.1
            consulta = new Query("requisito('Requ3.1',X)");
            echoIdRequisito.add("'Requ3.1'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ3.2
            consulta = new Query("requisito('Requ3.2',X)");
            echoIdRequisito.add("'Requ3.2'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ6.0
            consulta = new Query("requisito('Requ6.0',X)");
            echoIdRequisito.add("'Requ6.0'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ7.0
            consulta = new Query("requisito('Requ7.0',X)");
            echoIdRequisito.add("'Requ7.0'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ8.0
            consulta = new Query("requisito('Requ8.0',X)");
            echoIdRequisito.add("'Requ8.0'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ9.0
            consulta = new Query("requisito('Requ9.0',X)");
            echoIdRequisito.add("'Requ9.0'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ10.0
            consulta = new Query("requisito('Requ10.0',X)");
            echoIdRequisito.add("'Requ10.0'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ10.1
            consulta = new Query("requisito('Requ10.1',X)");
            echoIdRequisito.add("'Requ10.1'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ10.2
            consulta = new Query("requisito('Requ10.2',X)");
            echoIdRequisito.add("'Requ10.2'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ10.3
            consulta = new Query("requisito('Requ10.3',X)");
            echoIdRequisito.add("'Requ10.3'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ11.0
            consulta = new Query("requisito('Requ11.0',X)");
            echoIdRequisito.add("'Requ11.0'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ12.0
            consulta = new Query("requisito('Requ12.0',X)");
            echoIdRequisito.add("'Requ12.0'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ13.0
            consulta = new Query("requisito('Requ13.0',X)");
            echoIdRequisito.add("'Requ13.0'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--Requ14.0
            consulta = new Query("requisito('Requ14.0',X)");
            echoIdRequisito.add("'Requ14.0'");
            echoDesRequisito.add(consulta.oneSolution().get("X").toString());
            echoChekRequisito.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
        }else{
            JOptionPane.showMessageDialog(this,"No se pudo cargar el Motor de Inferencia");
        }
    }       
    public final void actionPerformed(ActionEvent e) {
        int band = 0;
        //--CheckButtons
        verticalMain.removeAll();
        if(echoChekRequisito.get(1).isSelected()==true||
            echoChekRequisito.get(2).isSelected()==true||
            echoChekRequisito.get(3).isSelected()==true||
            echoChekRequisito.get(6).isSelected()==true||
            echoChekRequisito.get(7).isSelected()==true||
            echoChekRequisito.get(8).isSelected()==true||
            echoChekRequisito.get(9).isSelected()==true||
            echoChekRequisito.get(10).isSelected()==true||
            echoChekRequisito.get(15).isSelected()==true||
            echoChekRequisito.get(16).isSelected()==true||
            echoChekRequisito.get(17).isSelected()==true){
            echoChekRequisito.get(13).setEnabled(false);
            echoChekRequisito.get(14).setEnabled(false);
            echoChekRequisito.get(13).setSelected(false);
            echoChekRequisito.get(14).setSelected(false);
        }else{
            echoChekRequisito.get(13).setEnabled(true);
            echoChekRequisito.get(14).setEnabled(true);
        }
        if(echoChekRequisito.get(3).isSelected()==true){
            verticalMain.add(echoChekRequisito.get(1));
            verticalMain.add(echoChekRequisito.get(2));
            verticalMain.add(echoChekRequisito.get(3));

            Box vertical1 = new Box(BoxLayout.Y_AXIS);
            vertical1.setBorder(new TitledBorder(new EtchedBorder()));
            vertical1.add(echoChekRequisito.get(4));
            vertical1.add(echoChekRequisito.get(5));

            verticalMain.add(vertical1);
            verticalMain.add(echoChekRequisito.get(6));
            verticalMain.add(echoChekRequisito.get(7));
            verticalMain.add(echoChekRequisito.get(8));
            verticalMain.add(echoChekRequisito.get(9));
        }else{
            verticalMain.add(echoChekRequisito.get(1));
            verticalMain.add(echoChekRequisito.get(2));
            verticalMain.add(echoChekRequisito.get(3));
            echoChekRequisito.get(4).setSelected(false);
            echoChekRequisito.get(5).setSelected(false);
            verticalMain.add(echoChekRequisito.get(6));
            verticalMain.add(echoChekRequisito.get(7));
            verticalMain.add(echoChekRequisito.get(8));
            verticalMain.add(echoChekRequisito.get(9));
        }
        if(echoChekRequisito.get(10).isSelected()==true){
            verticalMain.add(echoChekRequisito.get(10));

            Box vertical1 = new Box(BoxLayout.Y_AXIS);
            vertical1.setBorder(new TitledBorder(new EtchedBorder()));
            vertical1.add(echoChekRequisito.get(11));
            vertical1.add(echoChekRequisito.get(12));            

            verticalMain.add(vertical1);
            verticalMain.add(echoChekRequisito.get(13));
            verticalMain.add(echoChekRequisito.get(14));
            verticalMain.add(echoChekRequisito.get(15));
            verticalMain.add(echoChekRequisito.get(16));
            verticalMain.add(echoChekRequisito.get(17));
        }else{
            verticalMain.add(echoChekRequisito.get(10));
            echoChekRequisito.get(11).setSelected(false);
            echoChekRequisito.get(12).setSelected(false);

            verticalMain.add(echoChekRequisito.get(13));
            verticalMain.add(echoChekRequisito.get(14));
            verticalMain.add(echoChekRequisito.get(15));
            verticalMain.add(echoChekRequisito.get(16));
            verticalMain.add(echoChekRequisito.get(17));
        }
        updateUI();
        
        //--JButtons de Evaluacion
        //--Evaluar
        if(e.getSource() == evaluar){
            //--Cargamos Archivo
            String archivo = "consult('justicia.pl')";
            Query consulta = new Query(archivo);            
            //--CheckButtons            

            if(consulta.hasSolution()){
                //--Requ                
                    consulta = new Query("assert(resH('Requ',si))");
                    consulta.hasSolution();                
                //--Requ1.0
                if(echoChekRequisito.get(1).isSelected()==true){
                    consulta = new Query("assert(resH('Requ1.0',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ1.0',no))");
                    consulta.hasSolution();
                }
                //--Requ2.0
                if(echoChekRequisito.get(2).isSelected()==true){
                    consulta = new Query("assert(resH('Requ2.0',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ2.0',no))");
                    consulta.hasSolution();
                }
                //--Requ3.0
                if(echoChekRequisito.get(3).isSelected()==true){
                    consulta = new Query("assert(resH('Requ3.0',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ3.0',no))");
                    consulta.hasSolution();
                }
                //--Requ3.1
                if(echoChekRequisito.get(4).isSelected()==true){
                    consulta = new Query("assert(resH('Requ3.1',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ3.1',no))");
                    consulta.hasSolution();
                }
                //--Requ3.2
                if(echoChekRequisito.get(5).isSelected()==true){
                    consulta = new Query("assert(resH('Requ3.2',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ3.2',no))");
                    consulta.hasSolution();
                }
                //--Requ6.0
                if(echoChekRequisito.get(6).isSelected()==true){
                    consulta = new Query("assert(resH('Requ6.0',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ6.0',no))");
                    consulta.hasSolution();
                }
                //--Requ7.0
                if(echoChekRequisito.get(7).isSelected()==true){
                    consulta = new Query("assert(resH('Requ7.0',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ7.0',no))");
                    consulta.hasSolution();
                }
                //--Requ8.0
                if(echoChekRequisito.get(8).isSelected()==true){
                    consulta = new Query("assert(resH('Requ8.0',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ8.0',no))");
                    consulta.hasSolution();
                }
                //--Requ9.0
                if(echoChekRequisito.get(9).isSelected()==true){
                    consulta = new Query("assert(resH('Requ9.0',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ9.0',no))");
                    consulta.hasSolution();
                }
                //--Requ10.0
                if(echoChekRequisito.get(10).isSelected()==true){
                    consulta = new Query("assert(resH('Requ10.0',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ10.0',no))");
                    consulta.hasSolution();
                }
                //--Requ10.1
                if(echoChekRequisito.get(11).isSelected()==true){
                    consulta = new Query("assert(resH('Requ10.1',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ10.1',no))");
                    consulta.hasSolution();
                }
                //--Requ10.2
                if(echoChekRequisito.get(12).isSelected()==true){
                    consulta = new Query("assert(resH('Requ10.2',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ10.2',no))");
                    consulta.hasSolution();
                }
                //--Requ10.3
                if(echoChekRequisito.get(13).isSelected()==true){
                    consulta = new Query("assert(resH('Requ10.3',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ10.3',no))");
                    consulta.hasSolution();
                }
                //--Requ11.0
                if(echoChekRequisito.get(14).isSelected()==true){
                    consulta = new Query("assert(resH('Requ11.0',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ11.0',no))");
                    consulta.hasSolution();
                }
                //--Requ12.0
                if(echoChekRequisito.get(15).isSelected()==true){
                    consulta = new Query("assert(resH('Requ12.0',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ12.0',no))");
                    consulta.hasSolution();
                }
                //--Requ13.0
                if(echoChekRequisito.get(16).isSelected()==true){
                    consulta = new Query("assert(resH('Requ13.0',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ13.0',no))");
                    consulta.hasSolution();
                }
                //--Requ14.0
                if(echoChekRequisito.get(17).isSelected()==true){
                    consulta = new Query("assert(resH('Requ14.0',si))");
                    consulta.hasSolution();band++;
                }else{
                    consulta = new Query("assert(resH('Requ14.0',no))");
                    consulta.hasSolution();
                }


                if(band >= 1){
                    if(echoChekRequisito.get(10).isSelected() == true && (echoChekRequisito.get(11).isSelected() == false && echoChekRequisito.get(12).isSelected() == false)){
                           JOptionPane.showMessageDialog(null,"Marque al menos una de las subopciones","Alerta",JOptionPane.OK_OPTION);
                    }else{
                        band = 0;
                        consulta = new Query("reglaEsCorrecta('ReglaPorRequisito')");
                        if(consulta.hasSolution()){
                            int resultado = JOptionPane.showConfirmDialog(null,"<html><p align='center'>Demanda es PROCEDENTE porque se cumple con los requisitos</p><br><p align='center'>Desea pasar a la siguiente sección?</p><br></html>","Alerta",JOptionPane.YES_NO_CANCEL_OPTION);
                            if(resultado == JOptionPane.YES_OPTION){
                                principal.jpCentro.removeAll();
                                principal.EscogerRegimenComponentCentro();
                            }
                        }else{
                           
                            String rpt = "";
                            int resultado = JOptionPane.showConfirmDialog(null,"<html><p align='center'>Demanda es IMPROCEDENTE por no cumplir requisitos</p><br><p align='center'>Desea comenzar nuevamente?</p><br></html>","Alerta",JOptionPane.YES_NO_CANCEL_OPTION);
                            if(resultado == JOptionPane.NO_OPTION){

                                rpt= JOptionPane.showInputDialog(this,"<html><p align='center'>No se cumple con los Requisitos</p><br><p align='center'>Ingrese el Nro expediente para generar reporte</p><br></html>","Alerta", WIDTH);

                                if(!(rpt==null)){
                                //ExplicacionJ mensaje = new ExplicacionJ(Boolean.FALSE,echoIdRequisito,echoChekRequisito,"'ReglaPorRequisito'",usuario);
                                //mensaje.setVisible(true);
                                    ArrayList a =new ArrayList();
                                    a.add("No procede la demanda por no cumplir requisito(s) establecido(s) en el artículo 427 del Código Procesal Civil o requisito(s) establecido(s) en diversos artículos del Código Procesal Constitucional.");
                                    ArrayList b =new ArrayList();
                                    b.add("Requisitos de procedencia del Código Procesal Civil y del Código Procesal Constitucional.");

                                    GenerarPDF aa=new GenerarPDF(true,true,usuario,rpt,a,b);
                                   //aa.setRequisitos(true);
                                    if(!(rpt.equals("")))
                                        aa.AbrirPDF();
                                }
                                principal.jpCentro.removeAll();
                                principal.InitComponentCentro();
                            }                               
                        }
                    }                   
                }else{
                    JOptionPane.showMessageDialog(null,"Marque al menos una opción antes de evaluar");
                }
                for(int i=0;i<echoIdRequisito.size();i++){
                    consulta = new Query("retract(resH("+echoIdRequisito.get(i)+",si))");
                    consulta.hasSolution();
                    consulta = new Query("retract(resH("+echoIdRequisito.get(i)+",no))");
                    consulta.hasSolution();
                }
            }            
        }
        //--Refrescar
        if(e.getSource() == refrescar){
            for(int i=0;i<echoChekRequisito.size();i++){
                echoChekRequisito.get(i).setSelected(false);
                echoChekRequisito.get(i).setEnabled(true);
            }
            verticalMain.removeAll();
            verticalMain.add(echoChekRequisito.get(1));
            verticalMain.add(echoChekRequisito.get(2));
            verticalMain.add(echoChekRequisito.get(3));
            verticalMain.add(echoChekRequisito.get(6));
            verticalMain.add(echoChekRequisito.get(7));
            verticalMain.add(echoChekRequisito.get(8));
            verticalMain.add(echoChekRequisito.get(9));
            verticalMain.add(echoChekRequisito.get(10));
            verticalMain.add(echoChekRequisito.get(13));
            verticalMain.add(echoChekRequisito.get(14));
            verticalMain.add(echoChekRequisito.get(15));
            verticalMain.add(echoChekRequisito.get(16));
            verticalMain.add(echoChekRequisito.get(17));
            updateUI();
        }
    }

    public ArrayList echoDesCriterio()
    {
        return echoDesRequisito;
    }
}