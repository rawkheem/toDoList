package com.demo.toDoList.repository;

import com.demo.toDoList.entity.toDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface toDoListRepository extends JpaRepository<toDoItem, Long> {

}
