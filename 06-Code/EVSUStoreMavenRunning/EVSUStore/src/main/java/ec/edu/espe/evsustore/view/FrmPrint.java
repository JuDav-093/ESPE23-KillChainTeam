
package ec.edu.espe.evsustore.view;


import ec.edu.espe.evsustore.model.Sale;
import ec.edu.espe.evsustore.utils.EmailUtils;
import ec.edu.espe.evsustore.utils.ViewManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class FrmPrint extends javax.swing.JFrame {

    private Bill bill;
    private Sale sale; 
    

    /**
     * Creates new form FrmPrint
     */
    public FrmPrint() {
        this.bill = new Bill(sale);
        initComponents();

        bill = new Bill();
        showBill();

        JScrollPane pnel = new JScrollPane(bill);
        ViewManager.showPanel(pnelContent, pnel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        pnelContent = new javax.swing.JPanel();
        pnelButtons = new javax.swing.JPanel();
        btnPrint = new javax.swing.JButton();
        btnSendEmail = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnelContent.setBackground(new java.awt.Color(255, 255, 255));
        pnelContent.setAutoscrolls(true);

        javax.swing.GroupLayout pnelContentLayout = new javax.swing.GroupLayout(pnelContent);
        pnelContent.setLayout(pnelContentLayout);
        pnelContentLayout.setHorizontalGroup(
            pnelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );
        pnelContentLayout.setVerticalGroup(
            pnelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnPrint.setText("Imprimir");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnSendEmail.setText("EnviarFactura");
        btnSendEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnelButtonsLayout = new javax.swing.GroupLayout(pnelButtons);
        pnelButtons.setLayout(pnelButtonsLayout);
        pnelButtonsLayout.setHorizontalGroup(
            pnelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnelButtonsLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(pnelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        pnelButtonsLayout.setVerticalGroup(
            pnelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnelButtonsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSendEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(732, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnelContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        openPrinter();
    }//GEN-LAST:event_btnPrintActionPerformed
    
    private void btnSendEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendEmailActionPerformed
         
        
    }//GEN-LAST:event_btnSendEmailActionPerformed

    private void showBill(){
        
        bill.setSize(pnelContent.getWidth()-20, pnelContent.getHeight());
        bill.setLocation(0,0);
        
        JScrollPane scrollPane = new JScrollPane(bill);
        scrollPane.setSize(pnelContent.getWidth(), pnelContent.getHeight());
        scrollPane.setLocation(0,0);
        
        pnelContent.removeAll();
        pnelContent.add(scrollPane);
        pnelContent.revalidate();
        pnelContent.repaint();
        
        makePrintable(bill);
    }
    private void makePrintable(Bill bill){
        
        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                        JOptionPane.showMessageDialog(rootPane, "La impresión ha sido cancelada");
                                
                    }
            }
        }
        );
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
            JOptionPane.showMessageDialog(rootPane, "La impresión ha sido cancelada");   
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new FrmPrint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSendEmail;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnelButtons;
    private javax.swing.JPanel pnelContent;
    // End of variables declaration//GEN-END:variables
}
