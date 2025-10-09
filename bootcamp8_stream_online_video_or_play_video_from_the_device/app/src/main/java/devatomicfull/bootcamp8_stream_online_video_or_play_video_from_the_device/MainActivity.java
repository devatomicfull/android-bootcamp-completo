package devatomicfull.bootcamp8_stream_online_video_or_play_video_from_the_device;

import android.content.ContentResolver;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.widget.VideoView;

import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.video.VideoDecoderGLSurfaceView;
import androidx.media3.ui.PlayerView;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback{
    private VideoView videoView;

    // modo surface view
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private MediaPlayer mediaPlayer;

    // modo texture
    private TextureView textureView;
    private MediaPlayer mediaPlayer1;

    //exoplayer
    private ExoPlayer player;
    private PlayerView playerView;

    Uri uri1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);

        surfaceView = findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();

        // Registrar o callback para saber quando o Surface está pronto
        surfaceHolder.addCallback(this);


        // exemplo usando textureview
        textureView = findViewById(R.id.textureView);

        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surface, int width, int height) {
                Surface s = new Surface(surface);
                playVideo(s);
            }

            @Override
            public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surface, int width, int height) {}

            @Override
            public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surface) {
                if (mediaPlayer1 != null) {
                    mediaPlayer1.release();
                    mediaPlayer1 = null;
                }
                return true;
            }

            @Override
            public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surface) {}
        });

        playerView = findViewById(R.id.playerView);

        // 🔹 Cria o player
        player = new ExoPlayer.Builder(this).build();
        playerView.setPlayer(player);

        // Exemplo 1 — Forma clássica (a sua original)
        uri1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video2160_24fps);
        // ok "android.resource://" é o esquema padrão usado para acessar recursos internos (res/raw)
        // ok getPackageName() retorna o nome do pacote do app
        // ok R.raw.video2160_24fps é o ID do recurso no diretório /res/raw
        // Resultado: android.resource://seu.pacote/raw/video2160_24fps

        // 🔹 Define o vídeo remoto (streaming HLS)
        //MediaItem mediaItem = MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-1/multi-bitrate/hls.m3u8");
        MediaItem mediaItem = MediaItem.fromUri(uri1);

        player.setMediaItem(mediaItem);
        player.prepare();
        player.setPlayWhenReady(true); // inicia automaticamente

        // Exemplo 2 — Usando Uri.Builder (forma mais estruturada)
        Uri uri2 = new Uri.Builder()
                .scheme("android.resource")
                .authority(getPackageName())
                .appendPath(String.valueOf(R.raw.video2160_24fps))
                .build();
        // ok Uri.Builder permite montar a URI passo a passo
        // ok scheme define o tipo de recurso (android.resource)
        // ok authority define o pacote (dono do recurso)
        // ok appendPath adiciona o caminho (neste caso, o ID do recurso)
        // Resultado: android.resource://seu.pacote/2131820544 (ID numérico equivalente)

        // Exemplo 3 — Usando Uri.parse com String.format
        Uri uri3 = Uri.parse(String.format("android.resource://%s/%d", getPackageName(), R.raw.video2160_24fps));
        // ok Usa String.format para interpolar dinamicamente o nome do pacote e o ID
        // ok É mais limpo e legível em alguns contextos
        // Resultado: android.resource://seu.pacote/2131820544

        // Exemplo 4 — Usando ContentResolver e Resources (forma programática)
        int resId = R.raw.video2160_24fps;
        Uri uri4 = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                getResources().getResourcePackageName(resId) + '/' +
                getResources().getResourceTypeName(resId) + '/' +
                getResources().getResourceEntryName(resId));
        // ok getResourcePackageName: retorna o pacote do recurso
        // ok getResourceTypeName: retorna o tipo (ex: "raw")
        // ok getResourceEntryName: retorna o nome do arquivo (sem extensão)
        // ok Essa abordagem monta a URI completa dinamicamente
        // Resultado: android.resource://seu.pacote/raw/video2160_24fps

        // Exemplo 5 — Utilizando o método Uri.fromParts
        Uri uri5 = Uri.fromParts("android.resource", getPackageName() + "/" + R.raw.video2160_24fps, null);
        // ok fromParts cria uma Uri diretamente a partir das partes fornecidas
        // ok Primeiro parâmetro: esquema ("android.resource")
        // ok Segundo: autoridade + caminho
        // ok Terceiro: fragmento (geralmente null)
        // Resultado: android.resource://seu.pacote/raw/video2160_24fps


        videoView.setVideoURI(uri1);
        videoView.start();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Inicia o MediaPlayer quando o Surface estiver pronto
        mediaPlayer = new MediaPlayer();
        try {
            //Uri videoUri = Uri.parse("https://www.html5rocks.com/en/tutorials/video/basics/devstories.webm");
            mediaPlayer.setDataSource(this, uri1);
            mediaPlayer.setDisplay(surfaceHolder); // Conecta o vídeo à superfície
            mediaPlayer.prepareAsync();

            mediaPlayer.setOnPreparedListener(mp -> mediaPlayer.start());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // Chamado quando o tamanho ou formato da superfície muda
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void playVideo(Surface surface) {
        try {
            mediaPlayer1 = new MediaPlayer();
            //mediaPlayer.setDataSource("https://www.example.com/video.mp4"); // link remoto ou local
            mediaPlayer1.setDataSource(this, uri1);
            mediaPlayer1.setSurface(surface);
            mediaPlayer1.setLooping(true);
            mediaPlayer1.prepareAsync();
            mediaPlayer1.setOnPreparedListener(MediaPlayer::start);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (player != null) {
            player.play();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) {
            player.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.release();
            player = null;
        }
    }
}