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


    val auraColor = auraColor(healthPoints, isBlessed, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFireball(5)
    castFireball()
    
} 

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when(healthPoints){
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

private fun auraColor(healthPoints: Int, isBlessed: Boolean, isImmortal: Boolean): String {
    //Аура
    val auraVisible = healthPoints >= 50 && isBlessed || isImmortal
    val auraColor = if(auraVisible){
        "GREEN"
    } else{
        "NONE"
    }
    return auraColor
}

private fun printPlayerStatus(auraColor: String, isBlessed:Boolean, name: String, healthStatus:String){
    println("Aura: $auraColor. Blessed: ${if(isBlessed) "YES" else "NO"}")
    println("$name $healthStatus")
}

private fun castFireball(numFireballs: Int = 1) =  println("A glass of Fireball springs into existence. (x$numFireballs)")