package estudiante.dto;

/**
 * Clase usada para el intercambios de datos.
 * 
 * @author Elva Kehler, Nicolas Carsaniga , Hector Liceaga, Sergio Ya�ez.
 * @version 1.0
 * 
 */
public class ReporteDTO {




	private String nombre;
	private Long anio;
	private Long inscriptos;
	private Long graduados;

	/**
	 * Constructor con parametros
	 * @param carrera nombre de la carrera
	 * @param anio a�o cronologico
	 * @param inscriptos cantidad de inscriptos
	 * @param egresados cantidad de graduados
	 */
	public ReporteDTO(String carrera, Long anio, Long inscriptos, Long egresados) {
		this.nombre = carrera;
		this.anio = anio;
		this.inscriptos = inscriptos;
		this.graduados = egresados;
	}
	
	public ReporteDTO() {}


	/**
	 * Retorna el nombre de la carrera
	 * @return carrera nombre de la carrera
	 */

	public String getCarrera() {
		return nombre;
	}
	
	/**
	 * Retorna el a�o cronol�gico  de la carrera
	 * @return anio a�o cronol�gico  de la carrera
	 */

	public Long getAnio() {
		return anio;
	}
	/**
	 * Retorna la cantidad de inscriptos de la carrera
	 * @return inscriptos cantidad de inscriptos de la carrera
	 */

	public Long getInscriptos() {
		return inscriptos;
	}
	/**
	 * Retorna la cantidad de graduados de la carrera
	 * @return graduados cantidad de graduados de la carrera
	 */

	public Long getEgresados() {
		return graduados;
	}





	

}
