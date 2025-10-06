package devatomic.bootcamp6_logcat_registro_para_fins_depuracao_android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        Log.d("TAG", "\n" +
                "método onCreate chamado"+ "\n" );


        for (int i=0; i < 9; i++){
            Log.d("for_log_output", i+ " depuração");
        }
    }

    public void btnClicado(View view) {
        btn.setText("Changed");
        Log.d("btn", "Botão foi Clicado");

    }

}