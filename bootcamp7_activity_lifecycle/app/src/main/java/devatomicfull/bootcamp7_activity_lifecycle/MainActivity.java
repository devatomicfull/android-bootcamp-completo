package devatomicfull.bootcamp7_activity_lifecycle;

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

        Log.w("my_log", "onCreate called");

        for (int i=0; i<9; i++){
            Log.d("for_log_output", i+" ");
        }
    }

    @Override
    protected void onStart() {
        super.onStart(); finish();
        Log.d("my_log", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("my_log", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("my_log", "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("my_log", "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("my_log", "onDestroy called");
    }

    public void btn_Clicado(View view){
        btn.setText("Clicado");
        Log.d("some_tag", "button is clicado");
    }
}