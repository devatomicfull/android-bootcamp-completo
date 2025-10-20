package github.devatomicfull.bootcamp11_animals_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Animal> animalList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cria a instância do storage que contém os dados dos animais
        AnimalStorage storage = new AnimalStorage(this);

        // Configura o RecyclerView
        recyclerView = findViewById(R.id.recyclerView);

        // Recupera a lista de animais do storage
        List<Animal> animalList = storage.getAnimalList();

        // Se por algum motivo a lista vier nula, cria uma lista vazia (fallback)
        if (animalList == null) {
            animalList = new ArrayList<>();
        }

        // Cria e associa o adapter com a lista de animais
        AnimalAdapter animalAdapter = new AnimalAdapter(animalList, this);
        recyclerView.setAdapter(animalAdapter);

        // Define o layout (lista vertical simples)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}