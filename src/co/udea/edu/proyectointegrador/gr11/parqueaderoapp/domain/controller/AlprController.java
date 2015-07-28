
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement.UsuarioDaoImplement;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement.UsuarioVehiculoDaoImplement;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.UsuarioDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.UsuarioVehiculoDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.alpr.AlprRecognizer;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Usuario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.UsuarioVehiculo;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import com.openalpr.jni.AlprPlate;
import com.openalpr.jni.AlprPlateResult;
import com.openalpr.jni.AlprResults;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author davide.gomez
 */
public class AlprController {
    private final String rutaPlaca;
    AlprRecognizer alprRecognizer;
    AlprResults alprResults;
    UsuarioDao usuarioD;
    Usuario usuario;
    UsuarioVehiculoDao usuarioVehiculoDao;
    
    
    public AlprController(String rutaPlaca) {
        this.rutaPlaca=rutaPlaca;
        alprRecognizer=new AlprRecognizer();
    }
    
    public String recognizePlateFromUser(String idUsuario) throws BussinessException, PersistentException{
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
        
        try {
            alprResults=alprRecognizer.recognizePlate(rutaPlaca);
        } catch (IOException ex) {
            throw new BussinessException("Hubo un problema interno, por favor, verifique nuevamente o "
                    + "contacte al administrador.");
        }
        
        if(alprResults==null){
            throw new BussinessException("Hubo un problema interno, por favor, verifique nuevamente o "
                    + "contacte al administrador.");
        }
        
        if (alprResults.getPlates().isEmpty()) {
            throw new BussinessException("No se puede reconocer la placa, intente nuevamente");
        }
        List<AlprPlateResult> resultadosPlacas=alprResults.getPlates();
        for(UsuarioVehiculo usuarioVehiculo: vehiculosUsuario){
          for(AlprPlateResult plateResult: resultadosPlacas){
              if(usuarioVehiculo.getId().getPlaca().equals(plateResult.getBestPlate().getCharacters())){
                 return plateResult.getBestPlate().getCharacters();
              }
              List<AlprPlate> placas=plateResult.getTopNPlates();
              for (AlprPlate p : placas) {
                  if (p.getCharacters().equals(usuarioVehiculo.getId().getPlaca())) {
                     return p.getCharacters();
                  }
              }
          }
        }
        throw new BussinessException("El vehiculo que intenta ingresar no esta registrado,"
                + " por favor, registre el vehiculo del usuario o si esta seguro de "
                + "tenerlo registrado, posicione su vehiculo correctamente");
    }
    
}
