/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.OperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoOperarioUser;
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
public class OperarioUserDaoImplementTest {
    
    public OperarioUserDaoImplementTest() {
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
    public void testInsertarOperarioUser() throws Exception {
        System.out.println("insertarOperarioUser");
        OperarioUser operarioUser = new OperarioUser();
        TipoOperarioUser tipoUser= new TipoOperarioUser(1,"Vigilante");
        operarioUser.setNombreUsuarioOperario("example2");
        operarioUser.setActivo(true);
        operarioUser.setPassword("root");
        operarioUser.setTipoOperarioUser(tipoUser);
        OperarioUserDaoImplement instance = new OperarioUserDaoImplement();
        instance.insertarOperarioUser(operarioUser);
    }

    //Paso la prueba
    @Test
    public void testGetOperario() throws Exception {
        System.out.println("getOperario");
        String nombreUsuarioOperario = "example1";
        TipoOperarioUser tipoUser= new TipoOperarioUser(1,"Vigilante");
        OperarioUserDaoImplement instance = new OperarioUserDaoImplement();
        OperarioUser expResult = new OperarioUser("example1",tipoUser,"root",true);
        OperarioUser result = instance.getOperario(nombreUsuarioOperario);
        assertEquals(expResult.getPassword(), result.getPassword());
    }
    
}
