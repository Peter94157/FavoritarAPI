
# API Favoritar

API onde podemos cadastrar um cliente e produtos, onde conseguimos criar lista de produtos favoritos para cada cliente.




## Documentação da API



#### Retorna todos os clientes.

```http
  GET /Cliente
```


#### Retorna um cliente.

```http
  GET /Cliente/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do cliente que você quer |

#### Cadastra um cliente.

```http
  POST /Cliente
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `Nome`      | `string` | **Obrigatório**. O nome do cliente |
| `Email`      | `string` | **Obrigatório**. O email do cliente |
| `Senha`      | `string` | **Obrigatório**. A senha do cliente |


#### Atualiza um cliente.

```http
  PATCH /Cliente/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do cliente que você quer |


#### Exclui um cliente.

```http
  DELETE /Cliente/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do cliente que você quer |


#### Retorna todos produtos.

```http
  GET /Produtos
```


#### Retorna um produto.

```http
  GET /Produtos/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer |




#### Retorna um produto.

```http
  POST /Produtos
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `price`      | `string` | **Obrigatório**. O preço do item |
| `UrlImage`      | `string` | **Obrigatório**. A url da imagem do item |
| `Brande`      | `string` | **Obrigatório**. A marca do item|
| `Tittle`      | `string` | **Obrigatório**. A descrição do item |
| `ReviewScore`      | `string` | **Obrigatório**. A avaliação do item |

#### Retorna um produto.

```http
  DELETE /Produtos/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer |


#### Favorita um produto na lista do cliente.

```http
  POST /Produtos/favoritar
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer |


#### Retorna a lista de favoritos do cliente.

```http
  GET /Produtos/email/${email}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O email do cliente que você quer |






# Banco de dados MySQL

## Tabela Cliente
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


## Tabela Produtos
CREATE TABLE `produtos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Brande` varchar(255) DEFAULT NULL,
  `tittle` varchar(255) DEFAULT NULL,
  `UrlImage` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `ReviewScore` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


## Tabela ListaFavoritos
CREATE TABLE `listafavoritos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `SKU` int(11) DEFAULT NULL,
  `tittle` varchar(255) DEFAULT NULL,
  `nomeCliente` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





