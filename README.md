# Project order
Foram criados dois projetos Order Core e Query. No core são realizas as operações de escrita no banco e no query as operações de leitura. Entre o core e query temos o RabbitMQ sendo responsável pelas trocas de mensagens de ambos os projetos. 

No core os dados são formatos em um JSON e enviados como string para o query. No query os dados são salvos de modo normalizado, tendo primary key e foreign key.

# Em execução

* Criando um novo pedido
  
![image](https://github.com/user-attachments/assets/bb38a9a1-f542-4c70-99b2-08f082a620fe)

* Salvando no banco order-core
![image](https://github.com/user-attachments/assets/78bc30d4-5054-4c20-ade8-fdaadee385d6)

* Enviando mensagem para query
![image](https://github.com/user-attachments/assets/ac62ae5d-235e-4971-bf45-01ed755a5bb5)

* Salvando os dados no query recebidos do rabbitMQ
  TODO: adicionar

* Carregando o pedido com valor total calculado e tabelas normalizadas
FindByID
![image](https://github.com/user-attachments/assets/030ec68e-846e-4e96-9fce-2f2cfe9234b7)

FindAll
![image](https://github.com/user-attachments/assets/fdf6a90c-4c2f-4d07-9c0b-aae5d1b9edb6)
![image](https://github.com/user-attachments/assets/1158a7d1-286b-4998-bcd2-6bce70873dec)


Tabela Order
![image](https://github.com/user-attachments/assets/2132bacb-b0c8-4494-97f8-9d99625c8e87)
