<h1 align="center">TODO List</h1>

API para gerenciar tarefas (CRUD) que faz parte desse desafio para pessoas desenvolvedoras backend júnior, que se candidatam para a Simplify.


## 📚 Tecnologias Utilizadas

- Spring Boot
- Spring MVC
- Spring Data JPA
- SpringDoc OpenAPI 3
- Mysql

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
  $ http POST :8080/todos nome="Todo 1" descricao="Desc Todo 1" prioridade=1
  [
    {
    "descricao": "Desc Todo 1",
    "id": 1,
    "nome": "Todo 1",
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
    "descricao": "Desc Todo 1",
    "id": 1,
    "nome": "Todo 1",
    "prioridade": 1,
    "realizado": false
    }
  ]
  ```
    
  - Atualizar tarefas
  ```bash
  $ http PUT :8080/todos/1 nome="Todo 1 Up" descricao="Desc Todo 1 Up" prioridade=2
  [
    {
    "descricao": "Desc Todo 1 Up",
    "id": 1,
    "nome": "Todo 1 Up",
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

