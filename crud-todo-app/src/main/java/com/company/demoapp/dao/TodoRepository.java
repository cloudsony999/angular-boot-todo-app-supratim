package com.company.demoapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.demoapp.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, String> {

}
