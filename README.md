# 📋 TODO List Java (Terminal Edition)

Aplicação de gerenciamento de tarefas (to-do list) desenvolvida em **Java puro**, com persistência em **MySQL**, **Liquibase para migrations** e interface via **terminal**.

> Projeto inspirado no repositório [DIO Board CLI](https://github.com/digitalinnovationone/board), com boas práticas, design patterns e uma estrutura limpa e extensível.

---

## 🚀 Funcionalidades

- ✅ Criar tarefas
- ✅ Listar tarefas
- ✅ Concluir tarefas
- ✅ Remover tarefas
- ✅ Migrations automáticas via Liquibase
- ✅ Tarefas seed para testes
- ✅ Design em camadas com SOLID e padrões (DAO, DTO, Repository, Singleton, etc)

---

## 🧩 Estrutura do Projeto

```
src/main/
├── java/todolist
│   ├── application/        # Main e UI
│   ├── config/             # Configuração de conexão
│   ├── dao/                # DAO puro para acesso ao banco
│   ├── dto/                # Data Transfer Objects
│   ├── entity/             # Entidade Task
│   ├── exceptions/         # Exceções personalizadas
│   ├── migrations/         # Estratégia de execução do Liquibase
│   ├── repository/         # Repositório de abstração
│   └── service/            # Regras de negócio
└── resources/
    ├── application.properties   # Configuração do banco
    └── db/
        └── changelog/
            ├── db.changelog-master.yml
            └── sql/
                ├── V1__create_table_tasks.sql
                └── V2__seed_tasks.sql

```

---

## ⚙️ Tecnologias Utilizadas

- Java 17+
- JDBC (MySQL)
- Liquibase
- Maven

## 🧪 Pré-requisitos

- Arquivo `application.properties` configurado:

#### `src/main/resources/application.properties`

```properties
db.host=localhost
db.port=3306
db.name=todolist
db.user=seu_usuario
db.password=sua_senha
```
## 🏁 Como rodar

```bash
mvn clean compile exec:java
```

Na primeira execução:

* As migrations serão aplicadas automaticamente
* O banco será populado com tarefas de exemplo
* O menu será exibido no terminal

## 📋 TODO LIST MENU:

1. Criar tarefa
2. Listar tarefas
3. Concluir tarefa
4. Remover tarefa
0. Sair

## 🧠 Padrões aplicados

- **DAO**: Acesso direto ao banco via JDBC
- **DTO**: Transporte de dados entre camadas
- **Repository**: Abstração da persistência
- **Singleton**: Configuração de conexão
- **Facade**: Encapsulamento de operações de negócio (via *Service*)
- **Strategy (Liquibase)**: Execução configurável de migrations

## 🧼 Boas práticas

- Tratamento de exceções customizadas
- Separação clara de responsabilidades
- Projeto modular e escalável
- Arquitetura limpa
