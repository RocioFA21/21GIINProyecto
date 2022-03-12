package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Esta calse define el proceso de escucha para las acciones/eventos
 * de botones especificos pertenecientes al paquete Vista relacionado con las
 * presentaciones
 * @author Rocio Fontecha
 * @version 01/01/2022/A
 * 
 */

public class PresentacionesControlador implements ActionListener{
    
    PresentacionesDAO mdao=new PresentacionesDAO();
    PresentacionesEntidad me=new PresentacionesEntidad();
    ManagePresentaciones managepresentaciones=new ManagePresentaciones();
    DefaultTableModel modelo=new DefaultTableModel();

    public PresentacionesControlador(ManagePresentaciones p) {
        //acceder a los botones del menu presentaciones
        this.managepresentaciones=p;
        this.managepresentaciones.btnListar.addActionListener(this);
        this.managepresentaciones.jButton_editar.addActionListener(this);
        this.managepresentaciones.jButton_actualizar.addActionListener(this);
        this.managepresentaciones.jButton_registrar.addActionListener(this);
        this.managepresentaciones.jButton_nuevo.addActionListener(this);
        this.managepresentaciones.jButton_eliminar.addActionListener(this);
    }
    
    @Override
    /**
     * Acciones sobre las presentaciones
     */
    public void actionPerformed(ActionEvent e) {
        /**
         * Al hacer click sobre el el boton Refrescar
         * Cargar/refrescar los valores de la tabla perteneciente
         * a ManagePresentaciones donde se muestran las presentaciones
         * registradas en el sistema con todos sus datos
         */
        if (e.getSource() == managepresentaciones.btnListar) {
            //Vaciar la tabla
            limpiarTabla();
            //Mostrar los datos de las presentaciones en la tabla del menu
            listar(managepresentaciones.jTable_data);
            //Vaciar los campos del menu de la presentaciones
            nuevo();
        }
        /**
         * Al hacer click sobre el el boton Registrar
         * agregar presentaciones nuevas en el sistema
         */
        if (e.getSource() == managepresentaciones.jButton_registrar) {
            //prepara los datos de las presentaciones que sera registrados
            add();
            //Mostrar los datos de las presentaciones en la tabla del menu
            listar(managepresentaciones.jTable_data);
            //Vaciar los campos del menu de presentaciones
            nuevo();
        }
        /**
         * Al hacer click sobre el el boton Editar
         * modifica los valores de la presentacion seleccionada
         * y actualiza sus valores en la base de datos
         */
        if (e.getSource() == managepresentaciones.jButton_editar) {
            /**
             * Almacena en la variable "fila" el indice de la fila de la tabla
             * del menu de la presentaciones
             */
            int fila = managepresentaciones.jTable_data.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(managepresentaciones, "Debes seleccionar una fila");
            }else{
                /**
                 * Pasar los valores de la tabla al 
                 * formulario de la presentaciones
                 */
                int id = Integer.parseInt((String) managepresentaciones.jTable_data.getValueAt(fila, 0).toString());
                Date fechaP = (Date) managepresentaciones.jTable_data.getValueAt(fila, 1);
                Boolean estado = (Boolean) managepresentaciones.jTable_data.getValueAt(fila, 2);
                String docs = (String) managepresentaciones.jTable_data.getValueAt(fila, 3);
                String municipio = (String) managepresentaciones.jTable_data.getValueAt(fila, 4);
                String usuario = (String) managepresentaciones.jTable_data.getValueAt(fila, 5);
                String convocatoria = (String) managepresentaciones.jTable_data.getValueAt(fila, 6);
                
                
                managepresentaciones.jTextField_id.setText("" + id);
                managepresentaciones.jTextField_municipio.setText(municipio);
                managepresentaciones.jTextField_usuario.setText(usuario);
                managepresentaciones.jTextField_convo.setText(convocatoria);
                if (estado.equals(true)) {
                    managepresentaciones.jTextField_estado.setText("Abierta");
                }
                if (estado.equals(false)) {
                    managepresentaciones.jTextField_estado.setText("Cerrada");
                }
                managepresentaciones.jTextField_docs.setText(docs);
                
            }
        }
        /**
         * Ejecutar la actualizacion de los datos de la presentacion
         * en la base de datos
         */
        if (e.getSource() == managepresentaciones.jButton_actualizar) {
            // Update en la base de datos
            actualizar();
            listar(managepresentaciones.jTable_data);
            nuevo();
        }
        /**
         * Vaciar los campos del menu de la presentacione
         */
        if (e.getSource() == managepresentaciones.jButton_nuevo) {
            nuevo();
        }
        /**
         * Elimina el usuario seleccionado
         */
        if (e.getSource() == managepresentaciones.jButton_eliminar) {
            delete();
            listar(managepresentaciones.jTable_data);
            nuevo();
        }
        
    }
    /**
     * Mostrar los datos de las presentaciones en la tabla del menu
     * @param jTable_data 
     */
    public void listar(JTable jTable_data) {
        modelo=(DefaultTableModel) jTable_data.getModel();

        jTable_data.setModel(modelo);
        List<PresentacionesEntidad>lista=mdao.listar();
        Object[]objeto=new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0]=lista.get(i).getId();
            objeto[1]=lista.get(i).getFecha();
            objeto[2]=lista.get(i).isEstado();
            objeto[3]=lista.get(i).getDocs();
            objeto[4]=lista.get(i).getMunicipio();
            objeto[5]=lista.get(i).getUsuario();
            objeto[6]=lista.get(i).getConvocatoria();
            modelo.addRow(objeto);
        }
        
        jTable_data.setRowHeight(35);
        jTable_data.setRowMargin(10);
    }
    /**
     * Vaciar los campos del menu de la presentacione
     */
    void nuevo() {
        managepresentaciones.jTextField_id.setText("");
        managepresentaciones.jTextField_municipio.setText("");
        managepresentaciones.jTextField_usuario.setText("");
        managepresentaciones.jTextField_estado.setText("");
        managepresentaciones.jTextField_docs.setText("");
        managepresentaciones.jTextField_municipio.requestFocus();
    }
    /**
     * prepara los datos de la presentacion que sera registrada
     */
    public void add() {
        String municipio = managepresentaciones.jTextField_municipio.getText();
        String usuario = managepresentaciones.jTextField_usuario.getText();
        String convo = managepresentaciones.jTextField_convo.getText();
        String estado = managepresentaciones.jComboBox_estado.getSelectedItem().toString();
        String docs = managepresentaciones.jTextField_docs.getText();
        me.setMunicipio(municipio);
        me.setUsuario(usuario);
        me.setConvocatoria(convo);
        if (estado.equals("Abierta")) {
            me.setEstado(true);
        }
        if (estado.equals("Cerrada")) {
            me.setEstado(false);
        }
        me.setDocs(docs);
        int r = mdao.insertar(me);
        if (r == 1) {
            JOptionPane.showMessageDialog(managepresentaciones, "Presentacion Agregada con Exito.");
        } 
        limpiarTabla();
    }
    /**
     * Metodo para ejecutar el Update
     */
    public void actualizar() {
        if (managepresentaciones.jTextField_id.getText().equals("")) {
            
            JOptionPane.showMessageDialog(managepresentaciones, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {
            int id = Integer.parseInt(managepresentaciones.jTextField_id.getText());
            String municipio = managepresentaciones.jTextField_municipio.getText();
            String usuario = managepresentaciones.jTextField_usuario.getText();        
            String convo = managepresentaciones.jTextField_convo .getText();
            String estado = managepresentaciones.jComboBox_estado.getSelectedItem().toString();
            String docs = managepresentaciones.jTextField_docs.getText();
            
            me.setId(id);
            me.setMunicipio(municipio);
            me.setUsuario(usuario);            
            me.setConvocatoria(convo);            
            if (estado.equals("Abierta")) {
                me.setEstado(true);
            }
            if (estado.equals("Cerrada")) {
                me.setEstado(false);
            }
            me.setDocs(docs);
            int r = mdao.actualizar(me);
            if (r == 1) {
                JOptionPane.showMessageDialog(managepresentaciones, "Presentacion Actualizada con Exito.");
            } else {
                JOptionPane.showMessageDialog(managepresentaciones, "Error");
            }
        }
        limpiarTabla();
    }
    /**
     * Metodo para ejecutar el Delete
     */
    public void delete() {
        int fila = managepresentaciones.jTable_data.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(managepresentaciones, "Debe Seleccionar una Fila");
        } else {
            int id = Integer.parseInt((String) managepresentaciones.jTable_data.getValueAt(fila, 0).toString());
            mdao.Delete(id);
            System.out.println("El Reusltado es" + id);
            JOptionPane.showMessageDialog(managepresentaciones, "Presentacion Eliminada");
        }
        limpiarTabla();
    }
    /**
     * Vaciar la tabla del menu de la presentaciones
     */
    void limpiarTabla() {
        for (int i = 0; i < managepresentaciones.jTable_data.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
