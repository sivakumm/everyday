package com.zuehlke.hatch.backend.service;

import com.zuehlke.hatch.backend.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service

public class TodoService {


    private List<Todo> todoList = new ArrayList<>(Arrays.asList(

            new Todo("1", "_Spring FrameWork", "_Spring Description", false, new Date()),
            new Todo("2", "_Spring FrameWork", "_Spring Description", false, new Date()),
            new Todo("3", "_Spring FrameWork", "_Spring Description", false, new Date())


    ));

    public List<Todo> getAllTodos() {
        return todoList;
    }

    public Todo getTodo(String todoId) {
        return todoList.stream().filter(topic -> topic.getId().equals(todoId)).findAny().get();
    }

    public void addTodo(Todo todo) {
        todoList.add(todo);
    }

    public void updateTodo(Todo todo, String todoId) {
        int counter = 0;
        for ( Todo todoToEdit : todoList){
            if(todoToEdit.getId().equals(todoId)) {
                todoList.set(counter, todo);
            }
            counter ++;
        }
    }

    public void deleteTodo(String todoId) {
        todoList.removeIf(todo -> todo.getId().equals(todoId));
    }
}
