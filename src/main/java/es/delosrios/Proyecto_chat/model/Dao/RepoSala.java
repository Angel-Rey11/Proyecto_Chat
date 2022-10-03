package es.delosrios.Proyecto_chat.model.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.delosrios.Proyecto_chat.model.DataObject.Sala;

@XmlRootElement(name = "RepoSala")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoSala implements IRepoSala, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static RepoSala _instance;
	
	private List<Sala> list;
	
	private RepoSala() {
		list = new ArrayList<Sala>();
	}
	
	public static RepoSala getinstance() {
		if (_instance == null) {
			_instance = new RepoSala();
		}
		return _instance;
	}
	
	public boolean addSala(Sala s) {
		boolean added = false;
		
		if (!list.isEmpty()) {
			if (!list.contains(s.getNombre())) {
				list.add(s);
				added = true;
			}
		}
		
		return added;
	}
	
	public boolean removeSala(Sala s) {
		boolean removed = false;
		
		if (!list.isEmpty()) {
			if (list.contains(s.getNombre())) {
				list.remove(s);
				removed = true;
			}
		}
		return removed;
	}
	
	public void modifyName(String name, String newName) {
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNombre().equals(name)) {
					list.get(i).setNombre(newName);
				}
			}
		}
	}
	
	public void modifyDescr(String name, String descr) {
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNombre().equals(name)) {
					list.get(i).setDescr(descr);
				}
			}
		}
	}
	
	public Sala searchSala(String name) {
		Sala s = null;
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNombre().equals(name)) {
					s = list.get(i);
				}
			}
		}
		return s;
	}
	
	public void marshall(String file) {
		JAXBContext contexto;
		BufferedWriter bfr;
		
		try {
			bfr = new BufferedWriter(new FileWriter(file));
			contexto = JAXBContext.newInstance(RepoSala.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(_instance, new File(file));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void unmarshall(String file) {
		JAXBContext contexto;
		
		try {
			contexto = JAXBContext.newInstance(RepoSala.class);
			Unmarshaller um = contexto.createUnmarshaller();
			
			RepoSala newRepoSala = (RepoSala)um.unmarshal(new File(file));
			list = newRepoSala.list;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
