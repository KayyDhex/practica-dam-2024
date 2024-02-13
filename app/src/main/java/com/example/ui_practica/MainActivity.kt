package com.example.ui_practica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_practica.navigation.NavManagment
import com.example.ui_practica.ui.theme.UipracticaTheme
import com.example.ui_practica.viewmodels.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val instanceOfViewModelLogin = LoginViewModel()
        setContent {
            UipracticaTheme {
                NavManagment(instanceOfViewModelLogin)
            }
        }
    }
}

@Composable
fun CardStory() {
    Surface(
        elevation = 100.dp,
        modifier = Modifier.clip(RoundedCornerShape(5.dp))
    ){
        Column(
            modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(R.drawable.profile),
                "Perfil",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)                       // clip to the circle shape
            )
            Text("Nombre")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun preview() {
//    CardStory()
}