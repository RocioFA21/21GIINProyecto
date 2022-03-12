package Modelo;

/**
 * Entidad usuario y sus metodos
 * @author Rocio Fontecha
 * @version 01/01/2022/A
 * 
 */

public class UsuarioEntidad {
    public int id;
    public String nombre;
    public String clave;
    public String tipo;

    public UsuarioEntidad() {
    }
    /**
     * inicializar los parametros
     * @param id
     * @param nombre
     * @param clave
     * @param tipo 
     */
    public UsuarioEntidad(int id, String nombre, String clave, String tipo){
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.tipo = tipo;
    }
    
    /**
     * obtener id
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * establcer id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * obtener el nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * establecer el nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * obtener la clave
     * @return 
     */
    public String getClave() {
        return clave;
    }

    /**
     * establecer la clave
     * @param clave 
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * obtener el tipo de usuario
     * @return 
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * establecer el tipo de usuario
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
