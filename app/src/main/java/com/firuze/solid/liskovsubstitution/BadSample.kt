abstract class PaymentProcessor {
    abstract fun processPayment(amount: Double, smsCode: String)
    abstract fun generateInvoice(amount: Double): String
    abstract fun sendNotification(message: String)
}

class CreditCardPaymentProcessor : PaymentProcessor() {
    override fun processPayment(amount: Double, smsCode: String) {
        if (smsCode.isEmpty()) {
            throw IllegalArgumentException("SMS code is required for credit card payments")
        }

        if (!verifySms(smsCode)) {
            throw SecurityException("Invalid SMS code")
        }

        println("Processing credit card payment of $$amount")

        val invoice = generateInvoice(amount)
        sendNotification("Payment processed. Invoice: $invoice")
    }

    private fun verifySms(smsCode: String): Boolean {
        return smsCode == "123456"
    }

    override fun generateInvoice(amount: Double): String {
        return "Invoice for $$amount"
    }

    override fun sendNotification(message: String) {
        println("Notification sent: $message")
    }
}

class BankTransferPaymentProcessor : PaymentProcessor() {
    override fun processPayment(amount: Double, smsCode: String) {
        println("Processing bank transfer of $$amount without SMS verification")

        val invoice = generateInvoice(amount)
        sendNotification("Bank transfer processed. Invoice: $invoice")
    }

    override fun generateInvoice(amount: Double): String {
        return "Invoice for $$amount"
    }

    override fun sendNotification(message: String) {
        println("Notification sent: $message")
    }
}

fun testPaymentProcessor(processor: PaymentProcessor) {
    try {
        processor.processPayment(1000.0, "123456")
    } catch (e: Exception) {
        println("Test failed: ${e.message}")
    }
}

fun main() {
    val creditCardProcessor = CreditCardPaymentProcessor()
    val bankTransferProcessor = BankTransferPaymentProcessor()

    // CreditCardPaymentProcessor beklendiği gibi çalışır
    testPaymentProcessor(creditCardProcessor)

    // BankTransferPaymentProcessor, SMS doğrulama adımına gere duymadığından LSP ihlali olur
    testPaymentProcessor(bankTransferProcessor)
}
