package com.app.nervous.domain

import android.os.Parcel
import android.os.Parcelable

data class Answers(
        var question: String,
        var answer: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString().toString())

    constructor() : this(
            "",
            "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeString(answer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Answers> {
        override fun createFromParcel(parcel: Parcel): Answers {
            return Answers(parcel)
        }

        override fun newArray(size: Int): Array<Answers?> {
            return arrayOfNulls(size)
        }
    }

}