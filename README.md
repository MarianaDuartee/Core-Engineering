# Core Engineering

Repositório com meus códigos referentes aos temas da Trilha Core Engineering.

## Tema 01: Agile
Texto com todos os métodos ágeis, incluindo Scrum e XP e explicação de como eles funcionam, além dos problemas com agile e a relação entre Agile/Lean e Bi Modal e DevOps.

## Tema 02: Override e Overload
Texto explicando o que é override e overloading.

## Tema 03: Multithreading
Programa que usa duas threads, sendo que thread A gera apenas números randômicos ímpares e os printa no console (essa thread printa um número a cada 100 milisegundos) e a thread B gera apenas números randômicos pares e também os printa no console (essa thread printa um número a cada 500 milisegundos), por fim a classe main é usada para instanciar e iniciar as Threads.

## Tema 04: Lampada (Testes)
Projeto java com gradle utilizando JUNIT5, no qual possui uma Interface Lampada com a assinatura dos método void on(); e void off() e duas classe implementam essa interface, além disso, uma outra classe recebe uma lâmpada pelo construtor e expõe um método void switchState(). Na classe main, o exercício é exemplificado para testar o método switchState para cada cenário ON e OFF e testar a classe que tem o método switch com cada uma das classes que implementam a interface Lampada.

## Tema 05: Agenda de Contatos (Clean Code)
Projeto de agenda de contato, no qual é possível adicionar contato, remover contato, listar contato, buscar por nome, buscar por id. Usando um array em memória, com testes unitários para cada operação.

## Tema 06: TDD
Conversor de números romanos para números inteiros.
Suporta números de 1 a 20 e é possível passar um numero romano e convertê-lo para inteiro ou também passar um numero inteiro e converte-lo para romano
Foi desenvolvido utilizando TDD. (Testes primeiro)

## Tema 07: Biblioteca (Philosophy of Software Design)
Aplicação de empréstimo livro, na qual é possível cadastrar livro (id, titulo, autor), listar livro, excluir (não pode excluir um livro que está emprestado), buscar por título ou por autor e emprestar um livro, sendo que para essa funcionalidade, uma pessoa pode fazer empréstimo de no máximo 5 livros, com o prazo de entrega é 7 dias, além de que uma pessoa pode devolver vários livros e pode renovar um livro por mais 7 dias, exceto se ela estiver atrasada.
No momento da devolução será cobrado 5 reais por dia de atraso
É possível exibir relatórios de livros emprestados e nome da pessoa que estiver com ele, os TOP 10 usuários que mais locam livros e relatórios do cliente que atrasaram a entrega e quantos dias de atraso.

## Tema 08: DDD
Texto respondendo as seguintes questões:
  1. Qual é o objetivo principal do DDD?
  2. Qual é o impacto que DDD pode causar no projeto?

## Tema 09: Agenda de contato + Banco de Dados
Projeto de agenda de contato (id, nome, telefone, email), sendo possível adicionar contato, remover contato, listar contato (ordenar por nome/id), buscar por nome, buscar por id. Todas as operações envolvem banco de dados.

## Tema 10: Factory (Desing Pattern Criacional)
Projeto com padrão Factory de tema livre.

## Tema 11: Builder (Desing Pattern Criacional)
Projeto com a implementação do builder com interface fluente, no qual possui uma classe Pessoa (nome, data de nascimento, endereço), uma classe endereço (rua, número, cidade, estado) e uma classe builder com interface fluente para fazer a criação de uma pessoa completa.

## Tema 12: Strategy (Desing Pattern Comportamental)
Sistema de envio notificação que suporta apenas SMS e Email (apenas escreve no terminal o tipo de notificação junto com a mensagem), no qual possui uma classe que represente um cliente apenas com nome,email e telefone, uma classe responsável por apenas montar uma mensagem(Hello + nome do cliente) e uma classe de notificação para enviar.
Foi utilizado o padrão Strategy para definir SMS e Email.
Além disso, o sistema valida se o cliente possui telefone preenchido para enviar a notificação por telefone, ou caso contrario envia por email (email é obrigatório). 


## Tema 13: Template Method (Desing Pattern Comportamental)
Sistema responsável por fazer bebida quentes, no qual possui métodos abstratos para criar uma bebida quente e um método concreto responsável por executar em ordem.

## Tema 14: Chain (Desing Pattern Comportamental)
Programa que possui uma classe abstrata NotificationHandler, 3 implementações dessa classes e uma classe Request, sendo possível executar mais de um elemento da chain.

## Tema 15: Command (Desing Pattern Comportamental)
Sistema de banco onde é possível apenas depositar dinheiro e sacar dinheiro, essas duas ações utilizam o design pattern command e é possível salvar o histórico dos commands executados em um arraylist static. Além disso, possui uma consulta de saldo que lê todos os commands para calcular o saldo.

## Tema 16: Decorator (Desing Pattern Estruturais)
Programa que possui uma classe que é a base de uma pizza (preço 20 reais), um decorador para adicionar queijo (preço 3 reais) e outro decorator para adicionar bacon (preço 3,5). A classe main, usa as classe criadas para montar uma pizza de bacon com o dobro de queijo.