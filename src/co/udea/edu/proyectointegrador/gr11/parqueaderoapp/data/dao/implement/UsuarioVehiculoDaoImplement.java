/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.UsuarioVehiculoDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.hibernateconfig.HibernateUtil;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Usuario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.UsuarioVehiculo;
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
public class UsuarioVehiculoDaoImplement implements UsuarioVehiculoDao{

    Session session = null;
    boolean bandera=false;
    private Transaction transaction=null;

    public UsuarioVehiculoDaoImplement() {
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public void insertarUsuarioVehiculo(UsuarioVehiculo usuarioVehiculo) throws PersistentException {
        //Comienzo la transaccion
            try{
                SessionFactory sf=HibernateUtil.getSessionFactory();
                session=sf.openSession();
                transaction = session.beginTransaction();
                session.save("UsuarioVehiculo", usuarioVehiculo);
                transaction.commit();
                session.close();
            }catch(Exception e){
                transaction.rollback();
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
                throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: " + e.getMessage());
            }
    }

    @Override
    public List<UsuarioVehiculo> getUsuarioVehiculo(String  identificacion) throws PersistentException {
        List<UsuarioVehiculo> vehiculosUser=null;//vehiculos del usuario
        try{
           SessionFactory sf=HibernateUtil.getSessionFactory();
           session=sf.openSession();
           //Consulta vehiculos del usuario x
           String hql="from UsuarioVehiculo u where u.id.usuarioIdentificacion=:identificacion";
           vehiculosUser=session.createQuery(hql)
                   .setParameter("identificacion", identificacion).list();
           session.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
           System.out.println(e.getCause());
           throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: " + e.getMessage());
       }
        return vehiculosUser;
    }
    
}
