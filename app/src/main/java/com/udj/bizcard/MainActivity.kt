package com.udj.bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
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
            }
        }


    }
}

@Composable
private fun createText(text: String) {
    Column(modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
            ) {
        Text(
            text = text,
            color = MaterialTheme.colors.primaryVariant,
            style = MaterialTheme.typography.h4
        )
        
        Text(text = "Android Developer",
            modifier = Modifier.padding(4.dp),
            style = MaterialTheme.typography.subtitle2,
            fontSize = 24.sp
            )

        Text(text = "email@gmail.com",
            modifier = Modifier.padding(4.dp),
            style = MaterialTheme.typography.subtitle1,
            fontSize = 18.sp
            )
    }
    
}

@Composable
private fun createImageProfile() {
    Surface(
        modifier = Modifier
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
            modifier = Modifier.size(128.dp),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizCardTheme {
        createBiCard()
    }
}