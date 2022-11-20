package estudiante.controller;


import estudiante.model.Estudiante;
import estudiante.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;


//    @GetMapping("/id/{id}")
//    public ResponseEntity<?>getOne(@PathVariable Long id){
//        try{
//            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.estudiantePorId(id));
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el elemento.\"}");
//        }
//    }

    @GetMapping("/por/genero/{genero}")
     public ResponseEntity<?>getEstudiantesOrdenadosPorGenero(@PathVariable String genero){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.listarEstudiantesOrdenadosPorGenero(genero));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el elemento.\"}");
        }
    }
    @GetMapping("/ordenadosPor/apellido")
    public ResponseEntity<?>getEstudiantesOrdenadosPorApellido(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.listarEstudiantesOrdenadosPorApellido());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el elemento.\"}");
        }
    }

    @GetMapping("/carrera/ciudad/{carrera}/{ciudad}")
    public ResponseEntity<?>getEstudiantesPorCarreraPorCiudad(@PathVariable String carrera,@PathVariable String ciudad){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.listarEstudiantesPorCarreraPorCiudad(carrera,ciudad));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el elemento.\"}");
        }
    }

    @GetMapping("/lu/{lu}")
    public ResponseEntity<?>getEstudiantePorLibreta(@PathVariable Long lu){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.listarEstudiantePorLibreta(lu));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el elemento.\"}");
        }
    }

    @PostMapping("/alta")
    public ResponseEntity<?> save(@RequestBody Estudiante entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Estudiante entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(estudianteService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Revise los campos e intente nuevamente.\"}");
        }
    }
}
