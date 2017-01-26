package com.codenicely.project.groceryappadmin.helper;


/**
 * Created by meghal on 9/11/16.
 * <p>
 * Called when message is received.
 *
 * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
 */

/*
public class MyFirebaseService extends FirebaseMessagingService {
    int i;

    private static final String TAG = "MyFirebaseMsgService";

    */
/**
 * Called when message is received.
 *
 * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
 *//*

    // [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d("Response", "From: " + remoteMessage.getData());
        String jsonStr = remoteMessage.getData().toString();
        try {
            JSONObject jsonRootObject = new JSONObject(jsonStr);
//             i=Integer.parseInt(jsonRootObject.optString("intent_id"));
            i = Integer.parseInt(remoteMessage.getData().get("intent_id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        sendNotification("" + remoteMessage.getData().get("body"), "" +
                remoteMessage.getData().get("title"));

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
    // [END receive_message]

    private void sendNotification(String messageBody, String title) {
        Intent intent;
        int flag = 0;
        boolean notification_display = true;
        if (i == 1) {
            intent = new Intent(this, Home.class);
        } else if (i == 2) {
            intent = new Intent(this, Blogs.class);
        } else if (i == 3) {
            intent = new Intent(this, ListOfEvents.class);
        } else if (i == 4) {
            intent = new Intent(this, BQuizActivity.class);
        } else if (i == 5) {
            intent = new Intent(this, Spons.class);
        } else if (i == 6) {
            intent = new Intent(this, Contacts.class);
        } else if (i == 7) {
            intent = new Intent(this, AboutUsPage.class);
        } else if (i == 13) {
            final String appPackageName = getPackageName();
            Log.d("Response", "" + getPackageName());
            try {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName));
            } catch (android.content.ActivityNotFoundException anfe) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName));
            }
        } else if (i == 113) {
            final String uri_app = messageBody;
            notification_display = false;
            try {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + uri_app));
            } catch (android.content.ActivityNotFoundException anfe) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + uri_app));
            }
        } else {
            flag = 1;
            intent = null;
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);

        if (notification_display) {
            notificationBuilder.setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sound));
            notificationBuilder.setSmallIcon(R.drawable.ecell_logo)
                    .setContentTitle(title)
                    .setContentText(messageBody)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(messageBody))
                    .setAutoCancel(true);
            notificationBuilder.setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationBuilder.build());
        }
        if (flag == 0) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                    PendingIntent.FLAG_ONE_SHOT);
            notificationBuilder.setContentIntent(pendingIntent);
            startActivity(intent);

        }

    }
}
*/
