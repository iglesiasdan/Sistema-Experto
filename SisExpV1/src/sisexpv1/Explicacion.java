/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sisexpv1;

import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import jpl.Query;

/**
 *
 * 
 */
public final class Explicacion extends JPanel{
    private JLabel mensaje;
    private Box verticalMainA;
    private Box verticalMainB;
    private ArrayList<String> echoId;
    private ArrayList<JCheckBox> echoCheck;
    private Query consulta;
    private String clausula;
    public Explicacion(Boolean respuesta,ArrayList<String> echosId,ArrayList<JCheckBox> echosCheck,String nombre) {
        echoId = echosId;
        echoCheck = echosCheck;
        clausula = nombre;
        if(respuesta == true)
            MensajeSiProcedeElAmparo();
        else
            MensajeNoProcedeElAmparo();        
    }
    public void MensajeSiProcedeElAmparo(){
        mensaje = new JLabel("<html><h4><i>El Amparo procede por lo siguiente</i></h4></html>");
        this.add(mensaje);
        
        verticalMainA = new Box(BoxLayout.Y_AXIS);
        verticalMainA.setBorder(new TitledBorder(new EtchedBorder(),"Resultado de Evaluación"));
        verticalMainB = new Box(BoxLayout.Y_AXIS);
        verticalMainB.setBorder(new TitledBorder(new EtchedBorder(),"Criterios Evaluados"));

        consulta = new Query("explicaSi("+clausula+",X)");
        while (consulta.hasMoreSolutions()){
            Hashtable rpt = consulta.nextSolution();
            mensaje = new JLabel("<html><div style='width:250px'><b>» Se cumple que... </b> "+rpt.get("X").toString()+"</div></html>");
            verticalMainA.add(mensaje);
        }       

        for(int i=0;i<echoCheck.size();i++){
            if(echoCheck.get(i).isSelected()==true){
                consulta = new Query("criterio("+echoId.get(i)+",X)");
                mensaje = new JLabel("<html><div style='width:250px'><b>»</b> "+consulta.oneSolution().get("X").toString()+"</div></html>");
                verticalMainB.add(mensaje);
            }
        }        
        this.add(verticalMainA);
        this.add(verticalMainB);
    }
    public void MensajeNoProcedeElAmparo(){
        mensaje = new JLabel("<html><h4><i>El Amparo no procede por lo siguiente</i></h4></html>");
        this.add(mensaje);
        verticalMainA = new Box(BoxLayout.Y_AXIS);
        verticalMainA.setBorder(new TitledBorder(new EtchedBorder(),"Resultado de Evaluación"));
        verticalMainB = new Box(BoxLayout.Y_AXIS);
        verticalMainB.setBorder(new TitledBorder(new EtchedBorder(),"Criterios Evaluados"));

        consulta = new Query("explicaNo("+clausula+",X)");
        while (consulta.hasMoreSolutions()){
            Hashtable rpt = consulta.nextSolution();
            mensaje = new JLabel("<html><div style='width:250px'><b>» No se cumple que... </b> "+rpt.get("X").toString()+"</div></html>");
            verticalMainA.add(mensaje);
        }

        for(int i=0;i<echoCheck.size();i++){
            if(echoCheck.get(i).isSelected()==true){
                consulta = new Query("criterio("+echoId.get(i)+",X)");
                mensaje = new JLabel("<html><div style='width:250px'><b>»</b> "+consulta.oneSolution().get("X").toString()+"</div></html>");
                verticalMainB.add(mensaje);
            }
        }        
        this.add(verticalMainA);
        this.add(verticalMainB);
    }    
}
