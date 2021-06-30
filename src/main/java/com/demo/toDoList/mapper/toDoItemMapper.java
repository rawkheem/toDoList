package com.demo.toDoList.mapper;

import com.demo.toDoList.entity.toDoItem;
import com.demo.toDoList.model.toDoItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class toDoItemMapper {

    public toDoItemDto toDto(toDoItem entity) {

        toDoItemDto dto = new toDoItemDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setCreated(entity.getCreatedDate());
        dto.setPriority(entity.getPriority());
        dto.setIsDone(asString(entity.isDone()));

        return dto;
    }

    public toDoItem toEntity(toDoItemDto dto) {

        toDoItem entity = new toDoItem();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setCreatedDate(dto.getCreated());
        entity.setPriority(dto.getPriority());
        entity.setDone(asBoolean(dto.getIsDone()));

        return entity;
    }

    public String asString(Boolean bool) {
        if (bool != null) {
            if (bool) {
                return "Y";
            } else {
                return "N";
            }

        }
        return null;
    }

    public Boolean asBoolean(String bool) {
        if (bool != null) {
            return bool.equals("Y");
        }
        return null;
    }

}
