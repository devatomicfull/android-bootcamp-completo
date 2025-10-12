package devatomic.bootcamp9_menu_testing;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, TestandoMeuStyleActivity.class));
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true; // Retornar true exibe o menu na tela
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Mostra um Toast com o título do item clicado (exemplo simples)
        Toast.makeText(this, "Clicado: " + item.getTitle(), Toast.LENGTH_SHORT).show();

        return true; // Indica que o clique foi tratado
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        // Exemplo prático:
        // Log.d("Menu", "O menu foi fechado");
    }
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        // Exemplo: atualizar título de um item antes do menu aparecer
        // menu.findItem(R.id.menu_usuario).setTitle("Usuário: João");
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Exemplo prático:
        // menu.findItem(R.id.menu_sair).setVisible(usuarioLogado);
        return super.onPrepareOptionsMenu(menu);
    }
}