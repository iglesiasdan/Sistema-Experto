/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sisexpv1;

/**
 *
 * 
 */
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.*;
import java.awt.Color;
import com.lowagie.text.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GenerarAll{
    private String archivo;
    private String direccion;
    ArrayList varA,varB,varC,varD,varE,varF;
    String msg1="",msg2="",msg3="",msg4="",msg5="",msg6="";
    public GenerarAll() {
        Requisitos rq=new Requisitos("",null);
        Injustificado rq1=new Injustificado("");
        Incausado rq2=new Incausado("");
        Nulo rq3=new Nulo("");
        Fraudulento rq4=new Fraudulento("");
        RegimenPublico rq5=new RegimenPublico("");
        
        varA=rq.echoDesCriterio();
        varB=rq1.echoDesCriterio();
        varC=rq2.echoDesCriterio();
        varD=rq3.echoDesCriterio();
        varE=rq4.echoDesCriterio();
        varF=rq5.echoDesCriterio();

        for(int i=0;i<varA.size();i++)
        {
        msg1=msg1+(i+1)+".-"+varA.get(i)+" \n\n";
        }
            for(int i=0;i<varB.size();i++)
        {
        msg2=msg2+(i+1)+".-"+varB.get(i)+" \n\n\n";
        }
            for(int i=0;i<varC.size();i++)
        {
        msg3=msg3+(i+1)+".-"+varC.get(i)+" \n\n\n";
        }
        for(int i=0;i<varD.size();i++)
        {
        msg4=msg4+(i+1)+".-"+varD.get(i)+" \n\n";
        }
            for(int i=0;i<varE.size();i++)
        {
        msg5=msg5+(i+1)+".-"+varE.get(i)+" \n\n\n";
        }
        for(int i=0;i<varF.size();i++)
        {
        msg6=msg6+(i+1)+".-"+varF.get(i)+" \n\n\n";
        }

        Document documento = new Document();
        try{
            archivo = "Reporte.pdf";
            direccion = "archivos/";
            FileOutputStream nuevo = new FileOutputStream(direccion+archivo);
            PdfWriter.getInstance(documento,nuevo);


            documento.addTitle("Amparo Laboral");
            documento.open();
            
            Image foto = Image.getInstance("imagenes/justicia2.jpg");
            foto.scaleToFit(60,80);
            foto.setAlignment(Chunk.ALIGN_LEFT);
            documento.add(foto);
            Font font = new Font(2 ,6, Font.BOLD);
            Font title = new Font(2 ,14, Font.BOLD);
            Font font1 = new Font(2 ,12, Font.BOLD);
            
            Paragraph paragraph = new Paragraph("CRITERIOS DE EVALUACION DE AMPARO EN MATERIA LABORAL",title);
            documento.add(new Paragraph("      AMPARO LABORAL",font));
            paragraph.setAlignment(Element.ALIGN_CENTER);
            documento.add(paragraph);
            
            PdfPTable table = new PdfPTable(1);
            table.setSpacingBefore(40f);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.setWidthPercentage(100);
	    PdfPCell cell;
	    cell = new PdfPCell(new Paragraph("CRITERIOS DE REQUISITO ",font1));
            cell.setGrayFill(0.75f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph(msg1));
            table.addCell(cell);
            documento.add(table);
            
            documento.newPage();
            PdfPTable table2 = new PdfPTable(1);
            table2.setHorizontalAlignment(Element.ALIGN_LEFT);
            table2.setWidthPercentage(100);
	    PdfPCell cell1;
	    cell1 = new PdfPCell(new Paragraph("CRITERIOS DE INJUSTIFICADO ",font1));
            cell1.setGrayFill(0.75f);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.addCell(cell1);
            cell1 = new PdfPCell(new Paragraph(msg2));
            table2.addCell(cell1);
            documento.add(table2);
            //table2.setSpacingBefore(100f);

            documento.newPage();
            PdfPTable table3 = new PdfPTable(1);
            table3.setHorizontalAlignment(Element.ALIGN_LEFT);
            table3.setWidthPercentage(100);
	    PdfPCell cell2;
	    cell2 = new PdfPCell(new Paragraph("CRITERIOS DE INCAUSADO ",font1));
            cell2.setGrayFill(0.75f);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table3.addCell(cell2);
            cell2 = new PdfPCell(new Paragraph(msg3));
            table3.addCell(cell2);
            documento.add(table3);
            //table3.setSpacingBefore(100f);
            //table.setSpacingAfter(100f);

            documento.newPage();
            PdfPTable table4 = new PdfPTable(1);
            table4.setHorizontalAlignment(Element.ALIGN_LEFT);
            table4.setWidthPercentage(100);
	    PdfPCell cell3;
	    cell3 = new PdfPCell(new Paragraph("CRITERIOS DE NULO",font1));
            cell3.setGrayFill(0.75f);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            table4.addCell(cell3);
            cell3 = new PdfPCell(new Paragraph(msg4));
            table4.addCell(cell3);
            documento.add(table4);
            //table4.setSpacingBefore(100f);

            documento.newPage();
            PdfPTable table5 = new PdfPTable(1);
            table5.setHorizontalAlignment(Element.ALIGN_LEFT);
            table5.setWidthPercentage(100);
	    PdfPCell cell4;
	    cell4 = new PdfPCell(new Paragraph("CRITERIOS DE FRAUDULENTO ",font1));
            cell4.setGrayFill(0.75f);
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            table5.addCell(cell4);
            cell4 = new PdfPCell(new Paragraph(msg5));
            table5.addCell(cell4);
            documento.add(table5);
            //table5.setSpacingBefore(100f);

            documento.newPage();
            PdfPTable table6 = new PdfPTable(1);
            table6.setHorizontalAlignment(Element.ALIGN_LEFT);
            table6.setWidthPercentage(100);
	    PdfPCell cell5;
	    cell5 = new PdfPCell(new Paragraph("CRITERIOS DE REGIMEN PUBLICO ",font1));
            cell5.setGrayFill(0.75f);
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            table6.addCell(cell5);
            cell5 = new PdfPCell(new Paragraph(msg6));
            table6.addCell(cell5);
            documento.add(table6);
            //table3.setSpacingBefore(100f);




            //documento.add(new Paragraph(""));
            //documento.add(new Paragraph("aki todo el contenido"));

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
}