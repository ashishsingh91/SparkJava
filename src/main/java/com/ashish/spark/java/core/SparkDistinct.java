package com.ashish.spark.java.core;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkDistinct {

	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"DISTINCT");
		JavaRDD<Integer> rddwithdupElements =
				javaSparkContext.parallelize(Arrays.asList(1,1,2,4,5,6,8,8,9,10,11,11));
		rddwithdupElements.distinct().foreach(System.out::println);

	}

}
