package es.delosrios.Proyecto_chat.model.DataObject;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import es.delosrios.Proyecto_chat.Interfaces.IMessage;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message")
public class Message implements IMessage {
	
	private String nickName;
	private LocalDateTime Time;
	private String Text;

	public Message() {
		
	}

	public Message(String nickName, LocalDateTime time, String text) {
		super();
		this.nickName = nickName;
		this.Time = time;
		this.Text = text;
	}
	
	@Override
	public String getnickName() {
		// TODO Auto-generated method stub
		return nickName;
	}

	@Override
	public LocalDateTime getTime() {
		// TODO Auto-generated method stub
		return Time;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return Text;
	}

	@Override
	public void setName(String nickName) {
		// TODO Auto-generated method stub
		this.nickName = nickName;
	}

	@Override
	public void setTime(LocalDateTime time) {
		// TODO Auto-generated method stub
		this.Time = time;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		this.Text = text;
	}

	@Override
	public String toString() {
		return "Message [nickName=" + nickName + ", Time=" + Time + ", Text=" + Text + "]";
	}
}
