// Package declaration for the Business Logic Layer of the Centralization Server module.
package TEK.Rouzbeh.CentralizationServer.ServerApp.BusinessLogicLayer;

// Import statements for necessary classes and libraries.
import TEK.Rouzbeh.CentralizationServer.ServerApp.DataAccessLayer.ServerEntity;
import TEK.Rouzbeh.CentralizationServer.ServerApp.DataAccessLayer.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service annotation to declare that this class is a Spring service component.
@Service
public class ServerService {

    // Autowired constructor injection to inject the ServerRepository bean.
    private final ServerRepository serverRepository;

    @Autowired
    public ServerService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    // Method to retrieve all server entities from the ServerRepository.
    public List<ServerEntity> getAllServers() {
        return serverRepository.findAll();
    }

}
