package com.danimota.to_do_list.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ToDoDTO (
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Descrição é obrigatória")
        String descricao,

        boolean realizado,

        @Min(value = 1, message = "Prioridade deve ser >= 1")
        int prioridade
) {
}
