package com.example.androiddevchallenge

import android.os.Parcel
import android.os.Parcelable

data class Cat(
    val name:String,
    val owner:String,
    val imgSrc:Int,
    val id:Int,
    val breed:String,
    val description:String?,
    val dateOfBirth:String,

    val sex:String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(owner)
        parcel.writeInt(imgSrc)
        parcel.writeInt(id)
        parcel.writeString(breed)
        parcel.writeString(description)
        parcel.writeString(dateOfBirth)
        parcel.writeString(sex)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cat> {
        override fun createFromParcel(parcel: Parcel): Cat {
            return Cat(parcel)
        }

        override fun newArray(size: Int): Array<Cat?> {
            return arrayOfNulls(size)
        }
    }

}
