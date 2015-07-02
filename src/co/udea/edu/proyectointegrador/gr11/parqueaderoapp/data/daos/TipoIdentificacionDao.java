
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoIdentificacion;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;

/**
 *
 * @author Teban-Ing
 */
public interface TipoIdentificacionDao {
    /**
     * Se inserta un nuevo tipo de identificacion al sistema
     * @param tipoIdentificacion nuevo tipo de identificacion en el sistema
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
    public void insertTipoIdentificacion(TipoIdentificacion tipoIdentificacion)throws PersistentException;;
    /**
     * Retorna un tipo de identificacion especifico
     * @param idTipoIdentificacion, se refiere al identificador del tipo de identificacion
     * @return 
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException 
     */
    public TipoIdentificacion getTipoUsuario(int idTipoIdentificacion)throws PersistentException;;
}
