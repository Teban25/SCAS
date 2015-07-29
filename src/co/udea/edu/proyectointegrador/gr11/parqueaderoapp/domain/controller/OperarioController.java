/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement.OperarioDaoImplement;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement.OperarioUserDaoImplement;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement.TipoOperarioUserDaoImplement;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.OperarioDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.OperarioUserDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.TipoOperarioUserDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Operario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.OperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoOperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import java.util.List;

/**
 *
 * @author juanf.molina
 */
public class OperarioController {

    private OperarioDao operarioDao;
    private OperarioUserDao operarioUserDao;
    private TipoOperarioUserDao tipoOperarioUserDao;

    public OperarioController() {
        operarioDao = new OperarioDaoImplement();
    }
    
    public Operario buscarOperario(String cedula) throws BussinessException, PersistentException {
        Operario operario = operarioDao.getOperario(cedula);
        if (operario == null) {
            throw new BussinessException("El operario no existe");
        }
        return operario;
    }

    public void insertarOperario(Operario operario) throws BussinessException, PersistentException {
       validarOperario(operario);
       operarioDao.insertarOperario(operario);
    }
    
    public void eliminarOperario(String cedulaOperario) throws PersistentException, BussinessException{
        if(cedulaOperario==null || cedulaOperario.equals(""))
            throw new BussinessException("Debe ingresar una cedula para eliminar un operario");
        operarioDao.eliminarOperario(cedulaOperario);
    }
    
    public void actualizarOperario(Operario operario) throws BussinessException, PersistentException{
        validarOperario(operario);
        operarioDao.modificarOperario(operario);
    }

    private void validarOperario(Operario operario) throws BussinessException {
        if(operario ==null)
            throw new BussinessException("Alguno de los campos está vacío");
        
        if (operario.getApellido().equals("") || operario.getDireccion().equals("")
                || operario.getNombre().equals("") || operario.getTelefono().equals("")
                || operario.getOperarioUser().getNombreUsuarioOperario().equals("")
                || operario.getOperarioUser().getPassword().equals("")) {
            throw new BussinessException("Alguno de los campos está vacío");
        }
    }
    
    private void validarOperarioUser(OperarioUser operarioUser) throws BussinessException{
        if(operarioUser==null)
           throw new BussinessException("Alguno de los campos está vacío");
        if(operarioUser.getNombreUsuarioOperario().equals("") || 
                operarioUser.getPassword().equals("")){
            throw new BussinessException("Alguno de los campos está vacío");
        }
    }
    
    public List<TipoOperarioUser> getTiposOperario() throws BussinessException, PersistentException{
        List<TipoOperarioUser> tipoOperario;
        tipoOperarioUserDao=new TipoOperarioUserDaoImplement();
        tipoOperario=tipoOperarioUserDao.getAllTipoOperario();
        if(tipoOperario==null){
            throw new BussinessException("Hubo un error al recuperar los tipos de"
                    + " Operarios, contacte al administrador");
        }
        return tipoOperario;
    }
    
    public void insertarOperarioUser(OperarioUser operarioUser) throws BussinessException, PersistentException{
        validarOperarioUser(operarioUser);
        operarioUserDao=new OperarioUserDaoImplement();
        operarioUserDao.insertarOperarioUser(operarioUser);
    }
}
