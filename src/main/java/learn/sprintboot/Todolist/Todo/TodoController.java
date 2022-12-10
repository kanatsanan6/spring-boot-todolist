package learn.sprintboot.Todolist.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping(path = "{todoId}")
    public Optional<Todo> getTodo(@PathVariable("todoId") Long todoId) {
        return todoService.getTodo(todoId);
    }

    @PostMapping
    public void postTodos(@RequestBody Todo todo) {
        todoService.addNewTodo(todo);
    }

    @DeleteMapping(path = "{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
    }

    @PutMapping(path = "{todoId}")
    public void updateTodo(
            @PathVariable("todoId") Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Boolean status) {
        todoService.updateTodo(id, status, title);
    }

}
