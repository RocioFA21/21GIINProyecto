package Modelo;

import java.util.Date;

/**
 * Entidad Convocatoria y sus metodos
 * @author Rocio Fontecha
 * @version 01/01/2022/A
 * 
 */
public class ConvocatoriaEntidad {
    public int id;
    public String nombre;
    public String descrip;
    public Date fechaA;
    public Date fechaC;
    public boolean estado;
    public String docs;
    
    public ConvocatoriaEntidad() {
    }
    
    /**
     * Inicializar Parametros 
     * @param id
     * @param nombre
     * @param descrip
     * @param fechaA
     * @param fechaC
     * @param estado
     * @param docs 
     */
    public ConvocatoriaEntidad(int id, String nombre, String descrip, Date fechaA, Date fechaC, boolean estado, String docs){
        this.id = id;
        this.nombre = nombre;
        this.descrip = descrip;
        this.fechaA= fechaA;
        this.fechaA= fechaC;
        this.estado= estado;
        this.docs = docs;
    }
    
    /**
     * Metodo para obtener el ID
     * @return id
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
     * @return nombre
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
     * Metodo para obtener la descripcion
     * @return descripcion
     */
    public String getDescrip() {
        return descrip;
    }
    /**
     * Metodo para establecer el descripcion
     * @param descrip 
     */
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    /**
     * Metodo para obtener la fecha de apertura
     * @return fechaA
     */
    public Date getFechaA() {
        return fechaA;
    }
    /**
     * Metodo para establecer la fecha de apertura
     * @param fechaA 
     */
    public void setFechaA(Date fechaA) {
        this.fechaA = fechaA;
    }
    /**
     * Metodo para obtener la fecha de cierre
     * @return fechaC
     */
    public Date getFechaC() {
        return fechaC;
    }
    /**
     * Metodo para establecer la fecha de cierre
     * @param fechaC 
     */
    public void setFechaC(Date fechaC) {
        this.fechaC = fechaC;
    }
    /**
     * Metodo para consultar el estado de la convocatoria
     * @return estado
     */
    public boolean isEstado() {
        return estado;
    }
    /**
     * Metodo para establecer el estado de la convocatoria
     * @param estado 
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /**
     * Metodo para consultar los documentos de la convocatoria
     * @return 
     */
    public String getDocs() {
        return docs;
    }
    /**
     * Metodo para establecer los documentos de la convocatoria
     * @param docs 
     */
    public void setDocs(String docs) {
        this.docs = docs;
    }
    
}
