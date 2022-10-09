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

import es.delosrios.Proyecto_chat.Interfaces.IRepoUsuario;
import es.delosrios.Proyecto_chat.model.DataObject.Usuario;

@XmlRootElement(name = "RepoUsuario")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoUsuario implements IRepoUsuario, Serializable {
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	/**
	 * Lista de usuarios
	 */
	@XmlElement(name="Usuario")
	private List<Usuario> list;
	
	/**
	 * Inicializar lista de usuarios
	 */
	public RepoUsuario() {
		list = new ArrayList<Usuario>();
	}

	/**
	 * Método para añadir usuario
	 * @param u Usuario que se va a añadir
	 * @return Si el usuario ha sido añadido
	 */
	public boolean addUsuario(Usuario u) {
		boolean added = false;
		if (!list.contains(u)) {
				list.add(u);
				added = true;
		}
		return added;
	}
	
	/**
	 * Método para eliminar usuario
	 * @param u Usuario a eliminar
	 * @return Si el usuario ha sido borrado
	 */
	public boolean removeUsuario(Usuario u) {
		boolean removed = false;
		
		if(list.contains(u)) {
			list.remove(u);
			removed = true;
		}
		return removed;
	}
	
	/**
	 * Método para modificar el usuario
	 * @param u Usuario elegido
	 * @param que se van a modificar
	 */
	public void modifyUser(Usuario u, String name, String password, String nickName) {
		for (Usuario i : list) {
	        if (i.getNickName().equalsIgnoreCase(u.getNickName())) {
	            i.setNombre(name);
	            i.setPassword(password);
	            i.setNickName(nickName);
	        }
		}
	}
	
	/**
	 * Metodo que busca un usuario por su nickname
	 * @param nickName que tiene el usuario que queremos buscar
	 * @return el usuario encontrado
	 */
	public Usuario searchUser(String nickName) {
		Usuario u = null;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getNickName().contains(nickName)) {
				u = list.get(i);
			}
		}
		return u;
	}
	
	/**
	 * Método para validar login
	 * @param nickName Nick para comparar
	 * @param password Contraseña para comparar
	 * @return Usuario encontrado
	 */
	public Usuario validateLogin(String nickName, String password) {
		Usuario user = null;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNickName().contains(nickName) && list.get(i).getPassword().contains(password)) {
				user = list.get(i);
			}
		}
		return user;
	}
	
	/**
	 * Método para comprobar si un usuario existe en la lista
	 * @param user Usuario a buscar
	 */
	public boolean existUser(Usuario user) {
		boolean result = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNickName().contains(user.getNickName())) {
				result = true;
			}
		}
		return result;
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
			contexto = JAXBContext.newInstance(RepoUsuario.class);
			Marshaller m = contexto.createMarshaller();
			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(this, new File(file));
			bfr.close();
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/** Método para cargar archivo XML
	 * @param Nombre del archivo
	 * @return Lista de usuarios
	 */
	public List<Usuario> unmarshall(String file) {
		JAXBContext contexto;
		RepoUsuario newUsuario = null;
		
		try {
			contexto = JAXBContext.newInstance(RepoUsuario.class);
			Unmarshaller um = contexto.createUnmarshaller();
			
			newUsuario = (RepoUsuario)um.unmarshal(new File(file));
			this.list = newUsuario.list;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Método para mostrar la lista de usuarios
	 */
	@Override
	public String toString() {
		return "RepoUsuario [list=" + list + "]";
	}
}
