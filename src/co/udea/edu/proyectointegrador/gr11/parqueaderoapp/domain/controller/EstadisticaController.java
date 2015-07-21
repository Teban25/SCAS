/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement.EstadisticaDaoImpl;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.EstadisticasDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
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
public class EstadisticaController {

    private final EstadisticasDao estadisticasDao;

    public EstadisticaController() {
        estadisticasDao = new EstadisticaDaoImpl();
    }

    public List<TipoVehiculoEstadistica> getEstadisticasByTipoVehiculo(Date startDate, Date endDate) throws BussinessException {
        validateDates(startDate, endDate);
        try {
            return estadisticasDao.getIngresosByTipoVehiculo(startDate, endDate);
        } catch (PersistentException ex) {
            throw new BussinessException("Existe un error técnico, por favor, intente de nuevo "
                    + "o contacte al administrador.");
        }
    }

    public List<TipoUsuarioEstadistica> getEstadisticasByTipoUsuario(Date startDate, Date endDate) throws BussinessException {
        validateDates(startDate, endDate);
        try {
            return estadisticasDao.getIngresosByTipoUsuario(startDate, endDate);
        } catch (PersistentException ex) {
            throw new BussinessException("Existe un error técnico, por favor, intente de nuevo "
                    + "o contacte al administrador.");
        }
    }

    public List<HoraDelDiaEstadistica> getEstadisticasByHoraDelDia(Date startDate, Date endDate) throws BussinessException {
        validateDates(startDate, endDate);
        try {
            return estadisticasDao.getIngresosByHoraDelDia(startDate, endDate);
        } catch (PersistentException ex) {
            throw new BussinessException("Existe un error técnico, por favor, intente de nuevo "
                    + "o contacte al administrador.");
        }
    }

    private void validateDates(Date fechaInicio, Date fechaFin) throws BussinessException {
        if (fechaInicio == null) {
            throw new BussinessException("La Fecha de inicio no puede estar vacía.");
        }
        if (fechaFin == null) {
            throw new BussinessException("La Fecha de fin no puede estar vacía.");
        }
        if (fechaFin.before(fechaInicio)) {
            throw new BussinessException("La fecha de fin no puede estar antes de la fecha de inicio");
        }
    }

}
