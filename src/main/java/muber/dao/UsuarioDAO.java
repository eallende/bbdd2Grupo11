package muber.dao;

import muber.entities.Usuario;
import muber.exception.DAOException;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	public Usuario getUsuario(Long id) throws DAOException;

}
