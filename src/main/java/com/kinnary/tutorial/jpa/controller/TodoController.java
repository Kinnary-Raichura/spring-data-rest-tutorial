package com.kinnary.tutorial.jpa.controller;

import com.kinnary.tutorial.jpa.model.Todo;
import com.kinnary.tutorial.jpa.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by kraichura on 10/30/2015.
 */
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Todo> list() {
        return todoService.listAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Collection<Todo> create(@RequestBody List<Map<String,String>> valueMaps) {
        return todoService.saveOrUpdateAll(valueMaps);
    }

    @RequestMapping(params = {"title","description"})
    public List<Todo> read(@RequestParam(value = "title") String title,
                           @RequestParam(value = "description") String description) {
        return todoService.findByTitleAndDescription(title, description);
    }



}
