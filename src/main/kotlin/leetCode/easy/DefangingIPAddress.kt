package leetCode.easy

import java.lang.StringBuilder

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 */
class DefangingIPAddress {
    fun defangIPaddr(address: String): String {
        return address.replace(".", "[.]")
    }

    fun defangIPaddrStrBuilder(address: String): String {
        val result = StringBuilder()
        for (char in address) {
            result.append(if (char == '.') "[.]" else char)
        }
        return result.toString()
    }
}