/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.UsuarioVehiculo;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.UsuarioVehiculoId;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teban-Ing
 */
public class UsuarioVehiculoDaoImplementTest {
    
    public UsuarioVehiculoDaoImplementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    //Paso la prueba
    @Test
    public void testInsertarUsuarioVehiculo() throws Exception {
        System.out.println("insertarUsuarioVehiculo");
        UsuarioVehiculoId usuarioVehiId=new UsuarioVehiculoId("OIT95B","71699275");
        UsuarioVehiculo usuarioVehiculo = new UsuarioVehiculo();
        usuarioVehiculo.setId(usuarioVehiId);
        usuarioVehiculo.setActivo(true);
        UsuarioVehiculoDaoImplement instance = new UsuarioVehiculoDaoImplement();
        instance.insertarUsuarioVehiculo(usuarioVehiculo);
    }
    //Paso la prueba
    @Test
    public void testGetUsuarioVehiculo() throws Exception {
        System.out.println("getUsuarioVehiculo");
        String identificacion = "71699275";
        UsuarioVehiculoDaoImplement instance = new UsuarioVehiculoDaoImplement();
        List<UsuarioVehiculo> result = instance.getUsuarioVehiculo(identificacion);
        for(UsuarioVehiculo vehiculosUser:result){
            System.out.println(vehiculosUser.getId().getPlaca());
        }
    }
    
}
