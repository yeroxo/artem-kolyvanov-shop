package com.example.artem_kolyvanov_shop

/**
 * Модель для создания заказа
 */
data class CreateOrderModel(
    var firstName:String = "",
    var lastName:String = "",
    var phoneNumber:String = ""
)