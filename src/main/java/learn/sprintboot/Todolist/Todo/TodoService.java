package learn.sprintboot.Todolist.Todo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodo(Long id) {
       return todoRepository.findById(id);
    }

    public void addNewTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    @Transactional
    public void updateTodo(Long id, Boolean status, String title) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "todo with id " + id + " does not exist"
                ));

        if (title != null &&
                title.length() > 0 &&
                    !Objects.equals(todo.getTitle(), title)) {
            todo.setTitle(title);
        }

        if (status != null &&
                !Objects.equals(todo.getStatus(), status)) {
            todo.setStatus(status);
        }
    }
}
