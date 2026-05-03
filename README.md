```markdown
# Visualizador NASA APOD

Uma aplicação web em Java que busca e exibe a Foto Astronômica do Dia (APOD - Astronomy Picture of the Day) usando a API oficial da NASA.

## 🚀 Visão Geral
Este projeto utiliza um Java Servlet para lidar com as requisições do usuário, formatar datas e se comunicar com a API da NASA. Ele converte a resposta em JSON para um objeto Java e envia os dados para uma página JSP (`apod.jsp`) para exibição.

## ✨ Funcionalidades
* **Busca por Data:** Os usuários podem inserir uma data específica para buscar a foto astronômica e a explicação daquele dia.
* **Navegação por Dias:** Inclui a funcionalidade de avançar (+) ou retroceder (-) um dia a partir da data que está sendo visualizada no momento.
* **Segurança de Chave de API:** Utiliza variáveis de ambiente para carregar a chave da API da NASA com segurança, sem expô-la no código-fonte.

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Java
* **Framework:** Java Servlets (`jakarta.servlet`)
* **API:** NASA APOD API
* **Processamento JSON:** Jackson (`com.fasterxml.jackson`)
* **Gerenciamento de Variáveis:** java-dotenv (`io.github.cdimascio.dotenv`)
* **Frontend:** JSP (JavaServer Pages)

## ⚙️ Configuração e Execução
Para rodar este projeto localmente, você precisará de uma chave de API da NASA.

1. Obtenha uma chave de API gratuita em [api.nasa.gov](https://api.nasa.gov/).
2. Crie um arquivo `.env` na pasta raiz do projeto.
3. Adicione sua chave ao arquivo `.env` da seguinte forma:
   ```text
   APOD_KEY=sua_chave_de_api_aqui
Inicie o seu servidor local (ex: Tomcat) e acesse a aplicação.

Nota: O arquivo .env deve ser incluído no .gitignore para evitar o vazamento da chave de API.