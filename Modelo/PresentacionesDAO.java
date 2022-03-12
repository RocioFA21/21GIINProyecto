package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static Vista.Login.ut;
import static Vista.Login.uid;

/**
 * data access object de las presentaciones
 * @author Rocio Fontecha
 * @version 01/01/2022/A
 * 
 */
public class PresentacionesDAO {
    /**
     * define variables
     */
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar = new Conexion() {};
    Connection acceso;
    UsuarioEntidad u=new UsuarioEntidad();
    /**
     * Ejecute un SELECT sobre la tabla convocatoria
     * @return datos
     */
    public List listar(){
        /** 
         * agregar una nueva fila a la tabla del menu
         * de presentaciones
         */
        List<PresentacionesEntidad>datos=new ArrayList<>();
        System.out.println("usuario id = " + Vista.Login.uid);
        System.out.println("usuario tipo = " + Vista.Login.ut);
        
        try {
            acceso=(Connection) conectar.Conectar();
            if ("Cuentadante".equals(ut)) {
                    String sql="SELECT * FROM presentaciones WHERE usuarios_id = "+uid+";";
                    ps=acceso.prepareStatement(sql);
                    rs=ps.executeQuery();
                    while(rs.next()){
                        /**
                        * muestra los datos obtenidos en la consulta
                        * a la base de datos
                        */
                        PresentacionesEntidad pe = new PresentacionesEntidad();
                        pe.setId(rs.getInt(1));
                        pe.setFecha(rs.getDate(2));
                        pe.setEstado(rs.getBoolean(3));
                        pe.setDocs(rs.getString(4));
                        pe.setMunicipio(rs.getString(5));
                        pe.setUsuario(rs.getString(6));
                        pe.setConvocatoria(rs.getString(7));
                        datos.add(pe);
                    }
                    System.out.println("sql:  " + sql); 
                }
            //validar tipo de usuario y respectiva convocatoria
            else if ("Fiscal".equals(ut)) {
                    String sql="SELECT * FROM presentaciones WHERE usuarios_id = "+uid+";";
                    ps=acceso.prepareStatement(sql);
                    rs=ps.executeQuery();
                    while(rs.next()){
                        PresentacionesEntidad pe = new PresentacionesEntidad();
                        pe.setId(rs.getInt(1));
                        pe.setFecha(rs.getDate(2));
                        pe.setEstado(rs.getBoolean(3));
                        pe.setDocs(rs.getString(4));
                        pe.setMunicipio(rs.getString(5));
                        pe.setUsuario(rs.getString(6));
                        pe.setConvocatoria(rs.getString(7));
                        datos.add(pe);
                    }
                }
            //validar tipo de usuario y respectiva convocatoria
            else if ("Administrador".equals(ut)) {
                    ps=acceso.prepareStatement("select * from presentaciones;");
                    rs=ps.executeQuery();
                    while(rs.next()){
                        PresentacionesEntidad pe = new PresentacionesEntidad();
                        pe.setId(rs.getInt(1));
                        pe.setFecha(rs.getDate(2));
                        pe.setEstado(rs.getBoolean(3));
                        pe.setDocs(rs.getString(4));
                        pe.setMunicipio(rs.getString(5));
                        pe.setUsuario(rs.getString(6));
                        pe.setConvocatoria(rs.getString(7));
                        datos.add(pe);
                    }
                }
            //validar tipo de usuario y respectiva convocatoria
            else if ("Fiscal General".equals(ut)) {
                    ps=acceso.prepareStatement("select * from presentaciones;");
                    rs=ps.executeQuery();
                    while(rs.next()){
                        PresentacionesEntidad pe = new PresentacionesEntidad();
                        pe.setId(rs.getInt(1));
                        pe.setFecha(rs.getDate(2));
                        pe.setEstado(rs.getBoolean(3));
                        pe.setDocs(rs.getString(4));
                        pe.setMunicipio(rs.getString(5));
                        pe.setUsuario(rs.getString(6));
                        pe.setConvocatoria(rs.getString(7));
                        datos.add(pe);
                    }
                }
            //validar tipo de usuario y respectiva convocatoria
            else if ("superusuario".equals(ut)) {
                    ps=acceso.prepareStatement("select * from presentaciones;");
                    rs=ps.executeQuery();
                    while(rs.next()){
                        PresentacionesEntidad pe = new PresentacionesEntidad();
                        pe.setId(rs.getInt(1));
                        pe.setFecha(rs.getDate(2));
                        pe.setEstado(rs.getBoolean(3));
                        pe.setDocs(rs.getString(4));
                        pe.setMunicipio(rs.getString(5));
                        pe.setUsuario(rs.getString(6));
                        pe.setConvocatoria(rs.getString(7));
                        datos.add(pe);
                    }
                }   
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrio el siguiente error:" + e.getMessage());
        }
        return datos;
    }
    /**
     * Insertar datos en la base de datos
     * @param u
     * @return 
     */
    public int insertar(PresentacionesEntidad u) {
        int r=0;
        //obtener los datos en una consulta
        String sql="INSERT INTO presentaciones (fechaP,estado,documentos,municipio_id,usuarios_id,convocatoria_id) VALUES (?,?,?,?,?,?) ";
        java.sql.Date fechaP = new java.sql.Date(System.currentTimeMillis());
        try {
            acceso=(Connection) conectar.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setDate(1,fechaP);
            ps.setBoolean(2,u.isEstado());
            ps.setString(3,u.getDocs());
            ps.setString(4,u.getMunicipio());
            ps.setString(5,u.getUsuario());
            ps.setString(6,u.getConvocatoria());
            
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
     * actualizar la presentacion
     * @param u
     * @return r
     */
    public int actualizar(PresentacionesEntidad u) {  
        int r=0;
        String sql="update presentaciones set estado=?,documentos=?,municipio_id=?,usuarios_id=?,convocatoria_id=? where id=?";        
        try {
            acceso=(Connection) conectar.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setBoolean(1,u.isEstado());
            ps.setString(2,u.getDocs());
            ps.setString(3,u.getMunicipio());
            ps.setString(4,u.getUsuario());
            ps.setString(5,u.getConvocatoria());
            ps.setInt(6,u.getId());
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
     * eliminar la presentacion
     * @param id
     * @return r
     */
    public int Delete(int id){
        int r=0;
        String sql="delete from presentaciones where Id="+id;
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
