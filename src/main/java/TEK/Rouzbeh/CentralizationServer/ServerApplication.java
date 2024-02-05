// Package declaration for the Centralization Server module in the TEK.Rouzbeh package.
package TEK.Rouzbeh.CentralizationServer; // Adjust package accordingly

// Import statements for necessary classes and libraries.
import TEK.Rouzbeh.CentralizationServer.ServerApp.CommunicationLayer.ServerInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

// Annotation to declare that this class is a Spring Boot application.
@SpringBootApplication
public class ServerApplication extends SpringBootServletInitializer {

	// Logger for logging messages in the application.
	private static final Logger logger = LoggerFactory.getLogger(ServerApplication.class);

	// Override method to configure the application when deployed as a servlet.
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ServerApplication.class);
	}

	// Main method, the entry point of the application.
	public static void main(String[] args) {
		// Log a message indicating the start of the server application.
		logger.info("Starting the server application.");

		// Run the Spring Boot application and get the application context.
		ConfigurableApplicationContext context = SpringApplication.run(ServerApplication.class, args);

		// Get the ServerInitializer bean from the application context and call initializeServer method.
		ServerInitializer serverInitializer = context.getBean(ServerInitializer.class);
		serverInitializer.initializeServer();
	}
}
