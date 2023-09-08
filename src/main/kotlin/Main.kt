import java.text.DecimalFormat

fun main(args: Array<String>) {
    println("Please enter the cost of your items.")
    println("When you have finished enter 0.")
    var num = 0
    var price: Double = 0.0
    do {
        num += 1
        print("Item #$num: ")
        var itemCost = readln()!!.toDouble()
        price += itemCost
    } while (itemCost.toInt() != 0)
    val twoDigits = DecimalFormat("#.##")
    val taxes = twoDigits.format(taxesFig(price))
    var taxVal = taxes.toDouble()
    println("What percentage would you like to tip?")
    println("The default is 17.5% but if you would like to change")
    println("that you can put it in now. If you don't want to change")
    println("it, please enter -1.")
    var tipPer = readln()!!.toDouble()
    var tip: Double = 17.5
    var tipVal = ""
    var tipPayed = 0.0
    if (tipPer >= 0){
        tip = tipPer
        var tipEst = price * (tip / 100)
        tipVal = twoDigits.format(tipEst)
        tipPayed = tipVal.toDouble()
    } else if (tipPer.toInt() == -1){
        var tipEst = price * (tip / 100)
        tipVal = twoDigits.format(tipEst)
        tipPayed = tipVal.toDouble()
    } else {
        println("I'm sorry, that is not an acceptable option!")
    }
    println("The total cost of your items is $$price")
    println("The taxes come to $$taxVal")
    var tp = taxVal + price
    println("The total with taxes is $$tp")
    println("The tip is $$tipPayed")
    var tot = tp + tipPayed
    println("If you left a tip the total, including the tip is $$tot")



}
fun taxesFig(total: Double = 0.0): Double{
    var tax = total * .025
    return tax
}