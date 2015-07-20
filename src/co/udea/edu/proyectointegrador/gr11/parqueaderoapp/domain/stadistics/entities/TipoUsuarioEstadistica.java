/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoUsuario;

/**
 *
 * @author JuanF
 */
public class TipoUsuarioEstadistica {
    
    private TipoUsuario tipoUsuario;
     
    private int numeroDeIngresos;

    public TipoUsuarioEstadistica(TipoUsuario tipoUsuario, int numeroDeIngresos) {
        this.tipoUsuario = tipoUsuario;
        this.numeroDeIngresos = numeroDeIngresos;
    }
    
    public int getNumeroDeIngresos() {
        return numeroDeIngresos;
    }

    public void setNumeroDeIngresos(int numeroDeIngresos) {
        this.numeroDeIngresos = numeroDeIngresos;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    

   
    
}
