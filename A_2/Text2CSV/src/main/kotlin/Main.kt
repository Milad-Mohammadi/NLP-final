import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException


fun main(args: Array<String>) {
    val text = readFileAsString("Hamshahri-Corpus.txt")
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
    var fileContent = ""

    BufferedReader(FileReader(path)).use { br ->
        val line = br.readLine()
        while (line != null) {
            fileContent = line
        }
    }
    return fileContent
}

@Throws(IOException::class)
fun File.writeAsCSV(values: List<List<String>>) {
    val csv = values.joinToString("\n") { line -> line.joinToString(", ") }
    writeText(csv)
}