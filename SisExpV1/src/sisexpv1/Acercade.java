package sisexpv1;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Acercade
{
    private JDialog dialogo;
    private JLabel imagen;
    private JLabel texto;

    public Acercade()
    {
        dialogo=new JDialog();
        imagen=new JLabel();

        dialogo.setTitle("Acerca de");
        dialogo.setResizable(false);
        dialogo.setSize(400,400);

        texto=new JLabel("<html><h3><center>ACERCA DE:</center></h3>"+"<p><div align='justify'>El presente es un Sistema Experto, es decir un sistema informático especializado, el cual mediante la base de conocimiento que posee, compuesta por hechos y reglas de decisión, " +
                "puede inferir emulando a un experto humano una decisión respecto a un área del dominio específico del conocimiento.</div></p> " +
                "<p><div align='justify'>Este Sistema Experto es capaz de evaluar los requisitos y criterios de procedibilidad de las demandas de amparo en materia laboral, aproximando a una decisión, " +
                "la misma que el propio sistema será capaz de explicar sus fundamentos.</div></p></html>");
        texto.setBounds(10,10,380,200);

	imagen.setIcon(new ImageIcon("imagenes/fondo.jpg"));
	imagen.setBounds(150,215,136,127);
        dialogo.setLayout(null);
	dialogo.add(texto);
        dialogo.add(imagen);

        dialogo.setBackground(Color.white);
        dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-(dialogo.getWidth()/2),(Toolkit.getDefaultToolkit().getScreenSize().height/2)-(dialogo.getHeight()/2));
        dialogo.setVisible(true);
    }    
}
