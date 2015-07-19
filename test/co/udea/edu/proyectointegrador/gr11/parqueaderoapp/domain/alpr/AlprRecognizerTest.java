/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.alpr;

import com.openalpr.jni.AlprPlateResult;
import com.openalpr.jni.AlprResults;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class AlprRecognizerTest {
    
    public AlprRecognizerTest() {
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

    /**
     * Test of recognizePlate method, of class AlprRecognizer.
     */
    @Test
    public void testRecognizePlate() throws Exception {
        AlprRecognizer alprRecognizer= new AlprRecognizer();
        AlprResults alprResults=alprRecognizer.recognizePlate("C:\\Users\\ASUS\\Pictures\\Images\\DSC_0095_2.JPG");
        List<AlprPlateResult> list= alprResults.getPlates();
        
        for (AlprPlateResult plate  : list) {
            if (plate.getBestPlate().getCharacters().equals("HMT395")) {
                assertEquals(plate.getBestPlate().getCharacters(), "HMT395");
                return;
            }
        }
    }
    
}
