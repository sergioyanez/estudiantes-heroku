package estudiante.repository;


import estudiante.dto.EstudianteDTO;
import estudiante.dto.ReporteDTO;
import estudiante.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@EnableJpaRepositories
@Repository("EstudianteRepository")
public interface EstudianteRepository  extends JpaRepository<Estudiante, Long>  {

    @Query("SELECT DISTINCT e FROM Estudiante e ORDER BY e.apellido")
    List<Estudiante> EstudiantesOrdenadosApellidos();

    @Query("SELECT DISTINCT e FROM Estudiante e WHERE e.LU =:nro_libreta")
    Estudiante getEstudianteByNumeroLibreta(@Param("nro_libreta") Long nro_libreta);

    @Query("SELECT DISTINCT e FROM Estudiante e WHERE e.genero =:genero")
    List<Estudiante> getEstudiantesByGenero(@Param("genero") String genero);

    @Query("SELECT DISTINCT ec.estudiante FROM EstudianteCarrera ec  WHERE ec.estudiante.ciudad=:ciudad_residencia AND  ec.carrera.nombre =:carrera")
    List<Estudiante> getEstudiantesByCarreraOrderByCiudad(@Param("carrera") String carrera, @Param("ciudad_residencia") String ciudad_residencia);


}