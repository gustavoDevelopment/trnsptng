package trnsptng.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="trnsptng_ciudad")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ciudad extends Persistente{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String nombre;
	private String nombreCorto;
	private String codigo;
	private long idDepartamento;

}
