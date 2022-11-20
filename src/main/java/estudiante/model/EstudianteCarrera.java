package estudiante.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase que relaciona un estudiante con sus carreras y representa la entidad en
 * la Base de Datos con la anotaciones JPA.
 * 
 * @author Elva Kehler, Nicolas Carsaniga , Hector Liceaga, Sergio Ya�ez
 * @version Versi�n 1.0.
 * 
 */

@Entity
@Table(name = "estudiantes_carreras")
public class EstudianteCarrera implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ec;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_estudiante")
	private Estudiante estudiante;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_carrera")
	private Carrera carrera;

	@Column
	private Long anioInscripcion;
	@Column
	private Long anioGraduacion;
	@Column
	private int antiguedad;
	/**
	 * Constructor de la clase con los parametros Estudiante y Carrera
	 * @param e estudiante
	 * @param c carrera
	 */
	public EstudianteCarrera(Estudiante e, Carrera c) {
		super();
		this.estudiante = e;
		this.carrera = c;

	}
	/**
	 * Constructor de la clase EstudianteCarrera
	 * @param e estudiante
	 * @param c carrera
	 * @param anioInscripcion a�o de inscripcion
	 * @param anioGraduacion a�o de graduacion
	 * @param antiguedad antiguedad
	 */
	public EstudianteCarrera(Estudiante e, Carrera c, Long anioInscripcion, Long anioGraduacion, int antiguedad) {
		super();
		this.estudiante = e;
		this.carrera = c;
		this.anioInscripcion = anioInscripcion;
		this.anioGraduacion = anioGraduacion;
		this.antiguedad = antiguedad;
	}
	/**
	 * Constructor de la clase sin parametros
	 */
	public EstudianteCarrera() {
		
	}
	
	
	
	
	public Long getId_ec() {
		return id_ec;
	}
	/**
	 * Retorna un estudiante
	 * @return estudiante estudiante de la carrera
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}
	/**
	 * Retorna una carrera
	 * @return carrera carrera del estudiante
	 */
	public Carrera getCarrera() {
		return carrera;
	}
	/**
	 * Retorna el a�o de inscripcion
	 * @return anioInscripcion a�o de inscripcion
	 */
	public Long getAnioInscripcion() {
		return anioInscripcion;
	}
	/**
	 * Actualiza el a�o de inscripcion
	 * @param anioInscripcion a�o de inscripcion
	 */
	public void setAnioInscripcion(Long anioInscripcion) {
		this.anioInscripcion = anioInscripcion;
	}
	/**
	 * Retorna el a�o de graduacion
	 * @return anioGraduacion  a�o de graduacion
	 */
	public Long getAnioGraduacion() {
		return anioGraduacion;
	}
	/**
	 * Actualiza el a�o de graduacion
	 * @param anioGraduacion a�o de graduacion
	 */
	public void setAnioGraduacion(Long anioGraduacion) {
		this.anioGraduacion = anioGraduacion;
	}
	/**
	 * Retorna la antiguedad del estudiante en la carrera
	 * @return antiguedad antiguedad del estudiante en la carrera
	 */
	public int getAntiguedad() {
		return antiguedad;
	}
	/**
	 * Actualiza la antiguedad del estudiante en la carrera
	 * @param antiguedad antiguedad del estudiante en la carrera
	 */
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}



}
