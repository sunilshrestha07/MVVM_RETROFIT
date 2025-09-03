package com.example.crud.UI.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crud.R
import kotlinx.coroutines.launch


data class OnBoarding(
    val title: String,
    val description: String,
    val image: Int
)

val onBoardingItems = listOf<OnBoarding>(
    OnBoarding(
        "title1",
        "Exploring new technologies inspires creativity and growth. Learning modern tools like Jetpack Compose and Kotlin enables developers to build interactive and responsive applications efficiently. Continuous practice, experimentation, and persistence are key to mastering these skills and achieving success in software development.",
        R.drawable.image
    ),
    OnBoarding(
        "title2",
        "Exploring new technologies inspires creativity and growth. Learning modern tools like Jetpack Compose and Kotlin enables developers to build interactive and responsive applications efficiently. Continuous practice, experimentation, and persistence are key to mastering these skills and achieving success in software development.",
        R.drawable.image4
    ),
    OnBoarding(
        "title2",
        "Exploring new technologies inspires creativity and growth. Learning modern tools like Jetpack Compose and Kotlin enables developers to build interactive and responsive applications efficiently. Continuous practice, experimentation, and persistence are key to mastering these skills and achieving success in software development.",
        R.drawable.image3
    ),
)

@Preview(showSystemUi = true)
@Composable
fun OnBoardingScreen() {
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState { onBoardingItems.size }

    Box {


    HorizontalPager(
        state = pageState,
        modifier = Modifier
            .fillMaxWidth().background(Color.Red),
    ) { item ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Box(
                modifier = Modifier
                    .weight(4f)
                    .fillMaxWidth()

            ) {
                Image(
                    painterResource(id = onBoardingItems[item].image),
                    contentDescription = "screen one",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

            }

            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = onBoardingItems[item].title, maxLines = 2)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = onBoardingItems[item].description, maxLines = 4)
            }
        }
    }
        Row(
            modifier = Modifier

                .padding(30.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.Green),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Row(){
                repeat(onBoardingItems.size){index->
                    val color = if(index == pageState.currentPage) Color.Green else Color.Gray
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(100))
                            .background(
                                color = color
                            )
                            .size(15.dp)

                    )
                }
            }

            FilledTonalButton(onClick = {
                scope.launch {
                    if(pageState.currentPage != onBoardingItems.size-1){
                        pageState.animateScrollToPage(pageState.currentPage + 1)
                    }
                }
            }, modifier = Modifier.widthIn(100.dp)) {
                Text(if(pageState.currentPage == onBoardingItems.size-1) "Start" else "Next",)
            }
        }
}
}