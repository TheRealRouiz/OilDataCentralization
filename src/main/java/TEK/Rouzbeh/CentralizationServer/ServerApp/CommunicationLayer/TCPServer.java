package TEK.Rouzbeh.CentralizationServer.ServerApp.CommunicationLayer;// TCPServer.java

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Component
public class TCPServer {

    private static final Logger logger = LoggerFactory.getLogger(TCPServer.class);
    private static final int PORT = 5000;
    private static List<ClientHandler> clients = new ArrayList<>();

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            logger.info("Server listening on port {}", PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                logger.info("Accepted connection from {}", clientSocket.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            logger.error("Error starting the server", e);
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader reader;

        public ClientHandler(Socket clientSocket) throws IOException {
            this.clientSocket = clientSocket;
            this.reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    logger.info("Received message from {}: {}", clientSocket.getInetAddress(), message);
                    String response = "Server received your message: " + message;
                    clientSocket.getOutputStream().write((response + "\n").getBytes());
                    logger.info("Sent response to {}: {}", clientSocket.getInetAddress(), response);
                }
            } catch (IOException e) {
                logger.error("Error handling client connection", e);
                logger.info("Client disconnected: {}", clientSocket.getInetAddress());
                clients.remove(this);
            }
        }

    }
}
