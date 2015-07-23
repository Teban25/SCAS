/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Ingreso;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import java.util.Date;
import java.util.List;
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
public class IngresoControllerTest {

    public IngresoControllerTest() {
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

    /**
     * Test of getAllIngresos method, of class IngresoController.
     */
    @Test
    public void testGetAllIngresos() {
        try {
            System.out.println("getAllIngresos");
            IngresoController instance = new IngresoController();
            int expResult = 5;
            List<Ingreso> result = instance.getAllIngresos();
            assertEquals(expResult, result.size());
        } catch (PersistentException ex) {
            fail("Hubo un problema de persistencia: " + ex.getMessage());
        }
    }

    @Test(expected = BussinessException.class)
    public void testInsertarIngresoUsuarioNoExiste() throws BussinessException, PersistentException {
        System.out.println("insertarIngreso");
        Date fecha = new Date();
        String estado = "Dentro";
        String placa = "LAU47A";
        String identificacionUsuario = "5040";
        String nombreOperario = "example5";
        IngresoController instance = new IngresoController();
        instance.insertarIngreso(fecha, placa, identificacionUsuario,
                nombreOperario);
    }
    
    @Test(expected = BussinessException.class)
    public void testInsertarIngresoVehiculoNoExiste() throws BussinessException, PersistentException {
        System.out.println("insertarIngreso");
        Date fecha = new Date();
        String placa = "CRA74B";
        String identificacionUsuario = "1017214614";
        String nombreOperario = "example5";
        IngresoController instance = new IngresoController();
        instance.insertarIngreso(fecha, placa, identificacionUsuario,
                nombreOperario);
    }
    
    @Test(expected = BussinessException.class)
    public void testInsertarIngresoOperarioNoExiste() throws BussinessException, PersistentException {
        System.out.println("insertarIngreso");
        Date fecha = new Date();
        String placa = "LAU47A";
        String identificacionUsuario = "1017214614";
        String nombreOperario = "noexisto.test";
        IngresoController instance = new IngresoController();
        instance.insertarIngreso(fecha, placa, identificacionUsuario,
                nombreOperario);
    }
    
    @Test
    public void testInsertarIngreso(){
        try {
            System.out.println("insertarIngreso");
            Date fecha = new Date();
            String placa = "LAU47A";
            String identificacionUsuario = "1017214614";
            String nombreOperario = "example5";
            IngresoController instance = new IngresoController();
            instance.insertarIngreso(fecha, placa, identificacionUsuario,
                    nombreOperario);
            assertTrue("Insertado con exito", true);
        } catch (BussinessException ex) {
            fail("Fallo el proceso: " + ex.getMessage());
        } catch (PersistentException ex) {
            fail("Hubo un problema de persistencia: " + ex.getMessage());
        }
    }

}
