import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD



object wordcount {

  def main(args: Array[String]) {

    val pathToFile = "D:/JAYANTH/ScalaProg/src/main/scala/in.txt"



    val conf = new SparkConf()
      .setAppName("Wordcount")
      .setMaster("local[*]")

    val sc = new SparkContext(conf)



    val wordsRdd = sc.textFile(pathToFile)
      .flatMap(_.split(" "))

    val wordCountInitRdd = wordsRdd.map(word => (word, 1))
    val wordCountRdd = wordCountInitRdd.reduceByKey((v1, v2) => v1 + v2)
    val highFreqWords = wordCountRdd.filter(x => x._2 > 4)
    highFreqWords.saveAsTextFile("wordcountsDir")
  }
}