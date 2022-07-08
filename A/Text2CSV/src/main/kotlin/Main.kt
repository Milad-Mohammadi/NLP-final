import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths


fun main(args: Array<String>) {
    val text = readFileAsString("sample.txt")
    val txtList = getPreparedTextParts(text)
    val csvList = getCSVList(txtList)
    val csvFile = File("./output.csv")
    csvFile.writeAsCSV(csvList)
}

fun getPreparedTextParts(text: String): List<String> {
    var tempText = text
    tempText = tempText.replace(".DID|.Date|.Cat|[a-z]|\\\\|\\t|\\w+\\d+".toRegex(), "")
    tempText = tempText.replace("(?m)^[ \\t]*\\r?\\n".toRegex(), "*")
    return tempText.split("\\*".toRegex())
}

fun getCSVList(txtList: List<String>): List<List<String>> {
    val csvList = mutableListOf<List<String>>()
    txtList.forEach { textPart ->
        if (textPart.isNotBlank()) {
            val sentences = textPart.split("\n")
            csvList.add(sentences)
        }
    }
    return csvList
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