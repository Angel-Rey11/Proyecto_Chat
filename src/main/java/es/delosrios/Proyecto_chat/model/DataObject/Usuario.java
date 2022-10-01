package es.delosrios.Proyecto_chat.model.DataObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import es.delosrios.Proyecto_chat.Interfaces.IUsuario;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "usuario")
public class Usuario implements IUsuario {
	
	private String Nombre;
	private String Password;
	private String nickName;
	private String Desc;

	public Usuario() {
		this("", "", "", "");
	}

	public Usuario(String nombre, String password, String nickName, String desc) {
		super();
		this.Nombre = nombre;
		this.Password = password;
		this.nickName = nickName;
		this.Desc = desc;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return Nombre;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return Password;
	}

	@Override
	public String getnickName() {
		// TODO Auto-generated method stub
		return nickName;
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return Desc;
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		this.Nombre = nombre;
	}

	@Override
	public void setPassword(String Passwprd) {
		// TODO Auto-generated method stub
		this.Password = Passwprd;
	}

	@Override
	public void setNickName(String nickName) {
		// TODO Auto-generated method stub
		this.nickName = nickName;
	}

	@Override
	public void setDesc(String desc) {
		// TODO Auto-generated method stub
		this.Desc = desc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		return result;
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
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [Nombre=" + Nombre + ", Password=" + Password + ", nickName=" + nickName + ", Desc=" + Desc
				+ "]";
	}
}
