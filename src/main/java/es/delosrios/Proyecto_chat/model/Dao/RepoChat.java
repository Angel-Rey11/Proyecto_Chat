package es.delosrios.Proyecto_chat.model.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.delosrios.Proyecto_chat.model.DataObject.Message;

public class RepoChat {
	
	public static void save(Message m, String file) throws IOException, JAXBException {
		JAXBContext context;
		BufferedWriter bfr;
		
		bfr = new BufferedWriter(new FileWriter(file));
		context = JAXBContext.newInstance(Message.class);
		
		Marshaller ms = context.createMarshaller();
		ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		ms.marshal(m, bfr);
		bfr.close();
	}
	
	public static Message load(String file) {
		Message result = null;
		
		try {
			JAXBContext context = JAXBContext.newInstance(Message.class);
			Unmarshaller um = context.createUnmarshaller();
			result = (Message) um.unmarshal(new File(file));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
