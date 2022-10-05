package es.delosrios.Proyecto_chat.Interfaces;

import java.util.List;

import es.delosrios.Proyecto_chat.model.Dao.RepoSala;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;

public interface IRepoSala {
	boolean addSala(Sala s);
	boolean removeSala(String name);
	void modifyName(String name, String newName);
	void modifyDescr(String name, String descr);
	Sala searchSala(String name);
	void marshall(String file);
	List<Sala> unmarshall(String file);
}
