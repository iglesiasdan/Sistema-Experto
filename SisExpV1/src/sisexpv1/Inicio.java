/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sisexpv1;

import Administrador.ArchivoData;
import Administrador.Administracion;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * 
 */
public class Inicio implements ActionListener{
    private JFrame frame;
    private JLabel login;
    private JLabel imagen;
    private JLabel imagenusuario;
    private JLabel imagencontra;
    private JTextField campo1;
    private JLabel contrasenia;
    private JPasswordField campo2;
    private JButton aceptar;
    private JButton reset;
    private JPanel panel;
    private JCheckBox admin;

    public Inicio(){
        frame=new JFrame();
        frame.setSize(360,260);
        frame.setTitle("Ingreso al Sistema Experto");
        frame.setResizable(false);

        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        imagen=new JLabel();
        imagen.setIcon(new ImageIcon("imagenes/baner.jpg"));
        imagen.setBounds(0,0,320,100);
        imagenusuario=new JLabel();
        imagenusuario.setIcon(new ImageIcon("imagenes/cliente.png"));
        imagenusuario.setBounds(50,95,30,30);
        login=new JLabel("Usuario");
        login.setBounds(80,100,80,20);
        campo1=new JTextField();
        campo1.setBounds(140,100,150,22);
        imagencontra=new JLabel();
        imagencontra.setIcon(new ImageIcon("imagenes/llave.jpg"));
        imagencontra.setBounds(30,125,30,30);
        contrasenia=new JLabel("Contraseña");
        contrasenia.setBounds(60,130,100, 20);
        campo2=new JPasswordField();
        campo2.setBounds(140,130,150,22);
        admin=new JCheckBox("Como Administrador");
        admin.setBounds(95,160,200, 20);
        admin.setBackground(Color.white);
        aceptar=new JButton("Aceptar");
        aceptar.setBounds(70,190,100,23);
        aceptar.addActionListener(this);
        aceptar.setToolTipText("Ingrese sus datos para verficar");
        reset=new JButton("Reset");
        reset.setBounds(190,190,100,23);
        reset.addActionListener(this);
        reset.setToolTipText("Reinicio de datos en los campos");        

        panel.add(imagen);
        panel.add(imagenusuario);
        panel.add(login);
        panel.add(campo1);
        panel.add(imagencontra);
        panel.add(contrasenia);
        panel.add(campo2);
        panel.add(admin);
        panel.add(aceptar);
        panel.add(reset);                

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-(frame.getWidth()/2),(Toolkit.getDefaultToolkit().getScreenSize().height/2)-(frame.getHeight()/2));
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==reset){
            campo1.setText("");
            campo2.setText("");
        }
        if(e.getSource()==aceptar){
            ArchivoData usuario = new ArchivoData("archivos/usuarios.txt");            
            if(admin.isSelected() == true){
                if(usuario.isAdmin(campo1.getText(),(campo2.getText()))){
                    try {
                        Administracion administrador = new Administracion(campo1.getText());
                        frame.setVisible(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrecta");
                }
            }else{
                if(usuario.isUser(campo1.getText(),(campo2.getText()))){                    
                    try {
                        Principal principal = new Principal(campo1.getText());
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (HelpSetException ex) {
                        Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frame.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrecta");
                }
            }
        }
    }    
}
