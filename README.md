# FavoritarAPI
API onde podemos cadastrar um cliente e produtos, onde conseguimos criar lista de produtos favoritos para cada cliente.


# Clientes

Para registrar um Cliente utilize o caminho.
Metodo POST
localhost:8080/Cliente
Body
{
"nome": "pedro",
"email": "Pedro@gmail.com",
"senha":"senhadopedro"
}

Consulta de todos clientes.
Metodo GET
localhost:8080/Cliente/getAll

Consulta de um cliente.
metodo GET
localhost:8080/Cliente/get/{id}

Atualização das informações do cliente
Metodo PUT
localhost:8080/Cliente/put/{id}
Body
{
"nome": "pedro",
"email": "Pedro@gmail.com",
"senha":"senhadopedro"
}

Deletar um cliente
Metodo DELETE
localhost:8080/Cliente/delete/{id}

# Produtos

Registrar um produto 
Metodo POST
localhost:8080/Produtos
Body
{
    "price":100.0,
    "UrlImage":"https://gratisography.com/wp-content/uploads/2024/10/gratisography-cool-cat-800x525.jpg",
    "Brande":"animal",
    "Tittle":"Gato",
    "ReviewScore":5
}

Consultar produto. 
Metodo GET
localhost:8080/Produtos/
localhost:8080/Produtos/getAll

Consulta de um Produto.
metodo GET
localhost:8080/Produtos/get/{id}


Deletar um produto
Metodo DELETE
localhost:8080/Produtos/delete/{id}

Favoritar um produto
Metodo POST
localhost:8080/Produtos/favoritar
Body
{
    "tittle":"Cachorro",
    "email":"Pedro@gmail.com"
}

Consulta lista de favoritos.
Metodo GET
localhost:8080/Produtos/getFavoritos/{email}

# Banco de dados MySQL

## tabela Cliente
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





