package devatomicfull.bootcamp7_activity_lifecycle;

import android.app.Application;
import android.util.Log;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("my_log", "APP onCreate called");
    }
}
