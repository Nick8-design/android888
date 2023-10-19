package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDefaults.color
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.style.TextForegroundStyle.Unspecified.color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                FlowRow{
                    repeat(3){
                        Box (
                            modifier = Modifier
                                .width(Random.nextInt(50,200).dp)
                                .height(100.dp)
                                .background(Color(Random.nextLong(0xFFFFFFFF)))
                        )

                }
            }
        }
    }
}

@Composable
fun FlowRow(
    modifier: Modifier= Modifier,
    content:@Composable()-> Unit
){
Layout(
    modifier= modifier,
    measurePolicy = {measurables,constraints ->
        val placeables = measurables.map {
            it.measure(constraints)
        }
        layout(

            width = constraints.maxWidth,
            height = constraints.maxHeight
        ) {
            var xposition = 0
            placeables.forEach { placeable ->
                placeable.place(
                    x = xposition,
                    y = 0
                )
                xposition += placeable.width
            }
        }
    },
    content= content
)
}