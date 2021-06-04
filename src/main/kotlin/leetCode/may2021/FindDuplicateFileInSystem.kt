package leetCode.may2021

import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

fun main() {
    val f = FindDuplicateFileInSystem()
    f.findDuplicate2(arrayOf("root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)"))
}

class FindDuplicateFileInSystem {
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val list = ArrayList<Pair<String, String>>()
        paths.forEach { str ->
            val split = str.split(' ')
            for (i in 1 until split.size) {
                val smSplit = split[i].split('(')
                list.add(split[0] + "/"+smSplit[0] to smSplit[1].substringBefore(')'))
            }
        }

        val result = Arrays.stream(list.toTypedArray())
            .collect(
                Collectors.groupingBy(
                    Pair<String, String>::second,
                    Collectors.mapping(Pair<String, String>::first, Collectors.toList())
                )
            )

        return result.values.toList()
    }

    fun findDuplicate2(paths: Array<String>): List<List<String>> {
        val list = ArrayList<Pair<String, String>>()
        paths.forEach { str ->
            val split = str.split(' ')
            for (i in 1 until split.size) {
                val smSplit = split[i].split('(')
                list.add(split[0] +"/"+ smSplit[0] to smSplit[1].substringBefore(')'))
            }
        }

        val result = ArrayList<List<String>>()
        list.groupBy { it.second }.values.forEach { values ->
            if (values.size>1) {
                result.add(values.map { it.first })
            }
        }
        return result
    }
}