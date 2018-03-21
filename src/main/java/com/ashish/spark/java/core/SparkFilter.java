package com.ashish.spark.java.core;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;

public class SparkFilter {
	
	
	public static void main(String[] args) {
		
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"FILTER");
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		JavaRDD<Integer> intRDD = javaSparkContext.parallelize( intList , 2);
		JavaRDD<Integer> result= intRDD.filter(x -> (x%2 == 0));
		result.foreach(System.out::println);
		javaSparkContext.close();
	}

}
