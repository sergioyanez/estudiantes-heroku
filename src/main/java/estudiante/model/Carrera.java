package estudiante.model;



import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



/**
 * Clase que moldea a las carreras y representa la entidad en la Base de Datos con la anotaciones JPA.
 * 
 * @author Elva Kehler, Nicolas Carsaniga , Hector Liceaga, Sergio Ya�ez
 * @version Versi�n 1.0.
 *
 */
@Entity
@Data
@Table(name = "carreras")
public class Carrera implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_carrera;
	@Column
	private String nombre;
	@Column
	private Long duracionAnios;

	@OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
	private List<EstudianteCarrera> estudiantes;
	/**
	 * Constructor de la clase
	 */
	public Carrera() {
		super();
	}
	/**
	 * Constructor de la clase con parametros
	 * @param nombre nombre de la carrera
	 * @param duracionAnos duracion en a�os de la carrera
	 */
	public Carrera(String nombre, Long duracionAnos) {
		super();
		this.nombre = nombre;
		this.duracionAnios = duracionAnos;
	}

}
