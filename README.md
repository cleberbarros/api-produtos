# API- Gerenciador de Produtos

Este recurso permite o cadastro de Produtos e Categorias

**Path:**  `/api-produtos/`

**Status Code:**

| Status | Descrição |
| :---: | :---| 
| 200 |  OK
| 400 |  Bad Request |
| 404 |  Not Found|
| 422 |  Erros genéricos Dock|
***
**CATEGORIA**

**Request Criar**

```shell script
curl --location --request POST 'http://localhost:8080/api-produtos/categoria/criar' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome" : "Cama e Mesa",
    "situacao" :"ATIVO"
}'
```
**Response Criar**

```json
{
  "id": 79,
  "nome": "Cama e Mesa",
  "situacao": "ATIVO"
}
```
**Request Alterar**

```shell script
curl --location --request PUT 'http://localhost:8080/api-produtos/categoria/alterar' \
--header 'Content-Type: application/json' \
--data-raw '{
  "id": 79,
  "nome": "Cama,Mesa e Banho",
  "situacao": "ATIVO"
}'
```
**Response Alterar**

```json
{
  "id": 79,
  "nome": "Cama,Mesa e Banho",
  "situacao": "ATIVO"
}
```

**Request Listar**

```shell script
curl --location --request GET 'http://localhost:8080/api-produtos/categoria/listar'
```
**Response Listar**

```json
[
    {
      "id": 1,
      "nome": "Limpeza",
      "situacao": "ATIVO"
    },
   {
    "id": 79,
    "nome": "Cama,Mesa e Banho",
    "situacao": "ATIVO"
  }
]
```
**Request Listar por Nome**

```shell script
curl --location --request GET 'http://localhost:8080/api-produtos/categoria/listar/nome/limpeza'
```
**Response Listar**

```json
[
  {
    "id": 1,
    "nome": "Limpeza",
    "situacao": "ATIVO"
  }
]
```

***
**PRODUTO**

**Request Criar**

```shell script
curl --location --request POST 'http://localhost:8080/api-produtos/produto/criar' \
--header 'Content-Type: application/json' \
--data-raw '{
  "nome": "Cobertores casal",
  "descricao": "Cobertores para Casal tamanho G",
  "preco": 88.80,
  "situacao": "ATIVO",
  "validade": "2024-12-31",
  "codigoBarra": "123456789",
  "referencia": "REF123",
  "categoriaId": 79
}'
```
**Response Criar**

```json
{
  "id": 81,
  "nome": "Cobertores casal",
  "descricao": "Cobertores para Casal tamanho G",
  "preco": 88.80,
  "situacao": "ATIVO",
  "validade": "2024-12-31",
  "codigoBarra": "123456789",
  "referencia": "REF123",
  "categoria": {
    "id": 79,
    "nome": "Cama,Mesa e Banho",
    "situacao": "ATIVO"
  }
}
```
**Request Alterar**

```shell script
curl --location --request PUT 'http://localhost:8080/api-produtos/produto/alterar' \
--header 'Content-Type: application/json' \
--data-raw '{
  "id": 81,
  "nome": "Cobertores casal",
  "descricao": "Cobertores para Casal tamanho GG",
  "preco": 110.50,
  "situacao": "ATIVO",
  "validade": "2024-12-31",
  "codigoBarra": "123456789",
  "referencia": "REF123",
  "categoriaId": 40
}'
```
**Response Alterar**

```json
{
  "id": 81,
  "nome": "Cobertores casal",
  "descricao": "Cobertores para Casal tamanho GG",
  "preco": 110.50,
  "situacao": "ATIVO",
  "validade": "2024-12-31",
  "codigoBarra": "123456789",
  "referencia": "REF123",
  "categoria": {
    "id": 40,
    "nome": "teste API",
    "situacao": "ATIVO"
  }
}
```

**Request Listar**

```shell script
curl --location --request GET 'http://localhost:8080/api-produtos/produto/listar'
```
**Response Listar**

```json
[
  {
    "id": 80,
    "nome": "Arroz Branco",
    "descricao": "Arroz Branco 10KG",
    "preco": 88.80,
    "situacao": "ATIVO",
    "validade": "2024-12-31",
    "codigoBarra": "123456789",
    "referencia": "REF123",
    "categoria": {
      "id": 1,
      "nome": "Limpeza",
      "situacao": "ATIVO"
    }
  },
  {
    "id": 81,
    "nome": "Cobertores casal",
    "descricao": "Cobertores para Casal tamanho GG",
    "preco": 110.50,
    "situacao": "ATIVO",
    "validade": "2024-12-31",
    "codigoBarra": "123456789",
    "referencia": "REF123",
    "categoria": {
      "id": 40,
      "nome": "teste API",
      "situacao": "ATIVO"
    }
  }
]
```
**Request Listar por Categoria**

```shell script
curl --location --request GET 'http://localhost:8080/api-produtos/produto/listar/porcategoria/1'
```
**Response Listar**

```json
[
  {
    "id": 53,
    "nome": "Produto teste 01",
    "descricao": "Produto para teste 01",
    "preco": 88.80,
    "situacao": "ATIVO",
    "validade": "2023-12-31",
    "codigoBarra": "123456789",
    "referencia": "REF123",
    "categoria": {
      "id": 1,
      "nome": "Limpeza",
      "situacao": "ATIVO"
    }
  },
  {
    "id": 54,
    "nome": "Produto teste 01",
    "descricao": "Produto para teste 01",
    "preco": 88.80,
    "situacao": "ATIVO",
    "validade": "2023-12-31",
    "codigoBarra": "123456789",
    "referencia": "REF123",
    "categoria": {
      "id": 1,
      "nome": "Limpeza",
      "situacao": "ATIVO"
    }
  }  
]
```