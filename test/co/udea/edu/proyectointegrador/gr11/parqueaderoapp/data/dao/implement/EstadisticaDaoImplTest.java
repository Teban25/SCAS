/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.EstadisticasDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.HoraDelDiaEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoUsuarioEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoVehiculoEstadistica;
import java.text.SimpleDateFormat;
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
    
    private final SimpleDateFormat dateFormat= new 
        SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SSS");
    
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
    
    @Test
    public void testGetIngresosByTipoVehiculo() throws Exception {
        EstadisticasDao dao= new EstadisticaDaoImpl();
        
        List<TipoVehiculoEstadistica>tipos=dao.getIngresosByTipoVehiculo(dateFormat.parse("2014-07-04 18:14:29.000"),dateFormat.parse("2016-07-04 18:14:29.000"));
        assertEquals(2, tipos.size());
    }

    /**
     * Test of getIngresosByTipoUsuario method, of class EstadisticaDaoImpl.
     */
    @Test
    public void testGetIngresosByTipoUsuario() throws Exception {
        EstadisticasDao dao= new EstadisticaDaoImpl();
        
        List<TipoUsuarioEstadistica>tipos=dao.getIngresosByTipoUsuario(dateFormat.parse("2014-07-04 18:14:29.000"),dateFormat.parse("2017-07-04 18:14:29.000"));
        assertEquals(3, tipos.size());
    }

    /**
     * Test of getIngresosByHoraDelDia method, of class EstadisticaDaoImpl.
     */
    @Test
    public void testGetIngresosByHoraDelDia() throws Exception {
                EstadisticasDao dao= new EstadisticaDaoImpl();
        
        List<HoraDelDiaEstadistica>tipos=dao.getIngresosByHoraDelDia(dateFormat.parse("2014-07-04 18:14:29.000"),dateFormat.parse("2016-07-04 18:14:29.000"));
        assertEquals(3, tipos.size());
    }
    
}
