package es.delosrios.Proyecto_chat.Interfaces;

import java.util.List;

import es.delosrios.Proyecto_chat.model.DataObject.Message;
import es.delosrios.Proyecto_chat.model.DataObject.Usuario;

public interface ISala {
	String getNombre();
	String getDescr();
	List<Message> getAllMessagges();
	List<Usuario> getAllUser();
	void setNombre(String Nombre);
	void setDescr(String Descr);
	void setAllMessagges(List<Message> allMessagges);
	void setAllUsers(List<Usuario> allUsers);
	boolean equals(Object o);
}
