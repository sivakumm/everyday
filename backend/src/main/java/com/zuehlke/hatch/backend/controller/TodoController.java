package com.zuehlke.hatch.backend.controller;

import com.zuehlke.hatch.backend.model.Todo;
import com.zuehlke.hatch.backend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class TodoController {

    final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/todos/{todoId}")
    public Todo getTodo(@PathVariable("todoId") String todoId) {
        return todoService.getTodo(todoId);
    }

    @PostMapping("/todos/")
    public void addTodo(@RequestBody  Todo todo) {
        todoService.addTodo(todo);
    }

    @PutMapping("/todos/{todoId}")
    public void updateTodo(@RequestBody Todo todo,@PathVariable ("todoId")String todoId){
        todoService.updateTodo(todo,todoId);

    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable ("todoId")String todoId){
        todoService.deleteTodo(todoId);

    }


}
