package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Esta calse define el proceso de escucha para las acciones/eventos
 * de botones especificos pertenecientes al paquete Vista relacionado con 
 * los usuarios
 * @author Rocio Fontecha
 * @version 01/01/2022/A
 * 
 */

public class Controlador implements ActionListener{
    
    UsuarioDAO udao=new UsuarioDAO();
    UsuarioEntidad ue=new UsuarioEntidad();
    ManageUsuarios manageusuarios=new ManageUsuarios();
    DefaultTableModel modelo=new DefaultTableModel();

    public Controlador(ManageUsuarios u) {
        //acceder a los botones del menu usuario
        this.manageusuarios=u;
        this.manageusuarios.btnListar.addActionListener(this);
        this.manageusuarios.jButton_editar.addActionListener(this);
        this.manageusuarios.jButton_actualizar.addActionListener(this);
        this.manageusuarios.jButton_registrarusuario.addActionListener(this);
        this.manageusuarios.jButton_nuevo.addActionListener(this);
        this.manageusuarios.jButton_eliminarusuario.addActionListener(this);
    }
    
    @Override
    /**
     * Acciones sobre los usuarios
     */
    public void actionPerformed(ActionEvent e) {
        /**
         * Al hacer click sobre el el boton Refrescar
         * Cargar/refrescar los valores de la tabla perteneciente
         * a ManageUsuario donde se muestran los usuarios registrados 
         * en el sistema con todos sus datos
         */
        if (e.getSource() == manageusuarios.btnListar) {
            //Vaciar la tabla
            limpiarTabla();
            //Mostrar los datos de los usuarios en la tabla del menu
            listar(manageusuarios.jTable_data);
            //Vaciar los campos del menu de usuarios
            nuevo();
        }
        /**
         * Al hacer click sobre el el boton Registrar
         * agregar usuarios nuevos en el sistema
         */
        if (e.getSource() == manageusuarios.jButton_registrarusuario) {
            //prepara los datos de los usuarios que sera registrados
            add();
            //Mostrar los datos de los usuarios en la tabla del menu
            listar(manageusuarios.jTable_data);
            //Vaciar los campos del menu de usuarios
            nuevo();
        }
        /**
         * Al hacer click sobre el el boton Editar
         * modifica los valores del usuario seleccionado y actualiza
         * dichos valores en la base de datos
         */
        if (e.getSource() == manageusuarios.jButton_editar) {
            /**
             * Almacena en la variable "fila" el indice de la fila de la tabla
             * del menu de usuarios
             */
            int fila = manageusuarios.jTable_data.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(manageusuarios, "Debes seleccionar una fila");
            }else{
                //Pasar los valores de la tabla al formulario de usuarios
                int id = Integer.parseInt((String) manageusuarios.jTable_data.getValueAt(fila, 0).toString());
                String nombre = (String) manageusuarios.jTable_data.getValueAt(fila, 1);
                String clave = (String) manageusuarios.jTable_data.getValueAt(fila, 2);
                String tipo = (String) manageusuarios.jTable_data.getValueAt(fila, 3);
                manageusuarios.jTextField_id.setText("" + id);
                manageusuarios.jTextField_nombre.setText(nombre);
                manageusuarios.jTextField_clave.setText(clave);
                manageusuarios.jTextField_tipo.setText(tipo);
            }
        }
        /**
         * Ejecutar la actualizacion de los datos del usuario
         * en la base de datps
         */
        if (e.getSource() == manageusuarios.jButton_actualizar) {
            // Update en la base de datos
            actualizar();
            //Mostrar los datos de los usuarios en la tabla del menu
            listar(manageusuarios.jTable_data);
            //Vaciar los campos del menu de usuarios
            nuevo();
        }
        /**
         * Vaciar los campos del menu de usuarios
         */
        if (e.getSource() == manageusuarios.jButton_nuevo) {
            nuevo();
        }
        /**
         * Elimina el usuario seleccionado
         */
        if (e.getSource() == manageusuarios.jButton_eliminarusuario) {
            // Delete en la base de datos
            delete();
            listar(manageusuarios.jTable_data);
            nuevo();
        }
    }
    /**
     * Mostrar los datos de los usuarios en la tabla del menu
     * @param jTable_data 
     */
    public void listar(JTable jTable_data) {
        modelo=(DefaultTableModel) jTable_data.getModel();
        jTable_data.setModel(modelo);
        List<UsuarioEntidad>lista=udao.listar();
        Object[]objeto=new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0]=lista.get(i).getId();
            objeto[1]=lista.get(i).getNombre();
            objeto[2]=lista.get(i).getClave();
            objeto[3]=lista.get(i).getTipo();
            modelo.addRow(objeto);
        }
        
        jTable_data.setRowHeight(35);
        jTable_data.setRowMargin(10);
    }
    /**
     * Vaciar los campos del menu de usuarios
     */
    void nuevo() {
        manageusuarios.jTextField_id.setText("");
        manageusuarios.jTextField_nombre.setText("");
        manageusuarios.jTextField_clave.setText("");
        manageusuarios.jTextField_tipo.setText("");
        manageusuarios.jTextField_nombre.requestFocus();
    }
    /**
     * prepara los datos de los usuarios que sera registrados
     */
    public void add() {
        String nombre = manageusuarios.jTextField_nombre.getText();
        String clave = manageusuarios.jTextField_clave.getText();
        String tipo = manageusuarios.jComboBox_usuarioTipo.getSelectedItem().toString();
        ue.setNombre(nombre);
        ue.setClave(clave);
        ue.setTipo(tipo);
        int r = udao.insertar(ue);
        if (r == 1) {
            JOptionPane.showMessageDialog(manageusuarios, "Usuario Agregado con Exito.");
        } 
        limpiarTabla();
    }
    /**
     * Metodo para ejecutar el Update
     */
    public void actualizar() {
        if (manageusuarios.jTextField_id.getText().equals("")) {
            JOptionPane.showMessageDialog(manageusuarios, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {
            int id = Integer.parseInt(manageusuarios.jTextField_id.getText());
            String nombre = manageusuarios.jTextField_nombre.getText();
            String clave = manageusuarios.jTextField_clave.getText();
            String tipo = manageusuarios.jComboBox_usuarioTipo.getSelectedItem().toString();
            ue.setId(id);
            ue.setNombre(nombre);
            ue.setClave(clave);
            ue.setTipo(tipo);
            int r = udao.actualizar(ue);
            if (r == 1) {
                JOptionPane.showMessageDialog(manageusuarios, "Usuario Actualizado con Exito.");
            } else {
                JOptionPane.showMessageDialog(manageusuarios, "Error");
            }
        }
        limpiarTabla();
    }
    /**
     * Metodo para ejecutar el Delete
     */
    public void delete() {
        int fila = manageusuarios.jTable_data.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(manageusuarios, "Debe Seleccionar una Fila");
        } else {
            int id = Integer.parseInt((String) manageusuarios.jTable_data.getValueAt(fila, 0).toString());
            udao.Delete(id);
            System.out.println("El Reusltaod es" + id);
            JOptionPane.showMessageDialog(manageusuarios, "Usuario Eliminado");
        }
        limpiarTabla();
    }
    
    
    /**
     * Vaciar la tabla del menu de usuarios
     */
    void limpiarTabla() {
        for (int i = 0; i < manageusuarios.jTable_data.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
