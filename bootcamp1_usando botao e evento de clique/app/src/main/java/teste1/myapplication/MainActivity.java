package teste1.myapplication;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener { // Implementando a interface diretamente na MainActivity para eu delegar o que o/os botao pode realizar
    private ConstraintLayout main;
    private Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando as refêrencias dos Botoes do xml da activity_main
        initViews();

        // Forma Numero 2 de evento de clique usando a interface diretamente dentro do Parametro
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * Define uma cor sólida como fundo.
                * Recebe um inteiro representando uma cor (Color.RED, Color.parseColor(), ou recursos de cor).
                * Simples e direto para cores sólidas. */
                main.setBackgroundColor(Color.GREEN);
                //ou
                main.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            }
        });

        // informando ao botao que a MainActivity implementa o OnclickListener
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);


    }



    private void initViews() {
        main = findViewById(R.id.main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
    }

    // Forma Numero 1 de evento de clique usando o atributo onclick na view Button no xml
    public void btn_Clicado(View view) {
        //main.setBackgroundTintMode();
        /*
        * Define um Drawable como fundo da view.
        * Aceita qualquer tipo de Drawable: imagens, formas (shape), gradientes, etc.
        * Útil quando você quer usar arquivos de drawable como shape.xml, imagens (.png, .jpg), vetores (.xml), etc. */
        main.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_launcher_background));
        //main.setBackgroundResource();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn3){
            main.setBackgroundTintMode(PorterDuff.Mode.CLEAR);
            /*
            * Define um recurso de drawable como fundo.
            * É uma forma simplificada que internamente faz o equivalente a:
            * setBackground(ContextCompat.getDrawable(context, resId));
            * Funciona bem para recursos simples. Menos flexível que usar setBackground() diretamente com Drawable.
            */
            main.setBackgroundResource(android.R.drawable.alert_dark_frame);
        }else if (v.getId() == R.id.btn4){

            /* Define o modo de mesclagem (blend) da tinta aplicada ao fundo.
            * Funciona junto com setBackgroundTintList().
            * Controla como a cor de tinta (tint) se mistura com o fundo. */

            // Tint (filtro de cor sobre o background atual) -- Aplica uma cor com modo de mesclagem sobre o fundo
            main.setBackgroundTintList(ColorStateList.valueOf(Color.MAGENTA));
            /*
             * define COMO essa tintura vai se combinar com o background.
             *
             * Isso é chamado de "Blend Mode" (Modo de Combinação), que basicamente é uma regra matemática que mistura a cor da tintura (source)
             * com o background existente (destination) para gerar um resultado visual.
             *
             * Exemplo simples de Blend Mode:
             * → MULTIPLY → Multiplica os valores das cores. Resulta em uma cor mais escura.
             *               Branco não altera nada (x1), preto apaga tudo (x0).
             * → SRC_IN → Mantém apenas a tintura dentro da forma do background, é o mais usado para pintar shapes e ícones.
             *
             *  Em resumo:
             * - setBackgroundTintList() → Define a cor da tintura.
             * - setBackgroundTintMode() → Define como essa cor se mistura com o background.
             *
             * Se quer só trocar de cor → use setBackgroundColor().
             * Se quer um efeito visual (mistura, sombra, sobreposição) → use Tint + TintMode.
             */
            main.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);


        }
    }
}