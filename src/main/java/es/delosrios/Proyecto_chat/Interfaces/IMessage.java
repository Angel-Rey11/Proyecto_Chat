package es.delosrios.Proyecto_chat.Interfaces;

import java.time.LocalDateTime;

public interface IMessage {
	String getnickName();
	LocalDateTime getTime();
	String getText();
	void setName(String nickName);
	void setTime(LocalDateTime time );
	void setText(String text);
	String toString();
	
}
