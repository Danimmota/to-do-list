package com.danimota.to_do_list.controller;

import com.danimota.to_do_list.dto.ToDoDTO;
import com.danimota.to_do_list.entity.ToDo;
import com.danimota.to_do_list.service.ToDoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<List<ToDo>> create(@RequestBody  @Valid ToDoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.create(dto));
    }
    @GetMapping
    public ResponseEntity<List<ToDo>> list(){
        return ResponseEntity.status(HttpStatus.OK).body(toDoService.list());
    }
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<List<ToDo>> update(@PathVariable Long id, @RequestBody @Valid ToDoDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(toDoService.update(id, dto));
    }
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        toDoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
