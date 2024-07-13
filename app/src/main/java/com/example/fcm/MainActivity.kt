package com.example.fcm

import android.content.Context
import android.os.Bundle
import android.app.NotificationManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat
import com.example.fcm.ui.theme.FCMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FCMTheme {
                val context= LocalContext.current
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    notificationChannel("click for notification",context=context)
                }
            }
        }
    }
}

@Composable
fun notificationChannel(name: String, modifier: Modifier = Modifier,context : Context) {


    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
       TextButton(onClick = {
           var builder = NotificationCompat.Builder(context,App().channel_ID )
               .setSmallIcon(R.drawable.ic_launcher_foreground)
               .setContentTitle("textTitle")
               .setContentText("textContent")
               .setPriority(NotificationCompat.PRIORITY_DEFAULT)

           val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

           notificationManager.notify(0,builder.build())

       }) {
        Text(text = name )
       }
        Spacer(modifier =Modifier.padding(vertical = 10.dp))
        TextButton(onClick = {
            var builder = NotificationCompat.Builder(context,App().channel_ID2 )
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("textTitle")
                .setContentText("textContent")
                .setPriority(NotificationCompat.PRIORITY_HIGH)

            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.notify(1,builder.build())
        }) {
        Text(text = "1 priority" )
       }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FCMTheme {
        notificationChannel("preview", context = LocalContext.current)
    }
}