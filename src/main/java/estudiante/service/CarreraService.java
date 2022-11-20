package estudiante.service;


import estudiante.dto.CarreraConInscriptosDTO;
import estudiante.dto.EstudianteDTO;
import estudiante.dto.ReporteDTO;
import estudiante.model.Carrera;
import estudiante.model.Estudiante;
import estudiante.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("CarreraService")
public class CarreraService implements BaseService<Carrera,Long>{

    @Autowired
    private CarreraRepository carreraRepository;

    public List<CarreraConInscriptosDTO> getCarrerasConInscriptos() throws Exception {
        List<CarreraConInscriptosDTO> result =carreraRepository.listarCarrerasConInscriptosDTO();
        try{
            return  result.stream().map( e ->  new CarreraConInscriptosDTO( e.getCarrera(),e.getInscriptos())).collect(Collectors.toList());

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<ReporteDTO> getReporteFinal()throws Exception{
        try{
            return  carreraRepository.generarReporteFinal();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public List<Carrera> findAll() throws Exception {
       try{
           return carreraRepository.findAll();
       }
       catch (Exception e){
           throw new Exception(e.getMessage());
       }
    }

    @Override
    public Carrera findById(Long id) throws Exception {
        try{
            Carrera carrera = carreraRepository.findById(id).orElse(null);
            return carrera;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Carrera save(Carrera entity) throws Exception {
        try{
            return carreraRepository.save(entity);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Carrera update(Long id, Carrera entity) throws Exception {
        try{
            Optional<Carrera> entityOpcional = carreraRepository.findById(id);
            Carrera carrera = entityOpcional.get();
            carrera = carreraRepository.save(entity);
            return carrera;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try{
            if(carreraRepository.existsById(id)){
                carreraRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
