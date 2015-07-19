/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoVehiculo;
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
public class TipoVehiculoDaoImplementTest {
    
    public TipoVehiculoDaoImplementTest() {
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
    public void testInsertTipoVehiculo() throws Exception {
        System.out.println("insertTipoVehiculo");
        TipoVehiculo tipoVehiculo = new TipoVehiculo(3,"Camion");
        TipoVehiculoDaoImplement instance = new TipoVehiculoDaoImplement();
        instance.insertTipoVehiculo(tipoVehiculo);
    }
    
    
    @Test
    public void testGetAllTipoVehiculo() throws Exception {
        System.out.println("getAllTipoVehiculo");
        TipoVehiculoDaoImplement instance = new TipoVehiculoDaoImplement();
        List<TipoVehiculo> result = instance.getAllTipoVehiculo();
        for(TipoVehiculo vehiculos:result){
            System.out.println(vehiculos.getTipoVehiculoDescripcion());
        }
    }

    //Paso la prueba
    @Test
    public void testGetTipoVehiculo() throws Exception {
        System.out.println("getTipoVehiculo");
        String descripcionTipoVehiculo = "Motocicleta";
        int expResult=0;
        TipoVehiculoDaoImplement instance = new TipoVehiculoDaoImplement();
        TipoVehiculo result = instance.getTipoVehiculo(descripcionTipoVehiculo);
        assertEquals(expResult, result.getIdTipoVehiculo());
    }
  
}
