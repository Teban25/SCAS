/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoUsuario;
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
public class TipoUsuarioDaoImplementTest {
    
    public TipoUsuarioDaoImplementTest() {
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
    public void testInsertTipoUsuario() throws Exception {
        System.out.println("insertTipoUsuario");
        TipoUsuario tipoUsuario = new TipoUsuario(4,"Ejemplo4");
        TipoUsuarioDaoImplement instance = new TipoUsuarioDaoImplement();
        instance.insertTipoUsuario(tipoUsuario);
    }

    //Paso la prueba
    @Test
    public void testGetTipoUsuario() throws Exception {
        System.out.println("getTipoUsuario");
        int idTipoUsuario = 0;
        String descripcion="Estudiante";
        TipoUsuarioDaoImplement instance = new TipoUsuarioDaoImplement();
        TipoUsuario result = instance.getTipoUsuario(idTipoUsuario);
        assertEquals(descripcion, result.getTipoUsuarioDescripcion());
    }
    
}
