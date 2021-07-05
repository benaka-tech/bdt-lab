name := "Scala Prog"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.3",
  "org.apache.hadoop" % "hadoop-hdfs" % "2.5.2",
  "org.apache.spark" %% "spark-streaming" % "2.4.3",
  "org.apache.spark" %% "spark-streaming-twitter" % "1.6.3",
  "org.apache.spark" %% "spark-sql" % "2.4.3",
  "org.apache.parquet" % "parquet-hadoop" % "1.12.0"
)
