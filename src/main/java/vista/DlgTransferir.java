package vista;

/**
 *
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class DlgTransferir extends javax.swing.JDialog {

    /**
     * Creates new form DlgTranferir
     */
    public DlgTransferir(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar1 = new javax.swing.JButton();
        cboCuentas = new javax.swing.JComboBox<>();
        txtCuentaDestino = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transferir");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(185, 207, 180));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 40)); // NOI18N
        jLabel1.setText("Banco JV");

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        jLabel2.setText("Cuenta origen:");

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        jLabel3.setText("Cuenta destino:");

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        jLabel4.setText("Cantidad:");

        btnCancelar.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar1.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        btnAceptar1.setText("Aceptar");

        cboCuentas.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        cboCuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtCuentaDestino.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N

        txtCantidad.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCantidad)
                                    .addComponent(txtCuentaDestino)
                                    .addComponent(cboCuentas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(70, 70, 70))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(btnCancelar)
                                .addGap(0, 152, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cboCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtCuentaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar1)
                    .addComponent(btnCancelar))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        frmInicio inicio = new frmInicio();
        inicio.setVisible(true);
        dispose();      
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cboCuentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCuentaDestino;
    // End of variables declaration//GEN-END:variables
}
