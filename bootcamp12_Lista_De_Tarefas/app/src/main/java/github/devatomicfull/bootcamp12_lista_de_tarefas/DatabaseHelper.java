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

/**

 Método {@code onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)} —
 responsável por gerenciar a verificação da estrutura do banco de dados quando a versão é incrementada.

 <p>Este método é executado automaticamente sempre que a versão do banco (informada no construtor
 da classe que estende {@link SQLiteOpenHelper}) é alterado para um número superior ao anterior.
 O Android detecta essa diferença e chama o método {@code onUpgrade()} para permitir que o
 O desenvolvedor realiza as modificações na estrutura (schema) do banco de dados. </p>

 <h3> Função principal:</h3>
 <p>Adaptar o banco existente para uma nova versão sem perder os dados já armazenados.</p>
 <h3>Boas práticas:</h3>
     <ul>
         <li>**Evitar recriar as tabelas** com {@code DROP TABLE} — isso apagaria todos os registros existentes.</li>
         <li>**Usar comandos ALTER TABLE** para adicionar ou renomear colunas, preservando os dados.</li>
         <li>Executar migrações incrementais, tratando cada mudança de versão de forma controlada.</li>
         <li>Manter um histórico de migrações, caso o app evolua com várias versões do banco.</li>
     </ul>
 <h3></h3> Exemplo de uso:</h3>
 <p>Suponha que na nova versão do banco (versão 2), seja necessário adicionar uma coluna

 {@code date} na tabela {@code Note} para armazenar os dados da anotação. </p>

 <pre>{
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE Note ADD COLUMN date TEXT");
        }
    }
 </pre>

<p>Este exemplo garante que apenas bancos com versões anteriores à 2 sejam atualizados,
evitando execuções redundantes. Essa abordagem incremental permite compatibilidade
com várias versões e facilita futuras evoluções do esquema. </p>

<h3> Resumo:</h3>
<ul>
    <li>{@code onCreate()} → executado uma única vez, ao criar o banco.</li>
    <li>{@code onUpgrade()} → executado sempre que há mudança na versão do banco.</li>
    <li>Use {@code ALTER TABLE}, {@code CREATE TABLE IF NOT EXISTS} e migrações planejadas para   preservar os dados do usuário.</li>
</ul>

 */

    // Chamado quando o banco de dados precisa ser atualizado.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
