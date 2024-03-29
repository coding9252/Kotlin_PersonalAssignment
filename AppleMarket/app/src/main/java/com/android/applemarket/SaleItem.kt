package com.android.applemarket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SaleItem(
    val itemPhoto: Int,
    val itemName: String,
    val itemLocation: String,
    val itemPrice: Int,
    val itemComment: Int,
    val itemLike: Int,
    val nickName: String,
    val mannerImage: Int,
    val temperature: String,
    val description: String
) : Parcelable