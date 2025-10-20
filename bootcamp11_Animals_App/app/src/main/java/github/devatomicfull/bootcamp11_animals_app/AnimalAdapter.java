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
    MyClickInterface myClickInterface;

    public AnimalAdapter(List<Animal> animalData, Context context, MyClickInterface myClickInterface) {
        this.context = context;
        this.animalData = animalData;
        this.myClickInterface = myClickInterface;
    }

    /**
     * Método responsável por **inflar o layout XML** que representa cada item da lista.
     * <p>
     * Este método é chamado automaticamente pelo RecyclerView **quando um novo item precisa ser exibido**.
     * Aqui, o layout definido em `R.layout.animal_row` é convertido em um objeto `View`
     * para que possa ser associado a um `ViewHolder`.
     * <p>
     * Em resumo:
     * - Cria a estrutura visual de cada linha da lista (sem preencher os dados ainda).
     * - O preenchimento real (nome e imagem do animal) ocorre no método `onBindViewHolder`.
     *
     * @param viewGroup O grupo de visualização pai onde a nova View será adicionada.
     *                  Geralmente é o RecyclerView que está exibindo os itens.
     * @param i         O tipo de visualização (viewType) do novo item. É útil quando há múltiplos tipos de layouts na mesma lista.
     * @return Um novo objeto {@link AnimalRowHolder} que contém a View inflada e pronta para receber os dados do modelo.
     */
    @NonNull
    @Override
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // i -> representa o viewType (tipo de layout do item)
        View view = LayoutInflater.from(context).inflate(R.layout.animal_row, viewGroup, false);
        return new AnimalRowHolder(view);
    }

    /**
     * Método responsável por associar os dados do modelo (Animal) à View inflada
     * que representa cada item da lista.
     * <p>
     * É aqui que ocorre o "preenchimento" da interface — ou seja, os dados
     * vindos da lista do adapter são inseridos nas Views (TextView, ImageView etc.)
     * já referenciadas pelo {@link AnimalRowHolder}.
     * <p>
     * O uso do ViewHolder é uma prática essencial de desempenho, pois:
     * - Evita chamadas repetitivas de findViewById(), que são custosas.
     * - Mantém as referências das Views em memória, facilitando o reuso de itens.
     * - Torna o RecyclerView mais eficiente ao rolar grandes listas.
     * <p>
     * Funcionamento:
     * - O RecyclerView chama este método automaticamente para cada item visível.
     * - O parâmetro {@code i} representa a posição atual do item na lista.
     * - O método obtém o objeto {@link Animal} correspondente e insere seus valores
     * nas Views do layout (por exemplo, nome e imagem).
     * <p>
     * Exemplo prático:
     * {@code
     * viewHolder.textViewNomeAnimal.setText(animalData.get(i).getNome());
     * viewHolder.imageView.setImageResource(animalData.get(i).getImage());
     * }
     *
     * @param viewHolder O objeto que contém as referências das Views (TextView, ImageView etc.)
     *                   já vinculadas ao layout do item.
     * @param i          A posição atual do item dentro da lista de dados do Adapter.
     */
    @Override
    public void onBindViewHolder(@NonNull AnimalRowHolder viewHolder, int i) {
        // i -> representa a posição do item na lista
        viewHolder.textViewNomeAnimal.setText(animalData.get(i).getNome());
        viewHolder.imageView.setImageResource(animalData.get(i).getImage());
    }

    /**
     * Retorna a quantidade total de itens (elementos) presentes na lista de dados do adapter.
     * <p>
     * Este valor é essencial para o funcionamento do RecyclerView, pois:
     * - Define quantas vezes o método {@link #onCreateViewHolder(ViewGroup, int)} será chamado
     * para criar as Views necessárias.
     * - Indica quantas vezes o método {@link #onBindViewHolder(AnimalRowHolder, int)} será chamado
     * para associar os dados às Views.
     * <p>
     * Em outras palavras, o número retornado representa o tamanho da lista de objetos
     * (neste caso, a lista de {@link Animal}), sendo usado internamente pelo RecyclerView
     * para determinar quantos itens precisam ser exibidos na tela.
     * <p>
     * Exemplo prático:
     * - Se a lista animalData contém 10 objetos Animal, o RecyclerView saberá que deve renderizar 10 itens.
     *
     * @return A quantidade total de elementos contidos na lista {@code animalData}.
     */
    @Override
    public int getItemCount() {
        return animalData.size();
    }

    /**
     * Classe interna responsável por armazenar as referências dos componentes visuais
     * (Views) que compõem cada item da lista exibida pelo RecyclerView.
     * <p>
     * O padrão ViewHolder é utilizado para otimizar o desempenho da lista, evitando
     * chamadas repetitivas ao método {@code findViewById()}, que são custosas para o sistema.
     * <p>
     * Em vez de buscar os elementos visuais toda vez que um item é exibido,
     * o ViewHolder mantém essas referências em memória, permitindo acesso rápido
     * e eficiente durante o processo de vinculação dos dados.
     * <p>
     * Nesta implementação:
     * - {@link TextView} textViewNomeAnimal → exibe o nome do animal.
     * - {@link ImageView} imageView → exibe a imagem associada ao animal.
     * <p>
     * O RecyclerView utiliza esta classe para "segurar" as views de cada linha
     * (definidas no layout XML `animal_row.xml`) e reaproveitá-las conforme o
     * usuário rola a lista, reduzindo o uso de memória e processamento.
     */
    class AnimalRowHolder extends RecyclerView.ViewHolder {

        // Componentes visuais de cada item da lista
        TextView textViewNomeAnimal;
        ImageView imageView;

        /**
         * Construtor do ViewHolder.
         * <p>
         * É chamado automaticamente pelo método {@link RecyclerView.Adapter#onCreateViewHolder(ViewGroup, int)}
         * quando o RecyclerView precisa criar uma nova linha (item).
         *
         * @param itemView A view inflada a partir do layout XML (R.layout.animal_row),
         *                 representando uma única linha da lista.
         */
        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);

            // Associa os componentes visuais definidos no XML às variáveis do ViewHolder
            textViewNomeAnimal = itemView.findViewById(R.id.ttV_Animal);
            imageView = itemView.findViewById(R.id.imgV_Animal);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    myClickInterface.onItemClick(getAdapterPosition());
                }
            });
        }
    }

    interface MyClickInterface{
        // deve implementar essa interface
        void onItemClick(int positionOfTheAnimal);
    }
}