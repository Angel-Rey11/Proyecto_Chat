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
	
	private String nickname;
	@XmlJavaTypeAdapter(value = Adapter.class)
	private LocalDate time;
	private String text;

	public Message() {
		
	}

	public Message(String nickname, LocalDate time, String text) {
		super();
		this.nickname = nickname;
		this.time = time;
		this.text = text;
	}


	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [nickName=" + nickname + ", Time=" + time + ", Text=" + text + "]";
	}
}
