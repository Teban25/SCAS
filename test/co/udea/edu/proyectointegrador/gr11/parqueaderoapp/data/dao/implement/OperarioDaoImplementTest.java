/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Operario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.OperarioUser;
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
public class OperarioDaoImplementTest {
    
    public OperarioDaoImplementTest() {
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
    public void testInsertarOperario() throws Exception {
        System.out.println("insertarOperario");
        OperarioUser operUs=new OperarioUser();
        operUs.setNombreUsuarioOperario("example1");
        Operario operario = new Operario();
        operario.setIdentificacion("41699");
        operario.setNombre("Maria");
        operario.setApellido("Perez");
        operario.setTelefono("4444141");
        operario.setDireccion("Cra 50 a 63");
        operario.setOperarioUser(operUs);
        OperarioDaoImplement instance = new OperarioDaoImplement();
        instance.insertarOperario(operario);
    }

    //paso la prueba
    @Test
    public void testGetOperario() throws Exception {
        System.out.println("getOperario");
        String identificacion = "41699";
        OperarioDaoImplement instance = new OperarioDaoImplement();
        Operario result = instance.getOperario(identificacion);
        assertEquals(identificacion, result.getIdentificacion());
    }

    
    //Prueba fallida, no actualiza los campos
    @Test
    public void testModificarOperario() throws Exception {
        System.out.println("modificarOperario");
        String identificacion = "41699";
        OperarioDaoImplement instance = new OperarioDaoImplement();
        Operario result = instance.getOperario(identificacion);
        String direccion="Cra 30 B 100";
        result.setDireccion(direccion);
        instance.modificarOperario(result);
        result = instance.getOperario(identificacion);
        assertEquals(direccion, result.getDireccion());
    }
    
    //Paso prueba
    @Test
    public void testGetOperarioByNombreUsuario() throws Exception {
        System.out.println("getOperarioByNombreUsuario");
        String nombreUsuario = "example1";
        OperarioDaoImplement instance = new OperarioDaoImplement();
        Operario result = instance.getOperarioByNombreUsuario(nombreUsuario);
        assertEquals(nombreUsuario, result.getOperarioUser().getNombreUsuarioOperario());
    }
    //Paso prueba
    @Test
    public void testEliminarOperario() throws Exception {
        System.out.println("eliminarOperario");
        String cedula = "41699";
        OperarioDaoImplement instance = new OperarioDaoImplement();
        instance.eliminarOperario(cedula);
        Operario result = instance.getOperario(cedula);
        assertEquals(null, result);
    }
}
