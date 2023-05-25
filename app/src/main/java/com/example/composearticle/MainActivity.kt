package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composearticle.ui.theme.ComposeArticleTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   ComposeImage(
                       stringResource(R.string.title),
                       stringResource(R.string.jetpack_description),
                       stringResource(R.string.tutorial_description))
                }
            }
        }
    }
}

@Composable
fun ComposeText(title: String, jetpackDescription: String, tutorialDescription: String, modifier: Modifier = Modifier) {
    Column (modifier = modifier){
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier
                .padding(all = 16.dp)
        )
        Text(
            text = jetpackDescription,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp)

        )
        Text(
            text = tutorialDescription,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(all = 16.dp)
        )
    }
}

@Composable
fun ComposeImage(title: String, jetpackDescription: String, tutorialDescription: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column (modifier = modifier){
        Image(
            painter = image,
            contentDescription = null
        )
        ComposeText(
            title = title,
            jetpackDescription = jetpackDescription,
            tutorialDescription = tutorialDescription,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ComposeImage("Jetpack Compose tutorial",
            "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
        "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.")
    }
}