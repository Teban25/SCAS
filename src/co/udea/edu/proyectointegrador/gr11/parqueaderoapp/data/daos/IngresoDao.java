
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Ingreso;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import java.util.Date;

import java.util.List;

/**
 *
 * @author Teban-Ing
 */
public interface IngresoDao {
    /**
     * Se ingresa al sistema una nueva entrada
     * @param ingreso contiene la información estadistica de un ingreso o salida
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
    public void insertarIngreso(Ingreso ingreso)throws PersistentException;
    
    /**
     * Se actualiza el nuevo registro con la fecha de salida
     * @param ingreso con la información actualizada
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
    public void actualizarIngreso(Ingreso ingreso)throws PersistentException;
    
     /**
     * Se recupera todas las estadisticas del sistema por filtro 
     * @return
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
    public List<Ingreso> getAllIngresos()throws PersistentException;
    
    /**
     * Obtener los ingreos filtrados por una fecha especifica
     * @param fechaInicial fecha desde donde se van a traer los ingresos
     * @param fechaFinal fecha hasta donde se van a traer los ingresos
     * @return
     * @throws PersistentException
     */
    public List<Ingreso> getIngresosByDate(Date fechaInicial,Date fechaFinal)throws PersistentException;
}
