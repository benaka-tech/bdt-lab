import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
object IPLTossWinStats {
  def main(args: Array[String]) {
    val pathtodb="D:\\JAYANTH\\ScalaProg\\src\\main\\scala\\Match.csv"
    val sparkSession=SparkSession.builder().appName("MySQL_Session").config("spark.master", "local").getOrCreate()
    import sparkSession.implicits._
    val matchDF= sparkSession.read.format("csv")
      .option("sep",",")
      .option("inferSchema","true")
      .option("header","true")
      .load(pathtodb)
    matchDF.createOrReplaceTempView("match_stat")
    val n=sparkSession.sql("SELECT COUNT(*) FROM match_stat")
    n.show()
    val tsm =sparkSession.sql("SELECT (*) FROM match_stat WHERE Toss_Winner_Id = Match_Winner_Id")
    tsm.createOrReplaceTempView("toss_winner")
    val m = sparkSession.sql("SELECT COUNT(*) FROM toss_winner")
    m.show()
    val n1=sparkSession.sql("SELECT COUNT(*) FROM match_stat").first()(0).toString.toFloat
    val result=sparkSession.sql("SELECT COUNT(*) FROM toss_winner").first()(0).toString.toFloat*100/n1
    print(result)
  }
}
