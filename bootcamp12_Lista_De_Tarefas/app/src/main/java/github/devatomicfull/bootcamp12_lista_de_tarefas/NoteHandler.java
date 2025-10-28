package github.devatomicfull.bootcamp12_lista_de_tarefas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

// Gerenciador de tarefas
public class NoteHandler extends DatabaseHelper{

    public NoteHandler(@Nullable Context context) {
        super(context);
    }

    // CRUD - CREATE READ UPDATE DELETE

    /**
     * Método create(Note note) — responsável por inserir um novo registro na tabela "Note".
     *
     * Este método executa uma operação de inserção (INSERT) no banco de dados SQLite,
     * gravando os dados de uma instância da classe Note nos campos correspondentes da tabela.
     *
     * Funcionamento técnico:
     * 1. Cria-se um objeto ContentValues, que funciona como um mapa de pares chave-valor.
     *    Cada chave representa o nome da coluna e cada valor representa o dado a ser gravado.
     *    Exemplo:
     *      - "title" -> note.getTitle()
     *      - "description" -> note.getDescription()
     *
     * 2. Obtém-se uma instância do banco em modo escrita através de getWritableDatabase().
     *
     * 3. Executa-se o método insert(), que insere os dados na tabela "Note".
     *    Parâmetros:
     *      - Nome da tabela: "Note"
     *      - nullColumnHack: null (usado apenas se o ContentValues estiver vazio)
     *      - O objeto ContentValues com os dados.
     *
     * 4. O método insert() retorna o ID do novo registro inserido ou -1 em caso de erro.
     *    Assim, a expressão (db.insert(...) > 0) indica sucesso (true) ou falha (false).
     *
     * 5. Fecha-se a conexão com o banco através de db.close() para liberar o recurso.
     *
     * Sobre o ContentValues:
     * A classe ContentValues é usada no Android para armazenar valores que serão inseridos
     * ou atualizados no banco. Ela evita concatenar strings SQL manualmente e reduz riscos
     * de erro e vulnerabilidades como SQL injection. É equivalente a um mapa de colunas e dados.
     *
     * Exemplo simplificado:
     * ContentValues values = new ContentValues();
     * values.put("title", "Minha nota");
     * values.put("description", "Texto de exemplo");
     * db.insert("Note", null, values);
     *
     * Retorno:
     * - true  → se a inserção for bem-sucedida.
     * - false → se ocorrer algum erro na inserção.
     */
    public boolean create(Note note){
        ContentValues values = new ContentValues();
        values.put("title", note.getTitle());
        values.put("description", note.getDescription());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean isSucessfull = db.insert("Note", null, values) > 0;

        db.close();
        return isSucessfull;
    }


}
