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
public class BussinessException extends Exception{

    public BussinessException(String message) {
        super(message);
    }

    public BussinessException() {
    }

    public BussinessException(Throwable cause) {
        super(cause);
    }

    public BussinessException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
}
