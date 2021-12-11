package com.udj.bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udj.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    createBiCard()
                }
            }
        }
    }
}

@Composable
fun createBiCard() {

    val buttonClickState = remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
                .padding(16.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            backgroundColor = Color.White
        ) {
            Column(
                modifier = Modifier.height(300.dp), verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                createImageProfile()
                Divider(color = Color.LightGray, thickness = 2.dp)
                createText(text = "Person A.")

                Button(onClick = {
                    buttonClickState.value = !buttonClickState.value
                }) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.button,
                        modifier = Modifier.padding(4.dp)
                    )
                }

                if (buttonClickState.value) {
                    content()
                } else {
                    Box() {}
                }
            }
        }


    }
}

@Preview
@Composable
private fun content() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(4.dp),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            portfolio(
                values = listOf(
                    "Project1", "Project2",
                    "Project3", "Project4",
                    "Project3", "Project4"
                )
            )
        }
    }
}

@Composable
private fun portfolio(values: List<String>) {
    LazyColumn {
        items(values) { item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(), shape = RectangleShape, elevation = 4.dp) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(16.dp)) {
                    createImageProfile(modifier = Modifier.size(64.dp))
                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "Building a project", style = MaterialTheme.typography.body2)
                    }

                }
            }
        }
    }
}


@Composable
private fun createText(text: String) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            color = MaterialTheme.colors.primaryVariant,
            style = MaterialTheme.typography.h4
        )

        Text(
            text = "Android Developer",
            modifier = Modifier.padding(4.dp),
            style = MaterialTheme.typography.subtitle2,
            fontSize = 24.sp
        )

        Text(
            text = "email@gmail.com",
            modifier = Modifier.padding(4.dp),
            style = MaterialTheme.typography.subtitle1,
            fontSize = 18.sp
        )
    }

}

@Composable
private fun createImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(128.dp)
            .padding(8.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_profile),
            contentDescription = stringResource(R.string.user_profile_image),
            modifier = modifier.size(128.dp),
            contentScale = ContentScale.Crop
        )
    }
}


//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizCardTheme {
        createBiCard()
    }
}