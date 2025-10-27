package github.devatomicfull.bootcamp12_lista_de_tarefas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private ArrayList<Note> notes;
    private Context context;

    public NoteAdapter(ArrayList<Note> notes, Context context) {
        this.notes = notes;
        this.context = context;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.note_holder, viewGroup, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, int i) {
        noteHolder.textViewTitulo.setText(notes.get(i).getTitle());
        noteHolder.textViewDescricao.setText(notes.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitulo;
        private TextView textViewDescricao;
        private ImageButton imgEdit;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitulo = itemView.findViewById(R.id.textView_Titulo);
            textViewDescricao = itemView.findViewById(R.id.textView_Sub_Texto);
            imgEdit = itemView.findViewById(R.id.imgEdit);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void atualizar(){
        notifyDataSetChanged();
    }
}
