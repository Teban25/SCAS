/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.util.encrypt;

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
public class EncryptTest {
    
    public EncryptTest() {
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
    public void testGetPasswordEncrypted() throws Exception {
        System.out.println("getPasswordEncrypted");
        Encrypt instance = new Encrypt("TebanUdea25");
        String expResult = "c357d25b2ed81aa2a900ff8e25865bb0a5faa357092fc4a32823a95bdce0a482";
        String result = instance.getPasswordEncrypted();
        assertEquals(expResult, result);
    }
    
}
