package com.todo.spring_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ToDoItemController {

    private ToDoItemService toDoItemService;

    @Autowired
    public ToDoItemController(ToDoItemService toDoItemService){
        this.toDoItemService = toDoItemService;
    }

    @GetMapping("/todoitems")
    @CrossOrigin
    public List<ToDoItem> getToDoItems(){
        return toDoItemService.getToDoItems();
    }

    @GetMapping("/todoitem/{id}")
    public ToDoItem getToDoItem(@PathVariable("id") Long id) {
        return toDoItemService.getToDoItem(id);
    }
    

    @PutMapping("/todoitem/{id}")
    @CrossOrigin
    public ToDoItem updateToDoItem(@RequestBody() ToDoItem toDoItem, @PathVariable("id") Long id){
        return toDoItemService.updateToDoItem(toDoItem);
    }
    
    @PostMapping("/todoitems")
    @CrossOrigin
    public ResponseEntity<ToDoItem> addNew(@RequestBody() ToDoItem toDoItem){
        ToDoItem newToDoItem = toDoItemService.addToDoItem(toDoItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(newToDoItem);
    }

    @DeleteMapping("/todoitem/{id}")
    @CrossOrigin
    public void deleteToDoItem(@PathVariable("id") Long id) {
        toDoItemService.deleteToDoItem(id);
    }
    
}
