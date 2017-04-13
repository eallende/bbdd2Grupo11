package muber.dao;

import muber.exception.DAOException;

public interface GenericDAO<T> {
	public T save(T entity) throws DAOException;

}
