
# Bootcamp Android - Repositório de Exercícios

## Sumário

- [Botão, Eventos de Clique e Mudança de Cor do BackGround do App](#bootcamp1)
- [Botão, Eventos de Clique e Mudança de Cor do thumb do Switch, Uso do TextToSpeech para leitura de textos, DatePicker e Eventos de Alteração de Data](#bootcamp2)
- [Customização de Shapes (Formas), Animações, Progress Bar e Intent (É um objeto que representa a intenção de realizar uma ação)](#bootcamp3)
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

## Como Executar

1. Clone o repositório:  
   ```bash
   git clone https://github.com/devatomicfull/android-bootcamp-completo.git 
