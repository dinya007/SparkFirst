package ru.tisov.denis.spark.task1

object Utils {

  private val SPACE = "\\s+(?=([^\"]*\"[^\"]*\")*[^\"]*$)".r

  def getIp(string: String) = SPACE.split(string)(0)

}
