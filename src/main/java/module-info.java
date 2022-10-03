module es.delosrios.Proyecto_chat {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.xml.bind;

    opens es.delosrios.Proyecto_chat to javafx.fxml;
    exports es.delosrios.Proyecto_chat;
}
