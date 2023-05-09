package nl.ssi.todospringboot.controllers;

import nl.ssi.todospringboot.models.Todo;
import nl.ssi.todospringboot.services.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @PostMapping(value = "/add")
    public String addTodos(@RequestBody Todo todo, BindingResult result) {
                if (result.hasErrors()) {
            return "todo";
        }
        System.out.println("New Todo received: " + todo.getUserName() + " - " + todo.getDescription() + " - " + todo.getTargetDate());
        todoService.saveTodo(todo);
        return "redirect:/list-todos";
    }

    @PostMapping(value = "/update")
    public String updateTodo(@RequestBody Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        System.out.println("Todo updated: " + todo.getUserName() + " - " + todo.getDescription() + " - " + todo.getTargetDate());
        todoService.updateTodo(todo);
        return "redirect:/list-todos";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteTodo(@PathVariable long id) {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }
}
