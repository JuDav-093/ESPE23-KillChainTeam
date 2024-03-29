
package ec.edu.espe.evsustore.view;

import ec.edu.espe.evsustore.controller.CatalogController;
import ec.edu.espe.evsustore.controller.HardwareComponentController;
import ec.edu.espe.evsustore.controller.PurchaseController;
import ec.edu.espe.evsustore.model.Catalog;
import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.model.Purchase;
import ec.edu.espe.evsustore.utils.DecimalsControl;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class PnelSaveHardwareComponent extends javax.swing.JPanel {

    HardwareComponentController componentController = HardwareComponentController.getInstance();
    PurchaseController purchaseController = PurchaseController.getInstance();
    
    /**
     * Creates new form PnelSaveHardwareComponent
     */
    public PnelSaveHardwareComponent() {
        initComponents();
        
        int generatedId = componentController.generateId();
        txtId.setText(String.valueOf(generatedId));
        
        btnClear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    clearFieldsOption();

                }
            }
        );
        
        putLogo();
        addListeners();
    }
    
    public PnelSaveHardwareComponent(int idOfUpdatingComponent) {
        initComponents();
        
        fillFields(componentController.obtainFromDb(idOfUpdatingComponent));

        btnClear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    clearFieldsOption(idOfUpdatingComponent);

                }
            }
        );
        
        putLogo();
        addListeners();
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
        Content = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtCost = new javax.swing.JTextField();
        txtGainPercentage = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        msgWarningQuantity = new javax.swing.JLabel();
        msgWarningCost = new javax.swing.JLabel();
        msgWarningGainPercentage = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBackToMainMenu = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(18, 9, 24));

        Content.setBackground(new java.awt.Color(18, 9, 24));
        Content.setPreferredSize(new java.awt.Dimension(900, 675));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GUARDAR COMPONENTE DE HARDWARE");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Modelo:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad:");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Costo (Por unidad): $");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("% de Ganancia:");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PVP (Sin incluir impuestos): $");

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(169, 104, 216));
        txtId.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtId.setCaretColor(new java.awt.Color(169, 104, 216));
        txtId.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtId.setEnabled(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtName.setBackground(new java.awt.Color(231, 231, 246));
        txtName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(133, 44, 194));

        txtModel.setBackground(new java.awt.Color(231, 231, 246));
        txtModel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtModel.setForeground(new java.awt.Color(133, 44, 194));

        txtQuantity.setBackground(new java.awt.Color(231, 231, 246));
        txtQuantity.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(133, 44, 194));

        txtCost.setBackground(new java.awt.Color(231, 231, 246));
        txtCost.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCost.setForeground(new java.awt.Color(133, 44, 194));

        txtGainPercentage.setBackground(new java.awt.Color(231, 231, 246));
        txtGainPercentage.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtGainPercentage.setForeground(new java.awt.Color(133, 44, 194));
        txtGainPercentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGainPercentageActionPerformed(evt);
            }
        });

        txtPrice.setEditable(false);
        txtPrice.setBackground(new java.awt.Color(231, 231, 246));
        txtPrice.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(133, 44, 194));

        msgWarningQuantity.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        msgWarningQuantity.setForeground(new java.awt.Color(213, 0, 0));
        msgWarningQuantity.setText(" ");

        msgWarningCost.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        msgWarningCost.setForeground(new java.awt.Color(213, 0, 0));
        msgWarningCost.setText(" ");

        msgWarningGainPercentage.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        msgWarningGainPercentage.setForeground(new java.awt.Color(213, 0, 0));
        msgWarningGainPercentage.setText(" ");

        lblLogo.setBackground(new java.awt.Color(18, 9, 24));
        lblLogo.setForeground(new java.awt.Color(18, 9, 24));
        lblLogo.setText(" ");

        btnSave.setBackground(new java.awt.Color(92, 50, 118));
        btnSave.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Guardar");
        btnSave.setToolTipText("No puede guardar si faltan campos por llenar");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(92, 50, 118));
        btnClear.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Limpiar Campos");

        btnBackToMainMenu.setBackground(new java.awt.Color(92, 50, 118));
        btnBackToMainMenu.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnBackToMainMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnBackToMainMenu.setText("Volver al Menú Inventario");
        btnBackToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToMainMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContentLayout.createSequentialGroup()
                .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContentLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ContentLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtGainPercentage))
                            .addGroup(ContentLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(41, 41, 41)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ContentLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ContentLayout.createSequentialGroup()
                                .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtModel)
                                    .addComponent(txtQuantity)))
                            .addGroup(ContentLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtCost))
                            .addGroup(ContentLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrice))))
                    .addGroup(ContentLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContentLayout.createSequentialGroup()
                        .addComponent(btnBackToMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(msgWarningCost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                        .addComponent(msgWarningQuantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(msgWarningGainPercentage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ContentLayout.createSequentialGroup()
                            .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(259, 259, 259))
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentLayout.createSequentialGroup()
                .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContentLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(msgWarningQuantity))
                    .addGroup(ContentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(59, 59, 59)
                        .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msgWarningCost)
                    .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtGainPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContentLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(msgWarningGainPercentage))
                    .addGroup(ContentLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBackToMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Content, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtGainPercentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGainPercentageActionPerformed
        
    }//GEN-LAST:event_txtGainPercentageActionPerformed

    private void btnBackToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMainMenuActionPerformed
        PnelInventory pnelInventory=new PnelInventory();
        showPanel(pnelInventory);
    }//GEN-LAST:event_btnBackToMainMenuActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        HardwareComponent enteredComponent = readComponent();
        
        if(componentController.isInDB(enteredComponent)){
            updateConfirmation(enteredComponent);
        }
        else{
            saveConfirmation(enteredComponent);
            Purchase purchase = new Purchase(purchaseController.generateId(), enteredComponent, enteredComponent.getCost()*enteredComponent.getQuantity(), LocalDate.now());
            purchaseController.save(purchase);
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

                                        

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //
    }                                        

    private void btnClearUpdatingActionPerformed(java.awt.event.ActionEvent evt, int id) {                                         
        //
    }   
    
    private void saveConfirmation(HardwareComponent enteredComponent){

        String warningMessage = "¿Está seguro de que quiere guardar el siguiente producto?\n";
        String component = enteredComponent.toString().replace("\t|| ", "\n");

        int option = JOptionPane.showConfirmDialog(this, warningMessage + component);
        JRootPane rootPane = new JRootPane();

        if (option == 0) {
            boolean isSaved = componentController.save(enteredComponent);
            if(isSaved){
                JOptionPane.showMessageDialog(rootPane, "Se ha guardado exitosamente");
                clearFields();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Hubo un error al guardar el archivo, intentelo nuevamente");
            }
            
        } else if (option == 1) {
            JOptionPane.showMessageDialog(rootPane, "No guardado");
            clearFields();
        }
    }
    
    private void updateConfirmation(HardwareComponent enteredComponent){

        String warningMessage = "¿Está seguro de que quiere actualizar el producto con los siguientes datos?\n";
        String component = enteredComponent.toString().replace("\t|| ", "\n");

        int option = JOptionPane.showConfirmDialog(this, warningMessage + component);
        JRootPane rootPane = new JRootPane();

        if (option == 0) {
            boolean isUpdated = componentController.update(enteredComponent);
            if(isUpdated){
                JOptionPane.showMessageDialog(rootPane, "Se ha actualizado exitosamente");
                clearFields();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Hubo un error al actualizar el archivo, intentelo nuevamente");
            }
            
        } else if (option == 1) {
            JOptionPane.showMessageDialog(rootPane, "No guardado");
            clearFields();
        }
    }
    
    private void showPanel(JPanel panelUI) {
        panelUI.setSize(900, 675);
        panelUI.setLocation(0, 0);
        Content.removeAll();
        Content.add(panelUI, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }
    
    private void addListeners(){
        
        txtCost.addKeyListener(doubleListener());
        txtGainPercentage.addKeyListener(doubleListener());
        txtCost.getDocument().addDocumentListener(fillPriceListener());
        txtGainPercentage.getDocument().addDocumentListener(fillPriceListener());
        txtQuantity.addKeyListener(integerListener());
        
        txtId.getDocument().addDocumentListener(allFieldsFilledListener());
        txtName.getDocument().addDocumentListener(allFieldsFilledListener());
        txtModel.getDocument().addDocumentListener(allFieldsFilledListener());
        txtQuantity.getDocument().addDocumentListener(allFieldsFilledListener());
        txtCost.getDocument().addDocumentListener(allFieldsFilledListener());
        txtGainPercentage.getDocument().addDocumentListener(allFieldsFilledListener());
        txtPrice.getDocument().addDocumentListener(allFieldsFilledListener());
    }
    
    private KeyListener doubleListener (){
        KeyListener doubleKeyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateTypedDoubleNumbers(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            
            }

            @Override
            public void keyReleased(KeyEvent e) {
             
            }
        };
        return doubleKeyListener;
    }
    
    private KeyListener integerListener (){
        KeyListener integerListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateTypedIntegerNumbers(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
              
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        };
        return integerListener;
    }
    
    private KeyListener alphabeticListener (){
        KeyListener alphabeticKeyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateTypedCharacters(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
              
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        };
        return alphabeticKeyListener;
    }
    
    private DocumentListener allFieldsFilledListener(){
        DocumentListener allFieldsFilledListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }
        };
        return allFieldsFilledListener;
    }
    
    private DocumentListener fillPriceListener(){
        DocumentListener filledPriceListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calculatePrice();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calculatePrice();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calculatePrice();
            }
        };
        return filledPriceListener;
    }
    
    private void calculatePrice () { 
        if(txtCost.getText().isEmpty() || txtGainPercentage.getText().isEmpty()){
            txtPrice.setText("");
        }
        else{
            Double cost = Double.valueOf(txtCost.getText());
            Double gain = Double.valueOf(txtGainPercentage.getText());
            Double price = componentController.calculatePrice(cost, gain);
            
            String priceText = String.format ("%.2f", DecimalsControl.roundToTwoTenths(price)); 
            if(priceText.contains(",")){
                priceText = priceText.replace(",", ".");
            }
            txtPrice.setText(priceText);

            
        }
        

    }
    
    private void checkFields(){
        if(txtId.getText().isEmpty() || txtName.getText().isEmpty() || txtModel.getText().isEmpty()
                || txtQuantity.getText().isEmpty() || txtCost.getText().isEmpty() 
                || txtGainPercentage.getText().isEmpty() || txtPrice.getText().isEmpty())
        {
            btnSave.setEnabled(false); 
            btnSave.setToolTipText("No puede guardar el componente si faltan datos por llenar");
        }
        else {
            btnSave.setEnabled(true);
            btnSave.setToolTipText("Guardar el componente en la base de datos");
        }
    }
    
    private void validateTypedCharacters (java.awt.event.KeyEvent evt) { 
        char enteredChar = evt.getKeyChar ();  
        if (!Character.toString (enteredChar).matches ("[a-zA-ZáéíóúÁÉÍÓÚñÑ]")){
            evt.consume ();
        } 
    }
    
    private void validateTypedDoubleNumbers (java.awt.event.KeyEvent evt) { 
        
        char enteredChar = evt.getKeyChar ();
        if (!Character.toString (enteredChar).matches ("[0-9]") && !Character.toString (enteredChar).matches("\\.")) {
            evt.consume ();
        }
        else {
            JTextField field = (JTextField) evt.getSource ();
            String numbersText = field.getText ();
            if(numbersText!=null){
                if (numbersText.matches ("[0-9]{1,6}+\\.{1}[0-9]{2}")) {
                    evt.consume();
                    
                }
                else if(Character.toString (enteredChar).matches("\\.") && field.getText().contains(".") ){
                    evt.consume ();
                }
            }
            
        }
    }
    
    private void validateTypedIntegerNumbers (java.awt.event.KeyEvent evt) { 
        
        char enteredChar = evt.getKeyChar ();
        if (!Character.toString (enteredChar).matches ("[0-9]+")) {
            evt.consume ();
        }
        else {
            
        }
    }
    
    private HardwareComponent readComponent() {                                          
        int id = Integer.parseInt(txtId.getText());
        int quantity = Integer.parseInt(txtQuantity.getText());
        String name = txtName.getText();
        String model = txtModel.getText();
        Double cost = Double.valueOf(txtCost.getText());
        Double price = Double.valueOf(txtPrice.getText());
        
        HardwareComponent component = new HardwareComponent(id, quantity, cost, price, name, model);
    
        return component;
    }
    
    public void clearFields(){
        String voidString = "";
        int generatedId = componentController.generateId();
        txtId.setText(String.valueOf(generatedId));
        txtQuantity.setText(voidString);
        txtName.setText(voidString);
        txtGainPercentage.setText(voidString);
        txtModel.setText(voidString);
        txtCost.setText(voidString);
        txtPrice.setText(voidString);
    }
    
    public void clearFieldsOption(){
        String warningMessage = "¿Está seguro de que quiere limpiar todos los campos?\n";
        
        int option = JOptionPane.showConfirmDialog(this, warningMessage);
        JRootPane rootPane = new JRootPane();
        
        if(option == 0){
            clearFields();
            
            
        }
        else if(option == 1){
            
        }
        else {
            
        }
        
    }
    
    private void putLogo() {
        ImageIcon logo = new ImageIcon("src/main/resources/logo.jpg");
        Image logoImage = logo.getImage();
        Image scaledLogoImage = logoImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledLogo = new ImageIcon(scaledLogoImage);
        
        lblLogo.setIcon(scaledLogo);
    }
    
    public void fillFields(HashMap<Object, Object> updatingComponent){
        String voidString = "";
        
        txtId.setText(updatingComponent.get("id").toString());
        txtQuantity.setText(updatingComponent.get("quantity").toString());
        txtName.setText(updatingComponent.get("name").toString());
        txtModel.setText(updatingComponent.get("model").toString());
        txtCost.setText(updatingComponent.get("cost").toString());
        txtPrice.setText(updatingComponent.get("price").toString());
        txtGainPercentage.setText(String.format("%.2f", componentController.calculateGainPercentage(Double.valueOf(txtCost.getText()), Double.valueOf(txtPrice.getText()))));
    }
    
    public void clearFields(int idOfUpdating){
        String voidString = "";
        txtId.setText(String.valueOf(idOfUpdating));
        txtQuantity.setText(voidString);
        txtName.setText(voidString);
        txtModel.setText(voidString);
        txtGainPercentage.setText(voidString);
        txtCost.setText(voidString);
        txtPrice.setText(voidString);
    }
    
    public void clearFieldsOption(int idOfUpdating){
        String warningMessage = "¿Está seguro de que quiere limpiar todos los campos?\n";
        
        int option = JOptionPane.showConfirmDialog(this, warningMessage);
        JRootPane rootPane = new JRootPane();
        
        if(option == 0){
            clearFields(idOfUpdating);

        }
        else if(option == 1){
            
        }
        else {
            
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JButton btnBackToMainMenu;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel msgWarningCost;
    private javax.swing.JLabel msgWarningGainPercentage;
    private javax.swing.JLabel msgWarningQuantity;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtGainPercentage;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
