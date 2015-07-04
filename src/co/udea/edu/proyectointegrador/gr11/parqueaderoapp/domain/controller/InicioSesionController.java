
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement.OperarioUserDaoImplement;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.OperarioUserDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.OperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;

/**
 *
 * @author Teban-Ing
 */
public class InicioSesionController {
    private final String usuario;
    private final String password;
    private OperarioUserDao daoPrueba;
    private OperarioUser operario;
    
    public InicioSesionController(String usuario, String password) {
        this.usuario=usuario;
        this.password=password;
    }
    
    public int permitirSesion()throws PersistentException, BussinessException{
        daoPrueba=new OperarioUserDaoImplement();
        operario=daoPrueba.getOperario(usuario);
        if (operario==null) {
            throw new BussinessException("Verifique el nombre de usuario");
        }
        
        if(!operario.getPassword().equals(this.password)){
            throw new BussinessException("Verifique la contraseña e intentelo de nuevo");
        }
        
        if(!operario.isActivo()){
            throw new BussinessException("EL usuario no se encuentra"
                            + " activo en el sistema, contacte a un administrador");
        }
        return operario.getTipoOperarioUser().getIdTipoOperarioUser();
    }
    
}
