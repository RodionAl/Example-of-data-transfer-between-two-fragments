package com.example.exampletransferdatafromfragmentatofragmentb

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserArgs(
    val name: String,
    val age: Int,
    val info: String
) : Parcelable
