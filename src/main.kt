/**
 * Created by Samer on 25/12/2017.
 */
import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val target = sc.nextInt()
    val mainList = mutableListOf<MutableList<List<Int>>?>()
    for (i in 0 until target)
        mainList.add(null)
    for (i in 1..sc.nextInt()) {
        val nextInt = sc.nextInt()
        if (nextInt <= target && nextInt != 0) {
            mainList[nextInt] = mutableListOf()
            mainList[nextInt]!!.add(listOf(nextInt))
        }
    }

    val currentTimeMillis = System.currentTimeMillis()

    val checkPosib = checkPosib(mainList, target)
    println(checkPosib.joinToString("\n"))
    println(checkPosib.size)
    println(System.currentTimeMillis() - currentTimeMillis)
}

fun checkPosib(list: MutableList<MutableList<List<Int>>?>, target: Int): MutableSet<List<Int>> {
    val res = mutableSetOf<List<Int>>()
    for (i in 1..target / 2) {
        if (i == 1) {
            if (list[i] == null) {
                continue
            }
        }
        if (list[i] == null) {
            list[i] = mutableListOf()
            list[i]!!.addAll(checkPosib(list, i))
        }

        if (list[i]!!.isEmpty()) {
            continue
        }
        val complNum = target - i
        if (list[complNum] == null) {
            list[complNum] = mutableListOf()
            list[complNum]!!.addAll(checkPosib(list, complNum))
        }
        res.addAll(tryToCombine(list[i]!!, list[complNum]!!))
    }
    return res
}

fun tryToCombine(l1: MutableList<List<Int>>, l2: MutableList<List<Int>>)
        : MutableSet<List<Int>> {
    if (l1.isEmpty() || l2.isEmpty()) {
        return mutableSetOf()
    }
    val res = mutableSetOf<List<Int>>()
    for (m1 in l1)
        for (m2 in l2) {
            val newlist = m1 + m2
            val sorted = newlist.sorted()
            res.add(sorted)
        }
    return res
}



