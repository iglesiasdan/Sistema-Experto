/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Administrador;

import java.awt.Component;
import java.io.File;
import java.util.EventObject;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

/**
 *
 * 
 */
public class TablaEditor extends JRadioButton implements TableCellEditor {    
    protected transient Vector listeners;
    protected transient int originalValue;
    protected transient boolean editing;

    public TablaEditor(ButtonGroup coleccion) {
        listeners = new Vector( );
        coleccion.add(this);
    }
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        /*if(isSelected == true){
            setSelected(true);
        }*/
        return this;
    }

    public Object getCellEditorValue() {
        return this;
    }

    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    public boolean stopCellEditing() {
        return true;
    }
    public void addCellEditorListener(CellEditorListener cel) {
        listeners.addElement(cel);
    }
    public void removeCellEditorListener(CellEditorListener cel) {
        listeners.removeElement(cel);
    }
    public void cancelCellEditing() {
        editing = false;
    }
}
