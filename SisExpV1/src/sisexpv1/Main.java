/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sisexpv1;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // TODO code application logic here  
        try {
           //UIManager.setLookAndFeel("org.fife.plaf.Office2003.Office2003LookAndFeel");
           //UIManager.setLookAndFeel("org.fife.plaf.OfficeXP.OfficeXPLookAndFeel");
           //UIManager.setLookAndFeel("org.fife.plaf.VisualStudio2005.VisualStudio2005LookAndFeel");
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
           System.err.println("Error al cargar Look And Feel");
        }
        JFrame.setDefaultLookAndFeelDecorated(false);

        JFrame presentacion = new JFrame();        
        presentacion.setSize(500,320);
        presentacion.setUndecorated(true);
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BorderLayout());        
        contenedor.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        ImageIcon imagen = new ImageIcon("imagenes/fondomain.jpg");
        JLabel fondo = new JLabel(imagen);
        final JProgressBar barcompletar = new JProgressBar();        
        barcompletar.setOrientation(JProgressBar.HORIZONTAL);        
        barcompletar.setMinimum(0);
        barcompletar.setMaximum(100);        

        contenedor.add(fondo,BorderLayout.NORTH);
        contenedor.add(barcompletar,BorderLayout.SOUTH);

        presentacion.getContentPane().add(contenedor);

        presentacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        presentacion.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2)-(presentacion.getWidth()/2),(Toolkit.getDefaultToolkit().getScreenSize().height/2)-(presentacion.getHeight()/2));        
        presentacion.setVisible(true);

        for (int i = 0; i <= 100; i++) {
          final int percent = i;          
          try {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                  barcompletar.setValue(percent);                  
                }
            });
            java.lang.Thread.sleep(50);
          } catch (InterruptedException e) {}
        }
        presentacion.setVisible(false);
        Inicio login = new Inicio();
    }
}
