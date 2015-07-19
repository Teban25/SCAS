
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller;
/*
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement.UsuarioDaoImplement;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement.UsuarioVehiculoDaoImplement;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.UsuarioDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.UsuarioVehiculoDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.alpr.AlprRecognizer;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Usuario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.UsuarioVehiculo;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.alpr.AlprResult;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.alpr.Plate;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.alpr.Result;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import java.util.List;
*/
/**
 *
 * @author davide.gomez
 */
public class AlprController {
    /*private String placa;
    private final String rutaPlaca;
    AlprRecognizer alprRecognizer;
    AlprResult alprResult;
    UsuarioDao usuarioD;
    Usuario usuario;
    UsuarioVehiculoDao usuarioVehiculoDao;
    
    
    public AlprController(String rutaPlaca) {
        placa=new String();
        this.rutaPlaca=rutaPlaca;
        alprRecognizer=new AlprRecognizer();
    }
    
    public String recognizePlateFromUser(String idUsuario) throws BussinessException{
        usuarioD=new UsuarioDaoImplement();
        usuario=usuarioD.getUsuario(idUsuario);
        if(usuario==null){
            throw new BussinessException("El usuario no esta activo en el sistema");
        }
        usuarioVehiculoDao=new UsuarioVehiculoDaoImplement();
        List<UsuarioVehiculo> vehiculosUsuario=usuarioVehiculoDao.getUsuarioVehiculo(idUsuario);
        
        if (vehiculosUsuario.isEmpty()) {
            throw new BussinessException("El usuario no tiene vehiculos registrados en el sistema");
        }
        
        alprResult=alprRecognizer.recognize(rutaPlaca);
        
        if(alprResult==null){
            throw new BussinessException("Hubo un problema interno, por favor, verifique nuevamente o "
                    + "contacte al administrador.");
        }
        
        if (alprResult.getResults().isEmpty()) {
            throw new BussinessException("No se puede reconocer la placa, intente nuevamente");
        }
        List<Result> resultadosPlacas=alprResult.getResults();
        for(UsuarioVehiculo d: vehiculosUsuario){
          for(Result r: resultadosPlacas){
              if(d.getId().getPlaca().equals(r.getPlate())){
                 return placa=r.getPlate();
              }
              List<Plate> placas=r.getCandidates();
              for (Plate p : placas) {
                  if (p.getPlate().equals(d.getId().getPlaca())) {
                     return placa=p.getPlate();
                  }
              }
          }
        }
        throw new BussinessException("El vehiculo que intenta ingresar no esta registrado,"
                + " por favor, registre el vehiculo del usuario o si esta seguro de "
                + "tenerlo registrado, posicione su vehiculo correctamente");
    }
    */
}
