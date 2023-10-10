package modul2

fun main(){
    val str="tops technology"
    val c='o'
    var frequency=0
    for (i in 0..str.length-1){
        if (c==str[i]){
            ++frequency
        }
    }
    println("frequency $c is $frequency")
}