# Projeto PAC V

Bem-vindo ao repositório do projeto PAC V! Este projeto está sendo gerenciado e documentado por meio do Trello, que pode ser acessado pelo seguinte link:  
[Trello - PAC V](https://trello.com/invite/b/5wRN0s7O/ATTI3932244de965786e52dfd8688242b1811F3F4F38/pac-v-202352)

---

## Pré-requisitos

Antes de começar, certifique-se de que sua máquina atende aos seguintes requisitos:

1. **Java** e **Maven** instalados:
   - Configure as variáveis de ambiente `JAVA_HOME` e `MAVEN_HOME` corretamente.
   
2. **Cuidado com os nomes de pastas**:
   - Certifique-se de que os nomes das pastas estão corretos e não possuem letras maiúsculas ou caracteres fora do padrão esperado, pois isso pode causar erros ao iniciar a aplicação.

---

## Como executar o projeto

1. Clone este repositório para sua máquina local:

```bash
   git clone <URL_DO_REPOSITORIO>
```
2. Navegue até o diretório do projeto:
  ```bash
    cd <NOME_DO_DIRETORIO
```
3. Inicie o projeto com o comando Maven:
 ```bash
   mvn spring-boot:run
```

4. Acesse a aplicação no navegador:
 ```bash
    http://localhost:8080
```

## Funcionalidades do Projeto

### Página de Registro
- Após iniciar o projeto, você será redirecionado para a página de **registro**, onde deve criar um usuário.
- Com o usuário criado, você será levado para a página de **login**.
- Após o login, será redirecionado para a **Home**, onde encontrará as principais funcionalidades.

### Gerenciamento de Clientes
- Na página de gerenciamento de clientes, você pode:
  - Visualizar, editar e excluir os clientes cadastrados.
- **Nota:** Não é possível criar clientes diretamente nesta página, pois o registro ocorre na etapa inicial de cadastro.

### Gerenciamento de Salas
- A página de gerenciamento de salas permite:
  - Visualizar, editar e excluir salas.
  - Criar novas salas clicando no botão **Criar Sala**.

### Associação de Salas a Clientes
- Na página de gerenciamento de associações, você pode:
  - Associar ou desassociar clientes às salas disponíveis (atualmente funcional apenas para a sala com ID 1).

### Controle Financeiro
- A funcionalidade de **Controle Financeiro** fica disponível na página de gerenciamento de salas.
- Permite imprimir recibos, auxiliando no acompanhamento financeiro.

### Observações
- Caso encontre dificuldades ao executar o projeto, verifique as configurações de ambiente e os nomes das pastas.
- Para dúvidas ou melhorias, entre em contato com os integrantes do projeto.

    
