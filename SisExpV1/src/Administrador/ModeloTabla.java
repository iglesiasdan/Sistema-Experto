/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Administrador;

import java.io.File;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * 
 */
public class ModeloTabla extends AbstractTableModel{
    String titles[] = new String[] {"Select","Usuario","Password","Privilegio","Estado de Cuenta","Nombres","Apellidos","Cargo","Tiempo de uso del Sistema"};
    //667
    Class types[] = new Class[] {Volume.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};

    Object filas[][];
    
    public ModeloTabla() { this("."); }
    public ModeloTabla(String dir) {
        File pwd = new File(dir);
        setFileStats();
    }
    public final void setFileStats() {
        ArchivoData datos = new ArchivoData("archivos/usuarios.txt");
        ArrayList<ArrayList<String>> nuevo = datos.listar;
        //data = new Object[files.length][titles.length];
        //Object columnas[] = {new JRadioButton(),"Usuario","Password","Privilegio","Estado de Cuenta","Nombres","Apellidos","Cargo","Tiempo de uso del Sistema"};
        filas = new Object[nuevo.size()][nuevo.get(0).size()+1];
        /*for (int i=0; i < files.length; i++) {
            File tmp = new File(files[i]);
            data[i][0] = new Boolean(tmp.isDirectory( ));
            data[i][1] = tmp.getName( );
            data[i][2] = new String(tmp.canRead( ));
            data[i][3] = new String(tmp.canWrite( ));
            data[i][4] = new String(tmp.length( ));
            data[i][5] = new String(tmp.lastModified( ));
            data[i][6] = new String(tmp.lastModified( ));
            data[i][7] = new String(tmp.lastModified( ));
            data[i][8] = new String(tmp.lastModified( ));
        }*/
        for(int i=0;i<nuevo.size();i++){
            for(int j=1;j<nuevo.get(i).size()+1;j++){                
                filas[i][0] = new Volume(i);
                filas[i][j] = nuevo.get(i).get(j - 1);
            }
        }

        // Just in case anyone's listening
        fireTableDataChanged( );
    }
    public int getRowCount() {
        return filas.length;
    }
    public int getColumnCount() {
        return titles.length;
    }
    @Override
    public String getColumnName(int c){
        return titles[c];
    }
    @Override
    public Class getColumnClass(int c){
        return types[c];
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        return filas[rowIndex][columnIndex];
    }
    @Override
    public boolean isCellEditable(int r, int c) {
        getValueAt(r, c);
        return true;
    }        
}
