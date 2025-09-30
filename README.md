<h1 align="center">📋 ToDo List</h1>

API para gerenciamento de tarefas.

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
## ⚙️ Como rodar o projeto localmente

### Pré-requisitos
- Java 21 
- Maven

### 1. Clone o repositório
``` bash

git clone https://github.com/Danimmota/to-do-list.git
```
- Vá na pasta em que clonou e abra o Git Bash ou entre no projeto via terminal com: `cd to-do-list`
- 💡 Dica: Use uma IDE como IntelliJ IDEA ou VSCode com a extensão Java para facilitar o desenvolvimento.

### 2. Configure o banco de dados

- Crie um banco de dados chamado `to_do_list`
- Atualize o arquivo `application.properties` com usuário, senha e URL do banco.

### 3. Compile e rode a aplicação
```
./mvnw spring-boot:run
```
### 4. Acesse o Swagger da aplicação 
```
http://localhost:8080/swagger-ui/index.html#/
```
---
## 👩‍💻 Autora

Desenvolvido por Daniela Mota 

📧 Email: danielamedeiromota@hotmail.com

[🔗 LinkedIn](https://www.linkedin.com/in/danielammota/)


