<h1 align="center">📋 ToDo List</h1>

API para gerenciar tarefas (CRUD).

## ⚙️ Tecnologias Utilizadas

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/)
- [Mysql](https://dev.mysql.com/downloads/)

## 📚 Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## 🔎 Endpoints

- O Swagger poderá ser visualizado em localhost:8080/swagger-ui.html
- Para fazer as requisições HTTP abaixo, foi utilizada o próprio Swagger:

  - Criar tarefa
  ```bash
  $ http POST :8080/todos nome="ToDo" descricao="Desc ToDo" prioridade=1
  [
    {
    "descricao": "Desc ToDo",
    "id": 1,
    "nome": "ToDo",
    "prioridade": 1,
    "realizado": false
    }
  ]
  ```
  - Listar tarefas
  ```bash
  $ http GET :8080/todos
  [
    {
    "descricao": "Desc ToDo",
    "id": 1,
    "nome": "ToDo",
    "prioridade": 1,
    "realizado": false
    }
  ]
  ```
    
  - Atualizar tarefas
  ```bash
  $ http PUT :8080/todos/1 nome="ToDo Up" descricao="Desc ToDo Up" prioridade=2
  [
    {
    "descricao": "Desc ToDo Up",
    "id": 1,
    "nome": "ToDo Up",
    "prioridade": 2,
    "realizado": false
    }
  ]
  ```
  - Remover tarefas
  ```bash
  http DELETE :8080/todos/1
  
  [ ]
  ```

