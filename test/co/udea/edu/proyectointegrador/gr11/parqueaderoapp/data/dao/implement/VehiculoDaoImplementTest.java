/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoVehiculo;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Vehiculo;
import java.util.Date;
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
public class VehiculoDaoImplementTest {
    
    public VehiculoDaoImplementTest() {
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
    public void testInsertarVehiculo() throws Exception {
        System.out.println("insertarVehiculo");
        TipoVehiculo tipoV=new TipoVehiculo();
        tipoV.setIdTipoVehiculo(0);
        Vehiculo vehiculo = new Vehiculo("OIT95B",tipoV,"Boxer",
                "Blanca","2010",new Date(), null);
        VehiculoDaoImplement instance = new VehiculoDaoImplement();
        instance.insertarVehiculo(vehiculo);
    }

    //Paso la prueba
    @Test
    public void testGetVehiculo() throws Exception {
        System.out.println("getVehiculo");
        String placa = "LAU47A";
        VehiculoDaoImplement instance = new VehiculoDaoImplement();
        String expResult ="YAMAHA DT";
        Vehiculo result = instance.getVehiculo(placa);
        assertEquals(expResult, result.getMarca());
    }
}
