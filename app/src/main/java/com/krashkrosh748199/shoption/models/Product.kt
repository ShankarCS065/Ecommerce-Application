package com.krashkrosh748199.shoption.models

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize

@VersionedParcelize
data class Product(
    val user_id: String? = "",
    val user_name: String? = "",
    val title: String? = "",
    val price: String? = "",
    val description: String? = "",
    val stock_quantity: String? = "",
    val image: String? = "",
    var product_id: String? = "",
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

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}