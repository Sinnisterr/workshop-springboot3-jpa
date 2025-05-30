# 🛒 E-commerce API - Spring Boot

> **Projeto de estudos desenvolvido durante o curso da DevSuperior**

Uma API REST completa para sistema de e-commerce, desenvolvida com Spring Boot, demonstrando conceitos fundamentais de desenvolvimento backend, persistência de dados e arquitetura em camadas.

## 📋 Sobre o Projeto

Este projeto implementa um sistema de e-commerce com funcionalidades essenciais como gestão de usuários, produtos, categorias, pedidos e pagamentos. Foi desenvolvido com foco no aprendizado de tecnologias Java e Spring Framework.

### ✨ Funcionalidades

- 👥 **Gestão de Usuários** - CRUD completo (Create, Read, Update, Delete)
- 📦 **Catálogo de Produtos** - Listagem e consulta de produtos
- 🏷️ **Categorias** - Organização de produtos por categorias
- 🛍️ **Pedidos** - Sistema completo de pedidos com itens
- 💳 **Pagamentos** - Associação de pagamentos aos pedidos
- 🔗 **Relacionamentos JPA** - Demonstração de associações entre entidades

## 🛠️ Tecnologias Utilizadas

- **Java 17** - Linguagem de programação
- **Spring Boot 3.x** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Hibernate** - ORM (Object-Relational Mapping)
- **H2 Database** - Banco de dados em memória (perfil de teste)
- **Maven** - Gerenciamento de dependências
- **Jackson** - Serialização/Deserialização JSON

## 🏗️ Arquitetura

O projeto segue o padrão de arquitetura em camadas:

```
📁 src/main/java/com/educandoweb/course/
├── 📁 config/          # Configurações da aplicação
├── 📁 entities/        # Entidades JPA
│   ├── 📁 enums/      # Enumerações
│   └── 📁 pk/         # Chaves primárias compostas
├── 📁 repositories/    # Camada de acesso aos dados
├── 📁 resources/       # Controllers REST
│   └── 📁 exceptions/ # Tratamento de exceções
└── 📁 services/        # Regras de negócio
    └── 📁 exceptions/ # Exceções customizadas
```

## 📊 Modelo de Dados

### Entidades Principais

- **User** - Usuários do sistema
- **Order** - Pedidos realizados
- **Product** - Produtos disponíveis
- **Category** - Categorias de produtos
- **OrderItem** - Itens dos pedidos
- **Payment** - Pagamentos dos pedidos

### Relacionamentos

- `User` 1:N `Order` - Um usuário pode ter vários pedidos
- `Order` N:M `Product` - Relacionamento através de `OrderItem`
- `Product` N:M `Category` - Um produto pode ter várias categorias
- `Order` 1:1 `Payment` - Cada pedido tem um pagamento

## 🚀 Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- IDE de sua preferência (Eclipse, IntelliJ, VS Code)

### Passos para execução

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. **Execute a aplicação**
   ```bash
   mvn spring-boot:run
   ```

3. **Acesse a API**
   - Base URL: `http://localhost:8080`
   - Console H2: `http://localhost:8080/h2-console`

## 📋 Endpoints da API

### Usuários
- `GET /users` - Listar todos os usuários
- `GET /users/{id}` - Buscar usuário por ID
- `POST /users` - Criar novo usuário
- `PUT /users/{id}` - Atualizar usuário
- `DELETE /users/{id}` - Deletar usuário

### Produtos
- `GET /products` - Listar todos os produtos
- `GET /products/{id}` - Buscar produto por ID

### Categorias
- `GET /categories` - Listar todas as categorias
- `GET /categories/{id}` - Buscar categoria por ID

### Pedidos
- `GET /orders` - Listar todos os pedidos
- `GET /orders/{id}` - Buscar pedido por ID

## 🧪 Dados de Teste

A aplicação inclui dados de teste pré-configurados através da classe `TestConfig`:

- **Usuários**: Maria Brown, Alex Green
- **Produtos**: The Lord of the Rings, Smart TV, Macbook Pro, PC Gamer, Rails for Dummies
- **Categorias**: Electronics, Books, Computers
- **Pedidos**: Com diferentes status e itens associados

## 📝 Exemplos de Uso

### Buscar todos os usuários
```bash
curl -X GET http://localhost:8080/users
```

### Criar um novo usuário
```bash
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João Silva",
    "email": "joao@email.com",
    "phone": "11999999999",
    "password": "123456"
  }'
```

### Buscar pedidos
```bash
curl -X GET http://localhost:8080/orders
```

## 🎯 Conceitos Aprendidos

- **Spring Boot** - Configuração e estruturação de projetos
- **JPA/Hibernate** - Mapeamento objeto-relacional
- **REST API** - Desenvolvimento de APIs RESTful
- **Relacionamentos JPA** - OneToMany, ManyToOne, ManyToMany, OneToOne
- **Tratamento de Exceções** - Exception handling personalizado
- **Padrão Repository** - Camada de acesso aos dados
- **Injeção de Dependência** - Inversão de controle
- **Profiles Spring** - Configurações por ambiente

## 🚧 Melhorias Futuras

- [ ] Implementar autenticação JWT
- [ ] Adicionar validações de entrada
- [ ] Incluir testes unitários
- [ ] Documentação com Swagger/OpenAPI
- [ ] Implementar paginação
- [ ] Adicionar logs estruturados
- [ ] Deploy em ambiente cloud

## 👤 Autor

Willian Bruno
- GitHub: https://github.com/Sinnisterr
- LinkedIn: https://www.linkedin.com/in/willian-bruno-28924082/

## 🙏 Agradecimentos

- [DevSuperior](https://devsuperior.com.br/) pelo excelente curso
- Professor Nelio Alves pela didática excepcional
- Comunidade Spring Boot pela documentação

---

⭐ **Se este projeto te ajudou, deixe uma estrela!** ⭐