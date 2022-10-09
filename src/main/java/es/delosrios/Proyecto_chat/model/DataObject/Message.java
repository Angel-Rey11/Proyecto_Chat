package es.delosrios.Proyecto_chat.model.DataObject;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import es.delosrios.Proyecto_chat.utils.Adapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "messages")
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Nick del mensaje
	 */
	private String nickname;
	
	/**
	 * Hora del mensaje
	 */
	@XmlJavaTypeAdapter(value = Adapter.class)
	private LocalDate time;
	
	/**
	 * Texto del mensaje
	 */
	private String text;

	/**
	 * Constructor por defecto
	 */
	public Message() {
		this("", null, "");
	}
	
	/**
	 * Constructor con 3 parámetros
	 * @param nickname Nick del mensaje
	 * @param time Hora del mensaje
	 * @param text Texto del mensaje
	 */
	public Message(String nickname, LocalDate time, String text) {
		super();
		this.nickname = nickname;
		this.time = time;
		this.text = text;
	}

	/**
	 * Método para obtener el nick del mensaje
	 * @return Nick del mensaje
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Método para setear el nick del mensaje
	 * @param nickName Nick por el que se va a cambiar
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * Método para obtener la hora del mensaje
	 * @return Hora del mensaje
	 */
	public LocalDate getTime() {
		return time;
	}

	/**
	 * Método para setear la hora del mensaje
	 * @param time Hora por la que se va a cambiar
	 */
	public void setTime(LocalDate time) {
		this.time = time;
	}

	/**
	 * Método para obtener el texto del mensaje
	 * @return Texto del mensaje
	 */
	public String getText() {
		return text;
	}

	/**
	 * Método para setear el texto del mensaje
	 * @param text Texto por el que se va a cambiar
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Método para mostrar un mensaje
	 */
	@Override
	public String toString() {
		return "Message [nickName=" + nickname + ", Time=" + time + ", Text=" + text + "]";
	}
}
