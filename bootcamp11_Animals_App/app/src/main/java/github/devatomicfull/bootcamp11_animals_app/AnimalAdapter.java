package github.devatomicfull.bootcamp11_animals_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalRowHolder> {
    private List<Animal> animalData;
    private Context context;

    public AnimalAdapter(List<Animal> animalData, Context context) {
         this.context = context;
         this.animalData = animalData;
    }

    @NonNull
    @Override
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.animal_row, viewGroup, false);
        return new AnimalRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalRowHolder viewHolder, int i) {
        //viewHolder.textViewNomeAnimal;
        //viewHolder.imageView
    }

    @Override
    public int getItemCount() {
        return animalData.size();
    }

    // Classe Interna do Adapter
    class AnimalRowHolder extends RecyclerView.ViewHolder{
        TextView textViewNomeAnimal;
        ImageView imageView;

        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);

            textViewNomeAnimal = itemView.findViewById(R.id.ttV_Animal);
            imageView = itemView.findViewById(R.id.imgV_Animal);
        }
    }
}
