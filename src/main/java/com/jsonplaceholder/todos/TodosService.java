package com.jsonplaceholder.todos;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface TodosService {

    List<Todos> findAll();
    
    void insertTodo(Todos todo);
    
    void updateTodo(Todos todo);
}