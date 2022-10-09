package es.delosrios.Proyecto_chat.model.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
import es.delosrios.Proyecto_chat.model.DataObject.Message;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;
import es.delosrios.Proyecto_chat.model.DataObject.Usuario;

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
	 * Metodo para buscar una sala en concreto
	 * @param s sala que vamos a buscar en la lista de salas
	 * @return una sala con todos sus atributos del array de salas
	 */
	public Sala searchSala(Sala s) {
		Sala si = null;
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNombre().equals(s.getNombre())) {
					si = list.get(i);
				}
			}
		}
		return si;
	}
	
	/**
	 * Metodo para inicializar o meter usuarios en el array de usuarios de una sala en conreto
	 * @param u usuario que vamos a introducir
	 * @param s sala en donde vamos a introducir ese usuario
	 */
	public void initArray(Sala s, Usuario u) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNombre().equals(s.getNombre())) {
					s.getAllUsers().add(u);
				} 
			}
	}
	
	/**
	 * Método para comprobar si una sala existe en la lista
	 * @param s Sala a buscar
	 */
	public boolean existSala(Sala s) {
		boolean result = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNombre().equals(s.getNombre())) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * Metodo para inicializar o meter mensajes en el array de mensajes de una sala en concreto
	 * @param s sala donde meteremos los mensajes
	 * @para m mensaje que introduciremos en el array de la sala
	 */
	public void initArrayMessages(Sala s, Message m) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNombre().equals(s.getNombre())) {
				s.getAllMessagges().add(m);
			}
		}
	}
	
	public Sala removeUsers(Sala s, Usuario u) {
		Sala nueva = null;
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNombre().equals(s.getNombre())) {
					List<Usuario> Usuarios = new ArrayList<>();
					Usuarios.add(u);
					nueva = new Sala(s.getNombre(),s.getDescr(),Usuarios);
					removeSala(s);
					addSala(nueva);
				}
			}
		}
		return nueva;
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
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(this, new File(file));
			bfr.close();
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para cargar contenido del fichero xml
	 * @param file nombre del archivo
	 */
	public List<Sala> unmarshall(String file) {
		JAXBContext contexto;
		RepoSala newReposala = null;
		

		
		try {
			FileReader f = new FileReader(file);
			contexto = JAXBContext.newInstance(RepoSala.class);
			Unmarshaller um = contexto.createUnmarshaller();
			
			newReposala = (RepoSala)um.unmarshal(f);
			this.list = newReposala.list;
			f.close();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
