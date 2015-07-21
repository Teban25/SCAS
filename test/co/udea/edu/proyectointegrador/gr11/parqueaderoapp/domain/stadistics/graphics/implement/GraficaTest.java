/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.graphics.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller.EstadisticaController;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.graphics.IGrafica;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
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
public class GraficaTest {

    private EstadisticaController controller;
    private IGrafica g;

    public GraficaTest() {
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
        g = new Grafica();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createPieToUserType method, of class Grafica.
     */
    @Test
    public void testCreatePieToUserType() throws Exception {
        String startDate = "2014-07-04 18:14:29.000";
        String endDate = "2017-07-04 18:14:29.000";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date startD = dateFormat.parse(startDate);
        Date endD = dateFormat.parse(endDate);
        JFreeChart chart = g.createPieToUserType(controller.getEstadisticasByTipoUsuario(startD, endD));
        ChartUtilities.saveChartAsJPEG(new File("D:\\chart2.JPG"), chart, 400, 300);
    }

    /**
     * Test of createBarChartToVehicleType method, of class Grafica.
     */
    @Test
    public void testCreateBarChartToVehicleType() throws Exception {
        String startDate = "2014-07-04 18:14:29.000";
        String endDate = "2017-07-04 18:14:29.000";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date startD = dateFormat.parse(startDate);
        Date endD = dateFormat.parse(endDate);
        JFreeChart chart = g.createBarChartToVehicleType(controller.getEstadisticasByTipoVehiculo(startD, endD));
        ChartUtilities.saveChartAsJPEG(new File("D:\\chart4.JPG"), chart, 200, 300);
    }

    /**
     * Test of createXYLineChartToHoursOfDay method, of class Grafica.
     */
    @Test
    public void testCreateXYLineChartToHoursOfDay() throws Exception {
        String startDate = "2014-07-04 18:14:29.000";
        String endDate = "2017-07-04 18:14:29.000";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date startD = dateFormat.parse(startDate);
        Date endD = dateFormat.parse(endDate);
        JFreeChart chart = g.createXYLineChartToHoursOfDay(controller.getEstadisticasByHoraDelDia(startD, endD));
        ChartUtilities.saveChartAsJPEG(new File("D:\\chart5.JPG"), chart, 400, 300);
    }

}
