package com.demo.toDoList.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "toDoItems")
public class toDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private String priority;

    @Column(name = "created")
    private LocalDateTime createdDate;

    @Column(name = "done")
    @Getter
    private Boolean isDone;

    @PrePersist
    private void toCreate(){
        this.setCreatedDate(LocalDateTime.now());
        //this.setDone(false);
    }
}
