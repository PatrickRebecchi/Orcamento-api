API de Orçamento de Veículos

API REST desenvolvida com Java e Spring Boot para gerenciamento de clientes, veículos e orçamentos de serviços automotivos.

O objetivo do projeto é praticar conceitos de desenvolvimento backend como arquitetura em camadas, criação de APIs REST, persistência de dados com JPA/Hibernate e boas práticas no desenvolvimento de aplicações Java.

🚀 Tecnologias utilizadas

Java

Spring Boot

Spring Data JPA

Hibernate

Maven

Jakarta Validation

📂 Estrutura do projeto

O projeto segue uma arquitetura em camadas:

controller  → recebe as requisições HTTP
service     → contém a lógica de negócio
repository  → acesso ao banco de dados
entity      → entidades do sistema
dto         → objetos de transferência de dados
exception   → tratamento de erros da aplicação
📌 Funcionalidades
Clientes

Cadastrar cliente

Listar clientes

Atualizar dados do cliente

Deletar cliente

Veículos

Cadastrar veículo

Listar veículos

Relacionar veículo com cliente

Validação para impedir cadastro de placa duplicada

🔗 Relacionamento entre entidades

Um cliente pode possuir vários veículos.

Cliente 1 ──── N Veículos
📬 Exemplos de endpoints
Criar cliente

POST /clientes

{
  "nome": "Patrick",
  "telefone": "119999999",
  "email": "patrick@email.com"
}
Criar veículo

POST /veiculos

{
  "modelo": "Civic",
  "placa": "ABC1234",
  "clienteId": 1
}
Listar veículos

GET /veiculos

📚 Objetivo do projeto

Este projeto foi desenvolvido com fins de estudo para aprimorar conhecimentos em:

Desenvolvimento de APIs REST com Spring Boot

Uso de JPA/Hibernate para persistência de dados

Organização de projetos backend

Boas práticas de arquitetura em aplicações Java

👨‍💻 Autor

Patrick Rebecchi
