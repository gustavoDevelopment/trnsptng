package trnsptng.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trnsptng_rol")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Rol extends Persistente{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private BigDecimal id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "codigo")
	private String codigo;

}
