package com.koppr.myartspace


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.koppr.myartspace.ui.theme.MyArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyArtSpaceTheme {
                ArtSpace()
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var numArt by remember { mutableStateOf(1) }
    var like by remember { mutableStateOf(false) }

    val gudArt = when (like){
        false -> Icons.Outlined.FavoriteBorder
        true -> Icons.Outlined.Favorite
    }


    val imageResource = when (numArt){
        1 -> R.drawable.my_art1
        2 -> R.drawable.my_art2
        3 -> R.drawable.my_art3
        else -> R.drawable.my_art4
    }
    val contentDescription = when (numArt){
        1 -> R.string.my_art_1
        2 -> R.string.my_art_2
        3 -> R.string.my_art_3
        else -> R.string.my_art_4
    }
    val textName = when (numArt){
        1 -> R.string.my_art_1_name
        2 -> R.string.my_art_2_name
        3 -> R.string.my_art_3_name
        else -> R.string.my_art_4_name
    }
    val textAuthor = when (numArt){
        1 -> R.string.my_art_1_author
        2 -> R.string.my_art_2_author
        3 -> R.string.my_art_3_author
        else -> R.string.my_art_4_author
    }

Column (modifier = modifier
    .fillMaxSize()
    .padding(10.dp)
    .background(color = colorResource(R.color.blue2)),
    horizontalAlignment = Alignment.CenterHorizontally,
){
    Box(modifier = modifier
        .weight(4f)
        .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = modifier
            .shadow(8.dp),
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(contentDescription),
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .padding(30.dp),

            )
            Box(modifier = modifier
                .padding(bottom = 20.dp, end = 20.dp)
                .background(color = Color.White, shape = CircleShape)
                .align(Alignment.BottomEnd)
                .clickable(onClick = {
                    like = !like
                }),
                ) {
                Icon(gudArt,
                    modifier = modifier
                        .padding(5.dp)
                        .size(35.dp),
                    tint = Color.Red,
                    contentDescription = null,
                    )
            }
        }
    }
    Box (modifier = modifier
        .weight(1.2f)
        .fillMaxWidth()
        .padding(bottom = 45.dp, start = 8.dp, end = 8.dp)
        .background(color = colorResource(R.color.grey))){
        Column (modifier = modifier
            .padding(15.dp)
        ){
            Text(text = stringResource(textName),
                modifier = modifier
                    .weight(3f),
                color = colorResource(R.color.emerald),
                fontStyle = FontStyle.Italic,
                fontSize = 22.sp)
            Text(text = stringResource(textAuthor),
                modifier = modifier
                    .weight(1f),
                color = colorResource(R.color.emerald),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
    }
    Row (modifier = modifier
        .weight(0.7f)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly){
        Button1(onClick1 = {
            if (numArt>1) numArt--
            else numArt = 4
        }, modifier = modifier
            .weight(1f)
            .padding(10.dp), textResource1 = R.string.Previous)

        Button1(onClick1 = {
            if (numArt<4) numArt++
            else numArt = 1
        }, modifier = modifier
            .weight(1f)
            .padding(10.dp), textResource1 = R.string.Next)
    }
}
}

@Composable
fun Button1(modifier: Modifier, textResource1:Int, onClick1:() -> Unit){
    Button(onClick = onClick1,
        modifier = modifier,
            colors = ButtonDefaults.buttonColors(
                contentColor = colorResource(R.color.emerald),
                containerColor = colorResource(R.color.blue)
            )
        ) {
        Text(text = stringResource(textResource1), fontSize = 18.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyArtSpaceTheme {
        ArtSpace(modifier = Modifier


        )
    }
}