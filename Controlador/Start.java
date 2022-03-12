package Controlador;

import Vista.Login;

/**
 * Clase Start es el Main principal
 * @author Rocio Fontecha
 * @version 01/01/2022/A
 * 
 */

public class Start {
    /**
     * Iniciar el programa con la ventana de Login
     * @param args 
     */
    public static void main(String[] args){
        Login log = new Login();
        log.setVisible(true);
        log.setLocationRelativeTo(null);
    }
    
}
