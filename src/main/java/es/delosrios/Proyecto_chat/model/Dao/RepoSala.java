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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import es.delosrios.Proyecto_chat.Interfaces.IRepoSala;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;

@XmlRootElement(name = "RepoSala")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoSala implements IRepoSala, Serializable {
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	/**
	 * Lista de salas
	 */
	@XmlElement(name="Sala")
	private List<Sala> list;
	
	/**
	 * Inicializar lista de salas
	 */
	public RepoSala() {
		list = new ArrayList<Sala>();
	}

	/**
	 * Método para añadir sala
	 * @param s Sala que se va a añadir
	 */
	public boolean addSala(Sala s) {
		boolean added = false;
		if (!list.contains(s)) {
				list.add(s);
				added = true;
		}
		return added;
	}
	
	/**
	 * Método para eliminar sala
	 * @param s Sala a eliminar
	 * @return Si la sala ha sido borrada
	 */
	public boolean removeSala(Sala s) {
		boolean removed = false;
		
		if(list.contains(s)) {
			list.remove(s);
			removed = true;
		}
		return removed;
	}
	
	/**
	 * Método para modificar el nombre de la sala
	 * @param s Sala a modificar
	 * @param name Nombre que se va a añadir
	 */
	public void modifyName(Sala s, String name) {
		if(list.contains(s)) {
			s.setNombre(name);
		}
	}
	
	/**
	 * Método para modificar la descripción de la sala
	 * @param s Sala a modificar
	 * @param desc Descripción que se va a añadir
	 */
	public void modifyDescr(Sala s, String desc) {
		if(list.contains(s)) {
			s.setDescr(desc);
		}
	}
	
	/**
	 * Método para añadir contenido al fichero XML
	 * @param file Nombre del archivo
	 */
	public void marshall(String file) {
		JAXBContext contexto;
		BufferedWriter bfr;
		
		try {
			bfr = new BufferedWriter(new FileWriter(file));
			contexto = JAXBContext.newInstance(RepoSala.class);
			Marshaller m = contexto.createMarshaller();
			System.out.println(this.list);
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(this, new File(file));
			bfr.close();
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Sala> unmarshall(String file) {
		JAXBContext contexto;
		RepoSala newReposala = null;

		
		try {
			contexto = JAXBContext.newInstance(RepoSala.class);
			Unmarshaller um = contexto.createUnmarshaller();
			
			newReposala = (RepoSala)um.unmarshal(new File(file));
			this.list = newReposala.list;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Método para mostrar la lista de salas
	 */
	@Override
	public String toString() {
		return "RepoSala [list=" + list + "]";
	}
	
	
}
