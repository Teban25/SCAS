/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoVehiculo;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
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
public class VehiculoControllerTest {
    
    public VehiculoControllerTest() {
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
    @Test
    public void testRegistroVehiculoSinCampos(){
        try {
            System.out.println("registroVehiculo");
            String placa="";
            String marca="";
            String modelo="";
            String color="";
            String tipoVehiculo="";
            String identificacion="";
            VehiculoController instance = new VehiculoController(placa, marca, 
                    modelo, color, tipoVehiculo, identificacion);
            instance.registroVehiculo();
            fail("Fallo por que permitio el registro");
        } catch (BussinessException ex) {
            assertEquals("Falto algún campo por ingresar, "
                    + "intentelo de nuevo", ex.getMessage());
        } catch (PersistentException ex) {
            Logger.getLogger(VehiculoControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Paso la prueba
    @Test
    public void testRegistroVehiculoSinAlgunCampo(){
        try {
            System.out.println("registroVehiculo");
            String placa="OLX27B";
            String marca="AKT";
            String modelo="";
            String color="AZUL";
            String tipoVehiculo="Motocicleta";
            String identificacion="42926052";
            VehiculoController instance = new VehiculoController(placa, marca, 
                    modelo, color, tipoVehiculo, identificacion);
            instance.registroVehiculo();
            fail("Fallo por que permitio el registro");
        } catch (BussinessException ex) {
            assertEquals("Falto algún campo por ingresar, "
                    + "intentelo de nuevo", ex.getMessage());
        } catch (PersistentException ex) {
            Logger.getLogger(VehiculoControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Paso la prueba
    @Test
    public void testRegistroVehiculoUsuarioNoExiste(){
        try {
            System.out.println("registroVehiculo");
            String placa="OLX27B";
            String marca="AKT";
            String modelo="2008";
            String color="AZUL";
            String tipoVehiculo="Motocicleta";
            String identificacion="42926052";
            VehiculoController instance = new VehiculoController(placa, marca, 
                    modelo, color, tipoVehiculo, identificacion);
            instance.registroVehiculo();
            fail("Fallo por que permitio el registro");
        } catch (BussinessException ex) {
            assertEquals("El usuario no esta activo "
                    + "o no existe en el sistema.", ex.getMessage());
        } catch (PersistentException ex) {
            Logger.getLogger(VehiculoControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    //Paso la prueba
    @Test
    public void testRegistroVehiculoNoExistente(){
        try {
            System.out.println("registroVehiculo");
            String placa="OLX27B";
            String marca="AKT";
            String modelo="2008";
            String color="AZUL";
            String tipoVehiculo="Motocicleta";
            String identificacion="71699275";
            VehiculoController instance = new VehiculoController(placa, marca, 
                    modelo, color, tipoVehiculo, identificacion);
            instance.registroVehiculo();
            assertTrue("Se registro el vehiculo", true);
        } catch (BussinessException ex) {
            fail("Existio algún error "+ex.getMessage());
        } catch (PersistentException ex) {
            fail("Existio algún error "+ex.getMessage());
        }
    }
    //Paso la prueba
    @Test
    public void testRegistroVehiculoingresadoSinUsuario(){
        try {
            System.out.println("registroVehiculo");
            String placa="OLX27B";
            String marca="AKT";
            String modelo="2008";
            String color="AZUL";
            String tipoVehiculo="Motocicleta";
            String identificacion="1017214614";
            VehiculoController instance = new VehiculoController(placa, marca, 
                    modelo, color, tipoVehiculo, identificacion);
            instance.registroVehiculo();
            assertTrue("Se registro el vehiculo", true);
        } catch (BussinessException ex) {
            fail("Existio algún error "+ex.getMessage());
        } catch (PersistentException ex) {
            fail("Existio algún error "+ex.getMessage());
        }
    }
    
    //Paso la prueba
    @Test
    public void testRegistroVehiculoingresadoConUsuario(){
        try {
            System.out.println("registroVehiculo");
            String placa="OLX27B";
            String marca="AKT";
            String modelo="2008";
            String color="AZUL";
            String tipoVehiculo="Motocicleta";
            String identificacion="1017214614";
            VehiculoController instance = new VehiculoController(placa, marca, 
                    modelo, color, tipoVehiculo, identificacion);
            instance.registroVehiculo();
            fail("Fallo por que permitio el registro");
        } catch (BussinessException ex) {
            assertEquals("El vehiculo ya esta registrado a nombre"
                            + " del usuario ingresado, verifique intentando conceder"
                            + " el ingreso o salida.", ex.getMessage());
        } catch (PersistentException ex) {
            fail("Existio algún error "+ex.getMessage());
        }
    }

    //Paso la prueba
    @Test
    public void testGetTiposVehiculos() throws Exception {
        System.out.println("getTiposVehiculos");
        VehiculoController instance = new VehiculoController();
        int expResult=3;
        List<TipoVehiculo> result = instance.getTiposVehiculos();
        assertEquals(expResult, result.size());
    }
    
}
