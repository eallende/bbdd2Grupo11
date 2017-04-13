package muber.dao.imlp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import muber.dao.GenericDAO;
import muber.exception.DAOException;
import muber.hibernate.util.HibernateUtil;

public class GenericDAOImpl<T> implements GenericDAO<T> {
	
	protected Class<T> persistentClass;

	public GenericDAOImpl(Class<T> persistentClass){
		this.persistentClass = persistentClass;
	}

	public T save(T entity) throws DAOException {
		Session session = null;
		 try {
	         session = HibernateUtil.getSessionFactory().openSession();
	         Transaction tx = session.beginTransaction();
	         session.save(entity);
	         tx.commit();
	      }
	      catch (HibernateException e) {
	         throw new DAOException(e.toString());
	      }
	      finally {
	         if (session != null) {
	            try {
	               session.close();
	            }
	            catch (HibernateException e) {
	            	e.getMessage();
	            }
	         }
	      }

	      return entity;
	   }
	
	
	public T update(T entity) throws DAOException {
		Session session = null;
		 try {
	         session = HibernateUtil.getSessionFactory().openSession();
	         Transaction tx = session.beginTransaction();
	         session.update(entity);
	         tx.commit();
	      }
	      catch (HibernateException e) {
	         throw new DAOException(e.toString());
	      }
	      finally {
	         if (session != null) {
	            try {
	               session.close();
	            }
	            catch (HibernateException e) {
	            }
	         }
	      }

	      return entity;
	   }

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	
}


