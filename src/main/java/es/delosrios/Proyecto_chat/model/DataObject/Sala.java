package es.delosrios.Proyecto_chat.model.DataObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import es.delosrios.Proyecto_chat.Interfaces.ISala;

@XmlRootElement(name = "Sala")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sala implements ISala,Serializable {

	/**
	 * Nombre de la sala
	 */
	private String nombre;
	
	/**
	 * Descripción de la sala
	 */
	private String descr;
	
	/**
	 * Lista de mensajes que contendrá la sala
	 */
	private List<Message> allMessagges;
	
	/**
	 * Lista de usuario que contendrá la sala
	 */
	private List<Usuario> allUsers;
	
	/**
	 * Constructor por defecto
	 */
	public Sala() {
		this("","");
	}
	
	/**
	 * Constructor que recibe 4 parámetros
	 * @param Nombre Nombre de la sala
	 * @param Descr Descripción de la sala
	 * @param AllMessagges Lista de mensajes de la sala
	 * @param AllUsers Lista de usuario de la sala
	 */
	public Sala(String Nombre, String Descr, List<Message> AllMessagges, List<Usuario> AllUsers) {
		this.nombre = Nombre;
		this.descr = Descr;
		this.allMessagges = AllMessagges;
		this.allUsers = AllUsers;
	}
	
	/**
	 * Constructor que recibe dos parámetros
	 * @param nombre Nombre de la sala
	 * @param descr Descr
	 */
	public Sala(String nombre, String descr) {
		this.nombre = nombre;
		this.descr = descr;
		this.allMessagges = new ArrayList<>();
		this.allUsers = new ArrayList<>();
	}
	
	/**
	 * Método para obtener el nombre de la sala
	 * @return Nombre de la sala
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Método para setear el nombre a la sala
	 * @param nombre Nombre por el que se va a cambiar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Método para obtener la descripción de la sala
	 * @return Descripción de la sala
	 */
	public String getDescr() {
		return descr;
	}
	
	/**
	 * Método para setear la descripción de la sala
	 * @param descr Descripción por la que se va a cambiar
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	/**
	 * Método para obtener todos los mensajes de la sala
	 * @return Mensajes que tiene la sala
	 */
	public List<Message> getAllMessagges() {
		return allMessagges;
	}
	
	/**
	 * Método para setear todos los mensajes de la sala
	 * @param allMessagges Mensajes por los que se van a cambiar
	 */
	public void setAllMessagges(List<Message> allMessagges) {
		this.allMessagges = allMessagges;
	}
	
	/**
	 * Método para obtener todos los usuarios de la sala
	 * @return Usuario que tiene la sala
	 */
	public List<Usuario> getAllUsers() {
		return allUsers;
	}
	
	/**
	 * Métodos para setear todos los usuarios de la sala
	 * @param allUsers Usuarios por los que se van a cambiar
	 */
	public void setAllUsers(List<Usuario> allUsers) {
		this.allUsers = allUsers;
	}
	
	/**
	 * Método para comparar salas
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	/**
	 * Método para comparar salas
	 * @param obj Objeto a comparar
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	/**
	 * Método para mostrar una sala
	 */
	@Override
	public String toString() {
		return "Sala [nombre=" + nombre + ", descr=" + descr + ", allMessagges=" + allMessagges + ", allUsers="
				+ allUsers + "]";
	}
	
	/**
	 * Método para añadir un mensaje
	 * @param m Mensaje que se va a añadir
	 */
	@Override
	public boolean addMessage(Message m) {
		boolean added = false;
		if (!allMessagges.contains(m)) {
			allMessagges.add(m);
			added = true;
			
		}
		return added;
	}
	
	/**
	 * Método para añadir un usuario
	 * @param u Usuario que se va a añadir
	 */
	@Override
	public boolean addUser(Usuario u) {
		boolean added = false;
		if (!allUsers.contains(u)) {
			allUsers.add(u);
			added = true;
			
		}
		return added;
	}
	
	/**
	 * Método para modificar el nick del usuario
	 * @param u Usuario elegido
	 * @param nickName Nick que se va a añadir
	 */
	@Override
	public void modifynickName(Usuario u, String nickName) {
		if (allUsers.contains(u)) {
			u.setNickName(nickName);
		}
	}
	
	/**
	 * Método para modificar la contraseña del usuario
	 * @param u Usuario elegido
	 * @param password Contraseña que se va a añadir
	 */
	@Override
	public void modifyPassword(Usuario u, String password) {
		if (allUsers.contains(u)) {
			u.setPassword(password);
		}
	}
	
	/**
	 * Método para modificar la descripción del usuario
	 * @param u Usuario elegido
	 * @param desc Descripción que se va a añadir
	 */
	@Override
	public void modifyDesc(Usuario u, String desc) {
		if (allUsers.contains(u)) {
			u.setDesc(desc);
		}
	}
}
