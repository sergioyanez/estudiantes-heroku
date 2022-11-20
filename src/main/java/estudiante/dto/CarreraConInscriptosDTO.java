package estudiante.dto;

import lombok.Data;

@Data
public class CarreraConInscriptosDTO {

	private String carrera;
	private Long inscriptos;

	public CarreraConInscriptosDTO(String carrera, Long inscriptos) {
		this.carrera = carrera;
		this.inscriptos = inscriptos;
	}

	public CarreraConInscriptosDTO() {
	}

	
}
