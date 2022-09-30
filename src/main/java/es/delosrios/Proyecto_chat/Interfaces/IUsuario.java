package es.delosrios.Proyecto_chat.Interfaces;

public interface IUsuario {
	String getNombre();
	String getPassword();
	String getnickName();
	String getDesc();
	void setNombre(String nombre);
	void setPassword(String Passwprd);
	void setNickName(String nickName);
	void setDesc(String desc);
	boolean equals(Object o);
	String toString();
}
