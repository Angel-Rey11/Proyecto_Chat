package es.delosrios.Proyecto_chat.model.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import es.delosrios.Proyecto_chat.Interfaces.IRepoSala;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;

@XmlRootElement(name = "RepoSala")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoSala implements IRepoSala, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Sala> list;
	
	public RepoSala() {
		list = new ArrayList<Sala>();
	}

	public boolean addSala(Sala s) {
		boolean added = false;
		
		if (!list.isEmpty()) {
			if (!list.contains(s)) {
				list.add(s);
				added = true;
			}
		}
		
		return added;
	}
	
	public boolean removeSala(String name) {
		boolean removed = false;
		
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNombre().equals(name)) {
					list.remove(i);
				}
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
	
	public void marshall(RepoSala r, String file) {
		JAXBContext contexto;
		BufferedWriter bfr;
		
		try {
			bfr = new BufferedWriter(new FileWriter(file));
			contexto = JAXBContext.newInstance(RepoSala.class);
			Marshaller m = contexto.createMarshaller();
			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(r, new File(file));
			bfr.close();
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public RepoSala unmarshall(String file) {
		JAXBContext contexto;
		RepoSala newReposala = null;
		
		try {
			contexto = JAXBContext.newInstance(RepoSala.class);
			Unmarshaller um = contexto.createUnmarshaller();
			
			newReposala = (RepoSala)um.unmarshal(new File(file));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return newReposala;
	}
}
