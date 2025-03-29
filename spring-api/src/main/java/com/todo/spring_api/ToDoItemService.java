package com.todo.spring_api;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {

    private final ToDoItemRepository toDoItemRepository;

    public ToDoItemService(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository; 
    }

    public List<ToDoItem> getToDoItems(){
        return toDoItemRepository.findAll();
    }

    public ToDoItem getToDoItem(Long id) {
        return toDoItemRepository.findById(id).orElse(null);
    }

    public ToDoItem addToDoItem(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    public ToDoItem updateToDoItem(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    public void deleteToDoItem(Long id) {
        toDoItemRepository.deleteById(id);
    }
}
