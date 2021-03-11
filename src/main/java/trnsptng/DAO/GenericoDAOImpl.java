package trnsptng.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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



}
