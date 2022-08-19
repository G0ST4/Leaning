import kotlin.math.roundToInt
import java.io.File

const val TAVEREN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

val firstNameCollection = mutableListOf("Mordoc", "Eli", "Sophie")
val lastNameCollection = listOf("Ironfoot", "Fernsworth", "Baggins")
val patronList = mutableSetOf<String>()

val menuList = File("src/data/tavern-menu-data.txt")
    .readText()
    .split("\n")

fun main(args: Array<String>) {
    //placeOrder("shandy,Dragon's Breath,5.91")

    /*
    patronList.run{
        remove("Eli")
        add("Alex")
        add(0, "Alexis")
        add(2, "Flip")
    }
    */
    /*
    patronList.forEach{
        println("Good day, $it")
    }

    patronList.forEach{ patron ->
        println("Good day, $it")
    }

    */
    (0..9).forEach{
        val firstName = firstNameCollection.shuffled().first()
        val lastName = lastNameCollection.shuffled().first()
        val fullName = "$firstName $lastName"
        patronList += fullName
    }

    menuList.forEachIndexed { index, data ->
        println("$index : $data")
        }
    displayMenu()


    patronList.forEachIndexed{ index, patron ->
        println("Good day, $patron - you're #${index + 1} in line.")         
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(patronList.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }

    
}

private fun placeOrder(patron: String, menuData: String) {
    val indexOfApostraphe = TAVEREN_NAME.indexOf('\'')
    val taverenMaster = TAVEREN_NAME.substring(0 until indexOfApostraphe)
    println("$patron speaks with $taverenMaster about their order.")
    val (type, name, price) = menuData.split(',')
    val message = "$patron buys a $name($type) for $price"
    println(message)

    //performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "$patron exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "$patron says: Thanks for the $name."
    }   
    println(phrase)
}

private fun toDragonSpeak(phrase: String) = 
    phrase.replace(Regex("[aeiouAEIOU]")){
        when (it.value.lowercase()){
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

fun performPurchase(price: Double) {
    displayBalance()
    var totalPurse: Double = playerGold.toDouble() + (playerSilver / 100)
    val remainingBalance = totalPurse - price
    println("Purchasing item for $price")
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")
    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}

private fun displayMenu(){
    println("*** Welcome to $TAVEREN_NAME ***")
    val lst = mutableSetOf<String>()
    //перечень типов напитков
    menuList.forEach{ data ->
        val (type, _, _) = data.split(',')
        lst += type

    }
    //Ќапечатать
    lst.forEach{ drink ->
        println("\t~~~ $drink ~~~")
        menuList.forEach { row ->
            val (type, name, price) = row.split(',')
            if(type == drink){
                println("$name ....... $price")
            }
        }
    }
}

