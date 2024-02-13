package com.example.practice_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_1.ui.theme.Practice1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practice1Theme {
                entry()
            }
        }
    }
}

@Composable
fun entry() {

    val itemsCard = listOf(
        CardPerson("Hans Camilo Correa", "Hola como estas?"),
        CardPerson("Jose Maria de Zubiria", "No se como estoy"),
        CardPerson("Robertito", "xd")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 8.dp,
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Text("UniSabana Chat")
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column {
                verticalStory()
                Column() {
                    itemsCard.forEach { item ->
                        card(item.name, item.description)
                    }
                }
                Divider()
                cardPost()
            }
        }
    }
}

@Composable
fun card(name: String, lastMessage: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row() {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "Imagen de perfil",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            ) {
                Text(name)
                Text("Last message: $lastMessage")
            }
        }
        Icon(Icons.Rounded.ArrowForward, contentDescription = "Icono de flecha")
    }
}

@Composable
fun verticalStory() {
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier.horizontalScroll(scrollState)
    ) {
        for (i in 1..10) {
            cardStory(i)
        }
    }
}

@Composable
fun cardStory(state: Int) {
    Surface(
        elevation = 20.dp,
        modifier = Modifier
            .padding(5.dp)
            .clickable { println("Item numero $state") },
        shape = RoundedCornerShape(5.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "Imagen de perfil",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )

            if (state == 1) {
                Icon(Icons.Rounded.Add, "Add story")
            } else {
                Text("Hans")
            }
        }
    }
}

@Composable
fun cardPost() {
    Surface(
        elevation = 20.dp,
        modifier = Modifier
            .padding(5.dp),
        shape = RoundedCornerShape(5.dp),
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = "Imagen de perfil",
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .size(35.dp)
                            .clip(CircleShape)
                    )
                    Text("Hans Camilo Correa")
                }
                Icon(Icons.Rounded.MoreVert, "options")
            }
            Text("Vacaciones en un gran nevado, que felicidad #SoyElMejorXdXd")
            Image(
                painter = painterResource(R.drawable.post),
                contentDescription = "Post",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Row() {
                Icon(Icons.Outlined.Favorite, "Like")
                Icon(Icons.Outlined.MailOutline,"Comments")
            }
            Text("124 likes | 3 comments")
        }
        //


    }
}

@Preview
@Composable
fun defaultPreview() {
    entry()
}

data class CardPerson(val name: String, val description: String)
data class CardNews(
    val user: String,
    val description: String,
    val likesNumber: Int,
    val commentsNumber: Int,
    val isLike: Boolean,
    val urlImage: String,
)