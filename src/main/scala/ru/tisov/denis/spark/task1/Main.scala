package ru.tisov.denis.spark.task1

import java.io.{File, PrintWriter}
import java.lang.Integer.sum

import org.apache.spark.{SparkConf, SparkContext}
import ru.tisov.denis.spark.task1.Utils.getIp

object Main {

  @throws[Exception]
  def main(args: Array[String]) {

    if (args.length != 3) throw new IllegalArgumentException("Input parameters has to contain input, output and master node info")

    val input = args(0)
    val output = args(1)
    val master = args(2)

    val sparkConf = new SparkConf().setAppName("Logs").setMaster(master)
    val sc = new SparkContext(sparkConf)

    val result = sc.textFile(input)
      .filter((line: String) => getIp(line).contains("7"))
      .map(line => (getIp(line), 1))
      .reduceByKey(sum)
      .map(_.swap)
      .sortBy(_._1, ascending = false, 5)
      .take(10)
      .toStream
      .map(tuple => tuple._2 + " contains 7 and having " + tuple._1 + " hits")
      .toList

    val writer = new PrintWriter(new File(output))
    result.foreach(writer.println)
    writer.close()

    sc.stop
  }

}