package trnsptng.resquest;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trnsptng.model.Rol;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Setter
@Getter
public class RequestTrnsptngLogin {	
	private String nickName;
	private String password;
	private Set<Rol> roles;
}
