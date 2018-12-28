package cn.spark.study.core

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

/**
 * @author Administrator
 */
object WordCount {
  
  def main(args: Array[String]) {
    val conf = new SparkConf()
        .setAppName("WordCount")
        .setMaster("local");
    val sc = new SparkContext(conf)
  
    val lines = sc.textFile("C://hadoop.txt", 1); 
    val words = lines.flatMap { line => line.split(" ") }   
    val pairs = words.map { word => (word, 1) }   
    val wordCounts = pairs.reduceByKey { _ + _ }
    
    wordCounts.foreach(wordCount => println(wordCount._1 + " appeared " + wordCount._2 + " times."))  
  }
  
}