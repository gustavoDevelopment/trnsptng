package trnsptng.DAO;

import trnsptng.model.Login;
import trnsptng.model.Persistente;

public interface GenericoDAO {

	Persistente save(Persistente persistente);
	Persistente update(Persistente persistente);
	boolean delete(Persistente persistente);
	boolean deleteById(Class<? extends Persistente> classz, Object id);
	Login getByNickName(String username);

}
