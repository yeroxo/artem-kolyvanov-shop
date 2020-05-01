package com.example.artem_kolyvanov_shop.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class ProductItem internal constructor(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val value: Value) : Parcelable {

    override fun toString(): String {
        return "$id: $title"
    }

    override fun equals(other: Any?): Boolean {
        if (other is ProductItem) {
            return other.id == id
        }
        return false
    }

    override fun hashCode(): Int {
        return "Entity$id".hashCode()
    }

    companion object  {
        fun createProductItem(
            id: Int,
            title: String,
            imageUrl: String,
            price: Double,
            salePercent: Int
        ): ProductItem {
            val lot = Value(price, salePercent)
            return ProductItem(id, title, imageUrl, lot)
        }
    }
}

@Parcelize
class Value internal constructor(
    /**
     * [price] must be positive
     */
    val price: Double,
    /**
     * [salePercent] must between 0 and 100
     */
    val salePercent: Int
) : Parcelable {
    fun calcDiscountPrice(): Double {
        return price * (1 - (salePercent / 100.0))
    }
}