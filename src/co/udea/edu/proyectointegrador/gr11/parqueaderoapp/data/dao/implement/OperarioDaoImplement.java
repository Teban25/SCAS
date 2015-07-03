/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.OperarioDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.hibernateconfig.HibernateUtil;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Operario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Teban-Ing
 */
public class OperarioDaoImplement implements OperarioDao {

    Session session = null;
    boolean bandera = false;
    private Transaction transaction = null;

    public OperarioDaoImplement() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public void insertarOperario(Operario operario) throws PersistentException {
        //Comienzo la transaccion
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            transaction = session.beginTransaction();
            session.save("Operario", operario);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: " + e.getMessage());
        }
    }

    @Override
    public Operario getOperario(String identificacion) throws PersistentException {
        Operario retornaOper = null;
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            retornaOper = (Operario) session.get(Operario.class, identificacion);
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: "+e.getMessage());
        }
        return retornaOper;
    }

    @Override
    public void modificarOperario(Operario operario) throws PersistentException {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            session.update(operario);
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: "+e.getMessage());
        }
    }

    @Override
    public void eliminarOperario(String cedula) throws PersistentException {
        try {
            Operario operario = getOperario(cedula);
            if (operario == null) {
                throw new PersistentException("El usuario que desea eliminar no existe");
            }

            SessionFactory sf = HibernateUtil.getSessionFactory();

            session = sf.openSession();
            session.delete(operario);
            session.close();
        } catch (PersistentException | HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: "+e.getMessage());
        }
    }

    @Override
    public Operario getOperarioByNombreUsuario(String nombreUsuario) throws PersistentException {
        Operario retornaOper = null;
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query query = session.createQuery("FROM Operario AS e WHERE e.nombreUsuario= :nombreUsuario");
            query.setParameter("nombreUsuario", nombreUsuario);
            retornaOper = (Operario) query.uniqueResult();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: "+e.getMessage());
        }
        return retornaOper;
    }

}
