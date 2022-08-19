fun main(args: Array<String>) {
    val name: String = "Madrigal"
    var healthPoints: Int = 89
    val isBlessed: Boolean = true;
    val isImmortal = false

    /* Раса и фракция */
    val race = "gnome"
    val faction = when(race){
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> ""
    }
    //Карма
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20 ).toInt()
    val karmaStatus = when(karma){
        in 0..5 -> "RED"
        in 6..10 -> "ORANGE"
        in 11..15 -> "PURPLE"
        in 16..20 -> "GREEN"
        else -> "NONE"
    }

    //Аура
    val auraVisible = healthPoints >= 50 && isBlessed || isImmortal
    val auraColor = if(auraVisible){
        "GREEN"
    } else{
        "NONE"
    }

    val healthStatus = when(healthPoints){
        100 -> " is in excellent condition!"
        in 90..99 -> " has a few scratches."
        in 75..89 -> if(isBlessed){
                    " has some minor wounds but is healing quite quickly!"
                } else {
                    " has some minor wounds."    
                }        
        in 15..74 -> " looks pretty hurt."
        else -> " is in awful condition!"
    }



    println("Karma: $karmaStatus")
    println("Aura: $auraColor. Blessed: ${if(isBlessed) "YES" else "NO"}")
    println("$name $healthStatus")

    
} 

fun shouldReturnAString(): String {
    TODO("implement the string building functionality here to return a string")
    println("TODO realese")
    }