package com.danimota.to_do_list.repository;

import com.danimota.to_do_list.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
