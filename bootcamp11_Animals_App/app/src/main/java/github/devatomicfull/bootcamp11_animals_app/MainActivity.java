package github.devatomicfull.bootcamp11_animals_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.MyClickInterface {
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
        animalList = storage.getAnimalList();

        // Se por algum motivo a lista vier nula, cria uma lista vazia (fallback)
        if (animalList == null) {
            animalList = new ArrayList<>();
        }

        // Cria e associa o adapter com a lista de animais
        AnimalAdapter animalAdapter = new AnimalAdapter(animalList, this, this);
        recyclerView.setAdapter(animalAdapter);

        // Define o layout (lista vertical simples)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onItemClick(int positionOfTheAnimal) {
        Toast.makeText(this, "Clicado "+ animalList.get(positionOfTheAnimal).getNome(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ActivityAnimal_Info.class);
        intent.putExtra("image", animalList.get(positionOfTheAnimal).getImage());
        intent.putExtra("name", animalList.get(positionOfTheAnimal).getNome());
        startActivity(intent);
    }
}