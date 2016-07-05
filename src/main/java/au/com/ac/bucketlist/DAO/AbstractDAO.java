package au.com.ac.bucketlist.DAO;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public abstract class AbstractDAO<T> {

	@PersistenceContext(name = "bucketlist", type = PersistenceContextType.EXTENDED)
	@ApplicationScoped
	private EntityManager manager;



	public T persist(T t) {
		manager.persist(t);
		return t;
	}

	public T update(T t){
		manager.merge(t);
		return t;
	}

	public void delete(T t){
		manager.remove(t);
	}

	protected EntityManager getEm() {
		return manager;
	}
	

	/*protected void merge(T entity) {
    em.merge(entity);
  }

  protected void remove(T entity) {
	    em.remove(entity);
	  }*/

	/*  public List<T> findAll() {
    return em.createQuery(("FROM " + getTypeClass().getName())).getResultList();
  }

  private Class<?> getTypeClass() {
    return (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
  }*/

	/*
	 * 
	 */




}
