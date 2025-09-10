package com.danimota.to_do_list;

import com.danimota.to_do_list.entity.ToDo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.danimota.to_do_list.TestConstants.TODO;
import static com.danimota.to_do_list.TestConstants.TODOS;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateToDoSuccess() {
		var toDo = new ToDo("toDo 1", "desc toDo 1", false, 1);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(toDo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(toDo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(toDo.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(toDo.isRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(toDo.getPrioridade());
	}

	@Test
	void testCreateToDoFailure() {
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(
						new ToDo("", "", false, 0))
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Sql("/import.sql")
	@Test
	public void testUpdateTodoSuccess() {
		var todo = new ToDo(TODO.getId(), TODO.getNome() + " Up", TODO.getNome() + " Up", !TODO.isRealizado(),
				TODO.getPrioridade() + 1);

		webTestClient
				.put()
				.uri("/todos/" + TODO.getId())
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(5)
				.jsonPath("$[0].nome").isEqualTo(todo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
	}

	@Test
	public void testUpdateTodoFailure() {
		var unexinstingId = 1L;

		webTestClient
				.put()
				.uri("/todos/" + unexinstingId)
				.bodyValue(
						new ToDo(unexinstingId, "", "", false, 0))
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Sql("/import.sql")
	@Test
	public void testDeleteTodoSuccess() {
		webTestClient
				.delete()
				.uri("/todos/" + TODOS.get(0).getId())
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(4)
				.jsonPath("$[0].nome").isEqualTo(TODOS.get(1).getNome())
				.jsonPath("$[0].descricao").isEqualTo(TODOS.get(1).getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(TODOS.get(1).isRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(TODOS.get(1).getPrioridade());
	}

	@Test
	public void testDeleteTodoFailure() {
		var unexinstingId = 1L;

		webTestClient
				.delete()
				.uri("/todos/" + unexinstingId)
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Sql("/import.sql")
	@Test
	public void testListTodos() throws Exception {
		webTestClient
				.get()
				.uri("/todos")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(5)
				.jsonPath("$[0]").isEqualTo(TODOS.get(0))
				.jsonPath("$[1]").isEqualTo(TODOS.get(1))
				.jsonPath("$[2]").isEqualTo(TODOS.get(2))
				.jsonPath("$[3]").isEqualTo(TODOS.get(3))
				.jsonPath("$[4]").isEqualTo(TODOS.get(4));
	}

}
