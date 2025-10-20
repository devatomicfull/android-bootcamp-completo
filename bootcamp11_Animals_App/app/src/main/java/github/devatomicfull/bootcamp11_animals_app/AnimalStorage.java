package github.devatomicfull.bootcamp11_animals_app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalStorage {

    private List<Animal> animalList = new ArrayList<>();
    private List<String> nome_AnimalList;
    private List<Integer> img_AnimalList;

    /**
     * Construtor responsável por carregar os nomes e imagens dos animais.
     * <p>
     * Os nomes são carregados do arquivo strings.xml e as imagens de um array de drawables
     * definido em arrays.xml. Ambos são ordenados alfabeticamente pelo nome.
     */
    public AnimalStorage(Context context) {
        // Recebendo o vetor de nomes
        nome_AnimalList = Arrays.asList(context.getResources().getStringArray(R.array.animais_name));

        // Obtém um array de recursos (neste caso, imagens) definido no arquivo XML de recursos.
        // O método getResources().obtainTypedArray(int id) retorna um TypedArray, que é uma estrutura
        // capaz de armazenar diferentes tipos de valores (como drawables, cores, dimensões, etc.).
        //
        // Aqui, estamos buscando o array "animais_imgs" declarado em res/values/arrays.xml.
        // Cada item desse array é um identificador de recurso (ex: R.drawable.cavalo, R.drawable.gato...).
        //
        // Importante: o TypedArray ocupa recursos do sistema, portanto, após terminar de usá-lo,
        // é necessário chamar o método typedArray.recycle() para liberar a memória.
        //
        // Exemplo de uso:
        TypedArray typedArray = context.getResources().obtainTypedArray(R.array.animais_imgs);

        img_AnimalList = new ArrayList<>();

        for (int i = 0; i < typedArray.length(); i++) {
            img_AnimalList.add(typedArray.getResourceId(i, -1));
        }
        // Libera o recurso TypedArray (boa prática)
        typedArray.recycle();

        // Ordenando lista de nomes (imagens mantêm índice correspondente)
        ordenacaoPorNome(nome_AnimalList);

        // Monta a lista final de objetos Animal
        criarListaDeAnimais();
    }

    /**
     * Realiza a ordenação da lista de nomes de animais em ordem alfabética.
     * <p>
     * O método utiliza uma ordenação case-insensitive (ignora diferenças entre
     * letras maiúsculas e minúsculas), garantindo que "Gato" e "gato" sejam
     * tratados da mesma forma na comparação.
     * <p>
     * A implementação usa a API moderna de ordenação (disponível a partir do Android N),
     * e mantém compatibilidade com versões anteriores do Android.
     */
    private void ordenacaoPorNome(List<String> animalList) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // Android 7.0 (API 24) ou superior
            // Usa o método sort() da List, com comparador que ignora maiúsculas/minúsculas.
            animalList.sort(String.CASE_INSENSITIVE_ORDER);
            // nome_Animal.sort(Comparator.comparing(String::toString)); // ordena começando com maiúsculas
        } else {
            // Compatibilidade para versões antigas do Android
            // Utiliza Collections.sort() com o mesmo comparador case-insensitive.
            java.util.Collections.sort(animalList, String.CASE_INSENSITIVE_ORDER);
        }
    }

    /**
     * Cria a lista final de objetos Animal associando nome e imagem.
     * Aqui você poderia associar imagens correspondentes manualmente ou de forma fixa.
     * (caso queira associar imagem e nome por índice após ordenar, será preciso uma lógica extra).
     */
    private void criarListaDeAnimais() {
        for (int i = 0; i < nome_AnimalList.size(); i++) {
            // Por enquanto associamos o nome com a imagem na mesma posição (índice)
            // Se as listas forem paralelas, o índice mantém correspondência.
            int imgResId = (i < img_AnimalList.size()) ? img_AnimalList.get(i) : -1;
            animalList.add(new Animal(nome_AnimalList.get(i), imgResId));
        }
    }

    /**
     * Retorna a lista final de objetos Animal (já pronta para uso no adapter).
     */
    public List<Animal> getAnimalList() {
        return animalList;
    }
}