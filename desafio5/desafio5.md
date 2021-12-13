# Defina  com  suas  palavras  qual  é  a  responsabilidade  das  camadas  vistas  até  agora, entity, controller, repository e service.
O MVC (model, view e controller), é um padrão desenvolvimento de software.

A camada *Controller* é responsável pela gestão do sistema inteiro, é nele que passa todas informações e tomada de decisões, ou seja, o controller é a principal camada para o funcionamento do sistema.

O controller também tem como um auxílio o *Service* para ajuda nas demandas do sistema, é ele que repassa ou executar uma ordem o controller relacionado a regra do negócio.

A *model (Entety)* se concentrar todas as entidades ou tabelas do negócio, é parte mais lógica próxima do banco de dados, sendo assim, possível a persistência dos dados.

O *Repository* é a última camada ao banco de dados, é sendo responsável pelo CRUD ( create, read, update e delete), ou seja, somente ele pode executar as operações do banco de dados.