package estudiante.repository;


import estudiante.dto.CarreraConInscriptosDTO;
import estudiante.dto.ReporteDTO;
import estudiante.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("CarreraRepository")
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    @Query(value = "SELECT new estudiante.dto.CarreraConInscriptosDTO( c.nombre ,count(ec.estudiante.dni)) "
            + "FROM Carrera c JOIN c.estudiantes ec GROUP BY c.id_carrera "
            + "ORDER BY COUNT(ec.estudiante.dni) DESC")
    List<CarreraConInscriptosDTO> listarCarrerasConInscriptosDTO();

//    @Query(value="SELECT new estudiante.dto.ReporteDTO( nombre, anio_inscripcion as anio, count(anio_inscripcion) as inscriptos,(SELECT count(anio_graduacion) " +
//            "FROM estudiantes_carreras ec2 " +
//            "where ec.fk_carrera=ec2.fk_carrera and ec2.anio_inscripcion = ec.anio_inscripcion and ec2.anio_graduacion !=0) as graduados " +
//            "FROM carreras c INNER JOIN  estudianteS_carreras ec ON c.id_carrera= ec.fk_carrera group by c.id_carrera,anio_inscripcion " +
//            "having anio_inscripcion !=0 )" +
//            "order by nombre,anio asc ",nativeQuery = true)

    @Query(value="SELECT new estudiante.dto.ReporteDTO( c.nombre, ec.anioInscripcion, count(ec.anioInscripcion),count(ec.anioGraduacion)) " +
            "FROM Carrera c JOIN  c.estudiantes ec group by c.id_carrera,ec.anioInscripcion " +
            "order by c.nombre,ec.anioInscripcion asc ")
    List<ReporteDTO> generarReporteFinal();
}

