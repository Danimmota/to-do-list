package com.danimota.to_do_list;

import com.danimota.to_do_list.entity.ToDo;

import java.util.ArrayList;
import java.util.List;

public class TestConstants {
    public static final List<ToDo> TODOS = new ArrayList<>() {
        {
            add(new ToDo(9995L, "@giulianabezerra", "Curtir", false, 1));
            add(new ToDo(9996L, "@giulianabezerra", "Comentar", false, 1));
            add(new ToDo(9997L, "@giulianabezerra", "Compartilhar", false, 1));
            add(new ToDo(9998L, "@giulianabezerra", "Se Inscrever", false, 1));
            add(new ToDo(9999L, "@giulianabezerra", "Ativar as Notificações", false, 1));
        }
    };

    public static final ToDo TODO = TODOS.get(0);
}
