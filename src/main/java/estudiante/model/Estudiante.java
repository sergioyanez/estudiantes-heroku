package estudiante.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que moldea a los estudiantes y representa la entidad en la Base de
 * Datos con la anotaciones JPA.
 * 
 * @author Elva Kehler, Nicolas Carsaniga , Hector Liceaga, Sergio Ya�ez
 * @version Versi�n 1.0.
 * 
 */
@Entity
@Data
@EnableJpaRepositories
@Table(name = "estudiantes")
public class Estudiante implements Serializable {
	@Id
	private Long dni;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private int edad;
	@Column
	private String genero;
	@Column
	private String ciudad;
	@Column
	private Long LU;
	@Column
	@OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY)
	private List<EstudianteCarrera> carreras;
	/**
	 * Constructor sin parametrosde la clase Estudiante
	 */
	public Estudiante() {
		
	}
	/**
	 * Constructor de la clase Estudiante
	 * @param dni del Estudiante
	 * @param nombre del Estudiante
	 * @param apellido del Estudiante
	 * @param edad del Estudiante
	 * @param ciudad del Estudiante
	 * @param genero del Estudiante
	 * @param lU del Estudiante
	 */
	public Estudiante(Long dni, String nombre, String apellido, int edad, String ciudad, String genero, Long lU) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;

		this.LU = lU;
		this.carreras = new ArrayList<EstudianteCarrera>();
	}

	public void addCarrera(Carrera carrera) {
		EstudianteCarrera estudianteCarrera = new EstudianteCarrera(this, carrera);
		this.carreras.add(estudianteCarrera);
	}


}
