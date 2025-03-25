# Tech Challenge Backend - Fase 2

Projeto desenvolvido por **Paulo Vinicius de Souza Martinez** para o programa de pós-graduação em Engenharia de Software com Foco em Backend - FIAP.

## 📚 Descrição

Backend desenvolvido com **Spring Boot** que fornece uma API RESTful para gerenciar usuários, restaurantes, cardápios e tipos de usuários. Projeto com foco em boas práticas de arquitetura (Clean Architecture), testes automatizados e documentação.

## 📥 Link para Download

O código-fonte completo do projeto está disponível no GitHub:  
🔗 [https://github.com/PauloVinic/tech-challenge](https://github.com/PauloVinic/tech-challenge)

Você pode cloná-lo com:
```bash
git clone https://github.com/PauloVinic/tech-challenge.git
```

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.4
- JUnit 5 + Mockito
- Maven
- PostgreSQL (via Docker Compose)
- JaCoCo (relatórios de cobertura)
- Swagger/OpenAPI
- Docker/Docker Compose

## 📁 Estrutura do Projeto

```
tech_challenge_backend/
├── src/
│   ├── main/
│   │   ├── java/com/techchallenge/tech_challenge_backend/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── dto/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── config/
│   └── test/
│       └── java/com/techchallenge/tech_challenge_backend/
│           ├── controller/
│           └── service/
├── docker-compose.yml
└── pom.xml
```

## 🧪 Testes Automatizados

- **Testes Unitários**: Cobrem os services e parte dos controllers.
- **Testes de Integração**: Validam o comportamento dos endpoints com `@WebMvcTest` e `MockMvc`.
- **Cobertura de Código (JaCoCo)**: 83% de cobertura geral, com destaque para os controllers e services.

### Gerar e visualizar relatório de cobertura:

```bash
./mvnw clean verify
```

Abra o relatório em:

```bash
target/site/jacoco/index.html
```

## 📦 Como Executar

### Pré-requisitos

- Java 21+
- Docker + Docker Compose
- Maven Wrapper (`./mvnw` incluído no projeto)

### Subir o Banco de Dados:

```bash
docker-compose up -d
```

### Rodar o Projeto

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## 🔎 Documentação da API

Após iniciar o projeto, acesse:

```
http://localhost:8080/swagger-ui/index.html
```

## 📬 Exemplos de Requisições (funcionais e independentes)

### 1. Criar Tipo de Usuário
**POST** `/api/tipos-usuario`
```json
{
  "nomeTipo": "CLIENTE"
}
```

### 2. Criar Usuário
**POST** `/api/users`
```json
{
  "nome": "João",
  "email": "joao@email.com",
  "login": "joao123",
  "senha": "senha123",
  "endereco": "Rua A",
  "tipoUsuario": { "id": 1 }
}
```

### 3. Login do Usuário
**POST** `/api/users/validate`
```json
{
  "login": "joao123",
  "senha": "senha123"
}
```

## ✅ Requisitos Atendidos

- [x] Testes unitários com cobertura superior a 80%
- [x] Testes de integração para controllers
- [x] Documentação Swagger
- [x] Banco de dados via Docker Compose
- [x] Clean Architecture aplicada
- [x] API REST funcional com CRUDs de entidades principais

---

© 2025 - Paulo Vinicius de Souza Martinez