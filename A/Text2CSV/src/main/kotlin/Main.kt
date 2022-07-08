import java.io.File
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
            val sentences = textPart.split("\n")
            csvList.add(sentences)
        }
    }

    val csvFile = File("./output.csv")
    csvFile.writeAsCSV(csvList)
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

@Throws(IOException::class)
fun File.writeAsCSV(values: List<List<String>>) {
    val csv = values.joinToString("\n") { line -> line.joinToString(", ") }
    writeText(csv)
}