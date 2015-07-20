/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoIdentificacion;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoUsuario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Usuario;
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
public class UsuarioDaoImplementTest {
    
    public UsuarioDaoImplementTest() {
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
    public void testInsertarUsuario() throws Exception {
        System.out.println("insertarUsuario");
        TipoUsuario tipoUser=new TipoUsuario();
        tipoUser.setIdTipoUsuario(0);
        TipoIdentificacion tipoI=new TipoIdentificacion();
        tipoI.setIdTipoIdentificacion(0);
        Usuario usuario = new Usuario();
        usuario.setIdentificacion("1032630442");
        usuario.setNombre("Carla");
        usuario.setApellido("Lopez");
        usuario.setTelefono("5292065");
        usuario.setGenero("Femenino");
        usuario.setDireccion("Cra 10 A 30");
        usuario.setTipoIdentificacion(tipoI);
        usuario.setTipoUsuario(tipoUser);
        UsuarioDaoImplement instance = new UsuarioDaoImplement();
        instance.insertarUsuario(usuario);
    }
  
    //Paso la prueba
    /*
    @Test
    public void testGetUsuario() throws Exception {
        System.out.println("getUsuario");
        String id = "1017214614";
        UsuarioDaoImplement instance = new UsuarioDaoImplement();
        String expResult = "Esteban";
        Usuario result = instance.getUsuario(id);
        assertEquals(expResult, result.getNombre());
    }*/
    
}
