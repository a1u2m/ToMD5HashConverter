import java.io.File
import java.security.MessageDigest

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val file = File("C:\\\\Games\\\\contacts.txt")
        val lines = mutableListOf<String>()
        val md5 = MessageDigest.getInstance("MD5")
        val hashHexList = mutableListOf<String>()
        var count = 0

        file.forEachLine { lines.add(it) }
        for (item in lines) {
            count++
            println(item)
            val hashBytes = md5.digest(item.toByteArray())
            val hashHex = hashBytes.joinToString(""){"%02x".format(it)}
            println(hashHex)
            hashHexList.add(hashHex)
            println("count $count")
        }

        val filePath = "C:\\\\Games\\\\example.txt"

        File(filePath).printWriter().use { out ->
            hashHexList.forEach { out.println(it) }
        }
    }
}