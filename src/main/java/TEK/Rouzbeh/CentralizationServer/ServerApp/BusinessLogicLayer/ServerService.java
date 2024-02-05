package TEK.Rouzbeh.CentralizationServer.ServerApp.BusinessLogicLayer;

import TEK.Rouzbeh.CentralizationServer.ServerApp.DataAccessLayer.ServerEntity;
import TEK.Rouzbeh.CentralizationServer.ServerApp.DataAccessLayer.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerService {

    private final ServerRepository serverRepository;

    @Autowired
    public ServerService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    public List<ServerEntity> serverRepository(){
        return serverRepository.findAll();
    }

}
