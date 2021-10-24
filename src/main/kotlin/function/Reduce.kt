package function

/**
 * Reduce:
 * Accumulates value starting with the first element and applying operation
 * from left to right to current accumulator value and each element.
 * Throws an exception if this collection is empty.
 * If the collection can be empty in an expected way, please use reduceOrNull instead.
 * It returns null when its receiver is empty.
 *
 * Element의 Type에 맞는 값을 return 해야한다
 *
 */
fun main() {
    val reduceInstance = Reduce()

    println(reduceString(reduceInstance.stringList))
    println(reduceString2(reduceInstance.stringList))
    println(reduceInt(reduceInstance.intList))
    println(reduceInt2(reduceInstance.intList))
    println(reduceBoolean(reduceInstance.boolList))
    println(reduceOrNullStringList())
    println(reduceRightString(reduceInstance.stringList))
    println(reduceRightIndexedString(reduceInstance.stringList))
}

fun reduceString(stringList: MutableList<String>): String {
    return stringList.reduce { acc, s -> "$acc $s" }
}

fun reduceString2(stringList: MutableList<String>): String {
    return stringList.reduce { acc, s -> "$acc $s,$s,$s" }
}

fun reduceInt(intList: MutableList<Int>): Int {
    return intList.reduce { acc, s -> acc + s }
}

fun reduceInt2(intList: MutableList<Int>): Int {
    return intList.reduce { acc, s -> acc * s }
}

fun reduceBoolean(boolList: MutableList<Boolean>): Boolean {
    return boolList.reduce { acc, b -> acc || b }
}

fun reduceOrNullStringList() : String? {
    return emptyList<String>().reduceOrNull { _, _ -> "" }
}

fun reduceRightString(stringList: MutableList<String>): String {
    return stringList.reduceRight { s, acc -> "$acc $s" }
}

fun reduceRightIndexedString(stringList: MutableList<String>): String {
    return stringList.reduceRightIndexed(operation = { idx, acc, s -> "$acc, $idx:$s" })
}

class Reduce {
    val stringList = mutableListOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
    val intList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val boolList = mutableListOf(true, true, false, false)
}