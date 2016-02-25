package se.tepo.permissionsandnotifications;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;

public class MainActivity extends Activity {

    private static final int REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Some notification")
                .setContentText("Triggers overlay")
                .setPriority(Notification.PRIORITY_MAX)
                .setVibrate(new long[] { 1000, 1000, 1000 })
                .build();

        final NotificationManager notificationManager
                = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(1001, notification);

        requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if(requestCode != REQUEST_CODE
                || grantResults.length != 1
                || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        // Do something

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
