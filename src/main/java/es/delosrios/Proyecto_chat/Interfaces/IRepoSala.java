package es.delosrios.Proyecto_chat.Interfaces;

import java.util.List;

import es.delosrios.Proyecto_chat.model.Dao.RepoSala;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;

public interface IRepoSala {
	boolean addSala(Sala s);
	boolean removeSala(Sala s);
	void modifyName(Sala s, String name);
	void modifyDescr(Sala s, String desc);
	void marshall(String file);
	List<Sala> unmarshall(String file);
}
