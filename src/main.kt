/**
 * Created by Samer on 25/12/2017.
 */
import java.io.*
import java.util.*

fun main(args: Array<String>) {

    val sc = Scanner(System.`in`)
    val target = sc.nextInt()
    var res = 0L

    val list = mutableListOf<Int>()
    (1..sc.nextInt()).forEach {
        list.add(sc.nextInt())
    }
    list.removeIf { it > target || it == 0 }

    val set = mutableSetOf<Int>()
    var begainingOfCombainList = 0
    while (true) {
        val combainationList = mutableListOf<Int>()
        for (i in begainingOfCombainList until list.size)
            for (j in i until list.size) {
                val sum = list[i] + list[j]
                if (sum > target) {
                    continue
                }
                combainationList.add(sum)
            }
        if (combainationList.isEmpty()) {
            break
        }
        begainingOfCombainList = list.size
        list.addAll(combainationList)
    }

    set.addAll(list)
    list.forEach {
        if (target % it == 0) {
            res++
        }
        if (set.contains(target - it)) {
            res++
        }
    }
    println(res)
}


fun tryToCombine(list: MutableList<Long>, target: Long, startsWith: Int): Int {


    return tryToCombine(list, target, startsWith)
}



