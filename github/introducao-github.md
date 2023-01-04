# Introdução ao Github

Este repositório contem a síntese dos comandos apresentados no curso de introdução ao GIT/GITHUB:
1. Comandos para um bom desempenho no terminal: comandos DOS
2. Comandos específicos do GIT para gerenciar os repositórios na maquina e sincronizá-los no GITHUB

## Passagens executados no curso de introdução ao GIT/GITHUB
Este repositório foi criado diretamente no GITHUB em seguidas foram feitas algumas pequenas modificações ao arquivo README.md
O repositório foi clonado na minha maquina.
Em seguida trabalhei em local na maquina para criar uma nova pasta "github". Dentro da pasta criei dois arquivos .txt com os comandos uteis para trabalhar no git/github neste bootcamp e no futuro.
Executei em seguida o comando git status para verificar o estado do repositório e verifiquei que precisava atualizar os arquivos no github
Executei então os comandos git add * e git commit para commitar as atualizações feitas ao repositório. O git pediu configurar o e-mail e o nome do usuário, então executei o comando git config --global e em seguida repeti o commit.
Finalmente executei o comando git push para enviar os arquivos no github

## Resolução de conflito
Na hora de dar o comando push deu um erro fatal pois o git não estava encontrando o branch master do meu repositório. 
Procurei como resolver este conflito e descobri que a palavra master foi substituita pela palavra main. Consegui atualizar o repositório remoto mudando o nome do branch com o comando git branch.
Decidi mudar o nome do repositório remoto, assim precisei também atualizar o link do projeto no meu git local através do comando git remote set-url origin