package ro.pub.cs.systems.eim.practicaltest01var05;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;

public class PracticalTest01Var05Service extends Service {
    private static final String TAG = "PracticalTest01Var05Service";
    private static final String ACTION = "ro.pub.cs.systems.eim.practicaltest01var05.action";
    private Handler handler = new Handler();
    private boolean isRunning = false;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service started");
        isRunning = true;

        // Extrage șablonul din intent
        ArrayList<String> template = intent.getStringArrayListExtra("template");

        // Creează un runnable care va fi executat la fiecare 5 secunde
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    // Iterează prin elementele șablonului
                    for (String element : template) {
                        // Creează un nou intent cu acțiunea specificată
                        Intent broadcastIntent = new Intent();
                        broadcastIntent.setAction(ACTION);
                        broadcastIntent.putExtra("message", element);
                        sendBroadcast(broadcastIntent);

                        Log.d(TAG, "Sent broadcast message: " + element);
                    }

                    // Reprogramează runnable-ul pentru a fi executat din nou după 5 secunde
                    handler.postDelayed(this, 5000);
                }
            }
        };

        // Pornește execuția runnable-ului
        handler.post(runnable);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning = false; // Oprește execuția runnable-ului
        Log.d(TAG, "Service destroyed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}