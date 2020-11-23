package backend.core.frame.jpa;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;

import backend.core.frame.non.LoggerClass;
import backend.core.frame.util.ReflectUtil;

public abstract class Dao<T extends Bean> extends LoggerClass{

	// ************************************************************************
	// *
	// * JPA
	// *
	// ************************************************************************

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("pg");
	//private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.properties().getProperty("database"));

	private	EntityManager em;
	protected EntityManager em() {

		return factory.createEntityManager();
	}

	protected Session session() {
		em = em();
		return (Session) em.getDelegate();
	}
	
	protected void releaseEm(){
		try {
			em.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ************************************************************************
	// *
	// * CRUD
	// *
	// ************************************************************************

	public Serializable create(T t) {

		Session s = session();
		s.beginTransaction();
		Serializable save = s.save(t);
		s.flush();
		s.getTransaction().commit();
		s.close();
		releaseEm();
		return save;
	}

	public T update(T t) {

		Session s = session();
		s.beginTransaction();
		
		@SuppressWarnings("unchecked")
		T p = (T) s.merge(t);
		s.flush();
		s.getTransaction().commit();
		s.close();
		releaseEm();
		return p;
	}

	public void delete(T t) {

		Session s = session();
		s.beginTransaction();
		s.buildLockRequest(LockOptions.NONE).lock(t);
		s.delete(t);
		s.getTransaction().commit();
		s.close();
		releaseEm();
	}

	// *********************************************************
	// *
	// * List / Search
	// *
	// *********************************************************
	@SuppressWarnings("unchecked")
	public List<T> list() {

		Session s = session();
		Criteria crit = s.createCriteria(getBeanClass());
		
		distinct(crit);
		
		List<T> list = crit.list();
		s.close();
		releaseEm();
		return list;
	}

	public abstract List<T> search(String term);

	// *********************************************************
	// *
	// * Reflect
	// *
	// *********************************************************
	public T virgin() {

		T bean = null;

		try {
			bean = getBeanClass().getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		return bean;
	}

	protected Class<T> getBeanClass() {

		return ReflectUtil.myParamClass(0, this);
	}

	// *********************************************************
	// *
	// * Utilitary
	// *
	// *********************************************************
	
	protected <B extends Bean> void reattach(B bean, Session s){
		s.buildLockRequest(LockOptions.NONE).lock(bean);
	}
	
	protected void distinct(Criteria c){
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	}
	
	protected Criteria distinctBeanCriteria(Session s) {
		Criteria c = s.createCriteria(getBeanClass());
		distinct(c);
		return c;
	}
}