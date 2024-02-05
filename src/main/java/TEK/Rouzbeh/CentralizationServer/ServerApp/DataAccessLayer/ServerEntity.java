package TEK.Rouzbeh.CentralizationServer.ServerApp.DataAccessLayer;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table
public class ServerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String data;
    LocalDateTime timestamp;

    public ServerEntity() {
    }

    public ServerEntity(int id, String data, LocalDateTime timestamp) {
        this.id = id;
        this.data = data;
        this.timestamp = timestamp;
    }

    public ServerEntity(String data, LocalDateTime timestamp) {
        this.data = data;
        this.timestamp = timestamp;
    }

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

    @Override
    public String toString() {
        return "ServerEntity{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}