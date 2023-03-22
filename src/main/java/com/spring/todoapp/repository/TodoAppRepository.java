package com.spring.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.todoapp.entity.TodoListData;

public interface TodoAppRepository extends JpaRepository<TodoListData,Integer> {

}
