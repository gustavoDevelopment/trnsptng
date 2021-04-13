package trnsptng.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="trnsptng_aseguradoras")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aseguradora  extends Persistente{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nombre;
	private String telefono;
	private String celular;
	private String paginaWeb;
	private String direccion;
	private String email;
	
}
