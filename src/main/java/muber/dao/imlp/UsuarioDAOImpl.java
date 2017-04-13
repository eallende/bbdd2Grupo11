package muber.dao.imlp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import muber.dao.UsuarioDAO;
import muber.entities.Usuario;
import muber.exception.DAOException;
import muber.hibernate.util.HibernateUtil;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {
	
	public UsuarioDAOImpl(){
		super(Usuario.class);
	}

	public Usuario getUsuario(Long id) throws DAOException {
		Session session = null;
		Usuario result = null;
		 try {
	         session = HibernateUtil.getSessionFactory().openSession();
	         Transaction tx = session.beginTransaction();
	         String hql = "FROM Usuario WHERE id_usuario = :id";
	         Query query = session.createQuery(hql);
	         query.setParameter("id", id);
	         result = (Usuario)(query.list().get(0));
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
		 return result;
	}
	
	

	
	
}
