package Administrador;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class ModeloTablaReporte extends AbstractTableModel{
    String titles[] = new String[] {"Numero","Nombre de Archivo","Fecha","Usuario","Mostrar"};
    
    Class types[] = new Class[] {String.class, String.class, String.class, String.class, Volume.class};

    Object filas[][];

    public ModeloTablaReporte() { this("."); }
    public ModeloTablaReporte(String dir) {
        File pwd = new File(dir);
        setFileStats();
    }
    public final void setFileStats() {
        ArchivoData datos = new ArchivoData("archivos/reportes/reportes.txt");
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
            for(int j=0;j<nuevo.get(i).size();j++){
                filas[i][nuevo.get(i).size()] = new Volume(i);
                filas[i][j] = nuevo.get(i).get(j);
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
