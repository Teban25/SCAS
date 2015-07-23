/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Operario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.OperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoOperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import java.util.List;
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
public class OperarioControllerTest {

    public OperarioControllerTest() {
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

    @Test
    public void testBuscarOperarioExistente() throws Exception {
        System.out.println("buscarOperario");
        String cedula = "1017";
        OperarioController instance = new OperarioController();
        String nombreOperario = "Carlos";
        Operario result = instance.buscarOperario(cedula);
        assertEquals(nombreOperario, result.getNombre());
    }

    @Test
    public void testBuscarOperarioNoExistente() {
        try {
            System.out.println("buscarOperario");
            String cedula = "4020";
            OperarioController instance = new OperarioController();
            Operario result = instance.buscarOperario(cedula);
            fail("Fallo por que encontro 'algo' que no existe");
        } catch (BussinessException ex) {
            assertEquals("El operario no existe", ex.getMessage());
        } catch (PersistentException ex) {
            fail("Existio un error al buscar la información " + ex.getMessage());
        }
    }

    @Test
    public void testInsertarOperario() {
        try {
            System.out.println("insertarOperario");
            TipoOperarioUser tipoOperarioUser = new TipoOperarioUser();
            tipoOperarioUser.setIdTipoOperarioUser(1);
            OperarioUser operarioUser = new OperarioUser("example5", tipoOperarioUser, "root", true);
            Operario operario = new Operario("431225", operarioUser, "Steven",
                    "Galindo", "Cra 30 A 75", "5720906");
            OperarioController instance = new OperarioController();
            instance.insertarOperarioUser(operarioUser);
            instance.insertarOperario(operario);
            assertTrue("Registro exitoso", true);
        } catch (BussinessException ex) {
            fail("Existio un problema en el proceso " + ex.getMessage());
        } catch (PersistentException ex) {
            fail("Hubo un problema al intentar registrar el operario: " + ex.getMessage());
        }
    }
    
    @Test(expected = PersistentException.class)
    public void testEliminarOperarioNoExiste() throws PersistentException, BussinessException {
        System.out.println("eliminarOperario");
        String cedulaOperario = "50454";
        OperarioController instance = new OperarioController();
        instance.eliminarOperario(cedulaOperario);
    }

    @Test
    public void testEliminarOperarioExiste() {
        try {
            System.out.println("eliminarOperario");
            String cedulaOperario = "431225";
            OperarioController instance = new OperarioController();
            instance.eliminarOperario(cedulaOperario);
            assertTrue("Operación exitosa", true);
        } catch (PersistentException ex) {
            fail("Fallo el proceso: " + ex.getMessage());
        } catch (BussinessException ex) {
            fail("Fallo el proceso: " + ex.getMessage());
        }
    }

    @Test
    public void testActualizarOperario() throws Exception {
        System.out.println("actualizarOperario");
        OperarioController instance = new OperarioController();
        Operario operario = instance.buscarOperario("431225");
        if (operario != null) {
            operario.setTelefono("5292065");
            instance.actualizarOperario(operario);
            assertTrue("Operación exitosa", true);
        } else {
            fail("No existe el usuario para actualizar");
        }
    }

    @Test
    public void testGetTiposOperario() throws Exception {
        System.out.println("getTiposOperario");
        OperarioController instance = new OperarioController();
        int expResult = 2;
        List<TipoOperarioUser> result = instance.getTiposOperario();
        assertEquals(expResult, result.size());
    }

}
