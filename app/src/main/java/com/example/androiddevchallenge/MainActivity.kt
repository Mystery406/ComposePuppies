/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    private val puppies = listOf(
        Puppy(
            "Nala", "Pit Bull Terrier Mix", "Sunnyvale, CA",
            "Adult", "Female", "Large", R.drawable.img_puppy_nala
        ),
        Puppy(
            "Lulu", "Terrier Mix", "Sunnyvale, CA",
            "Young", "Female", "Medium", R.drawable.img_puppy_lulu
        ),
        Puppy(
            "Billy", "American Staffordshire Terrier Mix", "Sunnyvale, CA",
            "Adult", "Male", "Large", R.drawable.img_puppy_billy
        ),
        Puppy(
            "Arnie", "Chihuahua Mix", "Mountain View, CA",
            "Young", "Male", "Small", R.drawable.img_puppy_arnie
        ),
        Puppy(
            "Doby", "Mountain Dog & Shepherd Mix", "Sunnyvale, CA",
            "Puppy", "Female", "Medium", R.drawable.img_puppy_doby
        ),
        Puppy(
            "Bowen", "Mountain Dog & Shepherd Mix", "Sunnyvale, CA",
            "Puppy", "Male", "Medium", R.drawable.img_puppy_bowen
        ),
        Puppy(
            "Rumi", "Border Collie & German Shepherd Dog Mix", "Los Altos, CA",
            "Young", "Male", "Medium", R.drawable.img_puppy_rumi
        ),
        Puppy(
            "Mikey", "Chihuahua & Rat Terrier Mix", "Santa Clara, CA",
            "Young", "Male", "Medium", R.drawable.img_puppy_mikey
        ),
        Puppy(
            "Layla", "Chihuahua & Terrier Mix", "Santa Clara, CA",
            "Young", "Female", "Medium", R.drawable.img_puppy_layla
        ),
        Puppy(
            "Tessie", "Pit Bull Terrier Mix", "Santa Clara, CA",
            "Adult", "Female", "Large", R.drawable.img_puppy_tessie
        ),
        Puppy(
            "Sia", "Pit Bull Terrier", "Santa Clara, CA",
            "Young", "Female", "Medium", R.drawable.img_puppy_sia
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(this, puppies)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(context: Context, puppies: List<Puppy>) {
    Surface(color = MaterialTheme.colors.background) {
        PuppyList(puppies) { index ->
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("puppy", puppies[index])
            context.startActivity(intent)
        }
    }
}

@Composable
fun PuppyList(puppies: List<Puppy>, onPuppyClicked: (Int) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(puppies) { index, puppy ->
            PuppyItem(index, puppy, onPuppyClicked)
        }
    }
}

@Composable
fun PuppyItem(index: Int, puppy: Puppy, onPuppyClicked: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onPuppyClicked(index) }
            .height(120.dp)
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(puppy.avatar),
            contentDescription = "puppy",
            modifier = Modifier
                .width(100.dp)
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.width(6.dp))
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = "${puppy.name},age ${puppy.age}",
                fontSize = 16.sp
            )
            Text(
                text = puppy.breed,
                fontSize = 12.sp,
                maxLines = 2
            )
            Text(
                text = puppy.location,
                fontSize = 12.sp,
                maxLines = 2
            )
        }
    }
}
