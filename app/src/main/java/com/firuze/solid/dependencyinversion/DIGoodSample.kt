package com.firuze.solid.dependencyinversion

/*
 * Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules; both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions.

 *
 */

// Yüksek seviye modül: Sipariş İşlemcisi
class OrderProcessor(private val paymentProcessor: PaymentProcessor) {
    fun processOrder(order: Order) {
        // Yüksek seviye iş mantığı
        println("Processing order #${order.id}")

        // Ödemeyi işleme
        paymentProcessor.processPayment(order.total)

        // Diğer iş mantığı
        println("Order #${order.id} processed")
    }
}

interface PaymentProcessor {
    fun processPayment(amount: Double)
}

// Düşük seviye modül: Kredi Kartı Ödeme İşlemcisi
class CreditCardPaymentProcessor : PaymentProcessor {
    override fun processPayment(amount: Double) {
        println("Processing credit card payment of $$amount")
    }
}

// Düşük seviye modül: PayPal Ödeme İşlemcisi
class PayPalPaymentProcessor : PaymentProcessor {
    override fun processPayment(amount: Double) {
        println("Processing payment of $$amount using PayPal")
    }
}

data class Order(val id: Int, val total: Double)

fun main() {
    val order = Order(1, 150.0)

    // Yüksek seviye modül, düşük seviye detaylara bağımlı değil, abstractiona bağımlı
    val orderProcessor1 = OrderProcessor(CreditCardPaymentProcessor())
    orderProcessor1.processOrder(order)

    val orderProcessor2 = OrderProcessor(PayPalPaymentProcessor())
    orderProcessor2.processOrder(order)
}
