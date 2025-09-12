package com.danimota.to_do_list.mapper;

import com.danimota.to_do_list.dto.ToDoDTO;
import com.danimota.to_do_list.entity.ToDo;

public class ToDoMapper {

    public static ToDo toentity (ToDoDTO dto) {
        ToDo toDo = new ToDo();
        toDo.setNome(dto.nome());
        toDo.setDescricao(dto.descricao());
        toDo.setRealizado(dto.realizado());
        toDo.setPrioridade(dto.prioridade());
        return toDo;
    }

    public static ToDoDTO toDTO (ToDo toDo) {
        ToDoDTO dto = new ToDoDTO(
                toDo.getNome(), toDo.getDescricao(), toDo.isRealizado(), toDo.getPrioridade()
        );
        return dto;
    }
}
