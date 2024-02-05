package TEK.Rouzbeh.CentralizationServer; // Adjust package accordingly

import TEK.Rouzbeh.CentralizationServer.ServerApp.CommunicationLayer.ServerInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ServerApplication extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(ServerApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ServerApplication.class);
	}

	public static void main(String[] args) {
		logger.info("Starting the server application.");
		ConfigurableApplicationContext context = SpringApplication.run(ServerApplication.class, args);

		// Get the ServerInitializer bean and call initializeServer method
		ServerInitializer serverInitializer = context.getBean(ServerInitializer.class);
		serverInitializer.initializeServer();
	}
}
