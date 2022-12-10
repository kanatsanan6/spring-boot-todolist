package learn.sprintboot.Todolist.Todo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    private Long id;
    private String title;
    private Boolean status;

    public Todo() {
    }

    public Todo(Long id, String title, Boolean status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
