# BankApp (OBS.: README em construção...)

## O que é o sistema BankApp?

  É um sistema que tem como objetivo simular o funcionamento dos sistemas bancários digitais. Foi proposto durante a disciplina de Projeto Integrador II.

## Tecnologias utilizadas

- Linguagem de programação Java
- IDE: Intellij
- Draw.io (para elaboração de diagramas de Casos de Uso e de Classe)

## Estrutura básica do projeto

### Classes abstratas

#### Classe Pessoa: abstrai uma pessoa do mundo real. 

- Atributos principais: Nome, CPF, e-mail e data de nascimento.

#### Classe Conta: abstrai o que é uma conta e principais papeis que ela tem. 
- Atributos principais: ID, ativo (se conta está ativada ou não), número da agência e da conta, cliente e extrato. 
- Métodos principais: depositar, sacar, transferir e consultar extrato.

### Parte do cliente

#### Classe Cliente 

### Parte de Conta

#### Classe ContaPoupanca
#### Classe ContaCorrente
#### Classe Registro

### Parte de Agência Bancária

#### Classe AgenciaBancaria
#### Classe CentralAgencias

### Parte de apresentação

#### Classe InterfaceBankApp
#### Formatador
