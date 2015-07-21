/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.graphics;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.HoraDelDiaEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoUsuarioEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoVehiculoEstadistica;
import java.util.List;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author JuanF
 */
public interface IGrafica {
    /**
     * Construye un grafico de torta a partir de una lista de estadísticas según el tipo de
     * usuarios
     * @param tipoUsuarios
     * @return El gráfico tipo torta
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException
     */
    public JFreeChart createPieToUserType(List<TipoUsuarioEstadistica> tipoUsuarios)throws BussinessException;
    
    /**
     * Construye un grafico de barras a partir de una lista de estadísticas según el tipo de
     * vehiculos
     * @param tipoUsuarios
     * @return El gráfico tipo barra
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException 
     */
    public JFreeChart createBarChartToVehicleType(List<TipoVehiculoEstadistica> tipoUsuarios)throws BussinessException;
    
    /**
     * Construye un grafico de linea a partir de una lista de estadísticas según las horas
     * de ingreso de los vehículos
     * @param tipoUsuarios
     * @return El gráfico tipo XY linea
     * @throws BussinessException 
     */
    public JFreeChart createXYLineChartToHoursOfDay(List<HoraDelDiaEstadistica> tipoUsuarios)throws BussinessException;
}
