# Connect-Now

---

Api Backend para a rede social Connect Now(Parrot Sysmap),na construção desta api utilizamos:

Spring Boot: Framework Java de código aberto para a criação de Microsserviços.

Swagger: Documentação da Api(Rest API), para acessar a API Rode o Seu docker e o projeto e se conecte ao seguinte endereço.




Apache Kafka: Processamento de Fluxo de dados(Mensageria).

---

## Funcionalidades

- Criação de usuário
- Geração de Tokens
- Serviço de Mensageria
- Comunicação backend for frontend(Conceito BFF)

# Rodando localmente
para rodar a aplicaçao dentro do docker container execute o seguinte comando:
```bash
cd backend
docker compose up -d
```

Caso a validação de algum erro(e vai ocorrer),  Comente a classe Authenticate Filter remova a validação crie um container mongodb com o seguinte comando.
```bash
docker run --name demo_mongo -d mongo:latest
```
Apos a realização deste procedimento se conect com o swagger.


## Swagger
Estamos utilizando o Swagger para fazermos a documentação da nossa API, para acessar o swagger acesse o seguinte endereço web:
```bash
  http://localhost:8082/swagger-ui/swagger-ui/index.html
```
![Captura de tela de 2023-05-03 18-33-08](https://user-images.githubusercontent.com/78994881/236108455-ac923b5d-3f32-4c23-bac5-683a5ca8453a.png)
![Captura de tela de 2023-05-03 18-35-35](https://user-images.githubusercontent.com/78994881/236108451-878a101f-3df7-4ff8-a255-4399b3b7db1d.png)

## Apache Kafka

Conectando o sistema com o apache kafka utilizando a ferramenta Offset explorer para a visualização de dados em um ambiente gráfico:

Para consumir este serviço criamos a classe:

EventService.java

# Criando um producer:

```
 @Autowired
    private KafkaTemplate<String, String> kafka;
    @Value("${topic.name}")
    private String topic;
    public void send(String event) {
        kafka.send(topic, event);
    }
```



# Criando um consumer

```
 @KafkaListener(topics = "${topic.name}", groupId = "ms-demo")
    public void consumer(ConsumerRecord<String, String> event) {
           System.out.print("Event consumed: " + event.value());
    }
```

# Exemplo de consumer usando o Kafka tool:


![Captura de tela de 2023-05-02 21-55-30](https://user-images.githubusercontent.com/78994881/235984680-075c76c6-d6da-4ac7-9a27-7f9937eae5cd.png)
![Captura de tela de 2023-05-02 22-31-30](https://user-images.githubusercontent.com/78994881/235984683-23080fdf-485a-48ee-9ffe-bce3c2fbdd3a.png)

# JWT 
Para a geração de tokens para nossos usuários estamos usando o JWT.


![Captura de tela de 2023-05-04 00-49-16](https://user-images.githubusercontent.com/78994881/236108943-836aafc0-7256-46b6-8459-622f3b5123d1.png)

## Referência

- [spring-boot: casadocodigo](https://www.casadocodigo.com.br/products/livro-spring-boot?_pos=2&_sid=6afcf6f89&_ss=r)
- [apache Kafka:  casadocodigo](https://www.casadocodigo.com.br/products/livro-apache-kafka?_pos=3&_sid=6afcf6f89&_ss=r)

## Rodando os testes

Os testes e a imagem do docker(docker pull) irei subir entre sábado e domingo

```bash
  ------
  Docker compose up
  ----
```

## Documentação da API

---

Construindo as rotas da api

---

#### Retorna todos o usuário pelo ID

```http
  @GetMapping("/{id}")
```

| Parâmetro                                 | Tipo       | Descrição                           |
| :----------------------------------------- | :--------- | :------------------------------------ |
| `http://localhost:8082/api/v1/user/{id}` | `string` | **Obrigatório ID do Usuario**. |

#### Cadastara um usuario no banco de dados

```http
  GET 
```

| Parâmetro                                   | Tipo       | Descrição |
| :------------------------------------------- | :--------- | :---------- |
| `http://localhost:8082/api/v1/user/create` | `string` | ** **.      |

## Autores

- [@benetesla](https://github.com/benetesla)

## Licença

[MIT](https://choosealicense.com/licenses/mit/)

## Stack utilizada

**Back-end:** ![Spring_Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)
![Apache-Kafka](https://img.shields.io/badge/Apache_Kafka-231F20?style=for-the-badge&logo=apache-kafka&logoColor=white)
![docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white)
