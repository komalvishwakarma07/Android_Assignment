package modul2

fun main(){
    println("Enter the dividend:")
    var divident= readLine()!!.toInt()

    println("Enter the divisor:")
    var divisor= readLine()!!.toInt()

    if(divident==0){
        println("divide by zero is not allow")
    }
    else{
        val Quantent=divident/divisor
        val Remainder=divident%divisor

        println("Quantant is : $Quantent")
        println("Remainder is : $Remainder")
    }
}