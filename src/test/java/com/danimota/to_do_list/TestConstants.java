package com.danimota.to_do_list;

import com.danimota.to_do_list.entity.ToDo;

import java.util.ArrayList;
import java.util.List;

public class TestConstants {
    public static final List<ToDo> TODOS = new ArrayList<>() {
        {
            add(new ToDo(10L, "Estudar 1", "Curtir", false, 1));
            add(new ToDo(20L, "Estudar 2", "Comentar", false, 1));
            add(new ToDo(30L, "Estudar 3", "Compartilhar", false, 1));
            add(new ToDo(40L, "Estudar 4", "Se Inscrever", false, 1));
            add(new ToDo(50L, "Estudar 5", "Ativar as Notificações", false, 1));
        }
    };

    public static final ToDo TODO = TODOS.getFirst();
}
