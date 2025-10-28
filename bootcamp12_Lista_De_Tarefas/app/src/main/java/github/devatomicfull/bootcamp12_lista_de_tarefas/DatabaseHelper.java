package github.devatomicfull.bootcamp12_lista_de_tarefas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/*
Uma classe auxiliar para gerenciar a criação de banco de dados e o gerenciamento de versões.
Você cria uma subclasse implementando onCreate(SQLiteDatabase), onUpgrade(SQLiteDatabase, int, int)e opcionalmente onOpen(SQLiteDatabase), e essa classe se encarrega de abrir o banco de dados, se existir, criá-lo, se não existir, e atualizá-lo conforme necessário. Transações são usadas para garantir que o banco de dados esteja sempre em um estado sensato.
Esta classe facilita que ContentProvider as implementações adiem a abertura e a atualização do banco de dados até o primeiro uso, para evitar o bloqueio da inicialização do aplicativo com atualizações demoradas do banco de dados.
Para ver um exemplo, consulte a classe NotePadProvider no aplicativo de exemplo NotePad, no diretório samples/ do SDK.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NotesDatabase";

    // Crie um objeto auxiliar para criar, abrir e/ou gerenciar um banco de dados.
    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**

     Método {@code onCreate(SQLiteDatabase sqLiteDatabase)} — responsável pela criação inicial do banco de dados.

     <p>Este método é chamado **apenas uma vez**, no momento em que o banco de dados é criado pela primeira vez
     nenhum dispositivo. Ele é executado automaticamente pelo framework Android (através da classe {@link SQLiteOpenHelper})
     quando ainda não existe um arquivo de banco de dados associado ao nome definido no construtor do helper. </p>

     <p>Dentro deste método, são definidos como estruturas iniciais do banco, geralmente por meio de comandos
     SQL de criação de tabelas e índices. Neste caso, é criada a tabela {@code Note} com os seguintes campos: </p>

     <ul>
     <li><b>id</b> — inteiro, chave primária, autoincrementável;</li>
     <li><b>título</b> — texto, armazena o título da nota;</li>
     <li><b>descrição</b> — texto, armazena a descrição da nota.</li>
     </ul>

     <p>O método utiliza um {@link StringBuilder} para montar uma consulta SQL e, em seguida,
     executa o comando através de {@code sqLiteDatabase.execSQL(sqlQuery.toString())}. </p>

     <p>Após a criação, o método {@code onCreate()} **não é mais executado novamente**,
     menos que o número da versão do banco (passado no construtor do {@link SQLiteOpenHelper})
     seja alterado. Nesse caso, o sistema chamará o método {@code onUpgrade()}. </p>

     <p>Ao atualizar a versão do banco, é **fundamental** adaptar o esquema de forma segura para não
     perder dados existentes. Por exemplo, ao recriar uma tabela, você deve usar comandos como
     {@code ALTER TABLE} para adicionar novas colunas ou modificar a estrutura: </p>

     <pre>{@código
    ALTER TABLE Nota ADD COLUMN data TEXTO;
    } </pre>

     <p>Assim, os dados existentes permanecem preservados, e a aplicação mantém compatibilidade entre versões.</p>

     Exemplo de criação:
     <pre>{@código

    StringBuilder sqlQuery = novo StringBuilder();
    sqlQuery.append("CRIAR TABELA Nota (");
    sqlQuery.append("id INTEIRO CHAVE PRIMÁRIA AUTOINCREMENTO, ");
    sqlQuery.append("título TEXTO, ");
    sqlQuery.append("texto de descrição)");

    sqLiteDatabase.execSQL(sqlQuery.toString());
    } </pre>
     */

    //Chamado quando o banco de dados é criado pela primeira vez.
    @Override
    public void onCreate(SQLiteDatabase database) {
        StringBuilder sqlQuery = new StringBuilder();

        sqlQuery.append("CREATE TABLE Note (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT)");
        database.execSQL(sqlQuery.toString());

    }

    // Chamado quando o banco de dados precisa ser atualizado.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
