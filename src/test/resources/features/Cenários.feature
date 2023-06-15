#language: pt

  @todos
  Funcionalidade: teste da API

    @CN001
    Cenario: CN001 - Validar a saude da aplicacao
      Quando envio um request GET /test
      Entao valido GET /test que o status code retorna 200

    @CN002
    Cenario: CN002 - Validar a consulta de usuarios sem parâmetro.
      Quando envio um request GET /users
      Entao valido que GET /users retorna a lista de usuario com sucesso.
      E que a lista nao esta vazia.

    @CN003
    Cenario: CN003 - Validar a criação de token para autenticação.
      Quando envio um post /auth/login com o "kminchelle" e "0lelplR"
      Entao valido que o token foi obtido com sucesso.

    @CN004
    Cenario: CN004 - Validar a busca de produtos com autenticação
      Quando envio um post /auth/login com o "kminchelle" e "0lelplR"
      E envio um request GET /auth/products
      Entao valido que a busca de produtos com autenticação foi realizada com sucesso.

    @CN005
    Cenario: CN005 - Validar a busca de produtos sem autenticação
      Quando envio um request GET /auth/products
      Entao valido que a busca de produtos sem autenticação não foi realizada com sucesso.

    @CN006
    Cenario: CN006 - Validar a busca de produtos com problema na autenticação.
      Quando envio um request GET /auth/products/sem_token
      Entao valido que a busca de produtos não foi realizada com sucesso por problema na autencicação.

    @CN007
    Cenario: CN007 - validar a criação de produto
      Quando envio um Post /products/add com arquivo json
      Entao valido que o produto foi adicionado com sucesso.

    @CN008
    Cenario: CN008 - Validar a busca todos os produtos
      Quando envio um request GET /products
      Entao valido que a busca de todos os produtos foi realizada com sucesso.

    @CN009
    Cenario: CN009 - Validar a busca de apenas um produto por id
      Quando envio um request GET /products/1
      Entao valido que a busca foi realizada com sucesso

    @CN010
    Cenario: CN010 - Validar a busca de apenas um produto por id que não existe
      Quando envio um request GET /products/102
      Entao valido que a busca não foi realizada com sucesso


