package es.delosrios.Proyecto_chat.model.DataObject;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
/**
 * Clase Usuario
 * @author Francisco José Berral, Francisco Prados, Ángel Manuel Rey
 */
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Nombre del usuario
	 */
	private String nombre;
	
	/**
	 * Contraseña del usuario
	 */
	private String password;
	
	/**
	 * Nick del usuario
	 */
	private String nickName;

	/**
	 * Constructor por defecto
	 */
	public Usuario() {
		this("", "", "");
	}

	/**
	 * Constructor con 3 parámetros
	 * @param nombre Nombre del usuario
	 * @param password Contraseña del usuario
	 * @param nickName Nick del usuario
	 */
	public Usuario(String nombre, String password, String nickName) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.nickName = nickName;
	}

	/**
	 * Método para obtener el nombre del usuario
	 * @return Nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método para setear el nombre al usuario
	 * @param nombre Nombre por el que se va a cambiar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método para obtener la contraseña del usuario
	 * @return Contraseña del usuario
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Método para setear la contraseña al usuario
	 * @param password Contraseña por la que se va a cambiar
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Método para obtener el nick del usuario
	 * @return Nick del usuario
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Método para setear el nick al usuario
	 * @param nickName Nick por el que se va a cambiar
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Método para comparar usuarios
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nickName);
	}

	/**
	 * Método para comparar usuarios
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
		Usuario other = (Usuario) obj;
		return Objects.equals(nickName, other.nickName);
	}

	/**
	 * Método para mostrar un usuario
	 */
	@Override
	public String toString() {
		return "Usuario [Nombre=" + nombre + ", Password=" + password + ", nickName=" + nickName
				+ "]";
	}
}
