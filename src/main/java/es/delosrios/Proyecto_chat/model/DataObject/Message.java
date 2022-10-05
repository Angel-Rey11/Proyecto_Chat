package es.delosrios.Proyecto_chat.model.DataObject;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "messages")
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nickName;
	private LocalDateTime time;
	private String text;

	public Message() {
		
	}

	public Message(String nickName, LocalDateTime time, String text) {
		super();
		this.nickName = nickName;
		this.time = time;
		this.text = text;
	}
	

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
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
		return "Message [nickName=" + nickName + ", Time=" + time + ", Text=" + text + "]";
	}
}
