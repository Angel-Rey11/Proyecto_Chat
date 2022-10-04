package es.delosrios.Proyecto_chat.model.DataObject;

import java.io.Serializable;
import java.util.List;

import es.delosrios.Proyecto_chat.Interfaces.ISala;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Sala")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sala implements ISala, Serializable {
	
	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "Nombre", required = true)
	private String Nombre;
	
	@XmlAttribute(name = "Descr")
	private String Descr;
	
	private List<Message> AllMessagges;
	
	private List<Usuario> AllUsers;
	
	public Sala() {
		this.Nombre = "";
		this.Descr = "";
		this.AllMessagges = null;
		this.AllUsers = null;
	}
	
	public Sala(String Nombre, String Descr, List<Message> AllMessagges, List<Usuario> AllUsers) {
		this.Nombre = Nombre;
		this.Descr = Descr;
		this.AllMessagges = AllMessagges;
		this.AllUsers = AllUsers;
	}
	
	public Sala(String nombre, String descr) {
		super();
		Nombre = nombre;
		Descr = descr;
	}

	@Override
	public String getNombre() {
		return Nombre;
	}

	@Override
	public String getDescr() {
		return Descr;
	}

	@Override
	public List<Message> getAllMessagges() {
		return AllMessagges;
	}

	@Override
	public List<Usuario> getAllUser() {
		return AllUsers;
	}

	@Override
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;	
	}

	@Override
	public void setDescr(String Descr) {
		this.Descr = Descr;
	}

	@Override
	public void setAllMessagges(List<Message> allMessagges) {
		this.AllMessagges = allMessagges;
	}

	@Override
	public void setAllUsers(List<Usuario> allUsers) {
		this.AllUsers = allUsers;
	}
	
	public boolean equals(Object obj) {
		boolean valid = false;
		
		if (obj != null ) {
			if (this == obj) {
				valid = true;
			} else {
				if (this.getClass() == obj.getClass()) {
					Sala tmp = (Sala) obj;
					if (this.getNombre() == tmp.getNombre()) {
						valid = true;
					}
				}
			}
		}	
		return valid;
	}

	@Override
	public String toString() {
		return "Sala [Nombre=" + Nombre + ", Descr=" + Descr + ", AllMessagges=" + AllMessagges + ", AllUsers="
				+ AllUsers + "]";
	}
	
	
}
