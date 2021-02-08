package leetCode.february2021

import java.util.*

/**
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory
 * in a Unix-style file system, convert it to the simplified canonical path.
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..'
 * refers to the directory up a level, and any multiple consecutive slashes (i.e. '//')
 * are treated as a single slash '/'. For this problem, any other format of periods
 * such as '...' are treated as file/directory names.
 * The canonical path should have the following format:
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory
 * (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 */
fun main() {
    val f = SimplifyPath()
    f.simplifyPath("/a//b////c/d//././/..")
}

class SimplifyPath {
    fun simplifyPath(path: String): String {
        val deque = ArrayDeque<String>()
        deque.add("")
        var i = 0
        while (i < path.length) {
            val end = path.indexOf('/', i)
            var substring = ""
            if (end == -1) {
                substring = path.substring(i)
                i = path.length
            } else {
                substring = path.substring(i, end)
                i = end + 1
            }
            if (substring.isEmpty() || substring == ".") {
                continue
            } else if (substring == "..") {
                if (deque.size > 1) {
                    deque.removeLast()
                }
            } else {
                deque.add(substring)
            }
        }
        val result = deque.joinToString("/")
        return if (result.isEmpty()) "/" else result
    }
}