package devatomicfull.bootcamp5_shared_preferences;


import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.widget.CompoundButton;
import android.widget.Switch;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Switch swNotification;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swNotification = findViewById(R.id.switch1);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

            boolean isNotifyTurnedOn = sharedPreferences.getBoolean("notifications", true);

            /* if ( isNotifyTurnedOn ){
                swNotification.setChecked(true);
            }*/
            swNotification.setChecked(isNotifyTurnedOn);
        }

        swNotification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    // it is checked
                    // notifi... turned on
                    sharedPreferences.edit().putBoolean("notifications", true).apply(); // ou .commit()
                }else {
                    // it is não checked
                    // notifi... turned off
                    sharedPreferences.edit().putBoolean("notifications", false).apply();
                }


            }
        });
    }
}