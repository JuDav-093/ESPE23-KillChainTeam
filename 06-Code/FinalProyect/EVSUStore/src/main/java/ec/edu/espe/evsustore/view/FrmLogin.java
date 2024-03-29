
package ec.edu.espe.evsustore.view;

import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import ec.edu.espe.evsustore.controller.SessionController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;





/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class FrmLogin extends javax.swing.JFrame {

    SessionController sessionController = SessionController.getInstance();

    public FrmLogin() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        txtOcult.setVisible(false);  
        
    }
    
    private void showMessageWithoutButton(JFrame parentFrame, String message, String title, int delayInMilliseconds, boolean openNextWindow) {
       JDialog dialog = new JDialog(parentFrame, title, true);
       Font font = new Font("Arial", Font.PLAIN, 24); 
       JLabel label = new JLabel(message, SwingConstants.CENTER);
       label.setFont(font);
       dialog.add(label);
       dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       dialog.setSize(300, 200);
       dialog.setLocationRelativeTo(parentFrame);
       dialog.setModal(false);

       Timer timer = new Timer(delayInMilliseconds, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               dialog.dispose(); 
               if (openNextWindow) {
                   openNextWindow();
               }
           }
       });

       timer.setRepeats(false); 
       timer.start();

       dialog.setVisible(true);
   }
    private void openNextWindow() {
        EVSUStore mainApp = new EVSUStore();
        mainApp.setVisible(true);
        dispose();
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSee = new javax.swing.JLabel();
        txtOcult = new javax.swing.JLabel();
        lblRestore = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnSingIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(88, 50, 184));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(44, 45, 57));
        jPanel1.setPreferredSize(new java.awt.Dimension(880, 500));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Title.png"))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desconocido128.png"))); // NOI18N
        jLabel7.setMaximumSize(new java.awt.Dimension(64, 64));
        jLabel7.setMinimumSize(new java.awt.Dimension(64, 64));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");

        txtSee.setForeground(new java.awt.Color(255, 255, 255));
        txtSee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ver_32px.png"))); // NOI18N
        txtSee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSeeMouseClicked(evt);
            }
        });

        txtOcult.setForeground(new java.awt.Color(255, 255, 255));
        txtOcult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ocultar_32px.png"))); // NOI18N
        txtOcult.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtOcult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtOcultMouseClicked(evt);
            }
        });

        lblRestore.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRestore.setForeground(new java.awt.Color(255, 255, 255));
        lblRestore.setText("¿Olvido su contraseña?...Click aqui para recuperarla");
        lblRestore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRestore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRestoreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRestoreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRestoreMouseExited(evt);
            }
        });

        txtUserName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(204, 204, 204));
        txtUserName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUserName.setText("Ingrese Usuario");
        txtUserName.setBorder(null);
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(204, 204, 204));
        txtPassword.setText("Contraseña");
        txtPassword.setBorder(null);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(44, 45, 57));

        btnLogin.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        btnLogin.setText("Ingresar");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        btnExit.setText("Salir");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnSingIn.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        btnSingIn.setText("Registrarse");
        btnSingIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSingIn.setMargin(new java.awt.Insets(10, 20, 10, 20));
        btnSingIn.setPreferredSize(new java.awt.Dimension(150, 50));
        btnSingIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSingInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSingIn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSingIn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblRestore)
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOcult, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(57, 57, 57))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOcult, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSee, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(lblRestore)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        String username = txtUserName.getText().trim();
        char[] passwordChars = txtPassword.getPassword();
        String password = String.valueOf(passwordChars).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Algun campo está vacío, intentelo de nuevo", "ERROR DE INGRESO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            sessionController.migratePasswordsToBCrypt();
            if (sessionController.checkCredentials(username, password)) {
                showMessageWithoutButton(this, "Inicio de sesión exitoso", "EVSUSTORE SYSTEM", 2000, true);
               
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales inválidas", "Inicio de sesión fallido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSingInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSingInActionPerformed
       FrmRegister registerForm = new FrmRegister();
       registerForm.setVisible(true);
       dispose();
    }//GEN-LAST:event_btnSingInActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int option=JOptionPane.YES_NO_OPTION;
        int election=JOptionPane.showConfirmDialog(this,"¿DESEA SALIR?","SALIR",option);
        if(election==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtSeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSeeMouseClicked
        txtSee.setVisible(false);
        txtOcult.setVisible(true);
        txtPassword.setEchoChar((char)0);
    }//GEN-LAST:event_txtSeeMouseClicked

    private void txtOcultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtOcultMouseClicked
        txtOcult.setVisible(false);
        txtSee.setVisible(true);
        txtPassword.setEchoChar('•');
    }//GEN-LAST:event_txtOcultMouseClicked

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        btnLoginActionPerformed(evt);
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void lblRestoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestoreMouseClicked
       FrmRecoverPassword recoverPassword = new FrmRecoverPassword();
       recoverPassword.setVisible(true);
       dispose();
    }//GEN-LAST:event_lblRestoreMouseClicked

    private void lblRestoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestoreMouseEntered
        
        lblRestore.setForeground(Color.GREEN);
        
    }//GEN-LAST:event_lblRestoreMouseEntered

    private void lblRestoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestoreMouseExited
        
        lblRestore.setForeground(Color.WHITE);
        
    }//GEN-LAST:event_lblRestoreMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatDarkPurpleIJTheme.setup();
        UIManager.put( "Button.arc", 999 );
        UIManager.put( "TextComponent.arc", 999 );
        UIManager.put( "Component.focusWidth", 1);
        UIManager.put( "TextComponent.arc", 5 );
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSingIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblRestore;
    private javax.swing.JLabel txtOcult;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JLabel txtSee;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
