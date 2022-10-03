package es.delosrios.Proyecto_chat.model.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.delosrios.Proyecto_chat.model.DataObject.Usuario;

public class RepoUsuarios {

	public static void save(Usuario usu, String file) throws IOException, JAXBException {
		JAXBContext context;
		BufferedWriter bfr;
		
		bfr = new BufferedWriter(new FileWriter(file));
		context = JAXBContext.newInstance(Usuario.class);
		
		Marshaller ms = context.createMarshaller();
		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		ms.marshal(usu, bfr);
		bfr.close();
	}
	
	public static Usuario load(String file) {
		Usuario result = null;
		
		try {
			JAXBContext context = JAXBContext.newInstance(Usuario.class);
			Unmarshaller um = context.createUnmarshaller();
			result = (Usuario) um.unmarshal(new File(file));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
