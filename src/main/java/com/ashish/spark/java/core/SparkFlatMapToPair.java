package com.ashish.spark.java.core;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkFlatMapToPair {
	
	public static void main(String args[]){
		
		
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"FLATMAPTOPAIR");
		JavaRDD<String> stringRDD = javaSparkContext.parallelize(Arrays.asList("Hello Spark", "I am a Java Learner"));
		
		JavaPairRDD<String, Integer> flatMapToPair = stringRDD.flatMapToPair(s -> Arrays.asList(s.split(" ")).stream().map(token
				-> new Tuple2<String,Integer>(token,
				token.length())).collect(Collectors.toList()).iterator());
		flatMapToPair.foreach(System.out::println);
		javaSparkContext.close();
		
	}

}
