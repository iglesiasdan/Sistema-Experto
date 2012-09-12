/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Administrador;

import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 *
 */
public class TablaRenderer extends JRadioButton implements TableCellRenderer {
    //protected transient ButtonGroup coleccion;
     public TablaRenderer( ) {        
        // Set a starting size. Some 1.2/1.3 systems need this.
        setSize(115,15);
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        return this;
    }
}
