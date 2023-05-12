<h1 align="center"> Desafio da solos </h1>

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)

# Resumo do projeto
:construction: Projeto em construção :construction:, sendo realizado por mim(Alisson Mascarenhas), visando a prática com a linguagem Java, conhecimentos de ORM, um pouco de arquitetura e usabilidade da framework SpringBoot. Consiste em uma API de jogos onde além disso você pode categorizar eles.

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

# 📁 Acesso ao projeto

Você pode acessar os arquivos do projeto clicando [aqui](https://github.com/Alisson-Mascarenhas/gameAPI/tree/main/src).

# 🛠️ Abrir e rodar o projeto

Open an Existing Project (ou alguma opção similar)
Procure o local onde o projeto está e o selecione (Caso o projeto seja baixado via zip, é necessário extraí-lo antes de procurá-lo)
Por fim clique em OK

Após isso, é necessário ir até [aplication.properties"](https://github.com/Alisson-Mascarenhas/gameAPI/blob/main/src/main/resources/application.properties) e alterar APP_PROFILE:prod para APP_PROFILE:test.
Feito isso o projeto irá rodar localmente na sua máquina podendo ser acessado via localhost:8080

# Autores

| [<img src="https://avatars.githubusercontent.com/u/37356058?v=4" width=115><br><sub>Alisson Mascarenhas</sub>](https://github.com/Alisson-Mascarenhas) | :---: | :---: | :---: |
