# Simulador de Financiamento - Java POO ☕

Este projeto é um sistema de simulação de financiamentos imobiliários desenvolvido em Java. Ele foi criado como trabalho final da disciplina de **Fundamentos da Programação Orientada a Objetos** no curso de Análise e Desenvolvimento de Sistemas da **PUCPR**.

## 📝 Sobre o Projeto

Este foi um dos meus primeiros contatos profundos com a linguagem Java. O objetivo era aplicar na prática os conceitos estudados em sala de aula para construir um software funcional capaz de simular financiamentos de Casas, Apartamentos e Terrenos.

Fiquei muito feliz com o resultado final, pois o projeto atendeu a todos os requisitos propostos e obtive a nota máxima (**10/10**) na avaliação.

## 🚀 Funcionalidades e Conceitos Aplicados

Durante o desenvolvimento, busquei aplicar os 4 pilares da POO e outras técnicas importantes:

* **Abstração e Herança:** Uso da classe abstrata `Financiamento` como base para `Casa`, `Apartamento` e `Terreno`.
* **Polimorfismo:** Tratamento genérico dos diferentes tipos de imóveis em listas.
* **Encapsulamento:** Proteção dos atributos com modificadores de acesso e métodos Getters/Setters.
* **Tratamento de Exceções:** Criação de uma exceção personalizada (`AumentoMaiorDoQueJurosException`) para regras de negócio específicas.
* **Persistência de Dados:**
    * Leitura e escrita de arquivos de texto (`.txt`).
    * Serialização de objetos Java (`.ser`) para salvar o estado da aplicação.

## 🛠️ Tecnologias Utilizadas

* Java (JDK)
* VS Code (IDE)

## 📂 Como executar

Para rodar este projeto na sua máquina:

1. Clone o repositório.
2. Abra a pasta no VS Code ou sua IDE de preferência.
3. Navegue até a pasta `src/main` e execute o arquivo `Main.java`.

---
*Desenvolvido por Osvaldi de Jesus de Lima Filho como parte de sua jornada de aprendizado na PUCPR.*