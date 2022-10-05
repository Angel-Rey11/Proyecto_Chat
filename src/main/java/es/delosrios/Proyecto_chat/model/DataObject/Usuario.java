package es.delosrios.Proyecto_chat.model.DataObject;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String password;
	private String nickName;
	private String desc;

	public Usuario() {
		this("", "", "", "");
	}

	public Usuario(String nombre, String password, String nickName, String desc) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.nickName = nickName;
		this.desc = desc;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nickName);
	}

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

	@Override
	public String toString() {
		return "Usuario [Nombre=" + nombre + ", Password=" + password + ", nickName=" + nickName + ", Desc=" + desc
				+ "]";
	}
}
