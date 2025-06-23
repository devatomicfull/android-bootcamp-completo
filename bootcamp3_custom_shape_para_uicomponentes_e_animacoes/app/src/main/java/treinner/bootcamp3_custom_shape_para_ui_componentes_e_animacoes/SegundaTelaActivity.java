package treinner.bootcamp3_custom_shape_para_ui_componentes_e_animacoes;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundaTelaActivity extends AppCompatActivity {
    private TextView textViewExibir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        textViewExibir = findViewById(R.id.textPalavra);

        String palavra = getIntent().getStringExtra("textoDigitado");
        textViewExibir.setText(palavra);
    }
}