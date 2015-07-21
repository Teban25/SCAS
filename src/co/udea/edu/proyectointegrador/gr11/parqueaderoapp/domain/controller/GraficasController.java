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
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.graphics.IGrafica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.graphics.implement.Grafica;
import java.util.Date;
import java.util.List;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author JuanF
 */
public class GraficasController {

    private final EstadisticaController estadisticaController;
    private final IGrafica grafica;

    public GraficasController() {
        estadisticaController = new EstadisticaController();
        grafica = new Grafica();
    }

    public JFreeChart getChartToTypeVehicle(Date fechaInicio, Date fechaFin) throws BussinessException {
        List<TipoVehiculoEstadistica> tiposVehiculo = estadisticaController
                .getEstadisticasByTipoVehiculo(fechaInicio, fechaFin);
        JFreeChart chart = grafica.createBarChartToVehicleType(tiposVehiculo);
        return chart;
    }

    public JFreeChart getChartToTypeUser(Date fechaInicio, Date fechaFin) throws BussinessException {
        List<TipoUsuarioEstadistica> tiposUsuario = estadisticaController
                .getEstadisticasByTipoUsuario(fechaInicio, fechaFin);
        JFreeChart chart = grafica.createPieToUserType(tiposUsuario);
        return chart;
    }

    public JFreeChart getChartToHourOfDay(Date fechaInicio, Date fechaFin) throws BussinessException {
        List<HoraDelDiaEstadistica> horasDelDia = estadisticaController
                .getEstadisticasByHoraDelDia(fechaInicio, fechaFin);
        JFreeChart chart = grafica.createXYLineChartToHoursOfDay(horasDelDia);
        return chart;
    }

}
