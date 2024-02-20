package vista;

import datos.CuentaDAO;
import datos.RetiroSinCuentaDAO;
import excepciones.PersistenciaException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import objetos.Cuenta;
import objetos.RetiroSinCuenta;

/**
 *
 * @author adria
 */
public class DlgGenerarRetiro extends javax.swing.JDialog {
    RetiroSinCuentaDAO RetiroSinCuentaDAO = new RetiroSinCuentaDAO();
    CuentaDAO cuentaDAO = new CuentaDAO();
    int idc;
    ArrayList<Cuenta> lista = new ArrayList<>();
    /**
     * Creates new form DlgGenerarRetiro
     */
    public DlgGenerarRetiro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    DlgGenerarRetiro(int idc) throws PersistenciaException{
        initComponents();
        this.idc=idc;
        llenarCombo();
    }

    public void llenarCombo(){
//        cuenta = new CuentaDAO();
        
        try {
             lista = (ArrayList) cuentaDAO.buscarCuentas(idc);
        } catch (PersistenciaException ex) {
            Logger.getLogger(DlgGenerarRetiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < lista.size(); i++) {
            this.cboCuentas.addItem(lista.get(i).toString());
        }
    }
    
    public boolean crearRetiro(){
        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "El Campo esta Vacio", "Informacion", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        Cuenta r = lista.get(this.cboCuentas.getSelectedIndex());
        
        RetiroSinCuenta retiro = new RetiroSinCuenta(); 
        Random random = new Random();
        int randomNum = random.nextInt(90000000) + 10000000;
        retiro.setContraseña(randomNum);
        retiro.setCantidad(txtCantidad.getText());
        retiro.setNumeroCuenta(r.getNumero_cuenta());
        float retiroCantidad = Float.parseFloat(txtCantidad.getText());
        if (r.getSaldo()<retiroCantidad) {
          JOptionPane.showMessageDialog(this, "El Saldo de la Cuenta es Insuficiente para crear el Retiro", "Informacion", JOptionPane.WARNING_MESSAGE);
            return false ;
        }
        RetiroSinCuenta retiroGuardar = RetiroSinCuentaDAO.guardar(retiro);
        if (retiroGuardar==null) {
            JOptionPane.showMessageDialog(this, "No se Pudo Realizar el Retiro", "Informacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            
            JOptionPane.showMessageDialog(this, "Retiro Creado Su Folio Es "+retiroGuardar.getFolio()+" Y Contraseña Es: "+retiro.getContraseña(), "Retiro Creado", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
       
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
        lblNombreCliente = new javax.swing.JLabel();
        cboCuentas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        panelRound1 = new vista.PanelRound();
        btnGenerar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generar retiro");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(185, 207, 180));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 40)); // NOI18N
        jLabel1.setText("Banco JV");

        lblNombreCliente.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        lblNombreCliente.setText("nombrecliente");

        cboCuentas.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        cboCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCuentasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        jLabel2.setText("Cuenta origen:");

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        jLabel4.setText("Cantidad:");

        txtCantidad.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N

        panelRound1.setBackground(new java.awt.Color(103, 130, 103));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        btnGenerar.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        btnGenerar.setText("Generar");
        btnGenerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
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
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCantidad)
                                .addGap(81, 81, 81))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(btnGenerar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(126, 126, 126))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerar)
                    .addComponent(btnCancelar))
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void cboCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCuentasActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        crearRetiro();
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        frmInicio inicio= new frmInicio(idc);
        inicio.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox<String> cboCuentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNombreCliente;
    private vista.PanelRound panelRound1;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
