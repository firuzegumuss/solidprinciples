package com.firuze.solid.single_responsibility

// Bad Sample
class ShoppingCartClass{
    fun add(){}
    fun remove(){}
    fun checkOut(){}
    fun saveForLater(){}
}

// Single Responsibility Principle
class ShoppingCart{
    fun add(){}
    fun remove(){}
}

class CheckoutProcess{
    fun checkOut(){}
}

class Wishlist{
    fun saveForLater(){}
}