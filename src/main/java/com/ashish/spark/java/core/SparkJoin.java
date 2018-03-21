package com.ashish.spark.java.core;

import java.util.Arrays;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkJoin {

	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"JOIN");
		JavaPairRDD<String, String> pairRDD1 =
				javaSparkContext.parallelizePairs(Arrays.asList(new Tuple2<String,
				String>("B", "A"), new Tuple2<String, String>("C", "D"), new Tuple2<String,
				String>("D", "E"), new Tuple2<String, String>("A", "B")));
		JavaPairRDD<String, Integer> pairRDD2 = javaSparkContext.parallelizePairs(
				Arrays.asList(new Tuple2<String, Integer>("B", 2), new Tuple2<String,
				Integer>("C", 5), new Tuple2<String, Integer>("D", 7), new Tuple2<String,
				Integer>("A", 8)));
		JavaPairRDD<String, Tuple2<String, Integer>> joinedRDD =
				pairRDD1.join(pairRDD2);
		joinedRDD.foreach(System.out::println);
	}

}
