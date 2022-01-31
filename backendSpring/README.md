# JAVA_MD_BACKEND
Teste java

#### O backend foi documentado utilizando o swagger, podendo ser acessado pela url abaixo:
http://localhost:8080/swagger-ui.html

#### Ao executar o projeto, será criado um banco chamado teste, e o flyway ŕodará os scripts para criação das tabelas do banco de dados e inserção dos tipos sanguineos com os doadores e receptores.

#### Em User-controller temos as seguintes rotas:

>POST: /users/save -> salva um usuario e retorna o json correspondente ao usuario salvo
>
>GET: /users/visualizar/page/{page}/size/{size} -> uma lista paginada de usuarios, podendo definindo a pagina e a quantidade máxima a ser mostrada


#### Em address-controller temos a seguite rota:

>GET: /address/byCep/{cep} -> faz a busca do endereço do cep informado, utilizando a api ViaCep
