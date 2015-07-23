/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.dao.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Ingreso;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.IngresoId;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.OperarioUser;
import java.util.Date;
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
public class IngresoDaoImplementTest {

    public IngresoDaoImplementTest() {
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
    public void testInsertarIngreso() throws Exception {
        System.out.println("insertarIngreso");
        OperarioUser operario = new OperarioUser();
        operario.setNombreUsuarioOperario("vigilante.test");
        Ingreso ingreso = new Ingreso();
        IngresoId ingresoId = new IngresoId();
        ingresoId.setFechaIngreso(new Date());
        ingresoId.setPlaca("LAU47A");
        ingresoId.setUsuarioIdentificacion("1017214614");
        ingreso.setId(ingresoId);
        ingreso.setEstado("Dentro");
        ingreso.setOperarioUser(operario);
        IngresoDaoImplement instance = new IngresoDaoImplement();
        instance.insertarIngreso(ingreso);

    }

    //Paso la prueba
    @Test
    public void testGetAllIngresos() throws Exception {
        System.out.println("getAllIngresos");
        IngresoDaoImplement instance = new IngresoDaoImplement();
        List<Ingreso> result = instance.getAllIngresos();
        for (Ingreso result1 : result) {
            System.out.println(result1.getId().getFechaIngreso());
            System.out.println(result1.getId().getPlaca());
            System.out.println(result1.getId().getUsuarioIdentificacion());
        }
    }


    //Prueba pasada
    @Test
    public void testActualizarIngreso() throws Exception {
        System.out.println("actualizarIngreso");
        OperarioUser operario = new OperarioUser();
        operario.setNombreUsuarioOperario("vigilante.test");
        Ingreso ingreso = null;
        IngresoDaoImplement instance = new IngresoDaoImplement();
        ingreso=instance.getLastIngreso("1017214614","LAU47A");
        if(ingreso.getFechaSalida()==null){
            ingreso.setFechaSalida(new Date());
            ingreso.setEstado("Fuera");
            instance.actualizarIngreso(ingreso);
        }else{
            IngresoId ingresoId=new IngresoId(new Date(),"LAU47A", "1017214614");
            ingreso=new Ingreso(ingresoId,operario, null, null,"Dentro");
            instance.insertarIngreso(ingreso);
        }
    }
    
    //Paso la prueba
    @Test
    public void testGetIngresosByDate() throws Exception {
        System.out.println("getIngresosByDate");
        IngresoDaoImplement instance = new IngresoDaoImplement();
        List<Ingreso> result = instance.getIngresosByDate("2015-07-16 10:11:32.0", "2015-07-18 20:20:37.0");
        for (Ingreso result1 : result) {
            System.out.println(result1.getId().getFechaIngreso());
        }
    }
    //Paso la prueba
    @Test
    public void testGetLastIngreso() throws Exception {
        System.out.println("getIngresoWithOutExit");
        String identificacion="1017214614";
        String placa="LAU47A";
        IngresoDaoImplement instance = new IngresoDaoImplement();
        Ingreso result=instance.getLastIngreso(identificacion, placa);
        assertEquals("2015-07-18 15:42:39.0",result.getId().getFechaIngreso().toString());
    }
}
