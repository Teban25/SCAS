package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities;
// Generated 30/06/2015 12:55:54 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * IngresoId generated by hbm2java
 */
public class IngresoId  implements java.io.Serializable {


     private Date fechaIngreso;
     private String placa;
     private String usuarioIdentificacion;

    public IngresoId() {
    }

    public IngresoId(Date fechaIngreso, String placa, String usuarioIdentificacion) {
       this.fechaIngreso = fechaIngreso;
       this.placa = placa;
       this.usuarioIdentificacion = usuarioIdentificacion;
    }
   
    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getUsuarioIdentificacion() {
        return this.usuarioIdentificacion;
    }
    
    public void setUsuarioIdentificacion(String usuarioIdentificacion) {
        this.usuarioIdentificacion = usuarioIdentificacion;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof IngresoId) ) return false;
		 IngresoId castOther = ( IngresoId ) other; 
         
		 return ( (this.getFechaIngreso()==castOther.getFechaIngreso()) || ( this.getFechaIngreso()!=null && castOther.getFechaIngreso()!=null && this.getFechaIngreso().equals(castOther.getFechaIngreso()) ) )
 && ( (this.getPlaca()==castOther.getPlaca()) || ( this.getPlaca()!=null && castOther.getPlaca()!=null && this.getPlaca().equals(castOther.getPlaca()) ) )
 && ( (this.getUsuarioIdentificacion()==castOther.getUsuarioIdentificacion()) || ( this.getUsuarioIdentificacion()!=null && castOther.getUsuarioIdentificacion()!=null && this.getUsuarioIdentificacion().equals(castOther.getUsuarioIdentificacion()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFechaIngreso() == null ? 0 : this.getFechaIngreso().hashCode() );
         result = 37 * result + ( getPlaca() == null ? 0 : this.getPlaca().hashCode() );
         result = 37 * result + ( getUsuarioIdentificacion() == null ? 0 : this.getUsuarioIdentificacion().hashCode() );
         return result;
   }   


}


