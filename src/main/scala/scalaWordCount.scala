import scala.io.Source

object scalaWordCount {

  def main(args: Array[String]) {

    if (args.length != 1) {
      System.err.println("Usage: sbt run \"String\".")
      System.exit(1)
    }

    // val inputStr = "Lets try to make this a long sentence because then it will be more interesting but let us make it long without any punctuation so that the code required to parse it is simple"

    //    val inputStr = args(0)

    val filename = args(0)

    val wordCount = scala.collection.mutable.Map[String, Int]()

    for (line <- Source.fromFile(filename).getLines)
      for (word <- line.split(" "))
        wordCount(word) = if (wordCount.contains(word)) wordCount(word) + 1 else 1

    for ( (k,v) <- wordCount)
      printf("Word %s occurs %d times\n", k,v)

    println(wordCount)

  }
}