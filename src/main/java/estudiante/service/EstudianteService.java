package estudiante.service;


import estudiante.dto.EstudianteDTO;
import estudiante.model.Estudiante;
import estudiante.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("EstudianteService")
public class EstudianteService implements BaseService<Estudiante,Long>{

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<EstudianteDTO> listarEstudiantesOrdenadosPorGenero(String genero) throws Exception {
        List<Estudiante> result = estudianteRepository.getEstudiantesByGenero(genero);
        try{
            return  result.stream().map( e ->  new EstudianteDTO( e.getDni(),e.getNombre(),e.getApellido(),e.getEdad(),  e.getGenero(), e.getCiudad(), e.getLU())).collect(Collectors.toList());

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<EstudianteDTO> listarEstudiantesOrdenadosPorApellido() throws Exception {
        List<Estudiante> result = estudianteRepository.EstudiantesOrdenadosApellidos();
        try{
            return  result.stream().map( e ->  new EstudianteDTO( e.getDni(),e.getNombre(),e.getApellido(),e.getEdad(),  e.getGenero(), e.getCiudad(), e.getLU())).collect(Collectors.toList());

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public EstudianteDTO listarEstudiantePorLibreta(Long lu) throws Exception {
        Estudiante estudiante = estudianteRepository.getEstudianteByNumeroLibreta(lu);
        try{
            return  new EstudianteDTO( estudiante.getDni(),estudiante.getNombre(),estudiante.getApellido(),estudiante.getEdad(),  estudiante.getGenero(), estudiante.getCiudad(), estudiante.getLU());

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<EstudianteDTO> listarEstudiantesPorCarreraPorCiudad(String carrera, String ciudad) throws Exception {
        List<Estudiante> result =estudianteRepository.getEstudiantesByCarreraOrderByCiudad(carrera,ciudad);
        try{
            return  result.stream().map( e ->  new EstudianteDTO( e.getDni(),e.getNombre(),e.getApellido(),e.getEdad(),  e.getGenero(), e.getCiudad(), e.getLU())).collect(Collectors.toList());

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public List<Estudiante> findAll() throws Exception {
        try{
            return  estudianteRepository.findAll();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Estudiante findById(Long id) throws Exception {
        return null;
    }


    public EstudianteDTO estudiantePorId(Long id) throws Exception {
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        try{
            return  new EstudianteDTO( estudiante.getDni(),estudiante.getNombre(),estudiante.getApellido(),estudiante.getEdad(),  estudiante.getGenero(), estudiante.getCiudad(), estudiante.getLU());

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Estudiante save(Estudiante entity) throws Exception {
        try{
            return estudianteRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Estudiante update(Long id, Estudiante entity) throws Exception {
        try{
            Optional<Estudiante> entityOpcional = estudianteRepository.findById(id);
            Estudiante estudiante = entityOpcional.get();
            estudiante = estudianteRepository.save(entity);
            return estudiante;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try{
            if(estudianteRepository.existsById(id)){
                estudianteRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
