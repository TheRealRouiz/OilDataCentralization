package TEK.Rouzbeh.CentralizationServer.ServerApp.PresentationLayer;

import TEK.Rouzbeh.CentralizationServer.ServerApp.BusinessLogicLayer.ServerService;
import TEK.Rouzbeh.CentralizationServer.ServerApp.DataAccessLayer.ServerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ServerController {

    private final ServerService serverService;

    @Autowired
    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/api/v1")
    public List<ServerEntity> fetchData(){
        return serverService.serverRepository();

    }

}
