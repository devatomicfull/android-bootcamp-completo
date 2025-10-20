
# Bootcamp Android - Repositório de Exercícios

## Sumário

- [Botão, Eventos de Clique e Mudança de Cor do BackGround do App](#bootcamp1)
- [Botão, Eventos de Clique e Mudança de Cor do thumb do Switch, Uso do TextToSpeech para leitura de textos, DatePicker e Eventos de Alteração de Data](#bootcamp2)
- [Customização de Shapes (Formas), Animações, Progress Bar e Intent (É um objeto que representa a intenção de realizar uma ação)](#bootcamp3)
- [Ciclo de Vida das Activity.java Activity.xml)](#bootcamp4)
- [SharedPreferences, Preferências persistentes no app](#bootcamp5)
- [Logcat e Registro para Fins de Depuração](#bootcamp6)
- [Ciclo de Vida da Activity e da Application](#bootcamp7)
- [Streaming de Vídeo Online ou Reprodução Local no Android](#bootcamp8)
- [Menus e Interações com a Toolbar no Android](#bootcamp9)
- [Temas (Themes), Estilos (Styles) e Aplicação de Style por Activity](#bootcamp10)
- [Animais Apps](#bootcamp11)

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

## <a id="bootcamp6"></a> Tópico 6: Logcat e Registro para Fins de Depuração no Android

Este exercício demonstra como utilizar o **Logcat** no Android para registrar informações importantes durante a execução do aplicativo. Permite acompanhar eventos do ciclo de vida, interações do usuário e execução de loops, facilitando a depuração.

### Conceitos abordados:
- Uso da classe `Log` do Android para registrar mensagens no Logcat.
- Diferentes níveis de log:
  - `Log.d()` – Debug
  - `Log.i()` – Informação
  - `Log.w()` – Aviso
  - `Log.e()` – Erro
- Uso de **TAGs** para identificar a origem das mensagens no Logcat.

### Exemplos de uso:
- Registrar a chamada do método `onCreate()`:
  ```java
  Log.d("TAG", "método onCreate chamado");

### Exemplos de consulta/depuracao no Logcat no androidStudio :
- tag=:TAG

## <a id="bootcamp7"></a> Tópico 7: Ciclo de Vida da Activity e da Application no Android


### Descrição do Projeto
Este exercício demonstra e compara os ciclos de vida de uma **Activity** e da **Application** em aplicações Android. O objetivo é entender sequências de callbacks, onde inicializar recursos, como depurar com `Logcat` e as diferenças práticas entre os ciclos de vida das duas entidades.


### Ciclo de Vida da Activity e da Application
Análise detalhada das chamadas de lifecycle, mostrando como e quando cada método é executado, com exemplos práticos usando `Log` para inspeção via Logcat.


### Conceitos abordados
- Ciclo de vida da **Activity**: `onCreate()`, `onStart()`, `onResume()`, `onPause()`, `onStop()`, `onDestroy()`, `onRestart()`.
- Ciclo de vida da **Application**: `onCreate()` (executado quando o processo da aplicação é criado).
- Uso do `Log` (Log.d, Log.w, Log.i, Log.e) para depuração.
- Filtragem de logs no Logcat por TAG e nível.


### Exemplos de uso (logs / códigos)

### `App.java` (Application)
```java
package devatomicfull.bootcamp7_activity_lifecycle;

import android.app.Application;
import android.util.Log;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("my_log", "APP onCreate called"); // chamado primeiro, quando o processo é criado
    }
}
```
Obs.: App deve estar declarada no AndroidManifest.xmlvia android:name=".App"(já presente no projeto).

### 📱 Ciclo de Vida - Application

- Instância **única por processo**;  
- O método **`onCreate()`** é chamado **uma vez** quando o processo do aplicativo inicia;  
- O ciclo de vida está ligado **ao processo do aplicativo**;  
- Ideal para **inicializar singletons**, bibliotecas e configurações globais que precisam existir enquanto o processo estiver ativo;  
- ⚠️ **Não confie em `onTerminate()` em produção** — ele é chamado apenas em emuladores ou em alguns cenários específicos, **não faz parte do ciclo normal de apps Android**.

---

### 🧭 Ciclo de Vida - Activity

- Podem existir **várias instâncias** (uma por tela ou `Intent`);  
- Ciclo de vida está relacionado à **visibilidade e interação da interface do usuário**;  
- Métodos principais chamados durante o ciclo:  
  - **`onCreate()`** → Quando a Activity é criada;  
  - **`onStart()`** → Quando a Activity se torna visível;  
  - **`onResume()`** → Quando está pronta para interação com o usuário;  
  - **`onPause()`** → Quando outra Activity ganha foco;  
  - **`onStop()`** → Quando deixa de ser visível;  
  - **`onDestroy()`** → Antes de ser destruída.  
- Deve gerenciar recursos **relacionados à UI**, como:  
  - Registrar ouvintes (`listeners`);  
  - Pausar animações;  
  - Liberar sensores e outros recursos visuais;  
- Mais suscetível a eventos intermediários como:  
  - **Mudança de orientação**;  
  - **Troca de atividade**;  
  - **Usuário saindo do app**.

---

## 🧩 Resumo Prático

- Utilize **`Application.onCreate()`** para:
  - Inicializações **globais** (ex.: banco de dados, singletons, bibliotecas, configurações).  
- Utilize os métodos de **`Activity`** para:
  - **Lógica da interface**, controle de **visibilidade** e **estado da tela**.  

## <a id="bootcamp8"></a> Tópico 8: Streaming de Vídeo Online ou Reprodução Local no Android

## Objetivo
Demonstrar diferentes formas de reproduzir vídeos no Android, usando VideoView, SurfaceView, TextureView e ExoPlayer/Media3.

## Uso
- Reproduzir vídeos locais (res/raw) ou remotos (HLS, MP4)
- Testar ciclos de vida de MediaPlayer e ExoPlayer
- Demonstrar diferentes formas de construir URI para recursos internos
- Ensinar boas práticas de liberação de recursos e integração com UI

## Classes / Arquivos
- MainActivity.java
- activity_main.xml

## Para que serve
- Ensinar reprodução de vídeo eficiente e moderna no Android
- Fornecer exemplos de streaming e manipulação de superfícies
- Demonstrar integração de Media3 ExoPlayer para streaming profissional

## Alternativas / melhorias futuras
- Suporte a DASH e adaptive streaming
- Player customizado usando VideoDecoderGLSurfaceView
- Controle avançado de buffering e eventos de erro
- UI customizada com overlays e transformações usando TextureView

## Modos de reprodução
- **VideoView**: simples, rápido, fácil de usar
- **SurfaceView**: controle da superfície de renderização
- **TextureView**: renderização flexível, transformações e overlays
- **ExoPlayer / Media3**: player avançado para streaming, HLS/DASH e performance

## Diferença entre VideoView, SurfaceView e TextureView
- VideoView: rápido, fácil, limitado
- SurfaceView: eficiente, integra OpenGL, ideal para customizações
- TextureView: flexível, permite animações, filtros e overlays
- ExoPlayer/Media3: moderno, streaming, controle total, GPU-friendly


## <a id="bootcamp9"></a> Tópico 9: Menus e Interações com a Toolbar no Android

## Objetivo
Demonstrar o uso do **Options Menu** no Android, incluindo criação, manipulação e tratamento de eventos de clique nos itens do menu exibidos na **Toolbar** ou **Action Bar**.

## Uso
- Criar menus através de arquivos XML em `res/menu/`
- Inflar o menu na Toolbar via `onCreateOptionsMenu`
- Detectar e tratar cliques em itens com `onOptionsItemSelected`
- Atualizar dinamicamente itens de menu com `onPrepareOptionsMenu`
- Executar ações ao abrir e fechar o menu

## Classes / Arquivos
- `MainActivity.java`
- `activity_main.xml`
- `res/menu/main_menu.xml`

## Para que serve
- Demonstrar o ciclo de vida do menu de opções no Android
- Ensinar como personalizar menus e reagir a eventos de usuário
- Mostrar como inflar menus XML e associar ações programaticamente
- Exemplo prático de integração entre XML e código Java na UI

## Alternativas / Melhorias Futuras
- Implementar menus contextuais (long press)
- Adicionar **PopupMenu** para ações rápidas
- Usar **BottomAppBar** e **NavigationView** para menus modernos
- Integrar **MaterialToolbar** para consistência visual

## Métodos Importantes
| Método | Descrição |
|--------|------------|
| `onCreateOptionsMenu(Menu menu)` | Infla o menu XML e exibe os itens na Toolbar |
| `onOptionsItemSelected(MenuItem item)` | Trata cliques nos itens do menu |
| `onPrepareOptionsMenu(Menu menu)` | Atualiza dinamicamente os itens antes de exibir |
| `onMenuOpened(int featureId, Menu menu)` | Executa ações quando o menu é aberto |
| `onOptionsMenuClosed(Menu menu)` | Executa ações quando o menu é fechado |

## Exemplo de XML (`res/menu/main_menu.xml`)
```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/menu_config"
        android:title="Configurações"
        android:icon="@drawable/ic_config"
        android:showAsAction="ifRoom" />
    <item
        android:id="@+id/menu_sobre"
        android:title="Sobre"
        android:icon="@drawable/ic_info"
        android:showAsAction="ifRoom" />
</menu>
```

## <a id="bootcamp10"></a> Tópico 10: Temas, Styles e Aplicação de Style por Activity

## Objetivo
Trabalhar conceitos de **theme**, **style**, `AndroidManifest.xml`, `colors.xml`, `themes.xml` (light) e `themes.xml (night)` e aplicar um **style customizado** em uma Activity de forma individual.

## Uso
- Definir paleta de cores em `colors.xml`
- Criar tema base (light) em `res/values/themes.xml`
- Criar tema para night mode em `res/values-night/themes.xml`
- Criar styles auxiliares (overflow, MyStyle) em `res/values/styles.xml` ou em `themes.xml`
- Aplicar o tema global via `AndroidManifest.xml`
- Sobrescrever tema de uma Activity individual via atributo `android:theme` no `AndroidManifest.xml`

## Classes / Arquivos
- `res/values/colors.xml`
- `res/values/themes.xml`
- `res/values-night/themes.xml`
- `res/values/styles.xml` (ou mesclado em themes)
- `AndroidManifest.xml`
- `MainActivity.java`
- `TestandoMeuStyleActivity.java` (Activity que usa `MyStyle`)

## Para que serve
- Demonstrar a hierarquia Theme → Style → componente
- Ensinar como suportar modo claro/escur o (DayNight)
- Mostrar como aplicar um style apenas em uma Activity específica sem afetar o app todo
- Expor boas práticas de organização de paleta de cores e temas

## Alternativas / melhorias futuras
- Usar `ThemeOverlay` para variações locais sem duplicar temas
- Ativar **Dynamic Color (Material You)** para Android 12+
- Separar estilos por componentes (`themes.xml`, `styles.xml`, `colors.xml`) de forma mais granular
- Implementar troca de tema em runtime via código (SharedPreferences + recreate())

## Conteúdo dos arquivos (exatos trechos fornecidos)

### styles / themes (Night / base com OverFlow e MyStyle)
```xml
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Base.Theme.Bootcamp9_menu_testing" parent="Theme.Material3.DayNight">
        <!-- Customize your light theme here. -->
        <item name="colorPrimary">@color/primaryDark</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="android:colorBackground">@color/colorBackgroundDark</item>
        <item name="colorAccent">@color/colorAccent</item>
        <item name="iconTint">@color/purple</item>

        <item name="android:actionOverflowButtonStyle">@style/Base.Theme.Bootcamp9_menu_testing.OverFlow</item>
    </style>

    <style name="Base.Theme.Bootcamp9_menu_testing.OverFlow">
        <item name="android:src">@drawable/ic_camera</item>
        <item name="tint">#D78C1D</item>
        <item name="android:paddingRight">8dp</item>
    </style>

    <style name="MyStyle" parent="Theme.AppCompat.NoActionBar">
        <item name="android:colorPrimary">@color/purple</item>
        <item name="backgroundColor">#D78C1D</item>
        <item name="colorPrimaryDark">#FF0257</item>
    </style>
</resources>
```

## <a id="bootcamp11"></a> Tópico 11: Animais Apps

## Objetivo
Este projeto tem como objetivo demonstrar o uso do RecyclerView no Android para exibir uma lista dinâmica e otimizada de elementos personalizados, neste caso, uma coleção de animais.

O RecyclerView foi escolhido por oferecer uma estrutura moderna e eficiente para renderização de listas ou grades de dados, substituindo o antigo ListView. Sua principal vantagem está na reutilização inteligente de Views (ViewHolder pattern), o que reduz o consumo de memória e melhora o desempenho, especialmente em listas extensas.


## Uso
Uso de lista dinâmica personalizada  com o uso do RecyclerView e Adapter e seu uso com layout personalizado (customizado)

## Classes / Arquivos
Estrutura e Componentes Utilizados
RecyclerView: Componente principal responsável pela exibição da lista dinâmica.
Adapter personalizado (AnimalAdapter): Responsável por inflar o layout de cada item e associar os dados (nome e imagem do animal) às Views.
ViewHolder (AnimalRowHolder): Implementado dentro do adapter para armazenar e reutilizar as referências dos componentes visuais, evitando chamadas repetitivas a findViewById().
Classe de modelo (Animal): Representa os dados de cada item (nome e imagem).
Classe de armazenamento (AnimalStorage): Centraliza e fornece a lista de objetos Animal, utilizando referências a imagens do diretório drawable e nomes definidos em arrays.xml.
Layouts XML: Definem a estrutura visual de cada linha (animal_row.xml) e da tela principal (activity_main.xml).
## Para que serve 
O que é o TypedArray?
O TypedArray é uma estrutura de dados interna do Android que representa um conjunto de recursos carregados em tempo de execução, onde cada item pode ser de diferentes tipos — por exemplo:

@drawable/... (imagens)
@color/... (cores)
@string/... (textos)
@dimen/... (dimensões)
@layout/... (layouts)
Em resumo:
🔹 TypedArray é um contêiner que o Android usa para armazenar temporariamente recursos carregados de XML, permitindo acesso rápido via índice.

Onde ele é usado e por quê

```java
TypedArray typedArray = context.getResources().obtainTypedArray(R.array.animais_imgs);
```

Você está pedindo ao Android:

“Por favor, carregue todos os recursos que estão definidos no array animais_imgs dentro de res/values/arrays.xml.”
Isso cria um objeto em memória (na RAM) que contém referências internas aos recursos (R.drawable.bode, R.drawable.cao, etc).
Assim, você pode percorrer o array em tempo de execução e usar:

typedArray.getResourceId(i, -1);

para pegar o identificador real (exemplo: 2131165290), que o Android usa para localizar a imagem dentro do pacote do app.

## Onde o recurso é armazenado

O `TypedArray` trabalha em duas camadas principais dentro do Android:

| Camada | 📁 Localização | 📦 O que contém |
|-----------|----------------|----------------|
| ** No APK (em disco)** | Dentro do diretório `res/` e empacotado no APK final (`res/drawable`, `res/values/arrays.xml`) | Os arquivos originais declarados no projeto (imagens, arrays, strings, etc). |
| ** Em memória (RAM)** | Quando você chama `obtainTypedArray()` | Uma estrutura interna do Android que **referencia** (aponta para) os recursos empacotados, permitindo acesso dinâmico em tempo de execução. |

Portanto, o TypedArray não carrega as imagens completas — ele mantém ponteiros (referências) para os recursos armazenados no pacote do app.

Por que precisa chamar recycle()
Quando você chama: typedArray.recycle();

Você está devolvendo o objeto TypedArray para um pool interno de memória do Android.

Isso significa que o Android pode reutilizar essa estrutura mais tarde, em vez de alocar memória nova toda vez que obtainTypedArray() for chamado.
É uma técnica de reuso de buffer, muito comum em sistemas embarcados e mobile.

Se você não chamar recycle(), pode ocorrer vazamento de memória (memory leak), especialmente em loops ou listas grandes, porque o buffer interno não será liberado.

🧠 Em resumo

|  Conceito | 💡 Explicação curta |
|-------------|--------------------|
| **TypedArray** | Estrutura temporária na memória que guarda referências a recursos XML. |
| **Obtido de** | `context.getResources().obtainTypedArray(R.array.meu_array)` |
| **Armazena** | Identificadores de recursos (`int`) e metadados. |
| **Fica armazenado** | Em memória (RAM), dentro do sistema de recursos do Android. |
| **Precisa liberar?** | Sim, com `typedArray.recycle()` após o uso. |
| **Por quê?** | Evita vazamento de memória e mantém eficiência do pool interno. |

```xml
res/values/arrays.xml
   ↓
compilado em R.java (R.array.animais_imgs)
   ↓
obtainTypedArray(R.array.animais_imgs)
   ↓
TypedArray (na RAM)
   ↓
getResourceId(i, -1) → R.drawable.cavalo
   ↓
ImageView.setImageResource(R.drawable.cavalo)
   ↓
typedArray.recycle() → devolve ao sistema
```

## Funcionalidades e Características
Exibição de uma lista dinâmica de animais com nomes e imagens.
Utilização de recursos de imagem localizados em múltiplas densidades hdpi, xhdpi, xxhdpi, xxxhdpi para compatibilidade visual.
Implementação modular e reutilizável, separando lógica de apresentação, dados e interface.
Possibilidade de alternar entre layout linear (lista) e layout em grade (grid) utilizando LinearLayoutManager ou GridLayoutManager.


## Como Executar

1. Clone o repositório:  
   ```bash
   git clone https://github.com/devatomicfull/android-bootcamp-completo.git 
   ```    
