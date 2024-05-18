package com.firuze.solid.liskovsubstitution


/**
 * Liskov Substitution Principle (LSP): Subtypes must be substitutable for their base types without altering the correct behavior of the program.
 *
 */


abstract class PaymentProcessor {
    abstract fun processPayment(amount: Double)
    abstract fun generateInvoice(amount: Double): String
    abstract fun sendNotification(message: String)
}

interface SmsVerifiable {
    fun verifySms(smsCode: String): Boolean {
        return smsCode == "123456"
    }
}

class CreditCardPaymentProcessor(private val smsCode: String) : PaymentProcessor(), SmsVerifiable {

    override fun processPayment(amount: Double) {
        // SMS verification
        if (!verifySms(smsCode)) {
            throw SecurityException("Invalid SMS code")
        }

        println("Processing credit card payment of $$amount")

        val invoice = generateInvoice(amount)
        sendNotification("Payment processed. Invoice: $invoice")
    }

    override fun generateInvoice(amount: Double): String {
        return "Invoice for $$amount"
    }

    override fun sendNotification(message: String) {
        println("Notification sent: $message")
    }
}

class BankTransferPaymentProcessor : PaymentProcessor() {
    override fun processPayment(amount: Double) {
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
        processor.processPayment(1000.0)  // SMS doğrulama gerekmez
    } catch (e: Exception) {
        println("Test failed: ${e.message}")
    }
}

fun main() {
    val creditCardProcessor = CreditCardPaymentProcessor("123456")
    val bankTransferProcessor = BankTransferPaymentProcessor()

    testPaymentProcessor(creditCardProcessor)  // Kredi kartı ödeme işlemcisi SMS doğrulamasıyla çalışır
    testPaymentProcessor(bankTransferProcessor)  // Banka havalesi işlemcisi SMS doğrulama gerektirmez
}
