
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoOperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import java.util.List;

/**
 *
 * @author Teban-Ing
 */
public interface TipoOperarioUserDao {
    /**
     * Se inserta un nuevo tipo de operario al sistema
     * @param tipoOperarioUser el nuevo tipo de rol
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
    public void insertTipoUsuario(TipoOperarioUser tipoOperarioUser)throws PersistentException;;
    /**
     * Obtiene todos los tipos de operarios que existan en el sistema
     * @return 
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException 
     */
    public List<TipoOperarioUser> getAllTipoOperario()throws PersistentException;;
    /**
     * Retorna un tipo de operario especifico
     * @param idTipoOperarioUser, se refiere al identificador del tipo de operario
     * @return 
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException 
     */
    public TipoOperarioUser getTipoOperario(int idTipoOperarioUser)throws PersistentException;;
}
