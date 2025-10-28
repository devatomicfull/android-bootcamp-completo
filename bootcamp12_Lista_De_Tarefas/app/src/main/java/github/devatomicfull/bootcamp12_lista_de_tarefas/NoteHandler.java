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

    /**
     * Método readNotes() — responsável por ler todas as notas armazenadas na tabela "Note".
     *
     * Este método executa uma consulta (SELECT) no banco de dados SQLite, recuperando todos os
     * registros existentes na tabela "Note" e retornando-os em uma lista de objetos Note.
     *
     * Funcionamento técnico:
     * 1. Cria-se uma lista ArrayList<Note> que armazenará os objetos retornados.
     *
     * 2. Define-se a consulta SQL:
     *      SELECT * FROM Note ORDER BY id ASC
     *    Essa instrução seleciona todas as colunas e ordena os resultados pelo campo "id" em ordem crescente.
     *
     * 3. Obtém-se uma instância do banco de dados em modo leitura (getReadableDatabase()).
     *
     * 4. Executa-se a query através de rawQuery(sqlQuery, null), que retorna um objeto Cursor.
     *    O Cursor funciona como um iterador sobre os resultados da consulta.
     *
     * 5. moveToFirst() verifica se há registros retornados. Caso positivo, inicia o loop:
     *      - Lê o valor de cada coluna usando getColumnIndexOrThrow("nome_da_coluna").
     *      - Cria um novo objeto Note com os dados obtidos.
     *      - Define o ID da nota e adiciona à lista notes.
     *
     * 6. Após percorrer todos os registros, fecha-se o Cursor e o banco de dados
     *    com cursor.close() e db.close(), garantindo liberação de recursos.
     *
     * 7. Retorna a lista notes contendo todas as notas do banco.
     *
     * Boas práticas:
     * - Sempre fechar o Cursor e o banco após o uso para evitar vazamentos de memória.
     * - Utilizar getReadableDatabase() quando apenas leitura for necessária.
     * - Tratar exceções dentro do loop para evitar falhas na criação de objetos.
     *
     * Exemplo de uso:
     * ArrayList<Note> lista = dbHelper.readNotes();
     * for (Note n : lista) {
     *     Log.d("DB", "Título: " + n.getTitle());
     * }
     *
     * Retorno:
     * - Uma lista (ArrayList<Note>) com todas as notas salvas no banco.
     */
    public ArrayList<Note> readNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Note ORDER BY id ASC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    try {
                        // Lança exceção se a coluna não existir - mais seguro
                        int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                        String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                        String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));

                        Note note = new Note(title, description);
                        note.setId(id);
                        notes.add(note);
                    } catch (IllegalArgumentException e) {
                        Log.e("DB_ERROR", "Erro ao acessar coluna inexistente: " + e.getMessage());
                    }
                } while (cursor.moveToNext());
            }
        } finally {
            cursor.close();
            db.close();
        }
        return notes;
    }

    /**
     * Método readNotesDiretoAntigo() — responsável por ler todas as notas armazenadas na tabela "Note".
     *
     * Este método executa uma consulta (SELECT) no banco de dados SQLite, recuperando todos os
     * registros existentes na tabela "Note" e retornando-os em uma lista de objetos Note.
     *
     * Funcionamento técnico:
     * 1. Cria-se uma lista ArrayList<Note> que armazenará os objetos retornados.
     *
     * 2. Define-se a consulta SQL:
     *      SELECT * FROM Note ORDER BY id ASC
     *    Essa instrução seleciona todas as colunas e ordena os resultados pelo campo "id" em ordem crescente.
     *
     * 3. Obtém-se uma instância do banco de dados em modo leitura (getReadableDatabase()).
     *
     * 4. Executa-se a query através de rawQuery(sqlQuery, null), que retorna um objeto Cursor.
     *    O Cursor funciona como um iterador sobre os resultados da consulta.
     *
     * 5. moveToFirst() verifica se há registros retornados. Caso positivo, inicia o loop:
     *      - Obtém o índice das colunas usando getColumnIndex("nome_da_coluna").
     *      - Verifica se os índices são válidos (diferentes de -1).
     *      - Cria um novo objeto Note com os dados obtidos.
     *      - Define o ID da nota e adiciona à lista notes.
     *
     * 6. Caso alguma coluna não seja encontrada, é registrado um erro no Logcat.
     *
     * 7. Após percorrer todos os registros, fecha-se o Cursor e o banco de dados
     *    com cursor.close() e db.close(), garantindo liberação de recursos.
     *
     * Boas práticas:
     * - Sempre fechar o Cursor e o banco após o uso para evitar vazamentos de memória.
     * - Utilizar getReadableDatabase() quando apenas leitura for necessária.
     * - Tratar exceções dentro do loop para evitar falhas na criação de objetos.
     * - Verificar colunas com getColumnIndex() quando não se tem total garantia da estrutura.
     *
     * Retorno:
     * - Uma lista (ArrayList<Note>) com todas as notas salvas no banco.
     */
    public ArrayList<Note> readNotesDiretoAntigo() {
        ArrayList<Note> notes = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Note ORDER BY id ASC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    int indexId = cursor.getColumnIndex("id");
                    int indexTitle = cursor.getColumnIndex("title");
                    int indexDescription = cursor.getColumnIndex("description");

                    if (indexId != -1 && indexTitle != -1 && indexDescription != -1) {
                        int id = cursor.getInt(indexId);
                        String title = cursor.getString(indexTitle);
                        String description = cursor.getString(indexDescription);

                        Note note = new Note(title, description);
                        note.setId(id);
                        notes.add(note);
                    } else {
                        Log.e("DB_ERROR", "Colunas inválidas detectadas: id=" + indexId + ", title=" + indexTitle + ", description=" + indexDescription);
                    }
                } while (cursor.moveToNext());
            }
        } finally {
            cursor.close();
            db.close();
        }

        return notes;
    }

}
