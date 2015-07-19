/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoIdentificacion;
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
public class TipoIdentificacionDaoImplementTest {
    
    public TipoIdentificacionDaoImplementTest() {
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
    public void testGetTipoUsuario() throws Exception {
        System.out.println("getTipoUsuario");
        int idTipoIdentificacion = 0;
        TipoIdentificacionDaoImplement instance = new TipoIdentificacionDaoImplement();
        TipoIdentificacion result = instance.getTipoUsuario(idTipoIdentificacion);
        assertEquals("Cedula de ciudadania", result.getTipoIdentificacionDescripcion());
    }
    //Paso la prueba
    @Test
    public void testInsertTipoIdentificacion() throws Exception {
        System.out.println("insertTipoIdentificacion");
        TipoIdentificacion tipoIdentificacion = new TipoIdentificacion(3,"Cedula de extranjeria");
        TipoIdentificacionDaoImplement instance = new TipoIdentificacionDaoImplement();
        instance.insertTipoIdentificacion(tipoIdentificacion);
    }
    
}
