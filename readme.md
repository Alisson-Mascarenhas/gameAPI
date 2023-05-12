<h1 align="center"> Desafio da solos </h1>

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)

# Resumo do projeto
Projeto :construction: Projeto em construção :construction:
, sendo realizado por integrantes do time Scuba da Alura, visando a prática com a linguagem Java e os conceitos do paradigma de orientação a objetos.

## 🔨 Funcionalidades do projeto

- `Funcionalidade 1` `Cadastro, Atualização e Remoção de Games`: Nosso sistema precisa estar apto a cadastrar os games que o usuário desejar. Para cadastrar um game, devem ser informados o título, seu ano, seu score de 0 até 5.0, seu gênero, a URL da imagem dele, uma descrição curta e uma descrição longa. Todos os campos são obrigatórios.
- `Funcionalidade 2` `Cadastro, Atualização e Remoção de Listas`: O sistema precisa agrupar os games em categorias que chamamos de lista, para ela você pode dar o nome que quiser. Para o cadastro de uma categoria no sistema, é preciso informar obrigatoriamente seu nome.
- `Funcionalidade 3` `Associar um game a uma lista criada`: Para cadastrar um game na lista, precisamos informar seu id no path e o nome da lista que você desejá por parâmetro da url em uma requisição do tipo POST. Todos os campos são obrigatórios.
- `Funcionalidade 4` `Desassociar um game a uma lista criada`: Para remover um game da lista, precisamos informar seu id no path e o nome da lista que você desejá por parâmetro da url em uma requisição do tipo DELETE. Todos os campos são obrigatórios.

- ## 🔨 Lista de Endpoints: (https://gameapi-prod.up.railway.app/)
-  `Get:`
-  /games = Lista todos os games
-  /games/{id} = Mostra descrição completa de um game
-  /games/list/{id} = Mostra todos os games de uma lista
-  /lists = lista todas as listas
-  /lists/{id} = Mostra a lista de id

-  `Post:`
-  /lists = Insere uma nova lista. (Necessario: "nome").
-  /games = Insere umo novo game. (Necessario: "title", "year", "score"(0 a 5.0), "genre", "platforms", "imgUrl", "shortDescription", "longDescription").
-  /games/{id}/list = Insere um jogo já existente em uma lista existente. (Necessario: "gameId", "listName"(pelo body)).

-  `Put:`
-  /games/{id} = Atualiza um jogo passando o id dele na URl e as novas informações no body.
-  /lists/{id} = Atualiza uma lista passando o id dela e o novo nome no body.

-  `Delete:`
-  /lists/{id} = Deleta uma lista de id e todas os registros de beloging associados a ela.
-  /games/{id} = Deleta um game de id e todas os registros de beloging associados a ele.
-  /games/{id}/list = Deleta um jogo já existente de uma lista existente. (Necessario: "gameId", "listName"(pelo body)).

## ✔️ Técnicas e tecnologias utilizadas

- ``Java 17``
- ``Paradigma de orientação a objetos``
- ``Spring Tool Suite``
- ``H2 Database``
- ``PostgreSQL``
- ``Docker``
- ``Cloud (Railway)``


## 📁 Acesso ao projeto
Você pode acessar os arquivos do projeto clicando [aqui](https://github.com/Alisson-Mascarenhas/gameAPI/tree/main/src).
