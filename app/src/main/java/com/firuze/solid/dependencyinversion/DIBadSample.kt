// Düşük seviye modül: Kredi Kartı Ödeme İşlemcisi
class EFTPaymentProcessor {
    fun processCreditCardPayment(amount: Double) {
        println("Processing credit card payment of $$amount")
    }
}

// Düşük seviye modül: PayPal Ödeme İşlemcisi
class PayPalPaymentProcessor {
    fun processPayPalPayment(amount: Double) {
        println("Processing payment of $$amount using PayPal")
    }
}

// Yüksek seviye modül: Sipariş İşlemcisi
class OrderProcessor {
    private val creditCardPaymentProcessor = EFTPaymentProcessor()
    private val payPalPaymentProcessor = PayPalPaymentProcessor()

    fun processOrder(order: Order, paymentType: String) {
        // Yüksek seviye iş mantığı
        println("Processing order #${order.id}")

        // Ödemeyi işleme
        when (paymentType) {
            "CreditCard" -> creditCardPaymentProcessor.processCreditCardPayment(order.total)
            "PayPal" -> payPalPaymentProcessor.processPayPalPayment(order.total)
            else -> println("Unsupported payment method")
        }

        // Diğer iş mantığı
        println("Order #${order.id} processed")
    }
}

data class Order(val id: Int, val total: Double)

fun main() {
    val order = Order(1, 150.0)

    val orderProcessor = OrderProcessor()
    orderProcessor.processOrder(order, "CreditCard")
    orderProcessor.processOrder(order, "PayPal")
}
