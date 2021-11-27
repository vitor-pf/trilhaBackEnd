# O que é o protocolo de comunicação HTTP e como ele funciona; 
O HTTP (Hypertext Transfer Protocol) é um protocolo na camada de aplicação, é responsavel pela comunicação entre o cliente e servidor.
Ele trabalho com 2 protocolos TCP (responsável pela transferencia) e IP (endereço absoluto). O TCP/IP utiliza um pedido ao servidor (request) e devolve um resposta (response), normalmente esse retorno é um arquivo HTML ou JSON, aonde contém todas as informações da aplicação, como: textos, imagens e outros.
Toda conexão enviada ao servidor e encerrada com uma resposta, geralmente, as informações contém um padrão (method, path, version, code, status e entre outros) para que o request e response possa trata-los. Enfim, gerando um ciclo para cada requisição.


1 - O usuário em seu navegador (celular, computador ou outro dispositivo) acessa uma URL de uma página.
2 - Essa conexão é enviada para o servidor utilizando o TCP/IP, e será tratada com as informações recebidas (também pode acontecer outras requisições internas, como para API de terceiros), e assim devolver uma resposta com um corpo padrão.
3 - E assim, o navegador renderiza a resposta solicitada.

# O que é REST, e qual é a sua relação com o protocolo HTTP;
O REST ou RESTful (Representational State Transfer) é conjunto de definição que ajuda na requisição HTTP, ou seja, é uma boa prática no desenvolvimento de sistema. Essa arquitetura utiliza uma URL para se comunicar entre cliente-servidor, estado, cache, interface uniforme, sistema em camadas e código sob demanda.
O REST eleva o nivel da aplicação por performace, segurança e escalável.

# O que é Web API, e qual é a sua relação com REST;
A API (Application Programming Interface) é um conjunto de interface (compartilha parte da aplicação) para terceiro, ou seja, uma porta do sistema se comunica com outros sistemas.


# Todos os métodos do REST são:
GET: leitura de dados no host;
HEAD: É o metadados, é informação de um arquivo, no caso foto, câmera usada, data de criação da fotografia, formato, tamanho do arquivo e etc. 
POST: Salvar dados no servidor;
PUT: Atualizar informação;
DELETE: Deletar informação;
TRACE: Permite que o servidor veja o que está sendo recebido na outra extremidade (rastreamento da aplicação);
OPTIONS: Representa um pedido de informação sobre as opções de comunicação disponíveis;
CONNECT: Usa uma proxy que pode mudar dinamicamente para ser um túnel SSL;

# O que é Swagger?
O Swagger é uma ferramenta para desenvolver APIs, ou seja, permite que você descreva uma estrutura de API de forma facilitada, deixando a documentação fácil tanto humano ou máquina.
