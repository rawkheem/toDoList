package com.demo.toDoList.service.impl;

import com.demo.toDoList.entity.toDoItem;
import com.demo.toDoList.mapper.toDoItemMapper;
import com.demo.toDoList.model.toDoItemDto;
import com.demo.toDoList.repository.toDoListRepository;
import com.demo.toDoList.service.toDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class toDoItemServiceImpl implements toDoItemService {

    @Autowired
    private final toDoListRepository toDoListRepository;
    private toDoItemMapper mapper;

    public toDoItemServiceImpl(com.demo.toDoList.repository.toDoListRepository toDoListRepository, toDoItemMapper mapper) {
        this.toDoListRepository = toDoListRepository;
        this.mapper = mapper;
    }


    @Override
    public List<toDoItemDto> getAllItems() {
        List<toDoItemDto> dtos = toDoListRepository.findAll()
                .stream().map(mapper::toDto).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public toDoItemDto getById(Long id) {
        return mapper.toDto(toDoListRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException()));
    }

    @Override
    public toDoItemDto changeDoneState(Long id) {
        toDoItem item = toDoListRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        if (item!=null) {
            item.setIsDone(!item.getIsDone());
            toDoListRepository.save(item);
            return mapper.toDto(item);
        }

        return null;
    }

    @Override
    public toDoItemDto createItem(toDoItemDto dto) {
        return mapper.toDto(toDoListRepository
                .save(mapper.toEntity(dto)));
    }

    @Override
    public toDoItemDto updateItem(toDoItemDto dto) {
        toDoItem item = toDoListRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException());

        if (item != null) {
            item.setDescription(dto.getDescription());
            item.setPriority(dto.getPriority());
            return mapper.toDto(toDoListRepository.save(item));
        }
        //Create new if we dont have.
        return mapper.toDto(toDoListRepository.save(item));
    }

    @Override
    public boolean deleteItem(Long id) {

        toDoItem item = toDoListRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        if (item != null) {
            toDoListRepository.delete(item);
            return true;
        }

        return false;
    }

}
