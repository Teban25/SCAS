
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.TipoOperarioUserDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.hibernateconfig.HibernateUtil;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoOperarioUser;
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
public class TipoOperarioUserDaoImplement implements TipoOperarioUserDao{
    Session session = null;
    boolean bandera=false;
    private Transaction transaction=null;
    
    public TipoOperarioUserDaoImplement(){
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public void insertTipoUsuario(TipoOperarioUser tipoOperarioUser) throws PersistentException {
        //Comienzo la transaccion
            try{
                SessionFactory sf=HibernateUtil.getSessionFactory();
                session=sf.openSession();
                transaction = session.beginTransaction();
                session.save("TipoOperarioUser", tipoOperarioUser);
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
    public List<TipoOperarioUser> getAllTipoOperario() throws PersistentException {
       List<TipoOperarioUser> nuevoTipo=null;
       try{
           SessionFactory sf=HibernateUtil.getSessionFactory();
           session=sf.openSession();
           Query q=session.createQuery("from TipoOperarioUser");
           nuevoTipo=q.list();
           session.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
           System.out.println(e.getCause());
           throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: " + e.getMessage());
       }
       return nuevoTipo;
    }

    @Override
    public TipoOperarioUser getTipoOperario(int idTipoOperarioUser) throws PersistentException {
        TipoOperarioUser tipoOpe=null;
        try{
            SessionFactory sf=HibernateUtil.getSessionFactory();
            session=sf.openSession();
            tipoOpe=(TipoOperarioUser)session.get(TipoOperarioUser.class, idTipoOperarioUser);
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: " + e.getMessage());
        }
        return tipoOpe;
    }
    
}
