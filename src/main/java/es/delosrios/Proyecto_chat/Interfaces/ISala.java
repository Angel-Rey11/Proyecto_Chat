package es.delosrios.Proyecto_chat.Interfaces;

import es.delosrios.Proyecto_chat.model.DataObject.Message;
import es.delosrios.Proyecto_chat.model.DataObject.Usuario;

public interface ISala {
	boolean addMessage(Message m);
	boolean addUser(Usuario u);
	void modifynickName(Usuario u, String nickName);
	void modifyPassword(Usuario u, String password);
	void modifyDesc(Usuario u, String Desc);
}
