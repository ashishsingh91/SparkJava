package com.ashish.spark.java.core;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkReduceByKey {

	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"REDUCEBYKEY");
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		JavaRDD<Integer> intRDD = javaSparkContext.parallelize( intList , 2);
		JavaPairRDD<String, Integer> mapToPair = intRDD.mapToPair(i -> (i % 2 == 0)
				? new
				Tuple2<String, Integer>("even", i) : new Tuple2<String, Integer>("odd",	i));
		mapToPair.reduceByKey((v1,v2) -> v1+v2).foreach(value -> System.out.println(value));
	}

}
