package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import java.io.Serializable

data class Puppy(
    val name: String,
    val breed: String,
    val location: String,
    val age: String,
    val gender: String,
    val size: String,
    @DrawableRes val avatar: Int
) : Serializable
