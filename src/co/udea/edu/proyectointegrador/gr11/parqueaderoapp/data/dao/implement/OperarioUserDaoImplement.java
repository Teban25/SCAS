/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.OperarioUserDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.hibernateconfig.HibernateUtil;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.OperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Teban-Ing
 */
public class OperarioUserDaoImplement implements OperarioUserDao {

    Session session = null;
    boolean bandera = false;
    private Transaction transaction = null;

    public OperarioUserDaoImplement() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public void insertarOperarioUser(OperarioUser operarioUser) throws PersistentException{
        //Comienzo la transaccion
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            transaction = session.beginTransaction();
            session.save("OperarioUser", operarioUser);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: "+e.getMessage());
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public OperarioUser getOperario(String nombreUsuarioOperario) throws PersistentException{
        OperarioUser oper = null;
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            oper = (OperarioUser) session.get(OperarioUser.class, nombreUsuarioOperario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: "+e.getMessage());
        }finally{
            if(session!=null){
                session.close();
            }
        }
        return oper;
    }

}
