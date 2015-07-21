/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.EstadisticasDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.hibernateconfig.HibernateUtil;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoUsuario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoVehiculo;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.HoraDelDiaEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoUsuarioEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoVehiculoEstadistica;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author JuanF
 */
public class EstadisticaDaoImpl implements EstadisticasDao {

    Session session = null;
    boolean bandera = false;

    public EstadisticaDaoImpl() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public List<TipoVehiculoEstadistica> getIngresosByTipoVehiculo(Date fechaInicio, Date fechaFin) throws PersistentException {
        List<TipoVehiculoEstadistica> listaDeTipoVehiculo = new ArrayList<>();
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query query = session.createQuery("SELECT I.usuarioVehiculo.vehiculo.tipoVehiculo , count(*) FROM Ingreso as I "
                    + "where I.id.fechaIngreso between :fechaInicio and :fechaFin "
                    + "GROUP BY I.usuarioVehiculo.vehiculo.tipoVehiculo");
            query.setParameter("fechaInicio", fechaInicio).setParameter("fechaFin", fechaFin);
            List<Object[]> results = query.list();

            for (Object[] result : results) {
                TipoVehiculo tipoVehiculo = (TipoVehiculo) result[0];
                long numeroDeIngresos = (long) result[1];
                TipoVehiculoEstadistica estadistica = new TipoVehiculoEstadistica(tipoVehiculo, numeroDeIngresos);
                listaDeTipoVehiculo.add(estadistica);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listaDeTipoVehiculo;
    }

    @Override
    public List<TipoUsuarioEstadistica> getIngresosByTipoUsuario(Date fechaInicio, Date fechaFin) throws PersistentException {
        List<TipoUsuarioEstadistica> listaDeTipoUsuario = new ArrayList<>();
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query query = session.createQuery("SELECT I.usuarioVehiculo.usuario.tipoUsuario , count(*) FROM Ingreso as I "
                    + "where I.id.fechaIngreso between :fechaInicio and :fechaFin "
                    + "GROUP BY I.usuarioVehiculo.usuario.tipoUsuario");
            query.setParameter("fechaInicio", fechaInicio).setParameter("fechaFin", fechaFin);
            List<Object[]> results = query.list();

            for (Object[] result : results) {
                TipoUsuario tipoUsuario = (TipoUsuario) result[0];
                long numeroDeIngresos = (long) result[1];
                TipoUsuarioEstadistica estadistica = new TipoUsuarioEstadistica(tipoUsuario, numeroDeIngresos);
                listaDeTipoUsuario.add(estadistica);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listaDeTipoUsuario;

    }

    @Override
    public List<HoraDelDiaEstadistica> getIngresosByHoraDelDia(Date fechaInicio, Date fechaFin) throws PersistentException {
        List<HoraDelDiaEstadistica> listaDeHoras = new ArrayList<>();
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query query = session.createQuery("Select HOUR(I.id.fechaIngreso), count(*) from Ingreso as I "
                    + "where I.id.fechaIngreso between :fechaInicio and :fechaFin "
                    + "group by  HOUR(I.id.fechaIngreso) "
                    + "order by  HOUR(I.id.fechaIngreso) ");
            query.setParameter("fechaInicio", fechaInicio).setParameter("fechaFin", fechaFin);
            List<Object[]> results = query.list();

            for (Object[] result : results) {
                int horaDelDia = (int) result[0];
                long numeroDeIngresos = (long) result[1];
                HoraDelDiaEstadistica estadistica = new HoraDelDiaEstadistica(horaDelDia, numeroDeIngresos);
                listaDeHoras.add(estadistica);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return listaDeHoras;

    }

}
