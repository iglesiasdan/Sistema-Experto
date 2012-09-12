/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Administrador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.util.ArrayList;

/**
 *
 * 
 */
public class ArchivoData {
    private String ubicacion;    
    private BufferedReader entrada;
    protected ArrayList<ArrayList<String>> listar;
    public ArchivoData(String name) {        
        listar = new ArrayList<ArrayList<String>>();
        ubicacion = name;
        MostrarContenido1();
    }
    public void EscribirContenido(){
        try{
            FileReader fr = new FileReader(ubicacion);
            PrintWriter pw = new PrintWriter(new FileWriter(ubicacion));
            entrada = new BufferedReader(fr); 

            //limpia txt
            String line = null;
            while ((line = entrada.readLine()) != null) {
                    pw.println(line);
                    pw.flush();
            }            
            entrada.close();
            pw.close();

            FileWriter fw = new FileWriter(ubicacion,true);            
            BufferedWriter bw = new BufferedWriter(fw);           

            PrintWriter salida = new PrintWriter(bw);            

            String texto = "";
            for(int i=0;i<listar.size();i++){
                texto = "";
                for(int j=0;j<listar.get(i).size();j++){                    
                    texto += listar.get(i).get(j)+"/";
                }                
                salida.print(texto+"\n");
            }            
            salida.close();
        }catch(java.io.FileNotFoundException fnfex){
            System.out.println("Archivo no encontrado: " + fnfex);
        }catch(java.io.IOException ioex) {}
    }
    public ArrayList<ArrayList<String>> MostrarContenido() {
        try {
            FileReader fr = new FileReader(ubicacion);            
            entrada = new BufferedReader(fr);                                    
            int s;
            String cadena = new String();
            char caracter;
            CharBuffer b = null;
            ArrayList nuevo = new ArrayList<String>();
            while((s = entrada.read()) != -1){                
                caracter = (char)s;                
                if(caracter != '\n'){
                    if(caracter != '/'){
                        cadena += caracter;                        
                    }else{                        
                        nuevo.add(cadena);                        
                        cadena = new String();
                    }
                }else{
                    listar.add(nuevo);                        
                    nuevo = new ArrayList<String>();
                }                
            }            
            entrada.close();            
        }
        catch(java.io.FileNotFoundException fnfex) {
            System.out.println("Archivo no encontrado: " + fnfex);}
        catch(java.io.IOException ioex) {}
        return listar;
    }
    public final void MostrarContenido1(){
        try {
            FileReader fr = new FileReader(ubicacion);            
            entrada = new BufferedReader(fr);
            int s;
            String cadena = new String();
            char caracter;
            CharBuffer b = null;
            ArrayList nuevo = new ArrayList<String>();
            while((s = entrada.read()) != -1){
                caracter = (char)s;                
                if(caracter != '\n'){
                    if(caracter != '/'){
                        cadena += caracter;
                    }else{
                        nuevo.add(cadena);
                        cadena = new String();
                    }
                }else{
                    listar.add(nuevo);
                    nuevo = new ArrayList<String>();
                }
            }            
            entrada.close();
        }
        catch(java.io.FileNotFoundException fnfex) {
            System.out.println("Archivo no encontrado: " + fnfex);}
        catch(java.io.IOException ioex) {}        
    }
    public ArrayList<String> ListarContenidoUsuario(String user){        
        for(int i=0;i<listar.size();i++){
            if(listar.get(i).get(0).equals(user))
               return listar.get(i);
        }        
        return null;
    }
    public boolean isAdmin(String us,String pas) {        
        for(int i=0;i<listar.size();i++){            
            if(listar.get(i).get(0).equals(us) && listar.get(i).get(1).equals(pas) && listar.get(i).get(2).equals("admin"))
                return true;            
        }
        return false;
    }
    public boolean isUser(String us,String pas) {        
        for(int i=0;i<listar.size();i++){
            if(listar.get(i).get(0).equals(us) && listar.get(i).get(1).equals(pas) 
                    && (listar.get(i).get(2).equals("user")||listar.get(i).get(2).equals("admin"))
                    && listar.get(i).get(3).equals("activo"))
                return true;            
        }
        return false;
    }
    ///////////////////////////////////////
    public String getMagistrado(String user){
        MostrarContenido1();
        String a="";

        for(int i=0;i<listar.size();i++)
        {
           System.out.println("**"+listar.get(i).get(5).toString());
           if(listar.get(i).get(0).equals(user))
            {

                a=listar.get(i).get(4).toString()+"  "+listar.get(i).get(5).toString();
            }
        }
        return a;
    }
}
