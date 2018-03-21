package com.ashish.spark.java.core;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkFoldByKey {

	public static void main(String[] args) {
		
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"FOLDBYKEY");
		JavaRDD<String> stringRDD = javaSparkContext.parallelize(Arrays.asList("Hello Spark", "Hello Java")); 
		JavaPairRDD<String, Integer> flatMapToPair = stringRDD.flatMapToPair(s -> Arrays.asList(s.split(" ")).stream().
				map(token -> new Tuple2<String, Integer>(token, 1)).
				collect(Collectors.toList()).iterator());
		flatMapToPair.foldByKey(0,(v1, v2) -> v1+v2).foreach(value -> System.out.println(value)); 
		

	}

}
