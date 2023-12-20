package com.krashkrosh748199.shoption.models

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize

@VersionedParcelize
data class CartItem(
    val user_id: String? = "",
    val product_id: String? = "",
    val title: String? = "",
    val price: String? = "",
    val image: String? = "",
    var cart_quantity: String? = "",
    var stock_quantity: String? = "",
    var id: String? = "",
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
      return 0
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {

    }

    companion object CREATOR : Parcelable.Creator<CartItem> {
        override fun createFromParcel(parcel: Parcel): CartItem {
            return CartItem(parcel)
        }

        override fun newArray(size: Int): Array<CartItem?> {
            return arrayOfNulls(size)
        }
    }
}