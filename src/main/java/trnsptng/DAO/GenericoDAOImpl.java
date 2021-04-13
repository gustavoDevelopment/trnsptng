package trnsptng.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import trnsptng.model.Login;
import trnsptng.model.Persistente;

@Repository
@Transactional
public class GenericoDAOImpl implements GenericoDAO{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persistente save(Persistente persistente) {
		entityManager.persist(persistente);
		return persistente;
	}

	@Override
	public Persistente update(Persistente persistente) {
		entityManager.merge(persistente);
		return persistente;
	}

	@Override
	public boolean delete(Persistente persistente) {
		try {
			entityManager.remove(persistente);
			return true;
		}catch (Exception e) {
			return false;
		}		
	}
	
	@Override
	public boolean deleteById(Class< ? extends Persistente> classz,Object id) {
		try{
			Query query= entityManager.createQuery("delete from "+classz.getName()+" a where a.id :id");
			query.setParameter("id", id);
			query.executeUpdate();
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public Login getByNickName(String nickName) {
		try {
			StringBuilder q= new StringBuilder();
			q.append("SELECT l ");
			q.append("FROM "+Login.REF).append(" l ");
			q.append("WHERE l."+Login.PROP_NICKNAME).append(" = '").append(nickName).append("'");
		
			Query query = entityManager.createQuery(q.toString());
			return (Login) query.getSingleResult();
		}catch (Exception e) {
				return null;
		}
	}



}
