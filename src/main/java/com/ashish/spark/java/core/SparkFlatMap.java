package com.ashish.spark.java.core;

import java.util.Arrays;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkFlatMap {

	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"FLATMAP");
		JavaRDD<String> stringRDD = javaSparkContext.parallelize(Arrays.asList("Hello Spark", "Hello Java"));
		JavaRDD<String> flatMap = stringRDD.flatMap(t -> Arrays.asList(t.split(" ")).iterator());
		flatMap.foreach(System.out::println);
		javaSparkContext.close();
	}

}
