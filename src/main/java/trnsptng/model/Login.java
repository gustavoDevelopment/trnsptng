package trnsptng.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author shark
 *
 */
@Entity
@Table(name = "trnsptng_login")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Login extends Persistente{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF =" Login";
	public static final String PROP_NICKNAME = "nickName";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private BigDecimal id;
	
	@Column(name = "nickname")
	private String nickName;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "trnsptng_roles_login", joinColumns = @JoinColumn(name = "trnsptng_login_id"),inverseJoinColumns = @JoinColumn(name = "trnsptng_roles_id"))
	private Set<Rol> roles;

}
