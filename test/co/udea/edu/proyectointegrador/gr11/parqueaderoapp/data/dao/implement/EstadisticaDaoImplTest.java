/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.EstadisticasDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoUsuarioEstadistica;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class EstadisticaDaoImplTest {
    
    public EstadisticaDaoImplTest() {
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
     * Test of getIngresosByTipoVehiculo method, of class EstadisticaDaoImpl.
     */
    /*
    @Test
    public void testGetIngresosByTipoVehiculo() throws Exception {
    }

    /**
     * Test of getIngresosByTipoUsuario method, of class EstadisticaDaoImpl.
     */
    @Test
    public void testGetIngresosByTipoUsuario() throws Exception {
        EstadisticasDao dao= new EstadisticaDaoImpl();
        
        List<TipoUsuarioEstadistica>tipos=dao.getIngresosByTipoUsuario("2016-07-04 18:14:29.000", "2014-07-04 18:14:29.000");
        assertEquals(3, tipos.size());
    }
    
}
