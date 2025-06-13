package treiner.bootcamp2_toast_avisos_snackbar_notificacao_com_opcoes_de_acao;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener, CompoundButton.OnCheckedChangeListener {
    private EditText ediText_Nome;
    private String nome;
    private DatePicker datePicker_SelecionadorDeData;
    private SwitchCompat switchCompat_Ativador_DeVoz;
    private Boolean ttsAtivado = false;
    private MaterialButton btn_Idade;
    private ImageView img_Idade;
    private String dataSpinnner;
    private TextToSpeech tts; // Sintetiza a fala a partir do texto para reprodução imediata ou para criar um arquivo de som.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando as variaveis
        initViews();

        // EditText_Nome --> possui um evento ao ser Clicado
        ediText_Nome.setOnClickListener(this);
        btn_Idade.setOnClickListener(this);
        switchCompat_Ativador_DeVoz.setOnCheckedChangeListener(this);

        tts = new TextToSpeech(this, this);

        /**
         * Pegando os daddos do DatePicker E executa um evento quando a data é alterada
         */
        datePicker_SelecionadorDeData.init(
                datePicker_SelecionadorDeData.getYear(),
                datePicker_SelecionadorDeData.getMonth(),
                datePicker_SelecionadorDeData.getDayOfMonth(),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
                        LocalDate dataLocalDoSistema = LocalDate.now();
                        int anoSistema = Integer.parseInt(formatter.format(dataLocalDoSistema));
                        dataSpinnner = String.valueOf (anoSistema - year);
                        String data = "Data alterada: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year ;
                        mostarAviso_EmTempoCurto_Usando_Toast(data);
                        if (ttsAtivado){
                            tts.speak(data,TextToSpeech.QUEUE_FLUSH,null,null);
                        }
                    }
                }
        );


    }

    /**
     * Inicializa Todas variaveis view
     */
    private void initViews() {
        ediText_Nome = findViewById(R.id.editText_Nome);
        datePicker_SelecionadorDeData = findViewById(R.id.dataPicker_SelecionarData);
        switchCompat_Ativador_DeVoz = findViewById(R.id.switchParaOuvir);
        img_Idade = findViewById(R.id.img_Idade);
        btn_Idade = findViewById(R.id.btn_idade);
    }

    /**
     * Chamado quando uma visualização é clicada.
     *
     * @param v A view que foi clicada.
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(ediText_Nome != null && !ediText_Nome.getText().toString().isEmpty()){
            if (dataSpinnner != null){
                // Se a View que possui evento for Clicada e do id (x) executar um evento
                if(id == R.id.editText_Nome ){
                    exibirDataAo_Clicar_Em_EditarNome();// Exibi a data atual do DataPicker
                }else if (id == R.id.btn_idade){

                    nome = ediText_Nome.getText().toString();
                    String texto = "Nome: "+ nome + ", sua idade é : "+ dataSpinnner;

                    try {
                        int idade = Integer.parseInt(dataSpinnner);
                        if (idade > -1) {
                            if (ttsAtivado){
                                tts.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null);
                            }
                            Snackbar.make(v, texto, Snackbar.LENGTH_SHORT).show();
                        } else {
                            Snackbar.make(v, "Idade inválida", Snackbar.LENGTH_SHORT).show();
                            if (ttsAtivado) tts.speak("Idade Inválida", TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                    } catch (NumberFormatException e) {

                        Snackbar.make(v, "Erro ao calcular idade", Snackbar.LENGTH_SHORT).show();
                    }
                }
            }else{
                Toast.makeText(MainActivity.this, "Data Invalida", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(MainActivity.this, "Digite seu Nome", Toast.LENGTH_SHORT).show();
        }

    }

    private void exibirDataAo_Clicar_Em_EditarNome(){
        int dia = datePicker_SelecionadorDeData.getDayOfMonth(); // The selected day of month.
        int mes = datePicker_SelecionadorDeData.getMonth() + 1; // Atenção: Janeiro = 0 -- The selected month.
        int ano = datePicker_SelecionadorDeData.getYear();// The selected year.

        String data = "Data selecionada: "+ dia + "/" + mes + "/" + ano;// String (TEXTO) - Que sera exibido
        mostarAviso_EmTempoLongo_Usando_Toast(data); // Usando Toast para Aviso, este aviso tem um tempo mais longo
    }

    // Mensagem de aviso curta
    private void mostarAviso_EmTempoCurto_Usando_Toast(String mensagem){
        Toast.makeText(this,mensagem, Toast.LENGTH_SHORT).show();
    }

    // Mensagem de aviso longa
    private void mostarAviso_EmTempoLongo_Usando_Toast(String mensagem){
        Toast.makeText(this,mensagem, Toast.LENGTH_LONG).show();
    }

    /**
     * Called to signal the completion of the TextToSpeech engine initialization.
     *
     * @param status {@link TextToSpeech#SUCCESS} or {@link TextToSpeech#ERROR}.
     */
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int resultado = tts.setLanguage(new Locale("pt", "BR"));
            if (resultado == TextToSpeech.LANG_MISSING_DATA || resultado == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(MainActivity.this, "Idioma não suportado ou dados ausentes", Toast.LENGTH_SHORT).show();
            }
        } else if (status == TextToSpeech.ERROR) {
            Toast.makeText(MainActivity.this, "Houve uma falha, tente reiniciar o app", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();        // Para a fala imediatamente
            tts.shutdown();    // Libera recursos
            tts = null;        // Remove referência
        }
        super.onDestroy();     // Sempre por último
    }

    /**
     * Called when the checked state of a compound button has changed.
     *
     * @param buttonView The compound button view whose state has changed.
     * @param isChecked  The new checked state of buttonView.
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            //Mudar a bolinha do switch para verde
            ttsAtivado = isChecked;
            switchCompat_Ativador_DeVoz.setThumbTintList(
                    ContextCompat.getColorStateList(this, R.color.green)
            );

            Glide.with(MainActivity.this)
                    .load(R.drawable.idade)
                    //.override(79, 40)
                    .into(img_Idade);

            img_Idade.setVisibility(View.VISIBLE);

        }else{
            //Mudar a bolinha do switch para vermelho
            if (tts.isSpeaking()){
                tts.stop();
            }
            ttsAtivado = isChecked;
            switchCompat_Ativador_DeVoz.setThumbTintList(
                    ContextCompat.getColorStateList(this, R.color.red)
            );
            img_Idade.setVisibility(View.INVISIBLE);
        }
    }
}