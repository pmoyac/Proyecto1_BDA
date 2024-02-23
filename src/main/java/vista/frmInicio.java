package vista;

import datos.CuentaDAO;
import excepciones.PersistenciaException;
import java.awt.Component;
import java.awt.Font;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import objetos.Cuenta;

/**
 *
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class frmInicio extends javax.swing.JFrame {
    private int idc;
    
    /**
     * Creates new form frmInicio
     * @param id
     */

    
    public frmInicio(int id, String nombre, String apellidoPaterno) {
        initComponents();
        idc = id;
        txtNombreCliente.setText(nombre+" "+apellidoPaterno);
        llenarTabla();
    }

    public frmInicio(int id) {
        initComponents();
        idc = id;
        llenarTabla();
    }
    
    
    ArrayList<Cuenta> lista = new ArrayList<>();
    CuentaDAO cuentaDAO = new CuentaDAO();
    
    public void llenarTabla() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("No. de cuenta");
            modelo.addColumn("Saldo");
            lista = (ArrayList) cuentaDAO.buscarCuentas(idc);

            for (Cuenta cuenta : lista) {
                modelo.addRow(new Object[]{cuenta.getNumero_cuenta(), cuenta.getSaldo()});
            }
            
            tablaCuentas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            JTableHeader header = tablaCuentas.getTableHeader();
            header.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25)); 
            header.setResizingAllowed(true); 
            


            tablaCuentas.setModel(modelo);
        } catch (PersistenciaException ex) {
            Logger.getLogger(DlgGenerarRetiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ajustarAlturaFilas(tablaCuentas);
    }
  
    private void ajustarAlturaFilas(JTable table) {
        for (int row = 0; row < table.getRowCount(); row++) {
            int rowHeight = table.getRowHeight();

            for (int column = 0; column < table.getColumnCount(); column++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
            }

            table.setRowHeight(row, rowHeight);
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnGenerarRetiro = new javax.swing.JButton();
        btnTransferir = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtNombreCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentas = new javax.swing.JTable();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");

        jPanel1.setBackground(new java.awt.Color(185, 207, 180));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 40)); // NOI18N
        jLabel1.setText("Banco JV");

        btnHistorial.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        btnHistorial.setText("Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 25)); // NOI18N
        jLabel2.setText("Cuentas:");

        btnGenerarRetiro.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        btnGenerarRetiro.setText("Generar retiro");
        btnGenerarRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarRetiroActionPerformed(evt);
            }
        });

        btnTransferir.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        btnTransferir.setText("Transferir");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        btnActualizar.setText("Modificar datos");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        btnRegresar.setText("Cerrar sesión");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        txtNombreCliente.setEditable(false);
        txtNombreCliente.setBackground(new java.awt.Color(185, 207, 180));
        txtNombreCliente.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        txtNombreCliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNombreCliente.setBorder(null);
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });

        tablaCuentas.setFont(new java.awt.Font("Berlin Sans FB", 0, 25)); // NOI18N
        tablaCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaCuentas.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tablaCuentas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnTransferir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRegresar)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(310, 310, 310)
                                    .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(283, 283, 283)
                                .addComponent(btnGenerarRetiro))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHistorial)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarRetiro)
                    .addComponent(btnTransferir))
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addGap(25, 25, 25))
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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       DlgModificarDatos modificar;
        try {
            modificar = new DlgModificarDatos(this.idc); 
            modificar.setVisible(true);
            this.dispose();
        } catch (PersistenciaException ex) {
            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGenerarRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarRetiroActionPerformed
        DlgGenerarRetiro genretiro;
        try {
            genretiro = new DlgGenerarRetiro(this.idc); 
            genretiro.setVisible(true);
            dispose();
        } catch (PersistenciaException ex) {
            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarRetiroActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        // TODO add your handling code here:
        DlgTransferir transferir;
        try{
        transferir = new DlgTransferir(this.idc);
        transferir.setVisible(true);
        dispose();
        }catch (PersistenciaException ex) {
            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTransferirActionPerformed

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        txtNombreCliente.setText("");
        
        JOptionPane.showMessageDialog(this, "Se cerró sesión correctamente", 
                "Cerrar sesión", JOptionPane.INFORMATION_MESSAGE);
        frmPrincipal principal = new frmPrincipal();
        principal.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        frmHistorial historial = new frmHistorial(idc);
        historial.setVisible(true);  
        dispose();
    }//GEN-LAST:event_btnHistorialActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGenerarRetiro;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCuentas;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}
