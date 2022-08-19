fun main(args: Array<String>) {

    //val greetingFunction: (String, Int) -> String = { playerName, numBuildings -> 
    //val greetingFunction = { playerName: String, numBuildings: Int ->
    /*runSimulation("Gizmo",::printConstructionCost){ playerName: String, numBuildings: Int ->
        val currentYear = 2022
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }*/
    //runSimulation("Gizmo", greetingFunction)
    runSimulation()
} 

fun runSimulation(){
    val greetingFunction = cofigureCreetingFunction()
    println(greetingFunction("Gizmo"))
}

fun cofigureCreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2022
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}


/*
inline fun runSimulation(playerName: String, costPrinter: (Int) -> Unit, greetingFunction: (String, Int) -> String){
    val numBuildings = (1..5).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFunction(playerName, numBuildings))
}

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
} 
*/