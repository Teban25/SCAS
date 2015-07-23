/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoOperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teban-Ing
 */
public class InicioSesionControllerTest {
    
    public InicioSesionControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    //Paso la prueba
    //Caso de prueba usuario correcto, contraseña correcta
    @Test
    public void testSessionContraseñaUsuario() throws Exception {
        System.out.println("permitirSesion");
        InicioSesionController instance = new InicioSesionController("admin.test","root");
        int expResult = 0;
        TipoOperarioUser result = instance.permitirSesion();
        assertEquals(expResult, result.getIdTipoOperarioUser());
    }
    
    //Caso de prueba usuario correcto, contraseña incorrecta
    @Test
    public void testSessionUsuario(){
        try {
            System.out.println("permitirSesion");
            InicioSesionController instance = new InicioSesionController("vigilante.test","root1");
            TipoOperarioUser result = instance.permitirSesion();
            fail("Fallo porque permitio la sesión");
        } catch (PersistentException ex) {
            Logger.getLogger(InicioSesionControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BussinessException ex) {
            assertEquals("Verifique la contraseña e intentelo de nuevo", ex.getMessage());
        }
    }
    //Caso de prueba usuario incorrecto, contraseña incorrecta
    @Test
    public void testSession(){
        try {
            System.out.println("permitirSesion");
            InicioSesionController instance = new InicioSesionController("vigilante","root1");
            TipoOperarioUser result = instance.permitirSesion();
            fail("Fallo porque permitio la sesión");
        } catch (PersistentException ex) {
            Logger.getLogger(InicioSesionControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BussinessException ex) {
            assertEquals("Verifique el nombre de usuario", ex.getMessage());
        }
    }
    //Caso de prueba usuario inactivo
    @Test
    public void testSessionActivo(){
        try {
            System.out.println("permitirSesion");
            InicioSesionController instance = new InicioSesionController("example1","root");
            TipoOperarioUser result = instance.permitirSesion();
            fail("Fallo porque permitio la sesión");
        } catch (PersistentException ex) {
            Logger.getLogger(InicioSesionControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BussinessException ex) {
            assertEquals("El usuario no se encuentra activo en el sistema, "
                    + "contacte a un administrador", ex.getMessage());
        }
    }
    
}