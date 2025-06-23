package treinner.bootcamp3_custom_shape_para_ui_componentes_e_animacoes;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button btn_button;
    ProgressBar progressBar;
    TextView textView4;
    EditText editText_Digitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        // Animação para rotacionar para a esquerda (anti-horário)
        ObjectAnimator animator = ObjectAnimator.ofFloat(progressBar, "rotation", 0f, -360f);
        animator.setDuration(1000); // 1 segundo
        animator.setRepeatCount(ValueAnimator.INFINITE); // Roda para sempre
        animator.setInterpolator(new LinearInterpolator()); // Movimento constante
        animator.start();
    }

    private void initViews() {
        btn_button = findViewById(R.id.clique);
        progressBar = findViewById(R.id.progress);
        textView4 = findViewById(R.id.textView8);
        editText_Digitado = findViewById(R.id.editTextDigitado);
    }

    public void animated(View view) {
        if (view == btn_button){
            btn_button.animate().rotationYBy(180).start();
            //textView4.animate().rotationX(120).start();
            //textView4.animate().alpha(0).setDuration(1500).start();
            //textView4.animate().scaleY(1.2f).scaleX(1.2f).setDuration(1500).start();
            textView4.animate().translationX(300).start();
            indoParaSegundaTelaActivity();
        }

    }

    public void indoParaSegundaTelaActivity(){
        Intent intencao = new Intent(MainActivity.this, SegundaTelaActivity.class);
        intencao.putExtra("textoDigitado", editText_Digitado.getText().toString());
        startActivity(intencao);
    }
}