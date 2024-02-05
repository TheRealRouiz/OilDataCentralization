// Package declaration for the Data Access Layer of the Centralization Server module.
package TEK.Rouzbeh.CentralizationServer.ServerApp.DataAccessLayer;

// Import statement for the JpaRepository interface from Spring Data JPA.
import org.springframework.data.jpa.repository.JpaRepository;

// Interface declaration for the ServerRepository, extending JpaRepository for database operations.
public interface ServerRepository extends JpaRepository<ServerEntity, Integer> {

// This interface is responsible for providing CRUD (Create, Read, Update, Delete) operations
// for the ServerEntity, leveraging the JpaRepository capabilities.

// The JpaRepository interface already contains methods for common database operations such as
// save, findById, findAll, delete, etc., and these methods are available for ServerEntity
}