package com.example.studentportal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Omar Mulla Ibrahim
 * Student Nr 500766035
 */

/**
 * data class for the urls
 */
@Parcelize
public data class Portal(
    var titel: String,
    var url: String
) : Parcelable