package modul2

fun main() {

    val stateCityMap = HashMap<String, String>()


    stateCityMap["New York"] = "New York City"
    stateCityMap["California"] = "Los Angeles"
    stateCityMap["Texas"] = "Houston"



    println("State - City Mapping:")
    for ((state, city) in stateCityMap) {
        println("$state - $city")
    }
}


