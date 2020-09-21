package Control;

import Modelo.Alumno;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Stuwar Giron Garcia
 */
public class RegistroAlumno {
    String ruta = "C:\\Users\\Stuwar Giron Garcia\\Documents\\NetBeansProjects\\Ejercicio6\\Files\\alumnos.txt";
    Alumno objalu = new Alumno();
    FileReader fr;  //lector de archivos
    BufferedReader br;    //recepctor de memoria
    FileWriter fw;        //escribir
    File f;
    
    public ArrayList<Alumno> lista = new ArrayList<>();

    //METODO PARA AGREGAR USUARIO EN LA TABLA 
    public void agregar(Alumno a) throws FileNotFoundException, IOException {

        fw = new FileWriter(ruta, true);
        String cad = a.getCodigo() + "-" + a.getNombre() + "-" + a.getApellido() + "-" + a.getEdad();
        fw.write(cad);
        fw.write(13); //hace un salto de linea
        fw.close();
    }

    // LEER
    public void leer() throws FileNotFoundException, IOException {
        lista.clear();     //Limpiar arrayList 0 elementos
        fr = new FileReader(ruta);
        br = new BufferedReader(fr);
        String cad = br.readLine();
        String[] vec;
        while (cad != null) {
            vec = cad.split("-");  //separar la cadena en un vector
            objalu = new Alumno(vec[0], vec[1],(vec[2]), Integer.parseInt(vec[3]));
            lista.add(objalu);   //agregar elementos al arrayList
            cad = br.readLine();
        }
        fr.close();
    }
   
}
