---

## 📋 Sobre o Projeto

O **Terminal Quest** não é apenas um jogo de texto; é uma implementação prática de padrões de projeto aplicados a um ambiente restritivo (o terminal). O objetivo principal foi consolidar os pilares da **Programação Orientada a Objetos (POO)** sem a dependência de frameworks externos, garantindo o entendimento profundo da linguagem Java e da JVM.

O sistema simula um ciclo de jogo infinito (*Game Loop*), com progressão de dificuldade, economia in-game e um sistema de temporização customizado via Threads.

---

## ⚙️ Arquitetura e Decisões Técnicas

A estrutura do projeto foi desenhada para separar responsabilidades, evitando *God Classes* e promovendo a manutenibilidade. A organização de pacotes segue uma lógica semântica:

```text
src/
├── app/           # Entry Point (Main)
├── engine/        # Núcleo da simulação (GameLoop, Menu)
├── entities/      # Modelos de domínio ricos (Player, Enemy)
├── items/         # Objetos de valor e inventário (Weapon, Potion)
├── shop/          # Lógica de comércio e transações
└── utils/         # Utilitários agnósticos ao domínio (Clock, Stopwatch)
```

### Destaques da Implementação

*   **Game Loop Pattern:** Implementação manual do ciclo de vida do jogo, gerenciando a renderização (textual), entrada de dados e atualização de estado em um fluxo contínuo `while(true)`.
*   **Gestão de Estado e Encapsulamento:** Todas as entidades (`Player`, `Enemy`) protegem seus dados internos (`private fields`), expondo apenas comportamentos necessários através de métodos públicos, garantindo a integridade dos dados durante o combate.
*   **Custom Thread Management:** Em vez de depender apenas de pausas simples, foi desenvolvido um pacote `utils.clock` com as classes `Stopwatch` e `ClockHand`. Isso simula um relógio mecânico orientado a objetos para gerenciar "loading times" e suspense, manipulando `Thread.sleep` de forma abstraída.
*   **Java Text Blocks & Formatting:** Uso intensivo de *Text Blocks* (Java 15+) e `String.format` para criar uma interface de usuário (UI) limpa e tabular dentro do console, superando as limitações visuais do terminal.

---

## 🎮 Funcionalidades

*   **Sistema de Combate:** Lógica de turnos com cálculo de dano, verificação de vida e condições de vitória/derrota.
*   **Escalonamento de Dificuldade:** O método `newEnemy` implementa uma *Factory* simplificada que gera inimigos mais fortes (Slime -> Goblin -> Dragão) conforme o nível do jogador aumenta.
*   **Sistema Econômico:** Drop de ouro ao vencer batalhas e uma loja funcional (`Shop`) para compra de armas e poções.
*   **Feedback Visual:** Telas de status detalhadas e menus interativos com limpeza de tela programática.

---

## 💻 Demonstração (Preview)

Abaixo, uma representação da interface gerada pelo motor no console:

```text
==================================
|          PLAYER  STATUS        |
----------------------------------
| ♥️  VIDA: 100                  |
| ⚔️  ATAQUE: 5                  |
| 💰 OURO: 50                    |
| ⬆️  FASE: 3                    |
==================================
```

---

## 🚀 Como Executar o Projeto

O projeto não possui dependências externas além do JDK. Certifique-se de ter o **Java 17+** instalado.

### 1. Clonar e Acessar
```bash
git clone https://github.com/Caua5xx/Terminal-Game.git
cd Terminal-Game
```

### 2. Compilar e Executar
Utilize o comando abaixo para compilar todos os arquivos fonte para o diretório `target` e executar a classe principal, garantindo que o Classpath esteja correto:

```bash
javac -d target src/**/*.java && java -cp target app.Main
```

---

## 🛠️ Tecnologias Utilizadas

*   **Java 17:** Linguagem core, escolhida pela robustez e tipagem estática.
*   **Java IO & Util:** `Scanner` para input handling e estruturas lógicas.
*   **Java Threads:** Manipulação de concorrência básica para temporização da UX.