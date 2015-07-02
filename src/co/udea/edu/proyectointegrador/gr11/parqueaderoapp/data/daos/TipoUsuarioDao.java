
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoUsuario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;

/**
 *
 * @author Teban-Ing
 */
public interface TipoUsuarioDao {
    /**
     * Se inserta un nuevo tipo de usuario al sistema
     * @param tipoUsuario nuevo tipo de rol de los usuarios
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
    public void insertTipoUsuario(TipoUsuario tipoUsuario)throws PersistentException;;
    
    /**
     * Retorna un tipo de usuario especifico
     * @param idTipoUsuario, se refiere al identificador del tipo de usuario
     * @return 
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException 
     */
    public TipoUsuario getTipoUsuario(int idTipoUsuario)throws PersistentException;;
}
