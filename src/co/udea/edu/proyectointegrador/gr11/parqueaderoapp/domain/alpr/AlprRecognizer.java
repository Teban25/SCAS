package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.alpr;

/**
 *
 * @author Teban-Ing
 */
import com.openalpr.jni.Alpr;
import com.openalpr.jni.AlprResults;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class AlprRecognizer {

    String country, configfile, runtimeDataDir;
    Alpr alpr;
    
    public AlprRecognizer() {
        country = "co";
        configfile ="openalpr.conf";
        runtimeDataDir ="runtime_data/";
        alpr = new Alpr(country, configfile, runtimeDataDir);
        alpr.setTopN(10);
        alpr.setDefaultRegion("base");
    }
    
    public AlprResults recognizePlate(String licensePlate) throws IOException{
        Path path = Paths.get(licensePlate);
        byte[] imagedata = Files.readAllBytes(path);
        // Read an image into a byte array and send it to OpenALPR
        AlprResults results = alpr.recognize(imagedata);
        alpr.unload();
        return results;
    }
}
