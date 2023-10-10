package modul2
fun main(){
    print("Enter an integer: ")
    val input = readLine()

    try {
        val number = input?.toInt()
        if (number != null) {
            println("You entered: $number")
        } else {
            println("Invalid input. Please enter a valid integer.")
        }
    } catch (e: NumberFormatException) {
        println("Invalid input. Please enter a valid integer.")
    }
}