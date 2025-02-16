package com.example.task3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.task3.ui.theme.Task3Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task3Theme {
                ProfileScreen()
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    val context = LocalContext.current
    var showLink by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Фото
        val image: Painter = painterResource(id = R.drawable.ava)
        Image(
            painter = image,
            contentDescription = "My photo",
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Ссылка на Telegram
        Text(text = "TG: @irongun", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(8.dp))

        // Список интересов/хобби
        Text(text = "Хобби: программирование, музыка, аниме", fontSize = 16.sp, color = androidx.compose.ui.graphics.Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        // Кнопка Подписаться
        Button(
            onClick = { showLink = !showLink },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = if (showLink) "Скрыть" else "Подписаться")
        }

        if (showLink) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "TG url: https://t.me/irongun")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    Task3Theme {
        ProfileScreen()
    }
}
