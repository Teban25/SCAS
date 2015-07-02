/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception;

/**
 *
 * @author juanf.molina
 */
public class PersistentException extends Exception{

    public PersistentException() {
    }

    public PersistentException(String message) {
        super(message);
    }

    public PersistentException(Throwable cause) {
        super(cause);
    }

    public PersistentException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
}
