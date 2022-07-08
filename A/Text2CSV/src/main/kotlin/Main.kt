import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths


fun main(args: Array<String>) {
    var text = readFileAsString("sample.txt")
    text = text.replace(".DID|.Date|.Cat|[a-z]|\\\\|\\t|\\w+\\d+".toRegex(), "")
    text = text.replace("(?m)^[ \\t]*\\r?\\n".toRegex(), "*")

    val txtList = text.split("\\*".toRegex())
    val csvList = mutableListOf<List<String>>()
    txtList.forEach { textPart ->
        if (textPart.isNotBlank()) {
            csvList.add(listOf(textPart))
        }
    }
}

fun readFileAsString(path: String): String {
    var result: String? = ""
    try {
        result = Files.readString(Paths.get(path))
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return result ?: ""
}