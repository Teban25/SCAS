/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.HoraDelDiaEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoUsuarioEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoVehiculoEstadistica;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class EstadisticaControllerTest {

    private EstadisticaController controller;

    public EstadisticaControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        controller = new EstadisticaController();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEstadisticaByTipoVehiculoWithoutFechas() {
        try {
            List<TipoVehiculoEstadistica> estadisticas = controller
                    .getEstadisticasByTipoVehiculo(null, null);
        } catch (BussinessException ex) {
            assertEquals("La Fecha de inicio no puede estar vacía.", ex.getMessage());
        }
    }

    @Test
    public void testEstadisticaByTipoVehiculoWithEndDateBeforeStartDate() {
        try {
            String startDate = "2015-07-04 18:14:29.000";
            String endDate = "2014-07-04 18:14:29.000";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            Date startD = dateFormat.parse(startDate);
            Date endD = dateFormat.parse(endDate);
            List<TipoVehiculoEstadistica> estadisticas = controller
                    .getEstadisticasByTipoVehiculo(startD, endD);
        } catch (BussinessException ex) {
            assertEquals("La fecha de fin no puede estar antes de la fecha de inicio", ex.getMessage());
        } catch (ParseException ex) {
            fail("Fallaron las fechas " + ex.getMessage());
        }
    }

    @Test
    public void testEstadisticaByTipoVehiculo() {
        try {
            String startDate = "2014-07-04 18:14:29.000";
            String endDate = "2017-07-04 18:14:29.000";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SSS");
            Date startD = dateFormat.parse(startDate);
            Date endD = dateFormat.parse(endDate);
            List<TipoVehiculoEstadistica> estadisticas = controller
                    .getEstadisticasByTipoVehiculo(startD, endD);
            assertEquals(2, estadisticas.size());
        } catch (BussinessException ex) {
            fail("Fallo el proceso " + ex.getMessage());
        } catch (ParseException ex) {
            fail("Fallaron las fechas " + ex.getMessage());
        }
    }

    @Test
    public void testEstadisticaByTipoUsuario() {
        try {
            String startDate = "2014-07-04 18:14:29.000";
            String endDate = "2017-07-04 18:14:29.000";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SSS");
            Date startD = dateFormat.parse(startDate);
            Date endD = dateFormat.parse(endDate);
            List<TipoUsuarioEstadistica> estadisticas = controller
                    .getEstadisticasByTipoUsuario(startD, endD);
            assertEquals(3, estadisticas.size());
        } catch (BussinessException ex) {
            fail("Fallo el proceso " + ex.getMessage());
        } catch (ParseException ex) {
            fail("Fallaron las fechas " + ex.getMessage());
        }
    }

    @Test
    public void testEstadisticaByHoraDelDia() {
        try {
            String startDate = "2014-07-04 18:14:29.000";
            String endDate = "2017-07-04 18:14:29.000";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SSS");
            Date startD = dateFormat.parse(startDate);
            Date endD = dateFormat.parse(endDate);
            List<HoraDelDiaEstadistica> estadisticas = controller
                    .getEstadisticasByHoraDelDia(startD, endD);
            assertEquals(3, estadisticas.size());
        } catch (BussinessException ex) {
            fail("Fallo el proceso " + ex.getMessage());
        } catch (ParseException ex) {
            fail("Fallaron las fechas " + ex.getMessage());
        }
    }
}
