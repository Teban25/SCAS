
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.OperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;

/**
 *
 * @author Teban-Ing
 */
public interface OperarioUserDao {
     /**
     * Se inserta un usuario operario para la manipulación de sesión
     * @param operarioUser nuevo para ingresarlo al sistema y poder tener acceso
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
     public void insertarOperarioUser(OperarioUser operarioUser)throws PersistentException;
     /**
     * Se recupera un usuariooperario del sistema
     * @param nombreUsuarioOperario nombre de usuario
     * @return
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
     public OperarioUser getOperario(String nombreUsuarioOperario)throws PersistentException; 
}
