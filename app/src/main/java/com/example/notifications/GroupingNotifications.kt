package com.example.notifications

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

const val GROUP = "group"

fun groupingNotifications(context: Context) {

    val notification1 = NotificationCompat.Builder(context, DEFAULT)
        .setSmallIcon(R.drawable.baseline_reply_24)
        .setContentTitle("First Title")
        .setContentText("First Description")
        .setGroup(GROUP)
        .build()

    val notification2 = NotificationCompat.Builder(context, DEFAULT)
        .setSmallIcon(R.drawable.baseline_share_24)
        .setContentTitle("Second Title")
        .setContentText("Second Description")
        .setGroup(GROUP)
        .build()

    val groupBuilder = NotificationCompat.Builder(context, DEFAULT)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("Group Title")
        .setContentText("Group Description")
        .setGroup(GROUP)
        .setGroupSummary(true)
        .build()


    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ContextCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).apply {
                notify(4, notification1)
                notify(5, notification2)
                notify(6, groupBuilder)
            }
        } else {
            NotificationManagerCompat.from(context).apply {
                notify(4, notification1)
                notify(5, notification2)
                notify(6, groupBuilder)
            }

        }
    }
}