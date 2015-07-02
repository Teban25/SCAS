
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Vehiculo;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;


/**
 *
 * @author Teban-Ing
 */
public interface VehiculoDao {
    /**
     * Se inserta un operario
     * @param vehiculo nuevo vehiculo a ser registrado
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
     public void insertarVehiculo(Vehiculo vehiculo)throws PersistentException;;
     
      /**
     * Se recupera un vehiculo
     * @param placa conjunto de letras y numero unico de cada vehiculo
     * @return
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
     public Vehiculo getVehiculo(String placa)throws PersistentException;;
     
}
