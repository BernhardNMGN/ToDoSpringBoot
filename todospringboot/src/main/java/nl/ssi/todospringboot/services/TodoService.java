package nl.ssi.todospringboot.services;

import nl.ssi.todospringboot.models.Todo;
import nl.ssi.todospringboot.repositories.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements ITodoService{

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getTodosByUser(String user) {
        return todoRepository.findByUserName(user);
    }

    @Override
    public Optional<Todo> getTodoById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void addTodo(String name, String desc, Date targetDate) {
        todoRepository.save(new Todo(name, desc, targetDate));
    }

    @Override
    public void deleteTodo(long id) {
        if(todoRepository.existsById(id))
            todoRepository.deleteById(id);
    }

    @Override
    public void saveTodo(Todo todo) {
            todoRepository.save(todo);
    }
}
