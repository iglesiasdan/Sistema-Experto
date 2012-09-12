/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sisexpv1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import jpl.Query;
//import sun.net.www.content.image.jpeg;

/**
 *
 * 
 */
public final class ExplicacionJ extends JFrame implements ActionListener{
    private JLabel mensaje;
    private Box verticalMainA;
    private Box verticalMainB;
    private ArrayList<String> echoId;
    private ArrayList<String> colA=new ArrayList(),colB=new ArrayList();
    private ArrayList<JCheckBox> echoCheck;
    private Query consulta;
    private String clausula;
    private JButton reporteA;
    private JButton reporteB;
    private JButton volver;
    private String usuario;
    private Boolean resp;
    public ExplicacionJ(Boolean respuesta,ArrayList<String> echosId,ArrayList<JCheckBox> echosCheck,String nombre,String user) {
        resp=respuesta;
        echoId = echosId;
        echoCheck = echosCheck;
        clausula = nombre;
        usuario = user;
        setLayout(new BorderLayout());
        reporteA = new JButton("Reporte");
        reporteA.addActionListener(this);
        reporteB = new JButton("Ver mas...");
        reporteB.addActionListener(this);
        volver = new JButton("Volver");
        volver.addActionListener(this);
        if(respuesta == true)
            MensajeSiProcedeElAmparo();
        else
            MensajeNoProcedeElAmparo();
    }
    public void MensajeSiProcedeElAmparo(){
        mensaje = new JLabel("<html><h4><i>El Amparo procede por lo siguiente</i></h4></html>",JLabel.CENTER);
        getContentPane().add(mensaje,BorderLayout.NORTH);

        verticalMainA = new Box(BoxLayout.Y_AXIS);
        verticalMainA.setBackground(Color.white);
        verticalMainA.setBorder(new TitledBorder(new EtchedBorder(),"Resultado de Evaluación"));
        verticalMainB = new Box(BoxLayout.Y_AXIS);
        verticalMainB.setBackground(Color.white);
        verticalMainB.setBorder(new TitledBorder(new EtchedBorder(),"Criterios Evaluados"));

        consulta = new Query("explicaSi("+clausula+",X)");
        while (consulta.hasMoreSolutions()){
            Hashtable rpt = consulta.nextSolution();
            colA.add("Se cumple que..."+rpt.get("X").toString());
            mensaje = new JLabel("<html><div style='width:350px'><b>» Se cumple que... </b> "+rpt.get("X").toString()+"</div></html>");
            verticalMainA.add(mensaje);
        }

        for(int i=0;i<echoCheck.size();i++){
            if(echoCheck.get(i).isSelected()==true){
                consulta = new Query("criterio("+echoId.get(i)+",X)");
                colB.add(consulta.oneSolution().get("X").toString());
                mensaje = new JLabel("<html><div style='width:350px'><b>»</b> "+consulta.oneSolution().get("X").toString()+"</div></html>");
                verticalMainB.add(mensaje);
            }
        }
        JPanel jpBotones = new JPanel(new BorderLayout());
        Box horizontalButtons = new Box(BoxLayout.X_AXIS);
        horizontalButtons.add(reporteA);
        horizontalButtons.add(new JLabel("  "));
        horizontalButtons.add(reporteB);
        horizontalButtons.add(new JLabel("  "));
        horizontalButtons.add(volver);
        horizontalButtons.add(new JLabel("  "));
        jpBotones.add(horizontalButtons,BorderLayout.EAST);

        getContentPane().add(verticalMainA,BorderLayout.WEST);
        getContentPane().add(verticalMainB,BorderLayout.CENTER);
        getContentPane().add(jpBotones,BorderLayout.SOUTH);

        this.pack();
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-(this.getWidth()/2),(Toolkit.getDefaultToolkit().getScreenSize().height/2)-(this.getHeight()/2));
    }
    public void MensajeNoProcedeElAmparo(){
        mensaje = new JLabel("<html><h4><i>El Amparo no procede por lo siguiente</i></h4></html>",JLabel.CENTER);
        getContentPane().add(mensaje,BorderLayout.NORTH);
        verticalMainA = new Box(BoxLayout.Y_AXIS);
        verticalMainA.setBackground(Color.white);
        verticalMainA.setBorder(new TitledBorder(new EtchedBorder(),"Resultado de Evaluación"));
        verticalMainB = new Box(BoxLayout.Y_AXIS);
        verticalMainB.setBackground(Color.white);
        verticalMainB.setBorder(new TitledBorder(new EtchedBorder(),"Criterios Evaluados"));

        consulta = new Query("explicaNo("+clausula+",X)");
        while (consulta.hasMoreSolutions()){
            Hashtable rpt = consulta.nextSolution();
            colA.add("No se cumple que..."+rpt.get("X").toString());
            mensaje = new JLabel("<html><div style='width:350px'><b>» No se cumple que... </b> "+rpt.get("X").toString()+"</div></html>");
            verticalMainA.add(mensaje);
        }

        for(int i=0;i<echoCheck.size();i++){
            if(echoCheck.get(i).isSelected()==true){
                consulta = new Query("criterio("+echoId.get(i)+",X)");
                colB.add(consulta.oneSolution().get("X").toString());
                mensaje = new JLabel("<html><div style='width:350px'><b>»</b> "+consulta.oneSolution().get("X").toString()+"</div></html>");
                verticalMainB.add(mensaje);
            }
        }
        JPanel jpBotones = new JPanel(new BorderLayout());
        Box horizontalButtons = new Box(BoxLayout.X_AXIS);
        horizontalButtons.add(reporteA);
        horizontalButtons.add(new JLabel("  "));
        horizontalButtons.add(reporteB);
        horizontalButtons.add(new JLabel("  "));
        horizontalButtons.add(volver);
        horizontalButtons.add(new JLabel("  "));
        jpBotones.add(horizontalButtons,BorderLayout.EAST);

        getContentPane().add(verticalMainA,BorderLayout.WEST);
        getContentPane().add(verticalMainB,BorderLayout.CENTER);
        getContentPane().add(jpBotones,BorderLayout.SOUTH);

        this.pack();
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-(this.getWidth()/2),(Toolkit.getDefaultToolkit().getScreenSize().height/2)-(this.getHeight()/2));
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reporteA){
            String respuesta;
            respuesta=JOptionPane.showInputDialog(null,"Ingrese el Nº de expediente","Alerta",JOptionPane.INFORMATION_MESSAGE);
            if(respuesta==null){
                this.setVisible(false);
            }
            else{
                //if(respuesta.matches("[A-Z]"))
                GenerarPDF nuevo = new GenerarPDF(false,resp,usuario,respuesta,colA,colB);
                nuevo.AbrirPDF();
                this.setVisible(false);
            }
        }
        if(e.getSource() == reporteB){
            JFrame lbs = new JFrame();
            JButton bpdf1 = new JButton("Ver");
            JButton bpdf2 = new JButton("Ver");
            JButton bpdf3 = new JButton("Ver");
            JButton bpdf4 = new JButton("Ver");
            JButton bhtml1 = new JButton("Ver");
            JButton bhtml2 = new JButton("Ver");
            JButton bhtml3 = new JButton("Ver");

            JLabel lbpdf1 = new JLabel("                  Referencia 0206-2005-PA/TC (P.V.) (Caso: Cesar Baylón Flores) (WORD) Nº1   ");
            JLabel lbpdf2 = new JLabel("                  Referencia 976-2001-AA/TC (Caso: Eusebio LLanos Huasco)(WORD) Nº2   ");
            JLabel lbpdf3 = new JLabel("                  Referencia 03052-2009-PA/TC (P.V.) (Caso: Yolanda Lara Garay)(WORD) Nº3   ");
            JLabel lbpdf4 = new JLabel("                  Referencia LEY 29497Ley Procesal del Trabajo (PDF) ");
            JLabel lbhtml1 = new JLabel("                  Referencia: http://www.tc.gob.pe/jurisprudencia/2005/00206-2005-AA.html   ");
            JLabel lbhtml2 = new JLabel("                  Referencia: http://www.tc.gob.pe/precedentes/03052-2009-AA.html   ");
            JLabel lbhtml3 = new JLabel("                  Referencia: http://www.tc.gob.pe/jurisprudencia/2003/00976-2001-AA.html   ");
            
            lbs.getContentPane().setLayout(new BorderLayout());

            //JLabel pdf = new JLabel("ver PDF");
            //JLabel html=new JLabel("<html><a href='http:\\www.google.com'>ver LINK</a></html>");
            JLabel title=new JLabel("Referencias");
            
            JPanel contenedor = new JPanel(new GridLayout(7,2,120,10));

            bpdf1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                         File path = new File ("referencias/STC206.docx");
                         Desktop.getDesktop().open(path);
                    }catch (IOException ex) {
                    }
                }
            }); 

            bpdf2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                         File path = new File ("referencias/STC2.docx");
                         Desktop.getDesktop().open(path);
                    }catch (IOException ex) {
                    }
                }
            });

            bpdf3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                         File path = new File ("referencias/STC3.docx");
                         Desktop.getDesktop().open(path);
                    }catch (IOException ex) {
                    }
                }
            });

            bpdf4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                         File path = new File ("referencias/LEY29497.pdf");
                         Desktop.getDesktop().open(path);
                    }catch (IOException ex) {
                    }
                }
            });

            bhtml1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        abrirURL1();
                    } catch (IOException ex) {
                        Logger.getLogger(ExplicacionJ.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(ExplicacionJ.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });


            bhtml2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        abrirURL2();
                    } catch (IOException ex) {
                        Logger.getLogger(ExplicacionJ.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(ExplicacionJ.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            bhtml3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        abrirURL3();
                    } catch (IOException ex) {
                        Logger.getLogger(ExplicacionJ.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(ExplicacionJ.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            JPanel vacio = new JPanel(new FlowLayout(FlowLayout.LEFT));

            contenedor.add(lbpdf1,0.7);
            vacio.add(bpdf1);
            contenedor.add(vacio);

            vacio = new JPanel(new FlowLayout(FlowLayout.LEFT));
            contenedor.add(lbpdf2,0.7);
            vacio.add(bpdf2);
            contenedor.add(vacio);

            vacio = new JPanel(new FlowLayout(FlowLayout.LEFT));
            contenedor.add(lbpdf3,0.7);
            vacio.add(bpdf3);
            contenedor.add(vacio);

            vacio = new JPanel(new FlowLayout(FlowLayout.LEFT));
            contenedor.add(lbpdf4,0.7);
            vacio.add(bpdf4);
            contenedor.add(vacio);

            vacio = new JPanel(new FlowLayout(FlowLayout.LEFT));
            contenedor.add(lbhtml1,0.7);
            vacio.add(bhtml1);
            contenedor.add(vacio);

            vacio = new JPanel(new FlowLayout(FlowLayout.LEFT));
            contenedor.add(lbhtml2,0.7);
            vacio.add(bhtml2);
            contenedor.add(vacio);

            vacio = new JPanel(new FlowLayout(FlowLayout.LEFT));
            contenedor.add(lbhtml3,0.7);
            vacio.add(bhtml3);
            contenedor.add(vacio);
            
            /*Box horizontal = new Box(BoxLayout.X_AXIS);
            horizontal.add(lbpdf1);
            horizontal.add(bpdf1);
            verticalA.add(horizontal);
            
            horizontal = new Box(BoxLayout.X_AXIS);
            horizontal.add(lbpdf2);
            horizontal.add(bpdf2);
            verticalA.add(horizontal);

            horizontal = new Box(BoxLayout.X_AXIS);
            horizontal.add(lbpdf3);
            horizontal.add(bpdf3);
            verticalA.add(horizontal);

            horizontal = new Box(BoxLayout.X_AXIS);
            horizontal.add(lbpdf4);
            horizontal.add(bpdf4);
            verticalA.add(horizontal);

            horizontal = new Box(BoxLayout.X_AXIS);
            horizontal.add(lbhtml1);
            horizontal.add(bhtml1);
            verticalA.add(horizontal);

            horizontal = new Box(BoxLayout.X_AXIS);
            horizontal.add(lbhtml2);
            horizontal.add(bhtml2);
            verticalA.add(horizontal);

            horizontal = new Box(BoxLayout.X_AXIS);
            horizontal.add(lbhtml3);
            horizontal.add(bhtml3);
            verticalA.add(horizontal);*/

            JPanel aux = new JPanel(new FlowLayout(FlowLayout.CENTER));
            aux.add(title);

            lbs.getContentPane().add(aux,BorderLayout.NORTH);
            lbs.getContentPane().add(contenedor,BorderLayout.CENTER);            

            lbs.setSize(900,500);
            lbs.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-(lbs.getWidth()/2),(Toolkit.getDefaultToolkit().getScreenSize().height/2)-(lbs.getHeight()/2));
            lbs.setVisible(true);
        }
        if(e.getSource() == volver){
            this.setVisible(false);
        }
    }
    public void abrirURL1() throws IOException, URISyntaxException{
        Desktop.getDesktop().browse(new URI("http://www.tc.gob.pe/jurisprudencia/2005/00206-2005-AA.html"));
    }

    public void abrirURL2() throws IOException, URISyntaxException{
        Desktop.getDesktop().browse(new URI("http://www.tc.gob.pe/precedentes/03052-2009-AA.html"));
    }

    public void abrirURL3() throws IOException, URISyntaxException{
        Desktop.getDesktop().browse(new URI("http://www.tc.gob.pe/jurisprudencia/2003/00976-2001-AA.html"));
    }
}

