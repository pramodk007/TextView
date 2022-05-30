package com.example.textview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.textview.ui.theme.TextViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                SimpleText(
                    displayText = "I am simple Text"
                )
                SimpleText(
                    displayText = "hello there!!",
                    style = TextStyle(fontSize = 24.sp)
                )
                SimpleText(
                    displayText = "what's up",
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                SimpleText(
                    displayText = "yoooooo",
                    style = TextStyle(fontStyle = FontStyle.Italic)
                )
                SimpleText(
                    displayText = "hey there!!!",
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                SimpleText(
                    displayText = "hey wait for me",
                    style = TextStyle(
                        color = Color.DarkGray
                    )
                )
                SimpleText(
                    displayText = "go to hell!!",
                    style = TextStyle(
                        fontFamily = FontFamily.Cursive
                    )
                )
                SimpleText(
                    displayText = "where am i",
                    style = TextStyle(
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 20.sp
                    )
                )
                SimpleText(
                    displayText = "what the hell",
                    style = TextStyle(textDecoration = TextDecoration.Underline)
                )
                SimpleText(
                    displayText = "hey yoo I am taking to you",
                    style = TextStyle(textDecoration = TextDecoration.LineThrough)
                )
                SimpleText(
                    displayText = "fuck my life",
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Red,
                            blurRadius = 8f,
                            offset = Offset(2f, 2f)
                        )
                    )
                )
                SimpleText(
                    displayText = "what am i doing with my life",
                    style = TextStyle(
                        background = Color.Black,
                        color = Color.White
                    )
                )
                SimpleText(
                    displayText = "here i am in front of you",
                    style = TextStyle(
                        textIndent = TextIndent(firstLine = 30.sp)
                    )
                )
                SimpleText(
                    displayText = "I am an One Lined Text. If I cross the limit of one line then an Ellipsis(...)",
                    maxLines = 1
                )
                val spannableString = buildAnnotatedString {
                    append("I am a text having different colors.")
                    addStyle(style = SpanStyle(color = Color.Blue), start = 0, end = 6)
                    addStyle(style = SpanStyle(color = Color.LightGray), start = 7, end = 18)
                    addStyle(style = SpanStyle(color = Color.Gray), start = 19, end = 36)
                }
                Text(
                    text = spannableString,
                    modifier = Modifier.padding(16.dp)
                )

                SimpleText(
                    displayText = "I am a Text having Justified alignment. " +
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                            "eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                            "nisi ut aliquip ex ea commodo consequat.",
                    style = TextStyle(
                        textAlign = TextAlign.Justify
                    )
                )
                SimpleText(
                    displayText = "I am a Text having Justified alignment. " +
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                            "eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                            "nisi ut aliquip ex ea commodo consequat.",
                    style = TextStyle(
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}

@Composable
fun SimpleText(displayText: String, style: TextStyle? = null, maxLines: Int? = null) {
    Text(
        text = displayText,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextViewTheme {
        SimpleText("Hi I am learning Compose")
    }
}