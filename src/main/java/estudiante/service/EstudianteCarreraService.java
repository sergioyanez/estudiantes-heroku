package estudiante.service;

import estudiante.model.Carrera;
import estudiante.model.Estudiante;
import estudiante.model.EstudianteCarrera;
import estudiante.repository.CarreraRepository;
import estudiante.repository.EstudianteCarreraRepository;
import estudiante.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service("EstudianteCarreraService")
public class EstudianteCarreraService implements BaseService<EstudianteCarrera,Long>{

    EstudianteRepository estudianteRepository;
    CarreraRepository carreraRepository;
    EstudianteCarreraRepository estudianteCarreraRepository;

    EstudianteCarrera inscribir(Long idEstudiante,Long idCarrera){
        Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElse(null);
        Carrera carrera = carreraRepository.findById(idCarrera).orElse(null);
        if(estudiante != null && carrera != null) {
            EstudianteCarrera nuevo = new EstudianteCarrera(estudiante,carrera,2022L,0L,0);
            estudianteCarreraRepository.save(nuevo);
            return nuevo;
        }
        return null;
    }
    @Override
    public List<EstudianteCarrera> findAll() throws Exception {
        return null;
    }

    @Override
    public EstudianteCarrera findById(Long id) throws Exception {
        return null;
    }

    @Override
    public EstudianteCarrera save(EstudianteCarrera entity) throws Exception {
        return null;
    }

    @Override
    public EstudianteCarrera update(Long id, EstudianteCarrera entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }
}
