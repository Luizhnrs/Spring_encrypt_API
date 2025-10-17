
# 🔐 Spring_encrypt_API

API desenvolvida em **Java 21** com **Spring Boot 3.5.6** para estudo e aplicação de **criptografia e segurança de dados em banco de dados** utilizando a biblioteca **Jasypt (Java Simplified Encryption)**.  
O objetivo é proteger informações sensíveis de forma transparente para a aplicação e as camadas de serviço.

---

## 🧩 Sumário
- [Descrição](#-descrição)
- [Tecnologias utilizadas](#-tecnologias-utilizadas)
- [Arquitetura](#-arquitetura)
- [Configuração do ambiente](#-configuração-do-ambiente)
- [Execução do projeto](#-execução-do-projeto)
- [Endpoints da API](#-endpoints-da-api)
- [Segurança e Criptografia](#-segurança-e-criptografia)
- [Melhorias Futuras](#-melhorias-futuras)
- [Autor](#-autor)
- [Licença](#-licença)

---

## 📘 Descrição

O **Spring_encrypt_API** é uma API REST desenvolvida com **arquitetura limpa** e foco em **segurança de dados**.  
O projeto implementa criptografia utilizando **Jasypt**, permitindo que campos sensíveis sejam criptografados antes de serem persistidos no banco de dados, e descriptografados automaticamente quando lidos pela aplicação.

---

## 🛠 Tecnologias utilizadas

- **Java 21**
- **Spring Boot 3.5.6**
- **Spring Web**
- **Spring Data JPA**
- **MySQL Driver**
- **Maven**
- **Docker**
- **Jasypt** (Java Simplified Encryption)
- **Beekeeper Studio** (para consultas no banco)

---

## 🧱 Arquitetura

O projeto segue os princípios da **Clean Architecture**, garantindo separação de responsabilidades e fácil manutenção.

````
src/
├── main/
│ ├── java/com/example/crypto/
│ │ ├── entities/ 
│ │ ├── service/ 
│ │ ├── repository/
│ │ ├── controller/
│ │ ├────── dtos/
│ └── resources/
│ └── application.yml
└── test/ # Testes unitários e de integração
````


---

## ⚙️ Configuração do ambiente

### 1. Banco de Dados (Docker Compose)

Crie um arquivo `docker-compose.yml` na raiz do projeto com o seguinte conteúdo:

```yaml
services:
  mysql:
    image: mysql
    ports:
      - "3306:3306"
    expose:
      - "3306"
    environment:
      - MYSQL_USER=admin
      - MYSQL_PASSWORD=123
      - MYSQL_DATABASE=cryptodb
      - MYSQL_ROOT_PASSWORD=123

Execute:
docker-compose up -d

```
### 🚀 Execução do projeto
Passos:

# Clonar o repositório
git clone https://github.com/SEU_USUARIO/Spring_encrypt_API.git

# Entrar na pasta
cd Spring_encrypt_API

# Rodar o banco de dados
docker-compose up -d

# Rodar o projeto
mvn spring-boot:run

## A aplicação será iniciada em:
```

http://localhost:8080

````

### 📡 Endpoints da API
````
|   Método   |         Rota        | Descrição               |
| :--------: | :-----------------: | :---------------------- |
|  **POST**  |    `/transaction`   | Cria uma nova transação |
|   **GET**  | `/transaction/{id}` | Busca transação por ID  |
|   **PUT**  | `/transaction/{id}` | Atualiza uma transação  |
| **DELETE** | `/transaction/{id}` | Remove uma transação    |
````

##Exemplo de requisição:
Os campos sensíveis como creditCardToken, são criptografados automaticamente antes de serem salvos no banco.
````
POST /transaction
{
  "id": 1,
  "userDocument": "123",
  "creditCardToken": "424141"
  "value": 500.00
}

Os campos sensíveis como creditCardToken, são criptografados automaticamente antes de serem salvos no banco.

````

#🔒 Segurança e Criptografia

A aplicação utiliza Jasypt (Java Simplified Encryption) para criptografia de dados sensíveis.


# 👤 Autor

Luiz Henrique Silva
Analista de Email Marketing e Desenvolvedor Backend em formação
Focado em unir marketing e tecnologia para criar soluções seguras e escaláveis.

LinkedIn

GitHub


