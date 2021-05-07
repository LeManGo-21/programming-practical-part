package net.rgsu.exam.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("message")
    @Column(name = "MESSAGE", length = 4000)
    private String message;

    @JsonProperty("second_name")
    private String secondName;

    @JsonProperty("user_id")
    private String userId;

    public Log() {}

    public Log(Date createdAt, String firstName, String message, String secondName, String userId) {
        this.createdAt = createdAt;
        this.firstName = firstName;
        this.message = message;
        this.secondName = secondName;
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                '}';
    }
}
