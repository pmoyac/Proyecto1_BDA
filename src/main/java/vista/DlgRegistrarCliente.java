package vista;

import javax.swing.JTextField;
import javax.swing.JOptionPane;
import datos.ClienteDAO;
import excepciones.PersistenciaException;
import java.sql.Date;
import java.util.Random;
//import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cliente;

/**
 *
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class DlgRegistrarCliente extends javax.swing.JDialog {
    
     ClienteDAO cliente;

    /**
     * Creates new form DlgRegistrarCliente
     */
    public DlgRegistrarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.cliente = new ClienteDAO();
    }

    DlgRegistrarCliente() {
        initComponents();
        this.cliente = new ClienteDAO();
    }

    private boolean validarCampos() {
        return !txtContrasenia.getText().isEmpty() &&
            !txtNombre.getText().isEmpty() &&
            !txtApellidoP.getText().isEmpty() &&
            !txtApellidoM.getText().isEmpty() &&
            !txtCalle.getText().isEmpty() &&
            !txtNum.getText().isEmpty() &&
            !txtColonia.getText().isEmpty();
    }  

    private boolean validarContrasenia(String contrasenia) {
        // Expresión regular para para mínimo 4 caracteres, una letra mayúscula y un número
        String patron = "^(?=.*[A-Z])(?=.*\\d).{4,}$";

        // Verificar que la contraseña cumple con la expresión regular
        if (!contrasenia.matches(patron)) {
            JOptionPane.showMessageDialog(this, 
                    "La contraseña debe tener al menos 4 caracteres y contener al menos una letra mayúscula y un número", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtApellidoP = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        txtNum = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        panelRound1 = new vista.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JTextField();
        txtConfirmarContrasenia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jDateFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(185, 207, 180));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel3.setText("Apellido paterno:");

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel4.setText("Apellido materno:");

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel5.setText("Fecha de nacimiento:");

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel6.setText("Calle:");

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel7.setText("Número:");

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel8.setText("Colonia:");

        txtApellidoP.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N

        txtApellidoM.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(56, 89, 22));
        jLabel9.setText("Dirección");

        txtCalle.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        txtCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalleActionPerformed(evt);
            }
        });

        txtNum.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N

        txtColonia.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N

        panelRound1.setBackground(new java.awt.Color(103, 130, 103));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Contraseña:");

        txtContrasenia.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        txtContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseniaActionPerformed(evt);
            }
        });

        txtConfirmarContrasenia.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        txtConfirmarContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmarContraseniaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Confirmar contraseña:");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel10)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtConfirmarContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(txtContrasenia))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtConfirmarContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnAceptar.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnRestaurar.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        btnRestaurar.setText("Restaurar");
        btnRestaurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRestaurar)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jDateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                            .addComponent(txtApellidoP)
                            .addComponent(txtApellidoM)))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jDateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRestaurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
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

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        txtNombre.setText("");
        txtApellidoP.setText("");
        txtApellidoM.setText("");
        jDateFecha.setCalendar(null);
        txtCalle.setText("");
        txtNum.setText("");
        txtColonia.setText("");
        txtContrasenia.setText("");
        txtConfirmarContrasenia.setText("");

    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void txtCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalleActionPerformed

    private void txtContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseniaActionPerformed

    private void txtConfirmarContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmarContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmarContraseniaActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {

            if (validarCampos()) {
                // Verificar que la contraseña coincida con la confirmación de la contraseña
                if (txtContrasenia.getText().equals(txtConfirmarContrasenia.getText())) {

                    if (validarContrasenia(txtContrasenia.getText())) {

                        java.util.Date javaDate = this.jDateFecha.getDate();
                        Date fechaSql = new Date(javaDate.getTime());

                        Cliente clienteNuevo = new Cliente(this.txtContrasenia.getText(),
                                this.txtNombre.getText(),
                                this.txtApellidoP.getText(),
                                this.txtApellidoM.getText(),
                                fechaSql,
                                this.txtCalle.getText(),
                                this.txtNum.getText(),
                                this.txtColonia.getText());

                        Cliente clienteRegistrado = cliente.registrarCliente(clienteNuevo);
                        int idClienteGenerado = clienteRegistrado.getId();

                        JOptionPane.showMessageDialog(this, "No. de cliente: " + idClienteGenerado,
                                "Cliente registrado exitosamente", JOptionPane.INFORMATION_MESSAGE);

                        frmInicio inicio = new frmInicio();
                        inicio.setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                }
        } else {
            JOptionPane.showMessageDialog(this, "Asegúrese de llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (PersistenciaException ex) {
        Logger.getLogger(DlgRegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        frmPrincipal p = new frmPrincipal();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRestaurar;
    private com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private vista.PanelRound panelRound1;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtConfirmarContrasenia;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNum;
    // End of variables declaration//GEN-END:variables
}
