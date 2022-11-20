package estudiante.dto;

import lombok.Data;

@Data
public class EstudianteDTO {


	private Long dni;
	private String nombre;	
	private String apellido;	
	private int edad;	
	private String genero;	
	private String ciudad;		
	private Long LU;

	/**
	 * Constructor de la clase sin parametros
	 */
	public EstudianteDTO() {
		super();
		
	}
	/**
	 * Constructor de la clase con parametros
	 * @param dni dni del estudiante
	 * @param nombre nombre del estudiante
	 * @param apellido apellido del estudiante
	 * @param edad edad del estudiante
	 * @param genero genero del estudiante
	 * @param ciudad ciudad del estudiante
	 * @param lU LU del estudiante
	 */

	public EstudianteDTO(Long dni, String nombre, String apellido, int edad, String genero, String ciudad, Long lU) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
		LU = lU;
	}

	/**
	 * Retorna el dni del estudiante
	 * @return dni dni del estudiante
	 */
	public Long getDni() {
		return dni;
	}

	/**
	 * Retorna el nombre del estudiante
	 * @return nombre nombre del estudiante
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Retorna el apellido del estudiante
	 * @return apellido apellido del estudiante
	 */

	public String getApellido() {
		return apellido;
	}
	/**
	 * Retorna la edad del estudiante
	 * @return edad edad del estudiante
	 */

	public int getEdad() {
		return edad;
	}

	/**
	 * Retorna el genero del estudiante
	 * @return genero genero del estudiante
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Retorna la ciudad del estudiante
	 * @return ciudad ciudad del estudiante
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * Retorna el LU del estudiante
	 * @return LU LU del estudiante
	 */

	public Long getLU() {
		return LU;
	}


	@Override
	public String toString() {
		return "EstudianteDTO => dni: " + dni + ", nombre: " + nombre + ", apellido: " + apellido + ", edad: " + edad
				+ ", genero: " + genero + ", ciudad: " + ciudad + ", LU: " + LU ;
	}
	
	
	
	


}
