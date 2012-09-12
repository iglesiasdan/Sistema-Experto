/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

class Nulo extends JPanel implements ActionListener{
     //--Diseño
    private JLabel jlImagen;
    private Box verticalMain;
    private JPanel horizontalMain;
    private JButton evaluar;
    private JButton refrescar;
    //--Datos
    private ArrayList<String> echoIdCriterio;
    private ArrayList<String> echoDesCriterio;
    private ArrayList<JCheckBox> echoChekCriterio;
    private String usuario;

    public Nulo(String user){
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

        echoChekCriterio.get(1).addActionListener(this);
        echoChekCriterio.get(7).addActionListener(this);
        echoChekCriterio.get(14).addActionListener(this);
        echoChekCriterio.get(16).addActionListener(this);
        echoChekCriterio.get(18).addActionListener(this);
        echoChekCriterio.get(19).addActionListener(this);
        verticalMain.add(echoChekCriterio.get(1));
        verticalMain.add(echoChekCriterio.get(7));
        verticalMain.add(echoChekCriterio.get(14));
        verticalMain.add(echoChekCriterio.get(19));        

        evaluar = new JButton("Evaluar");
        evaluar.addActionListener(this);
        refrescar = new JButton("Refrescar");
        refrescar.addActionListener(this);
        
        horizontalMain.add(evaluar);
        horizontalMain.add(refrescar);

        ImageIcon imagen = new ImageIcon("imagenes/nulo.png");
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
            //--N
            consulta = new Query("criterio('N',X)");
            echoIdCriterio.add("'N'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N1
            consulta = new Query("criterio('N1',X)");
            echoIdCriterio.add("'N1'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N1.1
            consulta = new Query("criterio('N1.1',X)");
            echoIdCriterio.add("'N1.1'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N1.2
            consulta = new Query("criterio('N1.2',X)");
            echoIdCriterio.add("'N1.2'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N1.3
            consulta = new Query("criterio('N1.3',X)");
            echoIdCriterio.add("'N1.3'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N1.4
            consulta = new Query("criterio('N1.4',X)");
            echoIdCriterio.add("'N1.4'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N1.5
            consulta = new Query("criterio('N1.5',X)");
            echoIdCriterio.add("'N1.5'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N2
            consulta = new Query("criterio('N2',X)");
            echoIdCriterio.add("'N2'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N2.1
            consulta = new Query("criterio('N2.1',X)");
            echoIdCriterio.add("'N2.1'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N2.2
            consulta = new Query("criterio('N2.2',X)");
            echoIdCriterio.add("'N2.2'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N2.3
            consulta = new Query("criterio('N2.3',X)");
            echoIdCriterio.add("'N2.3'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N2.4
            consulta = new Query("criterio('N2.4',X)");
            echoIdCriterio.add("'N2.4'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N2.5
            consulta = new Query("criterio('N2.5',X)");
            echoIdCriterio.add("'N2.5'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N2.6
            consulta = new Query("criterio('N2.6',X)");
            echoIdCriterio.add("'N2.6'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N3
            consulta = new Query("criterio('N3',X)");
            echoIdCriterio.add("'N3'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N3.1
            consulta = new Query("criterio('N3.1',X)");
            echoIdCriterio.add("'N3.1'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N3.2
            consulta = new Query("criterio('N3.2',X)");
            echoIdCriterio.add("'N3.2'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N3.3
            consulta = new Query("criterio('N3.3',X)");
            echoIdCriterio.add("'N3.3'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N3.4
            consulta = new Query("criterio('N3.4',X)");
            echoIdCriterio.add("'N3.4'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N4
            consulta = new Query("criterio('N4',X)");
            echoIdCriterio.add("'N4'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N4.1
            consulta = new Query("criterio('N4.1',X)");
            echoIdCriterio.add("'N4.1'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));
            //--N4.2
            consulta = new Query("criterio('N4.2',X)");
            echoIdCriterio.add("'N4.2'");
            echoDesCriterio.add(consulta.oneSolution().get("X").toString());
            echoChekCriterio.add(new JCheckBox("<html><div style='width:300px' align='left'>"+consulta.oneSolution().get("X").toString()+"</div></html>"));            
        }else{
            JOptionPane.showMessageDialog(null,"No se pudo cargar el Motor de Inferencia");
        }
    }
    public void actionPerformed(ActionEvent e) {
        //--CheckButtons
        verticalMain.removeAll();
        //--N1
        if(echoChekCriterio.get(1).isSelected()==true){            
            verticalMain.add(echoChekCriterio.get(1));
            Box vertical1 = new Box(BoxLayout.Y_AXIS);
            vertical1.setBorder(new TitledBorder(new EtchedBorder()));
            vertical1.add(echoChekCriterio.get(2));
            vertical1.add(echoChekCriterio.get(3));
            vertical1.add(echoChekCriterio.get(4));
            vertical1.add(echoChekCriterio.get(5));
            vertical1.add(echoChekCriterio.get(6));            
            verticalMain.add(vertical1);            
        }else{
            verticalMain.removeAll();
            verticalMain.add(echoChekCriterio.get(1));
            echoChekCriterio.get(2).setSelected(false);
            echoChekCriterio.get(3).setSelected(false);
            echoChekCriterio.get(4).setSelected(false);
            echoChekCriterio.get(5).setSelected(false);
            echoChekCriterio.get(6).setSelected(false);                                    
        }
        //--N2
        if(echoChekCriterio.get(7).isSelected()==true){            
            verticalMain.add(echoChekCriterio.get(7));
            Box vertical1 = new Box(BoxLayout.Y_AXIS);
            vertical1.setBorder(new TitledBorder(new EtchedBorder()));
            vertical1.add(echoChekCriterio.get(8));
            vertical1.add(echoChekCriterio.get(9));
            vertical1.add(echoChekCriterio.get(10));
            vertical1.add(echoChekCriterio.get(11));
            vertical1.add(echoChekCriterio.get(12));
            vertical1.add(echoChekCriterio.get(13));            
            verticalMain.add(vertical1);            
        }else{
            verticalMain.add(echoChekCriterio.get(7));
            echoChekCriterio.get(8).setSelected(false);
            echoChekCriterio.get(9).setSelected(false);
            echoChekCriterio.get(10).setSelected(false);
            echoChekCriterio.get(11).setSelected(false);
            echoChekCriterio.get(12).setSelected(false);
            echoChekCriterio.get(13).setSelected(false);            
        }
        //--N3
        if(echoChekCriterio.get(14).isSelected()==true){            
            verticalMain.add(echoChekCriterio.get(14));
            Box vertical1 = new Box(BoxLayout.Y_AXIS);
            vertical1.setBorder(new TitledBorder(new EtchedBorder()));
            vertical1.add(echoChekCriterio.get(15));
            vertical1.add(echoChekCriterio.get(16));
            vertical1.add(echoChekCriterio.get(17));
            vertical1.add(echoChekCriterio.get(18));            
            verticalMain.add(vertical1);
        }else{            
            verticalMain.add(echoChekCriterio.get(14));
            echoChekCriterio.get(15).setSelected(false);
            echoChekCriterio.get(16).setSelected(false);
            echoChekCriterio.get(17).setSelected(false);
            echoChekCriterio.get(18).setSelected(false);                        
        }
        //--N3.2
        if(echoChekCriterio.get(16).isSelected()==true){
            echoChekCriterio.get(18).setEnabled(false);
        }else{
            echoChekCriterio.get(18).setEnabled(true);
        }
        //--N3.4
        if(echoChekCriterio.get(18).isSelected()==true){
            echoChekCriterio.get(16).setEnabled(false);
        }else{
            echoChekCriterio.get(16).setEnabled(true);
        }
        //--N4
        if(echoChekCriterio.get(19).isSelected()==true){            
            verticalMain.add(echoChekCriterio.get(19));
            Box vertical1 = new Box(BoxLayout.Y_AXIS);
            vertical1.setBorder(new TitledBorder(new EtchedBorder()));
            vertical1.add(echoChekCriterio.get(20));
            vertical1.add(echoChekCriterio.get(21));
            verticalMain.add(vertical1);            
        }else{            
            verticalMain.add(echoChekCriterio.get(19));
            echoChekCriterio.get(20).setSelected(false);
            echoChekCriterio.get(21).setSelected(false);            
        }
        updateUI();
        //--JButtons de Evaluacion
        //--Evaluar
        if(e.getSource() == evaluar){
            //--Flag
            int Reb1 = 0;
            int Reb2 = 0;
            int Reb3 = 0;
            int Reb4 = 0;
            //--Cargamos Archivo
            String archivo = "consult('justicia.pl')";
            Query consulta = new Query(archivo);
            if(consulta.hasSolution()){
                //--N
                    consulta = new Query("assert(resH('N',si))");
                    consulta.hasSolution();
                //--N1
                if(echoChekCriterio.get(1).isSelected()==true){
                    consulta = new Query("assert(resH('N1',si))");
                    consulta.hasSolution();Reb1++;
                }else{
                    consulta = new Query("assert(resH('N1',no))");
                    consulta.hasSolution();
                }
                //--N1.1
                if(echoChekCriterio.get(2).isSelected()==true){
                    consulta = new Query("assert(resH('N1.1',si))");
                    consulta.hasSolution();Reb1++;
                }else{
                    consulta = new Query("assert(resH('N1.1',no))");
                    consulta.hasSolution();
                }
                //--N1.2
                if(echoChekCriterio.get(3).isSelected()==true){
                    consulta = new Query("assert(resH('N1.2',si))");
                    consulta.hasSolution();Reb1++;
                }else{
                    consulta = new Query("assert(resH('N1.2',no))");
                    consulta.hasSolution();
                }
                //--N1.3
                if(echoChekCriterio.get(4).isSelected()==true){
                    consulta = new Query("assert(resH('N1.3',si))");
                    consulta.hasSolution();Reb1++;
                }else{
                    consulta = new Query("assert(resH('N1.3',no))");
                    consulta.hasSolution();
                }
                //--N1.4
                if(echoChekCriterio.get(5).isSelected()==true){
                    consulta = new Query("assert(resH('N1.4',si))");
                    consulta.hasSolution();Reb1++;
                }else{
                    consulta = new Query("assert(resH('N1.4',no))");
                    consulta.hasSolution();
                }
                //--N1.5
                if(echoChekCriterio.get(6).isSelected()==true){
                    consulta = new Query("assert(resH('N1.5',si))");
                    consulta.hasSolution();Reb1++;
                }else{
                    consulta = new Query("assert(resH('N1.5',no))");
                    consulta.hasSolution();
                }
                //--N2
                if(echoChekCriterio.get(7).isSelected()==true){
                    consulta = new Query("assert(resH('N2',si))");
                    consulta.hasSolution();Reb2++;
                }else{
                    consulta = new Query("assert(resH('N2',no))");
                    consulta.hasSolution();
                }
                //--N2.1
                if(echoChekCriterio.get(8).isSelected()==true){
                    consulta = new Query("assert(resH('N2.1',si))");
                    consulta.hasSolution();Reb2++;
                }else{
                    consulta = new Query("assert(resH('N2.1',no))");
                    consulta.hasSolution();
                }
                //--N2.2
                if(echoChekCriterio.get(9).isSelected()==true){
                    consulta = new Query("assert(resH('N2.2',si))");
                    consulta.hasSolution();Reb2++;
                }else{
                    consulta = new Query("assert(resH('N2.2',no))");
                    consulta.hasSolution();
                }
                //--N2.3
                if(echoChekCriterio.get(10).isSelected()==true){
                    consulta = new Query("assert(resH('N2.3',si))");
                    consulta.hasSolution();Reb2++;
                }else{
                    consulta = new Query("assert(resH('N2.3',no))");
                    consulta.hasSolution();
                }
                //--N2.4
                if(echoChekCriterio.get(11).isSelected()==true){
                    consulta = new Query("assert(resH('N2.4',si))");
                    consulta.hasSolution();Reb2++;
                }else{
                    consulta = new Query("assert(resH('N2.4',no))");
                    consulta.hasSolution();
                }
                //--N2.5
                if(echoChekCriterio.get(12).isSelected()==true){
                    consulta = new Query("assert(resH('N2.5',si))");
                    consulta.hasSolution();Reb2++;
                }else{
                    consulta = new Query("assert(resH('N2.5',no))");
                    consulta.hasSolution();
                }
                //--N2.6
                if(echoChekCriterio.get(13).isSelected()==true){
                    consulta = new Query("assert(resH('N2.6',si))");
                    consulta.hasSolution();Reb2++;
                }else{
                    consulta = new Query("assert(resH('N2.6',no))");
                    consulta.hasSolution();
                }
                //--N3
                if(echoChekCriterio.get(14).isSelected()==true){
                    consulta = new Query("assert(resH('N3',si))");
                    consulta.hasSolution();Reb3++;
                }else{
                    consulta = new Query("assert(resH('N3',no))");
                    consulta.hasSolution();
                }
                //--N3.1
                if(echoChekCriterio.get(15).isSelected()==true){
                    consulta = new Query("assert(resH('N3.1',si))");
                    consulta.hasSolution();Reb3++;
                }else{
                    consulta = new Query("assert(resH('N3.1',no))");
                    consulta.hasSolution();
                }
                //--N3.2
                if(echoChekCriterio.get(16).isSelected()==true){
                    consulta = new Query("assert(resH('N3.2',si))");
                    consulta.hasSolution();Reb3++;
                }else{
                    consulta = new Query("assert(resH('N3.2',no))");
                    consulta.hasSolution();
                }
                //--N3.3
                if(echoChekCriterio.get(17).isSelected()==true){
                    consulta = new Query("assert(resH('N3.3',si))");
                    consulta.hasSolution();Reb3++;
                }else{
                    consulta = new Query("assert(resH('N3.3',no))");
                    consulta.hasSolution();
                }
                //--N3.4
                if(echoChekCriterio.get(18).isSelected()==true){
                    consulta = new Query("assert(resH('N3.4',si))");
                    consulta.hasSolution();Reb3++;
                }else{
                    consulta = new Query("assert(resH('N3.4',no))");
                    consulta.hasSolution();
                }
                //--N4
                if(echoChekCriterio.get(19).isSelected()==true){
                    consulta = new Query("assert(resH('N4',si))");
                    consulta.hasSolution();Reb4++;
                }else{
                    consulta = new Query("assert(resH('N4',no))");
                    consulta.hasSolution();
                }
                //--N4.1
                if(echoChekCriterio.get(20).isSelected()==true){
                    consulta = new Query("assert(resH('N4.1',si))");
                    consulta.hasSolution();Reb4++;
                }else{
                    consulta = new Query("assert(resH('N4.1',no))");
                    consulta.hasSolution();
                }
                //--N4.2
                if(echoChekCriterio.get(21).isSelected()==true){
                    consulta = new Query("assert(resH('N4.2',si))");
                    consulta.hasSolution();Reb4++;
                }else{
                    consulta = new Query("assert(resH('N4.2',no))");
                    consulta.hasSolution();
                }
                    
                if(Reb1 > 1 || Reb2 > 1 || Reb3 > 1 || Reb4 > 1){
                    Reb1 = 0;
                    Reb2 = 0;
                    Reb3 = 0;
                    Reb4 = 0;
                    consulta = new Query("reglaEsCorrecta('ReglaPorNulo')");
                    if(consulta.hasSolution()){
                        ExplicacionJ mensaje = new ExplicacionJ(Boolean.TRUE,echoIdCriterio,echoChekCriterio,"'ReglaPorNulo'",usuario);
                        mensaje.setVisible(true);                        
                    }else{
                        ExplicacionJ mensaje = new ExplicacionJ(Boolean.FALSE,echoIdCriterio,echoChekCriterio,"'ReglaPorNulo'",usuario);
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
            }
            verticalMain.removeAll();
            verticalMain.add(echoChekCriterio.get(1));
            verticalMain.add(echoChekCriterio.get(7));
            verticalMain.add(echoChekCriterio.get(14));
            verticalMain.add(echoChekCriterio.get(19));
            updateUI();
        }
    }

    public ArrayList echoDesCriterio()
    {
        return echoDesCriterio;
    }
}
    

   