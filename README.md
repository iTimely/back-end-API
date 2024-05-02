# Projeto iTimely

## Pré-requisitos
Antes de começar, certifique-se de ter os seguintes requisitos instalados em sua máquina:

- [Java JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [MongoDB](https://www.mongodb.com/try/download/community)
- [Postman](https://www.postman.com/downloads/)

## Configuração do Banco de Dados

1. Abra o projeto na sua IDE favorita.
2. No diretório `src/main/resources`, encontre o arquivo `application.properties`.
3. Configure as seguintes propriedades para conectar ao seu banco de dados local:

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=iTimely
```

### Como criar o banco de dados

Você pode criar o banco de dados através da interface de administração do MongoDB. Certifique-se de que o nome do banco de dados especificado no arquivo `application.properties` corresponda ao nome do banco de dados que você criou.

### Adicionando coleções de dados

No projeto, há uma pasta chamada db que contém arquivos JSON com os dados para adicionar às coleções no banco de dados. Utilize esses arquivos para popular o banco de dados com dados iniciais.

## Como Rodar o Projeto

Para rodar o projeto:

1. Execute a classe que possui o método main.

## Contribuindo 

Se você quiser contribuir para este projeto, por favor, siga os passos abaixo:

1. Crie um fork do projeto.
2. Crie uma branch para a sua contribuição: `git checkout -b feature/nova-funcionalidade`.
3. Faça as alterações desejadas.
4. Faça o commit das suas alterações: `git commit -m 'Adiciona nova funcionalidade`.
5. Faça o push para a sua branch: `git push origin feature/nova-funcionalidade`.
6. Abra um pull request.


<br>

# Documentação do Postman para a API iTimely

## Utilizando o Postman

O Postman é uma ferramenta poderosa para testar APIs RESTful. Com o Postman, você pode enviar solicitações HTTP para endpoints da API e visualizar as respostas. Aqui está um guia passo a passo sobre como usar o Postman com a API iTimely.

### Passo 1: Instalação do Postman

Se você ainda não tem o Postman instalado, pode baixá-lo e instalá-lo gratuitamente em [postman.com/downloads](https://www.postman.com/downloads/).

### Passo 2: Importando a Coleção do Postman

A coleção do Postman contém uma série de solicitações predefinidas que você pode usar para interagir com a API iTimely. Siga estas etapas para importar a coleção no Postman:

1. Faça o download do arquivo de coleção do Postman do repositório do projeto.
2. Abra o Postman.
3. No canto superior esquerdo do aplicativo Postman, clique no botão "Import" para abrir o menu de importação.
4. Selecione a opção "Import File" e navegue até o local onde você baixou o arquivo de coleção do Postman.
5. Selecione o arquivo de coleção e clique em "Open" para importá-lo para o Postman.

### Passo 3: Configuração do Ambiente

O ambiente do Postman permite definir variáveis globais que podem ser usadas em todas as solicitações da coleção. Siga estas etapas para configurar o ambiente no Postman:

1. No canto superior direito do aplicativo Postman, clique no menu suspenso ao lado do botão "Eye" (Visualização) e selecione "Manage Environments".
2. Clique em "Add" para criar um novo ambiente.
3. Nomeie o ambiente como "iTimely Environment" e adicione as seguintes variáveis:

- `base_url`: O URL base da API. Por padrão, pode ser http://localhost:8080.
- `token`: Um token de autenticação, se necessário.

4. Clique em "Add" para salvar o ambiente.

### Passo 4: Executando Solicitações

Agora que você importou a coleção do Postman e configurou o ambiente, pode começar a executar solicitações para a API iTimely. Aqui estão algumas solicitações comuns que você pode experimentar:

- **Visualizar Detalhes de uma Chamada**: Esta solicitação obtém os detalhes de uma chamada específica.
- **Listar Alunos por Turma**: Esta solicitação lista todos os alunos de uma turma específica, juntamente com suas informações de presença.
- **Notificar Pais por Email**: Esta solicitação notifica os pais por e-mail quando a presença do aluno excede 65%.

### Passo 5: Execução das Solicitações

Para executar uma solicitação no Postman, siga estas etapas:

1. Selecione a solicitação desejada na coleção do Postman.
2. Verifique se o ambiente está configurado corretamente no canto superior direito do aplicativo Postman.
3. Clique no botão "Send" (Enviar) para enviar a solicitação para a API.
4. Visualize a resposta da API na seção de resposta abaixo da solicitação.

### Passo 6: Testando Diferentes Endpoints

Experimente diferentes endpoints e parâmetros para explorar a funcionalidade completa da API iTimely. Você pode alterar os valores dos parâmetros e ver como a API responde.

## Conclusão

O Postman é uma ferramenta essencial para testar e depurar APIs RESTful, e a coleção do Postman fornecida facilita a interação com a API iTimely. Experimente diferentes solicitações e explore a funcionalidade da API para entender completamente como ela funciona.

Se encontrar algum problema ou tiver dúvidas sobre como usar o Postman ou a API iTimely, não hesite em entrar em contato com a equipe de desenvolvimento.

Divirta-se testando a API iTimely com o Postman!
