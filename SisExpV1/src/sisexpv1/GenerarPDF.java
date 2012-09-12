/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sisexpv1;

/**
 *
 * 
 */
import com.lowagie.text.pdf.*;
import java.awt.Color;
import com.lowagie.text.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import Administrador.*;

public class GenerarPDF {
    private String archivo;
    private String direccion;
    ArrayList varA,varB;
    String msg1="",msg2="",magistrado;
    int dia=0,mes=0,anio=0,hora=0,min=0,seg=0;
    GregorianCalendar calendario;
    ArchivoData data=new ArchivoData("archivos/usuarios.txt");
    public GenerarPDF(boolean more,boolean t,String usuario,String expediente,ArrayList A,ArrayList B) {
        varA=A;
        varB=B;
        magistrado=data.getMagistrado(usuario);
        for(int i=0;i<varA.size();i++)
        {
        msg1=msg1+">> "+varA.get(i)+" \n";
        }
        for(int i=0;i<varB.size();i++)
        {
        msg2=msg2+">> "+varB.get(i)+" \n";
        }

        Document documento = new Document(PageSize.A4.rotate());
        Font font1 = new Font(2 ,15, Font.BOLD);
        Font font2 = new Font(2 ,13, Font.BOLD);
        try{
            archivo = expediente+"_"+Math.random()+".pdf";
            //direccion = "archivos/"+usuario+"/";
            direccion = "archivos/reportes/";

            FileOutputStream nuevo = new FileOutputStream(direccion+archivo);
            PdfWriter.getInstance(documento,nuevo);
            documento.addTitle("  Amparo Laboral");
            documento.addAuthor(usuario);
            documento.open();
            MultiColumnText mct = new MultiColumnText();
            mct.addRegularColumns(documento.left(), documento.right(),20f,1);
            Image foto = Image.getInstance("imagenes/justicia2.jpg");
            foto.scaleToFit(80,80);
            foto.setAlignment(Chunk.ALIGN_LEFT);
            documento.add(foto);
            documento.add(new Paragraph("  Amparo Laboral"));
            documento.add(new Paragraph("EXP. N.°"+expediente+"\n\n"));

            documento.add(new Paragraph("Ha Resultado.\n\n",font1));
            if(t==true)
                documento.add(new Paragraph("En la resolución del Auto Admisorio declarar  PROCEDENTE la demanda de amparo por: \n\n"));
            else
                documento.add(new Paragraph("En la resolución correspondiente declarar IMPROCEDENTE la demanda de amparo por:\n\n"));

            PdfPTable table = new PdfPTable(2);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.setWidthPercentage(100);
	    PdfPCell cell;
	    cell = new PdfPCell(new Paragraph("RESULTADOS DE LA EVALUACION",font2));
            cell.setGrayFill(0.75f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("CRITERIOS EVALUADOS",font2));
            cell.setGrayFill(0.75f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph(msg1));
            table.addCell(cell);
            mct.addElement(table);
            table.setSpacingBefore(100f);

            cell = new PdfPCell(new Paragraph(msg2));
            table.addCell(cell);

            //table.setSpacingAfter(100f);

            documento.add(mct);
            documento.add(mct);

            calendario=new GregorianCalendar();
            anio=calendario.get(GregorianCalendar.YEAR);
            mes=calendario.get(GregorianCalendar.MONTH);
            dia=calendario.get(GregorianCalendar.DAY_OF_MONTH);
            hora=calendario.get(GregorianCalendar.HOUR_OF_DAY);
            min=calendario.get(GregorianCalendar.MINUTE);
            seg=calendario.get(GregorianCalendar.SECOND);

            documento.add(new Paragraph(dia+" / "+(mes+1)+" / "+anio+"\n",font1));
            documento.add(new Paragraph(hora+":"+(min)+":"+seg+"\n",font1));

            documento.add(new Paragraph("Evaluado por:  "+magistrado,font1));



            Font a=new Font(2,12,Font.BOLD,Color.blue);
            Font b=new Font(2,14,Font.BOLD,Color.red);

            if(more==false)
            {
                documento.add(new Paragraph("\nVer más",b));
                documento.add(new Paragraph("http://www.tc.gob.pe/jurisprudencia/2005/00206-2005-AA.html",a));
                documento.add(new Paragraph("http://www.tc.gob.pe/precedentes/03052-2009-AA.html",a));
                documento.add(new Paragraph("http://www.tc.gob.pe/jurisprudencia/2003/00976-2001-AA.html",a));
            }
        } catch (Exception e) { }
      FontFactory.getFont("arial",22,Font.BOLD,Color.blue);
      documento.close();
      documento.open();
    }
    public void AbrirPDF(){
        try {
             File path = new File (direccion+archivo);
             Desktop.getDesktop().open(path);
        }catch (IOException ex) {
        }
    }
    public void AbrirUrl(String direc) throws URISyntaxException{
        try {
            URI url = new URI(direc);
             File path = new File (url);
             Desktop.getDesktop().open(path);
        }catch (IOException ex) {
        }
    }
}