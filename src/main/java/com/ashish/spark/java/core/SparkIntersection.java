package com.ashish.spark.java.core;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkIntersection {

	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"UNION");
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		JavaRDD<Integer> intRDD = javaSparkContext.parallelize( intList , 2);
		JavaRDD<Integer> intRDD2 = javaSparkContext.parallelize(Arrays.asList(1,8,3));
		intRDD.intersection(intRDD2).foreach(System.out::println);
	}

}
