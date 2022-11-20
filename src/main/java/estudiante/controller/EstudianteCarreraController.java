package estudiante.controller;

import estudiante.dto.EstudianteDTO;
import estudiante.model.Carrera;
import estudiante.model.Estudiante;
import estudiante.model.EstudianteCarrera;
import estudiante.service.CarreraService;
import estudiante.service.EstudianteCarreraService;
import estudiante.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiante/carrera")
public class EstudianteCarreraController {

    @Autowired
    EstudianteCarreraService estudianteCarreraService;
    @Autowired
    EstudianteService estudianteService;
    @Autowired
    CarreraService carreraService;

    @PostMapping("/{id_estudiante}/{id_carrera}")
    public ResponseEntity<?> save(@PathVariable Long id_estudiante,@PathVariable Long id_carrera) throws Exception {
        Estudiante estudiante = estudianteService.findById(id_estudiante);
        Carrera carrera = carreraService.findById(id_carrera);
        EstudianteCarrera nuevo= new EstudianteCarrera(estudiante,carrera);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteCarreraService.save(nuevo));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }
}
