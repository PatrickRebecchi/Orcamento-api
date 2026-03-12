# 🚗 Orcamento API

API REST desenvolvida em Java com Spring Boot para gerenciamento de orçamentos de veículos em uma oficina.

O objetivo deste projeto é praticar conceitos de desenvolvimento backend, arquitetura em camadas e boas práticas na construção de APIs REST.

---

## 🛠 Tecnologias utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- Bean Validation
- JUnit / Mockito
- Maven

---

## 📂 Estrutura do projeto

O projeto segue uma arquitetura em camadas:

controller → responsável por receber as requisições HTTP
service → contém as regras de negócio da aplicação
repository → responsável pelo acesso ao banco de dados
dto → objetos de transferência de dados
entity → entidades do sistema
exception → tratamento de erros da aplicação

---

## ⚙️ Funcionalidades

A API permite:

- Cadastro de clientes
- Cadastro de veículos
- Criação de orçamentos
- Atualização de dados
- Consulta de registros
- Remoção de registros

Também possui:

- Validação de dados com Bean Validation
- Tratamento de exceções
- Regras de negócio na camada service
- Testes unitários

---

## 📌 Exemplos de endpoints

### Clientes

POST /clientes
GET /clientes
GET /clientes/{id}
PUT /clientes/{id}
DELETE /clientes/{id}

### Veículos

POST /veiculos
GET /veiculos
GET /veiculos/{id}

### Orçamentos

POST /orcamentos
GET /orcamentos
GET /orcamentos/{id}

---

## 🧪 Testes

O projeto possui testes unitários utilizando:

- JUnit
- Mockito

Os testes garantem o funcionamento das regras de negócio da aplicação.

---

## 🎯 Objetivo do projeto

Este projeto foi desenvolvido com o objetivo de aprofundar conhecimentos em:

- APIs REST
- Spring Boot
- Arquitetura backend
- Boas práticas no desenvolvimento de software

---

## 👨‍💻 Autor

Patrick Rebecchi

GitHub:
https://github.com/PatrickRebecc
