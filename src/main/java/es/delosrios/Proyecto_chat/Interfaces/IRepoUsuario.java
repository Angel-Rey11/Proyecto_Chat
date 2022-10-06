package es.delosrios.Proyecto_chat.Interfaces;

import java.util.List;

import es.delosrios.Proyecto_chat.model.DataObject.Usuario;

public interface IRepoUsuario {
	boolean addUsuario(Usuario u);
	boolean removeUsuario(Usuario u);
	void modifyUser(Usuario u, String name, String password, String nickname);
	void marshall(String file);
	List<Usuario> unmarshall(String file);
}
