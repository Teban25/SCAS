
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Usuario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;

/**
 *
 * @author Teban-Ing
 */
public interface UsuarioDao {
     /**
     * Se inserta un nuevo usuario
     * @param usuario nuevo usuario para ser ingresado
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
    public void insertarUsuario(Usuario usuario)throws PersistentException;;
    
    /**
     * Se recupera un usuario
     * @param id clave del usuario (numero de identificacion)
     * @return
     * @throws co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException
     */
    public Usuario getUsuario(String id)throws PersistentException;;
}
