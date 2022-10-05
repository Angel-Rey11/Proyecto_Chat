package es.delosrios.Proyecto_chat.model.DataObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Sala")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sala implements Serializable {


	private String nombre;
	private String descr;
	
	private List<Message> allMessagges;
	
	private List<Usuario> allUsers;
	

	
	public Sala(String Nombre, String Descr, List<Message> AllMessagges, List<Usuario> AllUsers) {
		this.nombre = Nombre;
		this.descr = Descr;
		this.allMessagges = AllMessagges;
		this.allUsers = AllUsers;
	}
	public Sala(String nombre, String descr) {
		this.nombre = nombre;
		this.descr = descr;
		this.allMessagges = new ArrayList<>();
		this.allUsers = new ArrayList<>();
	}
	public Sala() {
		this("","");
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public List<Message> getAllMessagges() {
		return allMessagges;
	}
	public void setAllMessagges(List<Message> allMessagges) {
		this.allMessagges = allMessagges;
	}
	public List<Usuario> getAllUsers() {
		return allUsers;
	}
	public void setAllUsers(List<Usuario> allUsers) {
		this.allUsers = allUsers;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
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
	@Override
	public String toString() {
		return "Sala [nombre=" + nombre + ", descr=" + descr + ", allMessagges=" + allMessagges + ", allUsers="
				+ allUsers + "]";
	}


	
	
}
