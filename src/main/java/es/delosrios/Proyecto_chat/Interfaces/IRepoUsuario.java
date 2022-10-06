package es.delosrios.Proyecto_chat.Interfaces;

import java.util.List;

import es.delosrios.Proyecto_chat.model.DataObject.Usuario;

public interface IRepoUsuario {
	boolean addUsuario(Usuario u);
	boolean removeUsuario(Usuario u);
	void modifynickName(Usuario u, String nickName);
	void modifyPassword(Usuario u, String password);
	void marshall(String file);
	List<Usuario> unmarshall(String file);
}
