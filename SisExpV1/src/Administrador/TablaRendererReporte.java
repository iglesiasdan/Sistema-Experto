/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Administrador;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * 
 */
public class TablaRendererReporte extends JButton implements TableCellRenderer{
    //protected transient ButtonGroup coleccion;
     public TablaRendererReporte( ) {        
        setSize(115,15);
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}
