module es.delosrios.Proyecto_chat {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.xml.bind;


    opens es.delosrios.Proyecto_chat to javafx.fxml,java.xml.bind;
    opens es.delosrios.Proyecto_chat.model.Dao to java.xml.bind,javafx.fxml;
    opens es.delosrios.Proyecto_chat.model.DataObject;
    exports es.delosrios.Proyecto_chat;
}
