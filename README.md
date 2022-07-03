# Prova3
Projeto da Avaliação da Sprint 3 - Programa de Bolsas Compass.Uol

Seguem abaixo informações relevantes: 

  Como executar o projeto:
    - A classe Java responsável por executar o projeto é a EstadoApplication.java que está localizada no package compass.regioes da pasta do projeto src/main/java;
    
  Banco de Dados:
    - A API já é iniciada com 5 registros, que estão salvos no arquivo data.sql, na pasta src/main/sources da API;
    - O banco de dados utilziado na construção da API foi o H2;
  
  Documentação:
    - Há, na pasta Prova do GitHub o arquivo estadoseregioes.yaml, em formato .yaml, conforme solicitado na prova. Entretanto, visando o aprimoramento do projeto, tal arquivo foi convertido para JSON, renomeado como "estadoseregioes" e inserido na pasta do projeto src/main/webapp/file, a fim de permitir testes da documentação da aplicação diretamente pelo navegaor, usando o endereço http://localhost:8080/swagger/index.html no navegador;
    - Visando evitar erros de execução, para realizar o método Put no Swagger é necessário preencher os dados de TODOS OS CAMPOS do estado, ou seja, preenhcer com os novos dados os campos a serem alterados, e com os dados antigos os campos que serão mantidos, 
    
 Postman:
   
  Informações Gerais:
    - A API está configurada, por padrão, para executar os testes no seguinte endereço: http://localhost:8080/api/states;
    - A APi está configurada, por padrão, para exibir resultados por meio de paginação, e por default, traz 10 resultados da primeira página (página 0);
      
  Post:
    - Para realizar o cadastro de novos estados é preciso informar os seguintes campos:
    - nome(formato String);
    - regiao(formato String. Visando evitar erros na aplicação, informar as regiões com a escrita EXATAMENTE IGUAL descrito nesse item. O campo região só aceita as         opções: Norte, Nordeste, Sul, Sudeste ou Centro-Oeste.)
    - populacao(int);
    - capital(String);
    - area(int);
      
  Get:
    - Ao executar o Get no endereço http://localhost:8080/api/states o postman retorna todos os registros do banco de dados por ordem crescente de Id;
      
  Get(id):
    - Ao executar o Get(id) no endereço http://localhost:8080/api/states/"id" o postman retorna todos os registros do estado com o Id correspondente;
      
  Get - Filtro por Região:
    - Para realizar o filtro por região, no Get, basta, no final da Url inserir a região que deseja filtar.
    - Exemplo: filtrar estados da região Sudeste -> http://localhost:8080/api/states?regiao=Sudeste
      
  Get - Ordenar Estados com Maior População:
    - Para realizar a ordenação dos estados por população, do maior para o menor, basta informar esse filtro na Url.
    - Exemplo: filtrar todos os estados por populacao, da maior populacao para a menor populacao: -> http://localhost:8080/api/states?sort=populacao,desc
    
  Get - Ordenar Estados com Maior Área:
    - Para realizar a ordenação dos estados por área, da maior para a menor, basta informar esse filtro na Url.
    - Exemplo: filtrar todos os estados por populacao, da maior populacao para a menor populacao: -> http://localhost:8080/api/states?sort=area,desc
      
  Get - Paginação:
    - É possível realizar a paginação dos resultados informando o filtro na Url.
    - Exemplo: exibir 2 resultados da primeira página -> http://localhost:8080/api/states?page=0&size=2
      
  Get - Filtro por Mais de um Atributo
    - É possível realizar o filtro por mais de um atributo
    - Exemplo: filtrar a região de forma decrescente e a area de forma crescente -> http://localhost:8080/api/states?sort=regiao,desc&sort=area,asc
      
  Put - Alterando Dados
    - Para realizar a alteração de dados, é preciso preencher TODOS os dados do Estado, ou seja, preencher tanto o campo a ser alterado, com os novos dados, quanto os campos que ficaram mantidos, com os dados anteriores.
      
  Delete - Deletando Dados
    - Para deletar registros, basta informar o Id do estado que deseja alterar, na Url.
    - Exemplo: deletando o Estado de Id 1 -> http://localhost:8080/api/states/1
      
      
    
    
    
    



