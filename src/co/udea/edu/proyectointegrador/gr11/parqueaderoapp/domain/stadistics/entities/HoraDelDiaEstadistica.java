/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities;

/**
 *
 * @author juanF
 */
public class HoraDelDiaEstadistica {
    private int horaDelDia;
    private long numeroDeIngresos;

    public HoraDelDiaEstadistica(int horaDelDia, long numeroDeIngresos) {
        this.horaDelDia = horaDelDia;
        this.numeroDeIngresos = numeroDeIngresos;
    }

    public int getHoraDelDia() {
        return horaDelDia;
    }

    public void setHoraDelDia(int horaDelDia) {
        this.horaDelDia = horaDelDia;
    }

    public long getNumeroDeIngresos() {
        return numeroDeIngresos;
    }

    public void setNumeroDeIngresos(long numeroDeIngresos) {
        this.numeroDeIngresos = numeroDeIngresos;
    }
    
    
    
}
