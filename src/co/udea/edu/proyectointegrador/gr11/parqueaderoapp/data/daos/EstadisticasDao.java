/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.HoraDelDiaEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoUsuarioEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoVehiculoEstadistica;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JuanF
 */
public interface EstadisticasDao {
    
    /**
     * Obtiene el numero de ingresos hechos al parqueadero por tipo de vehiculo
     * @param fechaInicio fecha de inicio de los ingresos
     * @param fechaFin fecha  final de los ingresos
     * @return lista con el tipo de vehícul y el numero de ingresos
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
    public List<TipoVehiculoEstadistica> getIngresosByTipoVehiculo(Date fechaInicio, Date fechaFin)throws PersistentException;
    
    
      /**
     * Obtiene el numero de ingresos hechos al parqueadero por tipo de usuario
     * @param fechaInicio fecha de inicio de los ingresos
     * @param fechaFin fecha de fin de los ingresos
     * @return lista con el tipo de vehícul y el numero de ingresos
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
    public List<TipoUsuarioEstadistica> getIngresosByTipoUsuario(Date fechaInicio, Date fechaFin)throws PersistentException;
    
    /**
     * Obtiene el numero de ingresos hechos al parqueadero por hora del dia
     * @param fechaInicio fecha de inicio de los ingresos
     * @param fechaFin fecha de fin de los ingresos
     * @return lista con la hora del día y el numero de ingresos
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
    public List<HoraDelDiaEstadistica> getIngresosByHoraDelDia(Date fechaInicio, Date fechaFin)throws PersistentException;
}
