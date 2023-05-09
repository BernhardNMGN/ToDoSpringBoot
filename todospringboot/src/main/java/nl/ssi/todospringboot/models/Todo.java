package nl.ssi.todospringboot.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todos", uniqueConstraints = { @UniqueConstraint(name = "UniqueNameAndDescription", columnNames = { "userName", "description" }) })
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;

    private String description;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date targetDate;

    public Todo() {
        super();
    }

    public Todo(String userName, String description, Date targetDate) {
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
}
