
# Bootcamp Android - Repositório de Exercícios

## Sumário

- [Botão, Eventos de Clique e Mudança de Cor do BackGround do App](#bootcamp1)
- [Botão, Eventos de Clique e Mudança de Cor do thumb do Switch, Uso do TextToSpeech para leitura de textos, DatePicker e Eventos de Alteração de Data](#bootcamp2)
- [Customização de Shapes (Formas), Animações, Progress Bar e Intent (É um objeto que representa a intenção de realizar uma ação)](#bootcamp3)
- [Ciclo de Vida das Activity.java Activity.xml)](#bootcamp4)
- [SharedPreferences, Preferências persistentes no app](#bootcamp5)
---

## Descrição do Projeto
Este repositório contém exercícios práticos desenvolvidos durante o Bootcamp Android, focando em componentes visuais, interação com o usuário e recursos da plataforma Android como eventos, mensagens etc.

## <a id="bootcamp1"></a> Tópico 1: Botão, Eventos de Clique e Mudança de Cor do Background do App
Este exercício demonstra formas diferentes de implementar eventos de clique em botões dentro de uma Activity Android, manipulando o layout para alterar a cor do background da aplicação, aplicar filtros de cor (tint) e usar drawables como fundo. Além disso, apresenta os conceitos importantes do uso do `Button`, interface `OnClickListener`, modos de combinação de cores (`PorterDuff.Mode`) e o gerenciamento do background da `View`.

## <a id="bootcamp2"></a> Tópico 2: Botão, Eventos de Clique e Mudança de Cor do thumb do Switch, Uso do TextToSpeech para leitura de textos, DatePicker e seus Evento de alteração de data
Este exercício demonstra a integração de diferentes componentes interativos em uma Activity Android, como `Button`, `EditText`, `DatePicker` e `SwitchCompat`, permitindo a entrada de dados, controle de estado e feedback visual e sonoro ao usuário. Através da manipulação de eventos de clique e mudança de estado, é possível exibir a idade com base na data de nascimento selecionada e, opcionalmente, fazer a leitura em voz alta usando a API `TextToSpeech`.

Além disso, apresenta os conceitos importantes do uso da interface `OnClickListener` e `OnCheckedChangeListener`, manipulação do `SwitchCompat` com mudança dinâmica da cor do *thumb* através de `setThumbTintList()`, uso de `DatePicker` com evento de alteração de data via `setOnDateChangedListener`, exibição de mensagens utilizando `Toast` para avisos rápidos e `Snackbar` para notificações contextuais com possibilidade de ação, além da inicialização e controle do ciclo de vida do mecanismo de voz `TextToSpeech`.

Esse exercício reforça boas práticas de estruturação do código, validação de entradas do usuário, utilização de recursos do sistema e melhoria da acessibilidade por meio de respostas multimodais (visuais e auditivas).

## <a id="bootcamp3"></a> Tópico 3: Custom shape, animações usando progress bar, shapes, classes e metodos para animações. Intent para passar dados e trocar de tela.
Este exercício demonstra o uso de elementos visuais personalizados e animações para tornar a interface mais interativa e atrativa no Android. Entre os principais conceitos abordados estão:

Customização de componentes com arquivos drawable XML usando <shape>:Criação de botões com cantos arredondados e gradientes de cor.

Uso de formas como rectangle, oval, line e ring para estilizar elementos visuais como `ProgressBar`, `TextView` e `Button`.

Animações com `ObjectAnimator` e `ValueAnimator` aplicadas ao `ProgressBar` e botões: Rotação contínua do progresso.Translação e rotação de botões e textos ao interagir com o usuário.

Uso de `Intent` para navegação entre telas (Activities): Envio de texto digitado no `EditText` da tela principal para a segunda tela (`SegundaTelaActivity`). 

Uso de putExtra e getStringExtra para transportar dados entre atividades. Este exercício consolida a compreensão de personalização visual, uso de animações e comunicação entre telas em um aplicativo Android.

## <a id="bootcamp4"></a> Tópico 4: Ciclo de Vida da Activity

Este exercício demonstra o ciclo de vida de uma Activity no Android, explicando os métodos fundamentais que controlam o estado de uma tela, como criação, pausa, retomada e destruição. O objetivo é que o desenvolvedor compreenda como gerenciar recursos, salvar estados temporários e reagir a mudanças de visibilidade da tela de forma eficiente.

### Conceitos abordados:
- **onCreate()** – inicialização da Activity e configuração do layout.
- **onStart()** – Activity prestes a se tornar visível ao usuário.
- **onResume()** – Activity pronta para interação.
- **onPause()** – Activity parcialmente oculta, ideal para salvar estados temporários.
- **onStop()** – Activity completamente oculta, libera recursos que não precisam mais estar ativos.
- **onDestroy()** – Activity prestes a ser destruída, momento para liberar recursos finais.
- **onRestart()** – Activity reiniciada após ter sido parada.

### Exemplos de uso:
- Salvar e restaurar estados de UI usando `onSaveInstanceState` e `onRestoreInstanceState`.
- Pausar e retomar animações, vídeos ou sons conforme o estado da Activity.
- Gerenciar conexões de rede e sensores para evitar consumo desnecessário quando a Activity não está visível.

### Boas práticas:
- Evitar operações pesadas em `onCreate()`; usar `onStart()` ou `onResume()` quando possível.
- Liberar recursos em `onPause()` ou `onStop()` para otimizar memória.
- Utilizar `onSaveInstanceState` para salvar dados temporários do usuário.

### Arquivos / Classes principais:
- `MainActivity.java` – demonstra a implementação dos métodos de ciclo de vida.
- Layout XML (`activity_main.xml`) – interface simples com TextView ou logs para acompanhar os estados.

## <a id="bootcamp5"></a> Tópico 5: Gerenciamento de Preferências com SharedPreferences

Este exercício demonstra o uso de **SharedPreferences** no Android para salvar e recuperar configurações do usuário, como o estado de notificações, garantindo persistência entre sessões do app.

### Conceitos abordados:
- Uso de `SharedPreferences` para armazenamento simples de dados chave-valor.
- Leitura e escrita de valores booleanos no SharedPreferences.
- Atualização da interface com base nas preferências salvas.
- Listener `OnCheckedChangeListener` para capturar alterações do usuário.

### Exemplos de uso:
- Controlar o estado de notificações do usuário com um `Switch`.
- Salvar automaticamente alterações usando `apply()` ou `commit()`.
- Ler preferências salvas ao iniciar a Activity para configurar a interface corretamente.

### Boas práticas:
- Evitar operações pesadas ao salvar preferências.
- Inicializar SharedPreferences no `onCreate()` da Activity.
- Usar constantes para as chaves das preferências para evitar erros de digitação.

### Arquivos / Classes principais:
- `MainActivity.java` – implementa o Switch e gerencia as preferências.
- Layout XML (`activity_main.xml`) – contém o Switch de notificações.

## Como Executar

1. Clone o repositório:  
   ```bash
   git clone https://github.com/devatomicfull/android-bootcamp-completo.git 
