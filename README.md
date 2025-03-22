# Tech Challenge - Backend (Fase 1)

Este projeto é parte do Tech Challenge da Fase 1 da Pós-Tech, responsável por implementar o backend do sistema de gestão de usuários para restaurantes.

## 🛠 Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker e Docker Compose
- Lombok
- Maven

## 🚀 Como Rodar o Projeto

### Pré-requisitos
- Docker e Docker Compose instalados

### Passos
1. Clone o repositório ou extraia o `.zip`
2. Navegue até o diretório do projeto
3. Rode o comando:
   ```bash
   docker-compose up --build
   ```
4. A aplicação estará disponível em `http://localhost:8080`

Banco de dados PostgreSQL estará disponível em `localhost:5432`, com:
- **Usuário**: postgres
- **Senha**: postgres
- **Database**: tech_challenge

---

## 📦 Endpoints Disponíveis

### Criar Usuário
```
POST /api/users
```
Body:
```json
{
  "nome": "João",
  "email": "joao@email.com",
  "login": "joaologin",
  "senha": "123456",
  "endereco": "Rua A",
  "tipoUsuario": "CLIENTE"
}
```

### Buscar por login
```
GET /api/users/{login}
```

### Atualizar usuário
```
PUT /api/users/{id}
```
Body: (igual ao de criação)

### Deletar usuário
```
DELETE /api/users/{id}
```

### Validar login
```
POST /api/users/validate
```
```json
{
  "login": "joaologin",
  "senha": "123456"
}
```

### Trocar senha
```
POST /api/users/change-password
```
```json
{
  "login": "joaologin",
  "oldPassword": "123456",
  "newPassword": "novaSenha123"
}
```

---

## ✅ Requisitos Atendidos
- CRUD completo de usuários
- Campo obrigatório de tipo de usuário (CLIENTE ou DONO_RESTAURANTE)
- Validação de login e troca de senha com segurança
- Senhas criptografadas com BCrypt
- Docker Compose com banco PostgreSQL
- Estrutura com boas práticas (DTOs, Services, Controllers, Validations)

---

## 📬 Collection do Postman
Uma collection está disponível na pasta `/postman` com exemplos de testes prontos para os endpoints.

---

Desenvolvido para fins acadêmicos - Pós-Tech.
