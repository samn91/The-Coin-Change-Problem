/**
 * Created by Samer on 25/12/2017.
 */
import javafx.collections.transformation.SortedList
import java.io.*
import java.util.*

fun main(args: Array<String>) {

    val currentTimeMillis = System.currentTimeMillis()

    val sc = Scanner(System.`in`)
    val target = sc.nextInt()

    val mainList = mutableListOf<MutableMap<String, List<Int>>>()

    for (i in 0 until target)
        mainList.add(mutableMapOf())

   for (i in 1..sc.nextInt()){
        val nextInt = sc.nextInt()
        if (nextInt <= target && nextInt != 0) {
            mainList[nextInt].put(nextInt.toString(), listOf(nextInt))
        }
    }
    val checkPosib = checkPosib(mainList, target)
    println(checkPosib.keys.joinToString("\n"))
    println(checkPosib.size)
    println(System.currentTimeMillis() - currentTimeMillis)
}

fun checkPosib(list: MutableList<MutableMap<String, List<Int>>>, target: Int): MutableMap<String, List<Int>> {
    val res = mutableMapOf<String, List<Int>>()
    for (i in 1..target / 2) {
        if (i == 1) {
            if (list[i].isEmpty()) {
                continue
            }
        } else
            list[i].putAll(checkPosib(list, i))
        val complNum = target - i
        list[complNum].putAll(checkPosib(list, complNum))
        res.putAll(tryToCombine(list[i], list[complNum]))
    }
    return res
}

fun tryToCombine(map1: MutableMap<String, List<Int>>, map2: MutableMap<String, List<Int>>): MutableMap<String, List<Int>> {
    if (map1.isEmpty() || map2.isEmpty()) {
        return mutableMapOf()
    }
    val res = mutableMapOf<String, List<Int>>()
    for (m1 in map1)
        for (m2 in map2) {
            val newlist = m1.value + m2.value
            val sorted = newlist.sorted()
            res.put(sorted.toString(), sorted)
        }
    return res
}



