import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{window,col}
import org.apache.spark.sql.types.StructType
object StreamingRainfallAverages {
  def main(args: Array[String]){
    val spark =SparkSession.builder().appName("Average Rainfall").config("spark.master", "local").getOrCreate()
    import spark.implicits._
     spark.conf.set("spark.sql.shuffle.partitions",5)
    val userSchema=new StructType()
      .add("Creation_Time","double")
      .add("Station","string")
      .add("Rainfall","float")

    val Streaming=spark.readStream.schema(userSchema).json(null)

    val withEventTime=Streaming.selectExpr("*","cast(cast(Creation_Time as double)/10000000 as timestamp) as event_time")

    val events_per_window=withEventTime
      .groupBy(window(col("event_time"),"15 minutes"))
      .agg(avg("Rainfall"),count("station"))
      .writeStream
      .queryName("events_per_window")
      .outputMode("complete")
      .option("truncate",false)
      .start()
       events_per_window.awaitTermination()


  }
}
