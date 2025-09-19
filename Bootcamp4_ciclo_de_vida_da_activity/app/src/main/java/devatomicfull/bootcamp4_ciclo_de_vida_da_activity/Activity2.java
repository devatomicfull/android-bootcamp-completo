package devatomicfull.bootcamp4_ciclo_de_vida_da_activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Activity2 extends Activity {
    private ConstraintLayout fundo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        fundo = findViewById(R.id.main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, 1234);
            } else {
                startService(new Intent(this, IconeFlutuanteService.class));
            }
        } else {
            startService(new Intent(this, IconeFlutuanteService.class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mostrarCorComDelay(Color.RED, "Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mostrarCorComDelay(Color.GREEN, "Restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mostrarCorComDelay(Color.MAGENTA, "Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mostrarCorComDelay(Color.BLUE, "Resume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mostrarCorComDelay(Color.YELLOW, "Start");
    }

    private void mostrarCorComDelay(int cor, String texto) {
        // muda fundo da Activity
        fundo.setBackgroundColor(cor);

        // mostra mensagem
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();

        // envia a cor para o serviço atualizar o ícone
        Intent intent = new Intent(this, IconeFlutuanteService.class);
        intent.putExtra("COR", cor);
        startService(intent);

        // volta para branco depois de 2.5s
        fundo.postDelayed(() -> fundo.setBackgroundColor(Color.WHITE), 2500);
    }
}
