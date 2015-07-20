/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.EstadisticasDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.hibernateconfig.HibernateUtil;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoUsuario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoUsuarioEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoVehiculoEstadistica;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ASUS
 */
public class EstadisticaDaoImpl implements EstadisticasDao {

    Session session = null;
    boolean bandera = false;

    public EstadisticaDaoImpl() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public List<TipoVehiculoEstadistica> getIngresosByTipoVehiculo(String fechaInicio, String fechaFin) throws PersistentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoUsuarioEstadistica> getIngresosByTipoUsuario(String fechaInicio, String fechaFin) throws PersistentException {
        List<TipoUsuarioEstadistica> listaDeTipoUsuario = new ArrayList<>();
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query query = session.createQuery("SELECT I.usuarioVehiculo.usuario.tipoUsuario , count(*) FROM Ingreso as I "
                    + "where I.id.fechaIngreso between :fechaInicio and :fechaFin "
                    + "GROUP BY I.usuarioVehiculo.usuario.tipoUsuario");
            query.setParameter("fechaIngreso", fechaInicio).setParameter("fechaFin", fechaFin);
            List<Object[]> results = query.list();

            for (Object[] result : results) {
                TipoUsuario tipoUsuario = (TipoUsuario) result[0];
                int numeroDeIngresos = (int) result[1];
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

}
