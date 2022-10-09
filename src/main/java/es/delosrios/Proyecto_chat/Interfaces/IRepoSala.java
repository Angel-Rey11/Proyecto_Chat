package es.delosrios.Proyecto_chat.Interfaces;

import java.util.List;

import es.delosrios.Proyecto_chat.model.DataObject.Message;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;
import es.delosrios.Proyecto_chat.model.DataObject.Usuario;

/**
 * Interfaz para RepoSala
 * @author Francisco José Berral, Francisco Prados, Ángel Manuel Rey
 */
public interface IRepoSala {
	boolean addSala(Sala s);
	boolean removeSala(Sala s);
	void modifyName(Sala s, String name);
	public Sala searchSala(Sala s);
	void initArray(Sala s, Usuario u);
	boolean existSala(Sala s);
	void initArrayMessages(Sala s, Message m);
	Sala removeUsers(Sala s, Usuario u);
	void modifyDescr(Sala s, String desc);
	/**
	void removeArray(Sala s, Usuario u);
	**/
	void marshall(String file);
	List<Sala> unmarshall(String file);
	String toString();
}
