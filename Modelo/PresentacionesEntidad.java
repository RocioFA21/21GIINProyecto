package Modelo;

import java.util.Date;

/**
 * Entidad Presentaciones y sus metodos
 * @author Rocio Fontecha
 * @version 01/01/2022/A
 * 
 */

public class PresentacionesEntidad {
    public int id;
    public Date fecha;
    public boolean estado;
    public String docs;
    public String municipio;
    public String usuario;
    public String convocatoria;
    
    public PresentacionesEntidad() {
    }
    /**
     * Inicializar parametros
     * @param id
     * @param fecha
     * @param estado
     * @param docs
     * @param municipio
     * @param usuario
     * @param convocatoria 
     */
    public PresentacionesEntidad(int id, Date fecha, boolean estado, String docs, String municipio, String usuario, String convocatoria){
        this.id = id;
        this.fecha= fecha;
        this.estado= estado;
        this.docs = docs;
        this.municipio = municipio;
        this.usuario = usuario;
        this.convocatoria = convocatoria;
        
    }

    /**
     * Obtener id
     * @return 
     */
    public int getId() {
        return id;
    }
    
    /**
     * establecer id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * obtener la fecha
     * @return 
     */
    public Date getFecha() {
        return fecha;
    }
    
    /**
     * establecer la fecha
     * @param fecha 
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    /**
     * consultar el estado
     * @return 
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * establecer el estado
     * @param estado 
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * obtener los documentos
     * @return 
     */
    public String getDocs() {
        return docs;
    }

    /**
     * establecer los documentos
     * @param docs 
     */
    public void setDocs(String docs) {
        this.docs = docs;
    }

    /**
     * obtener el municipio de la presentacion
     * @return 
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * establecer el municipio de la presentacion
     * @param municipio 
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * obtener el usuario de la presentacion
     * @return 
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * establecer el usuario de la presentacion
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * obtener la convocatoria de la presentacion
     * @return 
     */
    public String getConvocatoria() {
        return convocatoria;
    }

    /**
     * establecer la convocatoria de la presentacion
     * @param convocatoria 
     */
    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }    
}
