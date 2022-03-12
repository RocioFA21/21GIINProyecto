package Modelo;

import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 * Clase que establece conexion con la base de datos
 * @author Rocio Fontecha
 * @version 01/01/2022/A
 * 
 */

public class Conexion {
    /**
     * Informacion de la base de datos
     */
    Connection con = null;
    //Base de datos
    String db="proyectodb";
    // Server
    String url="jdbc:mysql://rds-21giin.c0bc3kbxuj7d.us-east-1.rds.amazonaws.com:3306/"+db;
    // usuario
    String user="admin";
    // clave
    String pass="admin1234";
    // Driver que gestiona la conexion 
    String driver = "com.mysql.jdbc.Driver";;
    
    public Connection Conectar() throws ClassNotFoundException{
        /**
         * Gestion de errores en la conexion
         */
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrio el siguiente error:" + e.getMessage());
        }
        return con;
    }
    /**
     * Obtiene el servidor
     * @return 
     */
    public String getUrl() {
        return url;
    }
    /**
     * Obtiene el usuario
     * @return 
     */
    public String getUss() {
        return user;
    }
    /**
     * Obtiene la clave
     * @return 
     */
    public String getPwd() {
        return pass;
    }
    /**
     * Obtiene el driver
     * @return 
     */
    public String getDriver() {
        return driver;
    }
    
}



