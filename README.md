# 🎮 Jogo da Velha Multiplayer - Backend (Spring Boot)

Este é o **backend** do projeto *Jogo da Velha Multiplayer*, desenvolvido com **Java + Spring Boot**.  
O objetivo é permitir partidas em tempo real entre dois jogadores, com comunicação via **WebSocket** e persistência em banco de dados relacional.

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3+**
  - Spring Web (APIs REST)
  - Spring Data JPA (acesso ao banco)
  - Spring WebSocket (com STOMP)
- **Banco de Dados:** PostgreSQL *(pode usar H2 ou Oracle XE em desenvolvimento)*
- **Maven** (build e dependências)
- **Lombok** *(opcional, para reduzir boilerplate)*

---

## 🧱 Estrutura do Projeto

src/main/java/com/seuprojeto/jogodavelha <br>
├── config # Configurações (CORS, WebSocket) <br>
├── controller # Endpoints REST <br>
├── websocket # Comunicação em tempo real (STOMP) <br>
├── dto # Objetos de transferência de dados (PlayerRequest, MoveDTO, etc.) <br>
├── entity # Entidades do JPA (Game, Player) <br>
├── repository # Interfaces Spring Data JPA <br>
└── service # Regras de negócio <br>


---

## ⚙️ Pré-requisitos

Antes de iniciar, instale:
- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/) *(ou use H2 para testes)*

---

## ▶️ Como executar localmente

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/jogo-velha-backend.git
cd jogo-velha-backend

# Compile o projeto
mvn clean install

# Execute o backend
mvn spring-boot:run```

O backend rodará em:
👉 http://localhost:8080

| Método | Endpoint           | Descrição                              |
| ------ | ------------------ | -------------------------------------- |
| `POST` | `/games`           | Cria uma nova partida                  |
| `POST` | `/games/{id}/join` | Jogador entra em uma partida existente |
| `GET`  | `/games/{id}`      | Consulta o estado atual do jogo        |

🔌 WebSocket (STOMP)

Endpoint de conexão: /ws-game

Prefixo de envio: /app

Tópico de inscrição: /topic/game/{id}

Exemplo:

Enviar jogada: stompClient.send('/app/move', {}, JSON.stringify(move));

Receber atualizações: stompClient.subscribe('/topic/game/1', ...)

💾 Banco de Dados

O backend utiliza Spring Data JPA, e pode ser configurado via application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/jogodavelha
spring.datasource.username=postgres
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update

📎 Frontend do projeto

👉 Repositório Frontend (React + TypeScript)

## 📜 Licença

Este projeto está sob a licença MIT — sinta-se livre para usar e modificar.

## ✨ Autor

Seu Nome

Desenvolvedor Java | Spring Boot | React | TypeScript
  LinkedIn
 · GitHub
