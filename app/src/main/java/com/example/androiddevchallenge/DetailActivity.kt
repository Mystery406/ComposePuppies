package com.example.androiddevchallenge

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                PuppyDetail(this, intent.getSerializableExtra("puppy") as Puppy)
            }
        }
    }
}

@Composable
fun PuppyDetail(context: Context, puppy: Puppy) {
    Column {
        Box {
            Image(
                painterResource(puppy.avatar),
                null,
                Modifier.aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Button(
                onClick = {
                    Toast.makeText(
                        context,
                        "Congrats,You have adopted this puppy!",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text(text = "Adopt")
            }
        }


        Column(Modifier.padding(8.dp)) {
            Text("Name: ${puppy.name}", style = MaterialTheme.typography.h3)
            ProvideTextStyle(MaterialTheme.typography.h5) {
                Text("Breed: ${puppy.breed}")
                Text("Location: ${puppy.location}")
                Text("Age: ${puppy.age}")
                Text("Gender: ${puppy.gender}")
                Text("Size: ${puppy.size}")
            }
        }
    }
}