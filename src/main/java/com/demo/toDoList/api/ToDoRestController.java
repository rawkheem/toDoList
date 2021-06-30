package com.demo.toDoList.api;

import com.demo.toDoList.service.toDoItemService;
import com.demo.toDoList.model.toDoItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/toDo")
public class ToDoRestController {

    @Autowired
    private toDoItemService service;

    @GetMapping("/{itemId}")
    public toDoItemDto getItem(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/getAll")
    public List<toDoItemDto> getToDoList() {
        return service.getAllItems();
    }

    @PutMapping("/edit")
    public toDoItemDto updateTodoItem(@RequestBody toDoItemDto dto) {
        return service.updateItem(dto);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteTodoItem(@PathVariable Long id) {
        return service.deleteItem(id);
    }

    @PutMapping("/state/{id}")
    public toDoItemDto changeDoneState(@PathVariable Long id) {
        return service.changeDoneState(id);
    }
}
