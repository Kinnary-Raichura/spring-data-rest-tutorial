package com.kinnary.tutorial.jpa.service;

import com.kinnary.tutorial.jpa.model.Todo;
import com.kinnary.tutorial.jpa.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by kraichura on 11/3/2015.
 */
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> listAll(){
        return todoRepository.findAll();
    }

    public Collection<Todo> saveOrUpdateAll(List<Map<String,String>> valueMaps){
        List<Todo> todoList = new ArrayList<>();
        for(Map<String,String> valueMap: valueMaps){
            todoList.add(new Todo(valueMap.get("description"),valueMap.get("title")));

        }
        return todoRepository.save(todoList);
    }

    public List<Todo> findByTitleAndDescription(String title, String description){
        return todoRepository.findByTitleAndDescription(title,description);
    }

}
