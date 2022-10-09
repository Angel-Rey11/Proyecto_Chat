package es.delosrios.Proyecto_chat.Interfaces;

import java.util.List;

import es.delosrios.Proyecto_chat.model.DataObject.Usuario;

/**
 * Interfaz para RepoUsuario
 * @author Francisco José Berral, Francisco Prados, Ángel Manuel Rey
 */
public interface IRepoUsuario {
	boolean addUsuario(Usuario u);
	boolean removeUsuario(Usuario u);
	void modifyUser(Usuario u, String name, String password, String nickname);
	Usuario searchUser(String nickName);
	Usuario validateLogin(String nickName, String password);
	boolean existUser(Usuario user);
	void marshall(String file);
	List<Usuario> unmarshall(String file);
	String toString();
}
