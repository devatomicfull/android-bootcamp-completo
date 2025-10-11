package devatomic.bootcamp9_menu_testing;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Classe principal da aplicação que representa a tela inicial (Activity).
 *
 * Nesta classe, é demonstrado o uso dos métodos de ciclo de vida do menu de opções
 * (Options Menu), utilizado geralmente na Toolbar ou Action Bar.
 *
 * Cada método é documentado e exemplificado para mostrar seu uso prático.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Método chamado quando a Activity é criada.
     * Aqui definimos o layout principal da tela.
     *
     * Exemplo:
     *  - Quando a aplicação é aberta, o Android chama este método automaticamente.
     *  - O layout definido em activity_main.xml é carregado e exibido na tela.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Método chamado quando o menu de opções (menu da Toolbar) é criado pela primeira vez.
     *
     * Ele "infla" (ou carrega) o arquivo XML do menu e o transforma em itens visuais na Toolbar.
     *
     * Exemplo de arquivo XML (res/menu/main_menu.xml):
     * <menu xmlns:android="http://schemas.android.com/apk/res/android">
     *     <item android:id="@+id/menu_config"
     *           android:title="Configurações"
     *           android:icon="@drawable/ic_config" />
     *     <item android:id="@+id/menu_sobre"
     *           android:title="Sobre"
     *           android:icon="@drawable/ic_info" />
     * </menu>
     *
     * Resultado:
     *  - Os itens "Configurações" e "Sobre" aparecem no menu da Toolbar.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true; // Retornar true exibe o menu na tela
    }

    /**
     * Método chamado quando o usuário seleciona (clica) em um item do menu.
     *
     * Ele permite capturar o clique e realizar ações específicas para cada item.
     *
     * Exemplo:
     *  - Se o usuário clicar em "Configurações", podemos abrir uma nova tela de configurações.
     *  - Se clicar em "Sobre", podemos mostrar uma caixa de diálogo com informações do app.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Mostra um Toast com o título do item clicado (exemplo simples)
        Toast.makeText(this, "Clicado: " + item.getTitle(), Toast.LENGTH_SHORT).show();

        // Exemplo de tratamento real:
        /*
        switch (item.getItemId()) {
            case R.id.menu_config:
                startActivity(new Intent(this, ConfiguracoesActivity.class));
                return true;
            case R.id.menu_sobre:
                new AlertDialog.Builder(this)
                        .setTitle("Sobre o App")
                        .setMessage("Aplicativo de exemplo com menu na Toolbar.")
                        .setPositiveButton("OK", null)
                        .show();
                return true;
        }
        */

        return true; // Indica que o clique foi tratado
    }

    /**
     * Método chamado quando o menu de opções é fechado (por exemplo, ao tocar fora dele).
     *
     * Pode ser usado para executar ações após o menu ser fechado.
     *
     * Exemplo:
     *  - Registrar em log quando o menu é fechado.
     *  - Restaurar o estado de botões ou componentes na tela.
     */
    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        // Exemplo prático:
        // Log.d("Menu", "O menu foi fechado");
    }

    /**
     * Método chamado quando o menu é aberto (antes de ser exibido ao usuário).
     *
     * Pode ser usado para modificar dinamicamente itens do menu antes da exibição.
     *
     * Exemplo:
     *  - Atualizar o texto de um item de menu com o nome do usuário logado.
     *  - Habilitar ou desabilitar opções dependendo do estado do app.
     */
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        // Exemplo: atualizar título de um item antes do menu aparecer
        // menu.findItem(R.id.menu_usuario).setTitle("Usuário: João");
        return super.onMenuOpened(featureId, menu);
    }

    /**
     * Método chamado sempre que o menu vai ser mostrado novamente.
     *
     * Diferente do onCreateOptionsMenu, este é chamado toda vez que o menu
     * é preparado para exibição, permitindo atualizações em tempo real.
     *
     * Exemplo:
     *  - Mostrar ou ocultar opções de acordo com o estado do app.
     *  - Exemplo: esconder o botão "Sair" se o usuário ainda não estiver logado.
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Exemplo prático:
        // menu.findItem(R.id.menu_sair).setVisible(usuarioLogado);
        return super.onPrepareOptionsMenu(menu);
    }
}