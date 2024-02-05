// Package declaration for the Data Access Layer of the Centralization Server module.
package TEK.Rouzbeh.CentralizationServer.ServerApp.DataAccessLayer;

// Import statements for necessary classes and libraries.
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

// Entity annotation indicates that this class is an entity in the JPA (Java Persistence API) context.
@Entity
// Table annotation specifies the name of the database table associated with this entity.
@Table
public class ServerEntity implements Serializable {

    // Primary key annotation for the unique identifier of the entity.
    @Id
    // GeneratedValue annotation specifies the generation strategy for the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    // Data field to store server-related information.
    String data;

    // Timestamp field to store the date and time when the server information was recorded.
    LocalDateTime timestamp;

    // Default constructor required by JPA.
    public ServerEntity() {
    }

    // Constructor with parameters including the unique identifier, data, and timestamp.
    public ServerEntity(int id, String data, LocalDateTime timestamp) {
        this.id = id;
        this.data = data;
        this.timestamp = timestamp;
    }

    // Constructor with parameters excluding the unique identifier (useful for entity creation).
    public ServerEntity(String data, LocalDateTime timestamp) {
        this.data = data;
        this.timestamp = timestamp;
    }

    // Getter and setter methods for accessing and modifying the fields of the entity.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // toString method for generating a string representation of the entity.
    @Override
    public String toString() {
        return "ServerEntity{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
