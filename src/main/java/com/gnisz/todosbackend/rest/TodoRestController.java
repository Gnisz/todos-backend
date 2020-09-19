package com.gnisz.todosbackend.rest;


import com.gnisz.todosbackend.enitity.Todo;
import com.gnisz.todosbackend.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoRestController {

    private TodoService todoService;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    public List<Todo> findAll(){
        return  this.todoService.findAll();
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable int todoId){
        Todo theTodo = this.todoService.findAllById(todoId);

        if(theTodo == null){
            throw new RuntimeException("Did not find todo with id - " + todoId);
        }

        return theTodo;
    }

    @PostMapping("/todo")
    public Todo save(@RequestBody Todo theTodo){
        theTodo.setId(0);
        this.todoService.save(theTodo);
        return theTodo;
    }

    @PutMapping("/todo")
    public  Todo update (@RequestBody Todo theTodo){
        this.todoService.save(theTodo);
        return theTodo;
    }

    @DeleteMapping("/todo/{todoId}")
    public  String deleteTodo (@PathVariable int todoId){
        Todo tempTodo = this.todoService.findAllById(todoId);

        if (tempTodo == null){
            throw new RuntimeException("Did not find todo with id - " + todoId);
        }

        this.todoService.deleteById(todoId);

        return "to do with ID " + todoId + " deleted";
    }
}
