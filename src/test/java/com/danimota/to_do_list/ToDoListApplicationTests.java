package com.danimota.to_do_list;

import com.danimota.to_do_list.dto.ToDoDTO;
import com.danimota.to_do_list.entity.ToDo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.danimota.to_do_list.TestConstants.TODO;
import static com.danimota.to_do_list.TestConstants.TODOS;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql("/remove.sql")
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
				.expectStatus().isCreated()
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
						new ToDoDTO("", "", false, 0))
				.exchange()
				.expectStatus().isBadRequest()
				.expectBody()
				.jsonPath("$.nome").isEqualTo("Nome é obrigatório")
				.jsonPath("$.descricao").isEqualTo("Descrição é obrigatória")
				.jsonPath("$.prioridade").isEqualTo("Prioridade deve ser >= 1");
	}

	@Sql("/import.sql")
	@Test
	public void testUpdateTodoSuccess() {
		var todo = new ToDoDTO(TODO.getNome(), TODO.getDescricao(), !TODO.isRealizado(),
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
				.jsonPath("$[0].nome").isEqualTo(todo.nome())
				.jsonPath("$[0].descricao").isEqualTo(todo.descricao())
				.jsonPath("$[0].realizado").isEqualTo(todo.realizado())
				.jsonPath("$[0].prioridade").isEqualTo(todo.prioridade());
	}

	@Test
	public void testUpdateTodoFailure() {
		var unexinstingId = 1L;

		webTestClient
				.put()
				.uri("/todos/" + unexinstingId)
				.bodyValue(
						new ToDoDTO("", "", false, 1))
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Sql("/import.sql")
	@Test
	public void testDeleteTodoSuccess() {
		webTestClient
				.delete()
				.uri("/todos/" + TODOS.get(1).getId())
				.exchange()
				.expectStatus().isNoContent()
				.expectBody().isEmpty();
	}

	@Test
	public void testDeleteTodoFailure() {
		var unexinstingId = 1L;

		webTestClient
				.delete()
				.uri("/todos/" + unexinstingId)
				.exchange()
				.expectStatus().isBadRequest()
				.expectBody()
				.jsonPath("$.erro").isEqualTo("ToDo %d não existe! ".formatted(unexinstingId));
	}
	@Sql(scripts = "/import.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
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
				.jsonPath("$[0].nome").isEqualTo(TODOS.get(0).getNome())
				.jsonPath("$[0].descricao").isEqualTo(TODOS.get(0).getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(TODOS.get(0).isRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(TODOS.get(0).getPrioridade());
	}

}
