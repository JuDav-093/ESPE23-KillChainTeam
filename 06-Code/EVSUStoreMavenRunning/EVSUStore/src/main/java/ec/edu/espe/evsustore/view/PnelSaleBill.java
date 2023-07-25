
package ec.edu.espe.evsustore.view;

import ec.edu.espe.evsustore.model.Sale;
import ec.edu.espe.evsustore.utils.EmailUtils;
import ec.edu.espe.evsustore.utils.ViewManager;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import javax.mail.MessagingException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class PnelSaleBill extends javax.swing.JPanel {
    Bill bill;
    Sale sale;
    /**
     * Creates new form PnelSaleBill
     */
    public PnelSaleBill(Sale sale) {
        this.sale = sale;
        initComponents();
        
        showBill();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnelContent = new javax.swing.JPanel();
        pnelBillPreview = new javax.swing.JPanel();
        pnelButtons = new javax.swing.JPanel();
        btnPrint = new javax.swing.JButton();
        btnSendToEmail = new javax.swing.JButton();

        javax.swing.GroupLayout pnelBillPreviewLayout = new javax.swing.GroupLayout(pnelBillPreview);
        pnelBillPreview.setLayout(pnelBillPreviewLayout);
        pnelBillPreviewLayout.setHorizontalGroup(
            pnelBillPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );
        pnelBillPreviewLayout.setVerticalGroup(
            pnelBillPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnPrint.setText("Imprimir Factura");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnSendToEmail.setText("Enviar Factura al Correo del Cliente");
        btnSendToEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendToEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnelButtonsLayout = new javax.swing.GroupLayout(pnelButtons);
        pnelButtons.setLayout(pnelButtonsLayout);
        pnelButtonsLayout.setHorizontalGroup(
            pnelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSendToEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnelButtonsLayout.setVerticalGroup(
            pnelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnelButtonsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnSendToEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(438, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnelContentLayout = new javax.swing.GroupLayout(pnelContent);
        pnelContent.setLayout(pnelContentLayout);
        pnelContentLayout.setHorizontalGroup(
            pnelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnelBillPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnelContentLayout.setVerticalGroup(
            pnelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnelContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnelBillPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendToEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendToEmailActionPerformed
        sendToEmail();
    }//GEN-LAST:event_btnSendToEmailActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        openPrinter();
    }//GEN-LAST:event_btnPrintActionPerformed
    
    private void showBill(){
        this.bill = new Bill(sale);
        JScrollPane scrollPane = new JScrollPane(bill);
        scrollPane.setSize(pnelContent.getWidth(), 820);
        scrollPane.setLocation(0,0);
        
        ViewManager.showPanel(pnelBillPreview, scrollPane);
    }
    
    private void sendToEmail(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFolder = fileChooser.getSelectedFile();
            String folderPath = selectedFolder.getAbsolutePath() + File.separator + "Facturas";

            // Crear la carpeta si no existe
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            bill.saveBill(folderPath);

            String recipientEmail = bill.getCustomerEmail(); 
            String subject = "EVSU STORE FACTURA";
            String body = "Se adjunta la factura de su compra realizada, gracias por preferirnos.";

            try {
                String filePath = folderPath + File.separator + "Factura.pdf";

                EmailUtils.sendEmailWithAttachment(recipientEmail, subject, body, filePath);

                File pdfFile = new File(filePath);
                JOptionPane.showMessageDialog(null, "El correo se envió correctamente.");
            } catch (MessagingException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ocurrió un error al enviar el correo.");
            }
        }
    }
    
    private void openPrinter(){
       PrinterJob printerJob = PrinterJob.getPrinterJob();
       printerJob.setPrintable(bill);
        if(printerJob.printDialog()){
            try{
                printerJob.print();
            }
            catch(PrinterException ex){
                
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "La impresión ha sido cancelada");   
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSendToEmail;
    private javax.swing.JPanel pnelBillPreview;
    private javax.swing.JPanel pnelButtons;
    private javax.swing.JPanel pnelContent;
    // End of variables declaration//GEN-END:variables
}