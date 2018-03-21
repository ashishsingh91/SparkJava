package com.ashish.spark.java.core;

import java.util.Arrays;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkSortByKey {

	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"SORTBYKEY");
		JavaPairRDD<String, Integer> unsortedPairRDD =
				javaSparkContext.parallelizePairs (
				Arrays.asList(new Tuple2<String, Integer>("B", 2), new Tuple2<String,
				Integer>("C", 5), new Tuple2<String, Integer>("D", 7), new Tuple2<String,
				Integer>("A", 8)));
		unsortedPairRDD.sortByKey().foreach(System.out::println);;
		
		
	}

}
