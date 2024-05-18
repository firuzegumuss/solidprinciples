package com.firuze.solid.open_closed.decorator

/**
 *
 * Open/Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
 *
 * Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.
 *
 *  */

interface Coffee {
    fun cost(): Double
    fun description(): String
}

class BasicCoffee : Coffee {
    override fun cost() = 5.0
    override fun description() = "Coffee"
}

abstract class CoffeeDecorator(private val coffee: Coffee) : Coffee {
    override fun cost() = coffee.cost()
    override fun description() = coffee.description()
}

class MilkDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost() = super.cost() + 3.0
    override fun description() = super.description() + ", Milk"
}

class SugarDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost() = super.cost() + 0.5
    override fun description() = super.description() + ", Sugar"
}

class ChocolateDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost() = super.cost() + 2.5
    override fun description() = super.description() + ", Chocolate"
}

class CreamDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost() = super.cost() + 1.5
    override fun description() = super.description() + ", Cream"
}

class CaramelDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost() = super.cost() + 3.0
    override fun description() = super.description() + ", Caramel"
}

class CoffeeOrderManager {
    private var coffee: Coffee = BasicCoffee()

    fun addDecorator(decorator: CoffeeDecorator) {
        coffee = decorator
    }

    fun getTotalCost(): Double {
        return coffee.cost()
    }

    fun getDescription(): String {
        return coffee.description()
    }

}

fun main() {
    val coffeeOrderManager = CoffeeOrderManager()
    val milkCoffee = MilkDecorator(BasicCoffee())
    coffeeOrderManager.addDecorator(milkCoffee)
    println("Price: ${coffeeOrderManager.getTotalCost()}, Description: ${coffeeOrderManager.getDescription()}")
    val sugarCoffee = SugarDecorator(BasicCoffee())
    coffeeOrderManager.addDecorator(sugarCoffee)
    println("Price: ${coffeeOrderManager.getTotalCost()}, Description: ${coffeeOrderManager.getDescription()}")

    val sugarMilkCoffee = SugarDecorator(milkCoffee)
    coffeeOrderManager.addDecorator(sugarMilkCoffee)
    println("Price: ${coffeeOrderManager.getTotalCost()}, Description: ${coffeeOrderManager.getDescription()}")

    val chocolateDecorator = ChocolateDecorator(BasicCoffee())
    coffeeOrderManager.addDecorator(chocolateDecorator)
    println("Price: ${coffeeOrderManager.getTotalCost()}, Description: ${coffeeOrderManager.getDescription()}")

    val chocolateMilkDecorator = ChocolateDecorator(sugarMilkCoffee)
    coffeeOrderManager.addDecorator(chocolateMilkDecorator)
    println("Price: ${coffeeOrderManager.getTotalCost()}, Description: ${coffeeOrderManager.getDescription()}")

    val creamDecorator = CreamDecorator(chocolateDecorator)
    coffeeOrderManager.addDecorator(creamDecorator)
    println("Price: ${coffeeOrderManager.getTotalCost()}, Description: ${coffeeOrderManager.getDescription()}")

    var pureCoffee = BasicCoffee()
    var chocolateCoffee = ChocolateDecorator(pureCoffee)
    var milkChocolateCoffee = MilkDecorator(chocolateCoffee)
    val caramelMilkChocolateCoffee= CaramelDecorator(milkChocolateCoffee)


}