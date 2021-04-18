package leetCode.april2021

import java.lang.StringBuilder

class RemoveAllAdjacentDuplicatesInStringII {
    fun removeDuplicates(s: String, k: Int): String {
        if (s.isBlank() or s.isEmpty()) return s
        val stack = ArrayDeque<Pair<Char, Int>>()
        s.forEach { cur ->
            var prev = stack.lastOrNull()
            if (prev != null && prev.first == cur) {
                if (prev.second + 1 == k) {
                    while (prev != null && prev.first == cur) {
                        stack.removeLast()
                        prev = stack.lastOrNull()
                    }
                } else {
                    stack.add(cur to prev.second + 1)
                }
            } else {
                stack.add(cur to 1)
            }
        }

        val result = StringBuilder()
        while (stack.isNotEmpty()){
            result.append(stack.removeFirst().first)
        }

        return result.toString()
    }
}