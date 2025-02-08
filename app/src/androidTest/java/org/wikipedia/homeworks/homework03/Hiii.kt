package org.wikipedia.homeworks.homework03

import kotlin.math.min


data class Product(val name: String, val weight: Int, val price: Double)

class Stock {

    private val products = mutableMapOf<Product, Int>()

    fun addProduct(product: Product) {
        products[product] = products.getOrDefault(product, 0) + 1
    }

    fun addProduct(name: String, weight: Int, price: Double) {
        addProduct(Product(name, weight, price))
    }

    infix fun String.weight(weight: Int) = this to weight

    infix fun Pair<String, Int>.by(price: Double) {
        addProduct(this.first, this.second, price)
    }

    fun get(product: Product, amount: Int): Int {
        val currentAmount = products.getOrDefault(product, 0)
        val amountToReturn = min(currentAmount, amount)
        products[product] = currentAmount - amountToReturn
        return amountToReturn
    }

    override fun toString(): String {
        return products.map { (product, quantity) ->
            "${product.name} (${product.weight}g): $${product.price} $quantity items"
        }.joinToString("\n")
            .let { "** Stock **\n$it" }
    }

    operator fun invoke(function: Stock.() -> Unit) {
        function()
    }
}


val stock = Stock()
fun main() {

    stock.addProduct(Product("broad", 400, .5))
    stock.addProduct(Product("broad", 400, .5))
    stock.addProduct(Product("broad", 400, .5))
    stock.addProduct(Product("broad", 400, .5))
    stock.addProduct(Product("broad", 400, .5))
    stock.addProduct(Product("bread", 180, 2.1))
    stock.addProduct(Product("apple", 1000, 1.2))

    stock {
        "bread" weight 400 by 5.0
        addProduct("broad", 400, .5)
        addProduct("broad", 400, .5)
        addProduct("broad", 400, .5)
    }




    println(stock.toString())
}