import java.util.*

fun sumOfDivided(l: IntArray): String {
    var resultString = ""
    val allPrimes : MutableSet<Int> = HashSet()
    for(item in l) {
        allPrimes += getPrimeFactors(item.toLong())
    }
    val list = ArrayList<Int>(allPrimes)
    list.sort()
    for(prime in list) {
        resultString += "($prime "
        var sum = 0
        for(item in l) {
            if(item % prime == 0) {
                sum += item
            }
        }
        resultString += "$sum)"
    }
    return resultString
}

fun getPrimeFactors(number: Long): MutableSet<Int> {
    var number = number
    //set not Allowed Duplicate element
    val setPrimeFactors: MutableSet<Int> = HashSet() 
    var i = 2
    while (i <= number) {
        if (number % i == 0L) {
            // Add prime factor in Hash Set
            setPrimeFactors.add(i)               
            number /= i
            i--
        }
        i++
    }
    return setPrimeFactors
}