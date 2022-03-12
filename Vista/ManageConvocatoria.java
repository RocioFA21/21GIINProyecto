package Vista;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.util.JRLoader;
import javax.swing.WindowConstants;
import Modelo.Conexion;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Clase ManageConvocatoria
 * Acciones de los botones y eventos del formulario de
 * Administracion de Convocatorias
 * @author Rocio Fontecha
 * @version 01/01/2022/A
 * 
 */
public class ManageConvocatoria extends javax.swing.JFrame {
    public ManageConvocatoria() {
        initComponents();
        org.apache.log4j.BasicConfigurator.configure();
        org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
    }
    /**
     * Este metodo es llamado en el constructor 
     * para inicializar el formulario
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_nombre = new javax.swing.JTextField();
        jButton_registrarconvocatoria = new javax.swing.JButton();
        jButton_eliminarconvocatoria = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jButton_nuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_data = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();
        jButton_editar = new javax.swing.JButton();
        jButton_actualizar = new javax.swing.JButton();
        jTextField_descrip = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField_docs = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBox_estado = new javax.swing.JComboBox<>();
        jTextField_estado = new javax.swing.JTextField();
        jButton_reporte1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setText("Control de Convocatorias");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Descrip. :");

        jTextField_nombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombreActionPerformed(evt);
            }
        });

        jButton_registrarconvocatoria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_registrarconvocatoria.setText("Registrar");
        jButton_registrarconvocatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarconvocatoriaActionPerformed(evt);
            }
        });

        jButton_eliminarconvocatoria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_eliminarconvocatoria.setText("Eliminar");
        jButton_eliminarconvocatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarconvocatoriaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("ID:");

        jTextField_id.setEditable(false);
        jTextField_id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idActionPerformed(evt);
            }
        });

        jButton_nuevo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_nuevo.setText("Nuevo");
        jButton_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nuevoActionPerformed(evt);
            }
        });

        jTable_data.setAutoCreateRowSorter(true);
        jTable_data.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Apertura", "Cierre", "Estado", "Documentos"
            }
        ));
        jTable_data.getTableHeader().setReorderingAllowed(false);
        jTable_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_dataMouseClicked(evt);
            }
        });
        jTable_data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable_dataKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_data);

        btnListar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnListar.setText("Refrescar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jButton_editar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_editar.setText("Editar");

        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_actualizar.setText("Actualizar");

        jTextField_descrip.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField_descrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_descripActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setText("Documento:");

        jTextField_docs.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField_docs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_docsActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("Estado:");

        jComboBox_estado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------", "Abierta", "Cerrada" }));
        jComboBox_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_estadoActionPerformed(evt);
            }
        });

        jTextField_estado.setEditable(false);
        jTextField_estado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_estadoActionPerformed(evt);
            }
        });

        jButton_reporte1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_reporte1.setText("Reporte");
        jButton_reporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_reporte1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_eliminarconvocatoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton_registrarconvocatoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_actualizar)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_id, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField_nombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField_descrip, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jButton_reporte1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_docs, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(jComboBox_estado, 0, 253, Short.MAX_VALUE)
                            .addComponent(jTextField_estado))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(431, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(476, 476, 476))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_descrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jTextField_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jComboBox_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_docs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(108, 108, 108)
                        .addComponent(btnListar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_registrarconvocatoria)
                            .addComponent(jButton_editar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_nuevo)
                            .addComponent(jButton_actualizar))
                        .addGap(18, 18, 18)
                        .addComponent(jButton_eliminarconvocatoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_reporte1)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_estadoActionPerformed

    private void jComboBox_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_estadoActionPerformed

    private void jTextField_docsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_docsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_docsActionPerformed

    private void jTextField_descripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_descripActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_descripActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnListarActionPerformed

    private void jTable_dataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable_dataKeyReleased

    }//GEN-LAST:event_jTable_dataKeyReleased

    private void jTable_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_dataMouseClicked

    }//GEN-LAST:event_jTable_dataMouseClicked

    private void jButton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nuevoActionPerformed

    }//GEN-LAST:event_jButton_nuevoActionPerformed

    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_idActionPerformed

    private void jButton_eliminarconvocatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarconvocatoriaActionPerformed

    }//GEN-LAST:event_jButton_eliminarconvocatoriaActionPerformed

    private void jButton_registrarconvocatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarconvocatoriaActionPerformed

    }//GEN-LAST:event_jButton_registrarconvocatoriaActionPerformed

    private void jTextField_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombreActionPerformed
    /**
     * Accion para el boton que genera el Reporte.
     * @param evt 
     */
    private void jButton_reporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_reporte1ActionPerformed
        try {
            //conexion a la base de datos
            Conexion conectar = new Conexion();
            Connection acceso;
            acceso=(Connection) conectar.Conectar();
            
            JasperReport reporte = null;
            
            //ruta y archivo compilado del reporte
            String path = "src\\Reporte\\report2.jasper";
            
            //acceder al reporte previamente definido
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            //Mostrar en pantalla el resultado del reporte
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, acceso);
            
            if(jprint!=null){            
                JasperViewer view = new JasperViewer(jprint, false);
                view.setVisible(true);
                view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                view.setVisible(true);                        
            }
            
        } catch (JRException | ClassNotFoundException ex) {
            Logger.getLogger(ManageConvocatoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_reporte1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnListar;
    public javax.swing.JButton jButton_actualizar;
    public javax.swing.JButton jButton_editar;
    public javax.swing.JButton jButton_eliminarconvocatoria;
    public javax.swing.JButton jButton_nuevo;
    public javax.swing.JButton jButton_registrarconvocatoria;
    public static javax.swing.JButton jButton_reporte1;
    public javax.swing.JComboBox<String> jComboBox_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable_data;
    public javax.swing.JTextField jTextField_descrip;
    public javax.swing.JTextField jTextField_docs;
    public javax.swing.JTextField jTextField_estado;
    public javax.swing.JTextField jTextField_id;
    public javax.swing.JTextField jTextField_nombre;
    // End of variables declaration//GEN-END:variables
}
