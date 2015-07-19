/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoOperarioUser;
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
public class TipoOperarioUserDaoImplementTest {
    
    public TipoOperarioUserDaoImplementTest() {
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
        TipoOperarioUser tipoOperarioUser = new TipoOperarioUser(4,"example4");
        TipoOperarioUserDaoImplement instance = new TipoOperarioUserDaoImplement();
        instance.insertTipoUsuario(tipoOperarioUser);
    }

    //Paso la prueba
    @Test
    public void testGetAllTipoOperario() throws Exception {
        System.out.println("getAllTipoOperario");
        TipoOperarioUserDaoImplement instance = new TipoOperarioUserDaoImplement();
        List<TipoOperarioUser> result = instance.getAllTipoOperario();
        for (TipoOperarioUser result1 : result) {
            System.out.println(result1.getDescripcion());
        }
    }

    //Paso la prueba
    @Test
    public void testGetTipoOperario() throws Exception {
        System.out.println("getTipoOperario");
        int idTipoOperarioUser = 0;
        TipoOperarioUserDaoImplement instance = new TipoOperarioUserDaoImplement();
        TipoOperarioUser result = instance.getTipoOperario(idTipoOperarioUser);
        assertEquals("Administrador", result.getDescripcion());
    }
    
}
