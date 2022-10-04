package es.delosrios.Proyecto_chat.Interfaces;

import es.delosrios.Proyecto_chat.model.Dao.RepoUsuarios;
import es.delosrios.Proyecto_chat.model.DataObject.Usuario;

public interface IRepoUsuario {
	boolean addUser(Usuario s);
	boolean removeUser(String NickName);
	void modifyNickName (String NickName, String newNickName);
	void modifyUserName(String NickName, String UserName);
	void modifyPassword(String NickName, String Password);
	void modifyDescr(String NickName, String Descr);
	Usuario searchUser(String NickName);
	void marshall(RepoUsuarios r, String file);
	RepoUsuarios unmarshall(String file);
}
