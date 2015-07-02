
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoVehiculo;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import java.util.List;

/**
 *
 * @author Teban-Ing
 */
public interface TipoVehiculoDao {
    /**
     * Se inserta un nuevo tipo de vehiculo al sistema
     * @param tipoVehiculo nuevo tipo de vehiculo para hacer parte del sistema
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
    public void insertTipoVehiculo(TipoVehiculo tipoVehiculo)throws PersistentException;;
    /**
     * Obtiene todas los usuarios que existan en el sistema
     * @return 
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException 
     */
    public List<TipoVehiculo> getAllTipoVehiculo()throws PersistentException;;
    /**
     * Retorna un tipo de vehiculo especifico
     * @param descripcionTipoVehiculo, se refiere al identificador del tipo de vehiculo a retornar
     * @return 
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException 
     */
    public TipoVehiculo getTipoVehiculo(String descripcionTipoVehiculo)throws PersistentException;;
}
