Projeto do PAC V - README Será disponibilizado em breve...

Projeto está sendo "controlado" as funções dos integrantes através do Trello ferrmenta escolhida para realizar as documentações de projeto segue link: 
https://trello.com/invite/b/5wRN0s7O/ATTI3932244de965786e52dfd8688242b1811F3F4F38/pac-v-202352

1 - Ao clonar o repositorio para iniciar precisamos ter o maven, java intalado em nossas máquinas.
    - Lembrando de ter o java e maven home em nossas váriasveis de ambiente ou de usuario

2  - Para iniciar o projeto precisa executar o comando mvn spring-boot:run

3 - Quando iniciar pode colocar o caminho:
   - localhost:8080 - irá ser redirecionado para a página registro, que precisa criar um usuario para conseguir proseguirmos, após a criação do usuario vamo para a página de login, que quando logarmos com o usuario que acabamos de criar seremos redirecionados para a página home, onde temos uma lista de salas estáticas e algumas opções, clicando em gerenciar cliente temos o controle de todos os clientes que foram criados, assim podendo editar e excluir os clientes, não tem a opção de criar cliente, pq preferiamos que o cliente seja criado quando realize o registro.

   - Na segunda opção temos o gerenciar salas, que vamos para outra página que tem uma lista com as sals disponíveis, podendo editar as salas e excluir elas, clicando no botão de criar, podemos criar uma sala nova.

    - Na terceira opção temos a opção de gerenciamento de salas, no momento podemos ver que podemos assosiar e dessasociar salas, no momento apenas a sala com o id 1, mas temos todos os clientes cadastrados no momento, pára poder fazer essa associação.

    - Temos também uma quarta opção mas ela fica disponível apenas quando vai no gerenciamento de salas, que seria a opção de Financeiro, dessa forma podemso imprimir um recibo para termos controle financeiro.