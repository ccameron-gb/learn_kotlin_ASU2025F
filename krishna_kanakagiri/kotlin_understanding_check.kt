fun main()
{
    val name = "Krishna"
    var cupsOfCoffee = 1
    val favoriteDrink = "Latte"
    println("$name has ordered $cupsOfCoffee cup of $favoriteDrink.")
    cupsOfCoffee++
    println("Now $name has ordered $cupsOfCoffee cups of $favoriteDrink ☕")
    val totalPrice = cupsOfCoffee * 4.5
    println("Total cost: $$totalPrice")


    //conditionals and loops
    val day = "Monday"
    val mood = when (day)
    {
        "Monday" -> "Focused"
        "Friday" -> "Excited"
        "Sunday" -> "Relaxed"
        else -> "Productive"
    }
    println("Mood on $day: $mood")

    for (count in 1..3)
    {
        println("Attempt $count: Ready to learn Kotlin!")
    }

    var energy = 3
    while (energy > 0)
    {
        println("Energy left: $energy ")
        energy--
    }


    //  function usage with default parameters
    println(brewCoffee())
    println(brewCoffee("Americano", 2))
    println(brewCoffee(shots = 3, drink = "Cappuccino"))


    // collections and lambdas
    val menu = listOf("Latte", "Mocha", "Espresso", "Cappuccino", "Cold Brew")
    println("Menu: $menu")
    val cDrinks = menu.filter { it.startsWith("C") }
    println("Drinks starting with C: $cDrinks")
    val lowercaseMenu = menu.map { it.lowercase() }
    println("Lowercase menu: $lowercaseMenu")
    val totalLetters = menu.map { it.length }.reduce { acc, len -> acc + len }
    println("Total number of letters in menu items: $totalLetters")


    // data classes and null safety
    val order1 = Order("Latte", "Medium", 2, "Krishna")
    val order2 = Order("Espresso", null, 1, null)
    val customerName = order2.customer ?: "Guest"
    val size = order2.size ?: "Regular"
    println("Order Summary → ${order2.drink}, Size: $size, Customer: $customerName")

    val customOrder = order1.copy(size = "Large", shots = 3)
    println("Updated Order: $customOrder")
}


// optional parameters
fun brewCoffee(drink: String = "Latte", shots: Int = 1): String
{
    val strength = if (shots > 1) "strong" else "mild"
    return "Brewing a $strength $drink..."
}


//data class
data class Order(val drink: String, val size: String?, val shots: Int, val customer: String?)
