package com.gnisz.todosbackend.service;

import com.gnisz.todosbackend.enitity.Todo;

import java.util.List;

public interface TodoService {

    public List<Todo> findAll();

    public Todo findAllById(int theId);

    public void save(Todo theTodo);

    public void deleteById(int theId);

}
