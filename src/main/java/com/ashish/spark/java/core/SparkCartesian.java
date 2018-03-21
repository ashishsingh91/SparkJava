package com.ashish.spark.java.core;

import java.util.Arrays;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkCartesian {

	public static void main(String[] args) {
		
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"CARTESIAN");
		
		JavaRDD<String> rddStrings =  javaSparkContext.parallelize(Arrays.asList("A","B","C"));
		JavaRDD<Integer> rddIntegers = javaSparkContext.parallelize(Arrays.asList(1,4,5));
		rddStrings.cartesian(rddIntegers).foreach(System.out::println);;
	}

}
