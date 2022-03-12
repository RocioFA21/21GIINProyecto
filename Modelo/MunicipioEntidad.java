package Modelo;

/**
 * Entidad Municipío y sus metodos
 * @author Rocio Fontecha
 * @version 01/01/2022/A
 * 
 */
public class MunicipioEntidad {
    public int id;
    public String nombre;
    public String categoria;
    
    public MunicipioEntidad() {
    }
    /**
     * Inicializar Parametros 
     * @param id
     * @param nombre
     * @param categoria 
     */
    public MunicipioEntidad(int id, String nombre, String categoria){
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }
    /**
     * Metodo para obtener el ID
     * @return 
     */
    public int getId() {
        return id;
    }
    /**
     * Metodo para establecer el id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Metodo para obtener el nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para establecer el nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo para obtener la categoria
     * @return 
     */
    public String getCategoria() {
        return categoria;
    }
    /**
     * Metodo para establecer la categoria
     * @param categoria 
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
}
