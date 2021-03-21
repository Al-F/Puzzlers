package leetCode.march2021

class EncodeAndDecodeTinyURL {
    class Codec() {
        private val hashMap = HashMap<Int, String>()
        private var counter = 0

        // Encodes a URL to a shortened URL.
        fun encode(longUrl: String): String {
            counter++
            hashMap.putIfAbsent(counter, longUrl)
            return "http://tinyurl.com/$counter"
        }

        // Decodes a shortened URL to its original URL.
        fun decode(shortUrl: String): String {
            val index = shortUrl.indexOfLast { it == '/' }
            val key = shortUrl.substring(index + 1)
            return hashMap.getOrDefault(key.toInt(), "")
        }
    }
}