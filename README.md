# nivel-risco

* Sobre a arquitetura

- Optei por usar o BD em memório H2 pela simplicidade (não ter que instalar Postgres/MYSQL, etc.), mas o código é facilmente adaptável a qualquer outro DB (Estou usando JPA com hibernate)
- São 4 tabelas: cliente (id, nome), limite_credito (id, valorLimite), risco(id, tipoRisco, taxaJuros) e uma tabela associativa das 3, cliente_limite_credito_risco, resolvi mapear assim para deixar a modelagem normalizada
- O script do banco pode ser visto no arquivo start-database.sql no pacote resources. Utilizei a função ddl-auto do hiberante para simplificar a criação do banco. 
- Cada entidade tem suas classes relacionadas por package. Ex: DAO, Service, DTO e DTOMapper relacionados a model Cliente estão agrupados no pacote "br.com.nivelrisco.cliente"
- Existem alguns testes de integração e unitários.

Para rodar os testes: ./mvnw clean test
Para executar a app: ./mvnw spring-boot:run

Para acessar a aplicação vá para http://localhost:8080/ e preencha o formulário.



