package com.danimota.to_do_list.service;

import com.danimota.to_do_list.dto.ToDoDTO;
import com.danimota.to_do_list.entity.ToDo;
import com.danimota.to_do_list.exception.BadRequestException;
import com.danimota.to_do_list.mapper.ToDoMapper;
import com.danimota.to_do_list.repository.ToDoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> list() {
        Sort sort = Sort.by(Direction.DESC, "prioridade")
                .and(Sort.by(Direction.ASC, "id"));

        return toDoRepository.findAll(sort);
    }

    public List<ToDo> create(ToDoDTO dto) {
        ToDo toDo = ToDoMapper.toentity(dto);
        toDoRepository.save(toDo);

        return list();
    }

    public List<ToDo> update(Long id, ToDoDTO dto) {
        ToDo toDo = ToDoMapper.toentity(dto);
        toDoRepository.findById(id)
                .ifPresentOrElse((existingToDo) -> {
            toDo.setId(id);
            toDoRepository.save(toDo);
        }, () -> { throw new BadRequestException("ToDo %d não existe! ".formatted(id));
        });
        return list();
    }

    public void delete(Long id) {
        toDoRepository.findById(id)
                .ifPresentOrElse(toDoRepository::delete,
                () -> { throw new BadRequestException("ToDo %d não existe! ".formatted(id));
        });
    }
}
