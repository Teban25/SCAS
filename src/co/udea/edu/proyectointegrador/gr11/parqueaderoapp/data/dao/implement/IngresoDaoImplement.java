/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.IngresoDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.hibernateconfig.HibernateUtil;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Ingreso;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Teban-Ing
 */
public class IngresoDaoImplement implements IngresoDao {

    Session session = null;
    boolean bandera = false;
    private Transaction transaction = null;

    public IngresoDaoImplement() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public void insertarIngreso(Ingreso ingreso) throws PersistentException {
        //Comienzo la transaccion
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            transaction = session.beginTransaction();
            session.save("Ingreso", ingreso);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: " + e.getMessage());
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Ingreso> getAllIngresos() throws PersistentException {
        List<Ingreso> todosIngresos = null;
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query q = session.createQuery("from Ingreso");
            todosIngresos = q.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: " + e.getMessage());
        }finally{
            if(session!=null){
                session.close();
            }
        }
        return todosIngresos;
    }

    @Override
    public void actualizarIngreso(Ingreso ingreso) throws PersistentException {
        //Comienzo la transaccion
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            transaction = session.beginTransaction();
            session.update("Ingreso", ingreso);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: " + e.getMessage());
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }
    
    

    @Override
    public List<Ingreso> getIngresosByDate(String fechaInicial, String fechaFinal) throws PersistentException {
        List<Ingreso> todosIngresos = null;
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            String hql = "from Ingreso u where u.id.fechaIngreso >= :fechaInicial and u.id.fechaIngreso <= :fechaFinal";
            todosIngresos = session.createQuery(hql)
                    .setParameter("fechaInicial", fechaInicial).setParameter("fechaFinal", fechaFinal).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: " + e.getMessage());
        }finally{
            if(session!=null){
                session.close();
            }
        }
        return todosIngresos;
    }

    @Override
    public Ingreso getLastIngreso(String identificacion, String placa) throws PersistentException {
        Ingreso ultimoIngreso=null;
        try{
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            String hql="from Ingreso e where e.id.placa=:placa and "
                    + "e.id.usuarioIdentificacion=:identificacion ORDER BY "
                    + "e.id.fechaIngreso DESC";
            ultimoIngreso=(Ingreso)session.createQuery(hql).setParameter("placa", placa)
                    .setParameter("identificacion", identificacion).setMaxResults(1).uniqueResult();
        }finally{
            if(session!=null){
                session.close();
            }
        }
        return ultimoIngreso;
    }

}
