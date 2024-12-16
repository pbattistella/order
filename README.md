# Project order
Foram criados dois projetos Order Core e Query. No core são realizas as operações de escrita no banco e no query as operações de leitura. Entre o core e query temos o RabbitMQ sendo responsável pelas trocas de mensagens de ambos os projetos. 

No core os dados são formatos em um JSON e enviados como string para o query. No query os dados são salvos de modo normalizado, tendo primary key e foreign key.

# Tecnologias

* Java 17
* Spring Boot 3.4.0
* Flyway
* Postgresql 14
* Docker
* RabbitMQ

# Em execução

* Criando um novo pedido - CORE
  
![image](https://github.com/user-attachments/assets/bb38a9a1-f542-4c70-99b2-08f082a620fe)

* Salvando no banco order - CORE
  
![image](https://github.com/user-attachments/assets/78bc30d4-5054-4c20-ade8-fdaadee385d6)

* RabbitMQ enviando mensagem
  
![image](https://github.com/user-attachments/assets/ac62ae5d-235e-4971-bf45-01ed755a5bb5)
![image](https://github.com/user-attachments/assets/99bf8632-3ee8-40b5-a434-6b6c8f7c27d7)

* Salvando os dados no query recebidos do rabbitMQ
  TODO: adicionar

* Carregando o pedido com valor total calculado e tabelas normalizadas
* FindByID - QUERY
  
![image](https://github.com/user-attachments/assets/030ec68e-846e-4e96-9fce-2f2cfe9234b7)

* FindAll - QUERY
  
![image](https://github.com/user-attachments/assets/fdf6a90c-4c2f-4d07-9c0b-aae5d1b9edb6)
![image](https://github.com/user-attachments/assets/1158a7d1-286b-4998-bcd2-6bce70873dec)

# Tabela

* DATABASE Order - CORE
* Tabela Order
  
![image](https://github.com/user-attachments/assets/bde5ef37-47a1-4ae1-a5d9-86b94e061dca)

* DATABASE Order - QUERY
* Tabela Order
  
![image](https://github.com/user-attachments/assets/10e76af2-238b-4180-8d56-0a4951f3210d)

* Tabela Item
  
![image](https://github.com/user-attachments/assets/415793a5-b306-4992-af25-69c5b0046a5d)

* Tabela Product
  
![image](https://github.com/user-attachments/assets/35446f92-7fc3-4c15-8816-8899d06300bb)

* Tabela Customer
  
![image](https://github.com/user-attachments/assets/859ae803-d7b3-44a2-8774-9c1e5c453ebe)

#ER Core

![image](https://github.com/user-attachments/assets/a8edbd4a-e818-4a5f-8533-92a250602283)

#ER Query

![image](https://github.com/user-attachments/assets/71539798-de5c-4ac9-9055-bfc285d19dfd)
