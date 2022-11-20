package estudiante.utils;

import estudiante.model.Carrera;
import estudiante.model.Estudiante;
import estudiante.model.EstudianteCarrera;
import estudiante.repository.CarreraRepository;
import estudiante.repository.EstudianteCarreraRepository;
import estudiante.repository.EstudianteRepository;
import org.apache.commons.csv.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

import java.io.FileReader;
import java.io.IOException;


@Configuration
public class CargaDeDatos {
    @Autowired
    private  EstudianteRepository estudianteRepository;
    @Autowired
    private  CarreraRepository carreraRepository;
    @Autowired
    private  EstudianteCarreraRepository estudianteCarreraRepository;

    public void insertarDatosEstudiantes() throws IOException{
        CSVParser datosEstudiantes = CSVFormat.DEFAULT.builder().setHeader().build().parse(new FileReader("src/main/java/estudiante/csv/estudiantes.csv"));
        for (CSVRecord row : datosEstudiantes) {
            Long dni = Long.parseLong(row.get("DNI"));
            String nombre = row.get("nombre");
            String apellido = row.get("apellido");
            int edad = Integer.parseInt(row.get("edad"));
            String genero = row.get("genero");
            String ciudad = row.get("ciudad");
            Long lu = Long.parseLong(row.get("LU"));

            Estudiante insert = new Estudiante(dni, nombre, apellido, edad, ciudad, genero, lu);
            estudianteRepository.save(insert);
        }
    }
    public void insertarDatosEstudianteCarrera() throws IOException{
        CSVParser datosEstudianteCarreras = CSVFormat.DEFAULT.builder().setHeader().build().parse(new FileReader("src/main/java/estudiante/csv/estudianteCarrera.csv"));
        for (CSVRecord row : datosEstudianteCarreras) {
            Long id = Long.parseLong(row.get("id"));
            Long id_estudiante = Long.parseLong(row.get("id_estudiante"));
            Long id_carrera = Long.parseLong(row.get("id_carrera"));
            Long anioinscripcion = Long.parseLong(row.get("inscripcion"));
            Long aniograduacion = Long.parseLong(row.get("graduacion"));
            int antiguedad = Integer.parseInt(row.get("antiguedad"));

            Estudiante e = estudianteRepository.findById(id_estudiante).orElse(null);
            Carrera c = carreraRepository.findById(id_carrera).orElse(null);

            EstudianteCarrera insert = new EstudianteCarrera(e, c, anioinscripcion, aniograduacion, antiguedad);
            estudianteCarreraRepository.save(insert);
        }
    }

    public void insertarDatosCarreras() throws IOException{
        CSVParser datosCarreras = CSVFormat.DEFAULT.builder().setHeader().build().parse(new FileReader("src/main/java/estudiante/csv/carreras.csv"));
        for (CSVRecord row : datosCarreras) {
            Long id = Long.parseLong(row.get("id_carrera"));
            String carrera = row.get("carrera");
            Long duracion = Long.parseLong(row.get("duracion"));

            Carrera insert = new Carrera(carrera, duracion);
            carreraRepository.save(insert);
        }
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            insertarDatosEstudiantes();
            insertarDatosCarreras();
            insertarDatosEstudianteCarrera();
        };
    }
}
