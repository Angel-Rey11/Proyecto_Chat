package es.delosrios.Proyecto_chat.Interfaces;

import es.delosrios.Proyecto_chat.model.DataObject.Message;
import es.delosrios.Proyecto_chat.model.DataObject.Usuario;

/**
 * Interfaz para Sala
 * @author Francisco José Berral, Francisco Prados, Ángel Manuel Rey
 *
 */
public interface ISala {
	int hashCode();
	boolean equals(Object obj);
	String toString();
	boolean addMessage(Message m);
	boolean addUser(Usuario u);
	boolean removeUser(Usuario u);
	void modifynickName(Usuario u, String nickName);
	void modifyPassword(Usuario u, String password);
	boolean checkUser(Usuario u);
}
