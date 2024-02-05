package TEK.Rouzbeh.CentralizationServer.ServerApp.CommunicationLayer;// ServerInitializer.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServerInitializer {

    private final TCPServer tcpServer;

    @Autowired
    public ServerInitializer(TCPServer tcpServer) {
        this.tcpServer = tcpServer;
    }

    public void initializeServer() {
        tcpServer.startServer();
    }
}