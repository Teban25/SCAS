
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.TipoIdentificacionDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.hibernateconfig.HibernateUtil;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoIdentificacion;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Teban-Ing
 */
public class TipoIdentificacionDaoImplement implements TipoIdentificacionDao{
    
    Session session = null;
    boolean bandera=false;
    private Transaction transaction=null;
    
    public TipoIdentificacionDaoImplement(){
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public TipoIdentificacion getTipoUsuario(int idTipoIdentificacion)throws PersistentException {
        TipoIdentificacion tipoI=null;
        try{
            SessionFactory sf=HibernateUtil.getSessionFactory();
            session=sf.openSession();
            tipoI=(TipoIdentificacion)session.get(TipoIdentificacion.class, idTipoIdentificacion);
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            throw new PersistentException("Se genero un problema con el manejo "
                    + "de la base de datos, mensaje del sistema: " + e.getMessage());
        }
        return tipoI;
    }

    @Override
    public void insertTipoIdentificacion(TipoIdentificacion tipoIdentificacion)throws PersistentException {
            //Comienzo la transaccion
            try{
                SessionFactory sf=HibernateUtil.getSessionFactory();
                session=sf.openSession();
                transaction = session.beginTransaction();
                session.save("TipoIdentificacion", tipoIdentificacion);
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
    
}
