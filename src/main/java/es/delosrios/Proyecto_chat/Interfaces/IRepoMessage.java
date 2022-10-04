package es.delosrios.Proyecto_chat.Interfaces;

import es.delosrios.Proyecto_chat.model.Dao.RepoChat;
import es.delosrios.Proyecto_chat.model.DataObject.Message;

public interface IRepoMessage {
	boolean addMessage(Message m);
	void marshall(RepoChat r, String file);
	RepoChat unmarshall(String file);
}
