module es.delosrios.Proyecto_chat {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.xml.bind;
	requires java.xml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.logging;


    opens es.delosrios.Proyecto_chat to javafx.fxml,java.xml.bind;
    opens es.delosrios.Proyecto_chat.model.Dao to java.xml.bind,javafx.fxml;
    opens es.delosrios.Proyecto_chat.model.DataObject;
    opens es.delosrios.Proyecto_chat.utils to java.xml.bind;
    exports es.delosrios.Proyecto_chat;
}
