package devatomicfull.bootcamp4_ciclo_de_vida_da_activity;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class IconeFlutuanteService extends Service {

    private WindowManager windowManager;
    private ImageView icone;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onCreate() {
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        icone = new ImageView(this);
        icone.setImageResource(android.R.drawable.btn_star_big_on); // pode trocar o ícone

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ?
                        WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY :
                        WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        );

        params.gravity = Gravity.TOP | Gravity.START;
        params.x = 100;
        params.y = 200;

        windowManager.addView(icone, params);

        // Permite arrastar
        icone.setOnTouchListener(new View.OnTouchListener() {
            private int ultimoX, ultimoY;
            private float toqueInicialX, toqueInicialY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ultimoX = params.x;
                        ultimoY = params.y;
                        toqueInicialX = event.getRawX();
                        toqueInicialY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        params.x = ultimoX + (int) (event.getRawX() - toqueInicialX);
                        params.y = ultimoY + (int) (event.getRawY() - toqueInicialY);
                        windowManager.updateViewLayout(icone, params);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Quando Activity2 mandar uma cor, aplica no ícone
        if (intent != null && intent.hasExtra("COR")) {
            int cor = intent.getIntExtra("COR", 0);
            ColorFilter filtro = new LightingColorFilter(cor, 1);
            icone.setColorFilter(filtro);
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (icone != null) windowManager.removeView(icone);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
