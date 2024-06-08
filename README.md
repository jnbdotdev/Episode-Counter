# Episode-Counter

Este projeto foi criado para uso pessoal, com o objetivo de salvar informações sobre filmes, séries e animes.

## Índice

1. [Sobre](#sobre)
2. [Como Usar](#como-usar)
3. [Como Funciona](#como-funciona)
4. [Estrutura do Projeto](#estrutura-do-projeto)
5. [Tecnologias](#tecnologias)
6. [Contribuições](#contribuições)
7. [Licença](#licença)

## Sobre

O **Episode-Counter** é uma ferramenta feita em Java, com uma interface gráfica multi-telas que permite realizar todas as funções CRUD com integração ao banco de dados MySQL. O software permite salvar diversas opções como: Nome do conteúdo que está assistindo, em qual episódio e temporada está, status (assistindo, terminado ou pretende começar), situação do conteúdo (finalizado, em lançamento, etc.), entre outras.

## Como Usar

### 1. Pré-requisitos

- Java Development Kit (JDK)
- MySQL
- Biblioteca JDBC para MySQL

### 2. Instalação

1. Clone este repositório:
    ```bash
    git clone https://github.com/jnbdotdev/Episode-Counter.git
    ```
2. Navegue até o diretório do projeto:
    ```bash
    cd Episode-Counter
    ```
3. Configure o banco de dados MySQL com o script fornecido em `database/setup.sql`.

### 3. Uso

1. Compile e execute o projeto:
    ```bash
    javac -cp .:mysql-connector-java-8.0.23.jar Main.java
    java -cp .:mysql-connector-java-8.0.23.jar Main
    ```
2. Utilize a interface gráfica para gerenciar suas entradas de filmes, séries e animes.

## Como Funciona

### 1. Interface de Usuário

A interface gráfica foi construída em Java Swing. Ela permite que o usuário adicione novas entradas, visualize e atualize informações salvas.

#### Tela Principal

A tela principal, implementada na classe `ViewAnime.java`, possui as seguintes funcionalidades:

- **Listagem de Conteúdos**: Exibe uma tabela com todos os conteúdos cadastrados, permitindo a visualização rápida do progresso de cada um.
- **Adição de Conteúdo**: Formulário para adicionar novos filmes, séries ou animes, com campos para nome, episódio atual, temporada, status e situação.
- **Edição e Exclusão**: Opções para editar ou excluir conteúdos existentes diretamente na tabela.
- **Filtragem e Busca**: Ferramentas para filtrar a lista de conteúdos por diferentes critérios e buscar por nomes específicos.
- **Status e Situação**: Campos específicos para definir se o usuário está assistindo, terminou ou pretende começar um conteúdo, bem como se o conteúdo está finalizado ou em lançamento.

### 2. Armazenamento de Dados

Os dados são armazenados em um banco de dados MySQL, o que permite uma gestão eficiente e persistente das informações.

### 3. Funcionalidades

- Adicionar nova mídia (filme, série, anime).
- Atualizar o progresso (episódios assistidos, notas, etc.).
- Visualizar lista completa de mídias salvas.
- Filtros e buscas para encontrar rapidamente o que você está assistindo.
- Diferentes status para a mídia (assistindo, terminado, etc.).
- Situação da mídia (finalizado, em lançamento, etc.).

## Estrutura do Projeto

### 1. Classes Principais

#### `Anime.java`

Classe que representa a entidade Anime, com os seguintes atributos:
- `nome`
- `temporada`
- `episodio`
- `dtProxEp`
- `dtUltEp`
- `dtLanc`
- `statusAnime`
- `statusPessoal`
- `tipo`

#### `AnimeNIT.java`

Classe responsável pelas operações CRUD com o banco de dados:
- `create(Anime a)`: Adiciona um novo anime ao banco de dados.
- `alterar(Anime a)`: Altera os dados de um anime existente.
- `deletar(int codigo)`: Remove um anime do banco de dados.
- `listar()`: Retorna uma lista de todos os animes no banco de dados.

#### `ViewAnime.java`

Classe que implementa a interface gráfica e interage com o usuário, permitindo a gestão dos animes.

### 2. Conexão com o Banco de Dados

A classe `ConnectionFactory` gerencia a conexão com o banco de dados MySQL, fornecendo métodos para abrir e fechar conexões.

## Tecnologias

- **Java**: Linguagem principal utilizada no desenvolvimento.
- **Swing**: Biblioteca para a criação da interface gráfica.
- **MySQL**: Banco de dados para armazenamento das informações.
- **JDBC**: Conector para comunicação entre Java e MySQL.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
