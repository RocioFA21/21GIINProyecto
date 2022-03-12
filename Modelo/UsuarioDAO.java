package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static Vista.Login.password;
import static Vista.Login.usernameLogin;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class UsuarioDAO {

/**
 * data access object de los usuarios
 * @author Rocio Fontecha
 * @version 01/01/2022/A
 * 
 */    
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar = new Conexion() {};
    Connection acceso;
    
    public UsuarioEntidad ValidarUsuario(String nombre, String clave) throws ClassNotFoundException{
        /**
        * define variables
        */
        UsuarioEntidad ue = new UsuarioEntidad();
        String sql="select * from usuarios where nombre=? and clave=?";
        try {
            acceso=conectar.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setString(1, usernameLogin.getText());
            ps.setString(2, password.getText());
            rs=ps.executeQuery();
            
            while(rs.next()){
            ue.setId(rs.getInt(1));
            ue.setNombre(rs.getString(2));
            ue.setClave(rs.getString(3));
            ue.setTipo(rs.getString(4));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrio el siguiente error:" + e.getMessage());
        }
        return ue;
    }
    /**
     * Ejecute un SELECT sobre la tabla convocatoria
     * @return datos
     */
    public List listar(){
        /** 
         * agregar una nueva fila a la tabla del menu
         * de convocatorias
         */
        List<UsuarioEntidad>datos=new ArrayList<>();
        try {
            acceso=(Connection) conectar.Conectar();
            ps=acceso.prepareStatement("select * from usuarios");
            rs=ps.executeQuery();
            while(rs.next()){
                /**
                 * muestra los datos obtenidos en la consulta
                 * a la base de datos
                 */
                UsuarioEntidad ue = new UsuarioEntidad();
                ue.setId(rs.getInt(1));
                ue.setNombre(rs.getString(2));
                ue.setClave(rs.getString(3));
                ue.setTipo(rs.getString(4));
                datos.add(ue);
            }
            
        } catch (Exception e) {
        }
        
        return datos;
    }
    /**
     * Insertar datos en la base de datos
     * @param u
     * @return 
     */
    public int insertar(UsuarioEntidad u) {
        int r=0;
        //obtener los datos en una consulta
        String sql="INSERT INTO usuarios (nombre, clave, tipo) VALUES (?, ?, ?) ";
        try {
            acceso=(Connection) conectar.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setString(1,u.getNombre());
            ps.setString(2,u.getClave());
            ps.setString(3,u.getTipo());
            r=ps.executeUpdate();
            if (r == 1){
                return 1;
            }else{
                return 0;
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrio el siguiente error:" + e.getMessage());
        }
        return r;
    }
    /**
     * actualizar datos del usuario
     * @param u
     * @return r
     */
    public int actualizar(UsuarioEntidad u) {  
        int r=0;
        String sql="update usuarios set nombre=?,clave=?,tipo=? where id=?";
        try {
            acceso=(Connection) conectar.Conectar();
            ps = acceso.prepareStatement(sql);            
            ps.setString(1,u.getNombre());
            ps.setString(2,u.getClave());
            ps.setString(3,u.getTipo());
            ps.setInt(4,u.getId());
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrio el siguiente error:" + e.getMessage());
        }
        return r;
    }
    /**
      * eliminar usuarion
      * @param id
      * @return r
      */
    public int Delete(int id){
        int r=0;
        String sql="delete from usuarios where Id="+id;
        try {
            acceso=(Connection) conectar.Conectar();
            ps=acceso.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrio el siguiente error:" + e.getMessage());
        }
        return r;
    }
}
