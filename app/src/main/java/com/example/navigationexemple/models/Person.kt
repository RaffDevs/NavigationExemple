package com.example.navigationexemple.models

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String = "",
    val age: Int = 0,
    val street: String = "",
    val number: Int = 0
): Parcelable {
    @IgnoredOnParcel
    val person = "$name $age"
    @IgnoredOnParcel
    val address = "$street $number"
}
