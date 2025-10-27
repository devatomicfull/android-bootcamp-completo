package github.devatomicfull.bootcamp11_animals_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAnimal_Info extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);

        imageView = findViewById(R.id.imgViewAnimalInfo);
        textView = findViewById(R.id.textViewInfo);

        Intent intent = getIntent();
        imageView.setImageResource(intent.getIntExtra("image", R.drawable.ic_launcher_foreground));
        textView.setText(intent.getStringExtra("nome"));
    }
}