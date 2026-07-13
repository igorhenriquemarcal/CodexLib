# Sistema de Biblioteca — Java OO

Recriação de um projeto acadêmico originalmente desenvolvido em C, reescrito em Java aplicando os principais conceitos de Orientação a Objetos: herança, polimorfismo, encapsulamento e composição. A interface gráfica foi construída com JavaFX.

---

## Tecnologias

- Java 26
- JavaFX 26 (interface gráfica)
- IntelliJ IDEA (IDE)

---

## Estrutura do Projeto

```
src/
├── entities/
│   ├── Usuario.java        # Classe abstrata base
│   ├── Aluno.java          # Herda de Usuario — prazo de 7 dias, limite de 3 livros
│   ├── Professor.java      # Herda de Usuario — prazo de 30 dias, limite de 10 livros
│   ├── Livro.java          # Entidade de livro
│   ├── Emprestimo.java     # Composição de Usuario + Livro
│   └── Biblioteca.java     # Classe gerenciadora (listas + regras de negócio)
├── MainApp.java            # Ponto de entrada JavaFX
├── TelaLivros.java         # Aba de cadastro e listagem de livros
├── TelaUsuarios.java       # Aba de cadastro de alunos e professores
└── TelaEmprestimos.java    # Aba de empréstimos e devoluções
```

---

## Conceitos de OO Aplicados

### Herança
`Aluno` e `Professor` estendem `Usuario`. Compartilham atributos comuns (nome, matrícula, telefone) mas implementam regras diferentes de prazo e limite de empréstimos.

### Polimorfismo
O método `getDiasEmprestimo()` é abstrato em `Usuario` e implementado diferente em cada subclasse. A classe `Biblioteca` chama esse método sem precisar saber se o usuário é Aluno ou Professor — cada objeto responde com o valor correto.

```java
// Sem polimorfismo (evitado)
if (tipo.equals("Aluno")) return 7;
else if (tipo.equals("Professor")) return 30;

// Com polimorfismo (como foi feito)
usuario.getDiasEmprestimo(); // cada objeto sabe responder
```

### Encapsulamento
Todos os atributos são `private`. O acesso externo é feito apenas por getters, e setters existem somente onde há necessidade real de alteração após a criação do objeto (`setDevolvido` em `Emprestimo`).

### Composição
`Emprestimo` guarda referências aos objetos `Usuario` e `Livro` em vez de copiar seus dados. Isso permite acessar `emprestimo.getUsuario().getNome()` diretamente, sem buscas manuais em listas.

---

## Funcionalidades

- Cadastro de livros com código, título, autor, editora, ano e número de exemplares
- Cadastro de usuários do tipo Aluno (com curso) ou Professor (com departamento)
- Realização de empréstimos com cálculo automático de prazo por tipo de usuário
- Devolução de livros com validação de empréstimo já devolvido
- Listagem de livros, usuários e empréstimos ativos
- Interface gráfica com abas separadas por funcionalidade

---

## Melhorias Futuras

- Persistência em arquivo (salvar dados entre sessões)
- Validação de matrícula e código duplicados no cadastro
- Aplicação do limite de empréstimos simultâneos por tipo de usuário
- Relatórios de empréstimos por período
- Busca de livros por título ou autor na interface gráfica

---

## Origem do Projeto

Este projeto foi originalmente desenvolvido em linguagem C como trabalho acadêmico, utilizando structs, arrays globais e funções procedurais. A reescrita em Java teve como objetivo aplicar os conceitos de Orientação a Objetos aprendidos na disciplina, mantendo as mesmas funcionalidades do sistema original e expandindo o domínio com a adição de tipos de usuário (Aluno/Professor) para demonstrar herança e polimorfismo de forma significativa.
