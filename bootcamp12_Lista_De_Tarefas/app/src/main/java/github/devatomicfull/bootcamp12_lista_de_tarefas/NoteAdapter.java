package github.devatomicfull.bootcamp12_lista_de_tarefas;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends RecyclerView.Adapter {


    class NoteHolder extends RecyclerView.ViewHolder{

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
