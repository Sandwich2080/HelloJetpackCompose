package com.example.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStory()
        }
    }
}

@Composable
fun NewsStory() {
    Column() {
        TopAppBar() {

        }
        Column(modifier = Modifier.padding(all = 10.dp)) {
            Image(
                painter = painterResource(id = R.mipmap.header),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Item one")
            Text(text = "Item two")
            Text(text = "Item three")
            ListItem {
                Text(text = "A customized item")
            }
            Divider(color = Color.Transparent,thickness = 22.dp)
            Counter()
        }

    }
}

@Composable
fun Counter(){
    val count = remember {
        mutableStateOf(0)
    }
    Button(onClick = { count.value++ }) {
        Text(text = "I've been clicked ${count.value} times")
    }
}

@Composable
fun ListItem(content: @Composable () -> Unit){
   Surface(color = Color.Red) {
       content()
   }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsStory()
}