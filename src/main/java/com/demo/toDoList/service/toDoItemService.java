package com.demo.toDoList.service;

import com.demo.toDoList.model.toDoItemDto;

import java.util.List;

public interface toDoItemService {
    List<toDoItemDto> getAllItems();
    toDoItemDto getById(Long id);
    toDoItemDto changeDoneState(Long id);
    toDoItemDto createItem(toDoItemDto dto);
    toDoItemDto updateItem(toDoItemDto dto);
    boolean deleteItem(Long id);
}
