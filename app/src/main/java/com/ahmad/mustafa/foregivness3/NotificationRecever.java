package com.ahmad.mustafa.foregivness3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

/**
 * Created by ahmad on 14/02/17.
 */
public class NotificationRecever  extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

        Intent intent1 = new Intent(context.getApplicationContext() , AstegfarActivity.class);
        intent1.putExtra("editType",intent.getStringExtra("editType"));
        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context
                , 100
                , intent1
                , PendingIntent.FLAG_UPDATE_CURRENT);

        Uri alarmSound2 = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE
                + "://" + context.getPackageName() + "/raw/4");

        Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/raw/aaa");

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification.Builder notifiBuilder = new Notification.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.hands)
                .setContentTitle(context.getString(R.string.remember))
                .setContentText(intent.getStringExtra("editType"))
                .setSound(uri)
                .setAutoCancel(true);
// set the sonds



        notificationManager.notify(101 , notifiBuilder.build());

    }
}
