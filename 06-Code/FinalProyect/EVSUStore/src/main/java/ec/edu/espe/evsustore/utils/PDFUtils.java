package ec.edu.espe.evsustore.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class PDFUtils {

    public static void convertPanelToPDF(JPanel panel, String folderPath, String fileName) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(folderPath + File.separator + fileName));
            document.open();
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(panel.getWidth(), panel.getHeight());
            Graphics2D g2 = template.createGraphics(panel.getWidth(), panel.getHeight());
            panel.print(g2);
            g2.dispose();


            contentByte.addTemplate(template, 0, 0);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}