package com.ashish.spark.java.core;

import java.util.Arrays;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkAggregateByKey {

	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"REDUCEBYKEY");
		JavaPairRDD<String, String> pairRDD = javaSparkContext.parallelizePairs(Arrays.asList(
				new Tuple2<String, String>("key1", "Austria"), 
				new Tuple2<String, String>("key2", "Australia"),
				new Tuple2<String, String>("key3", "Antartica"), 
				new Tuple2<String, String>("key1", "Asia"),
				new Tuple2<String, String>("key2", "France"),
				new Tuple2<String, String>("key3", "Canada"),
				new Tuple2<String, String>("key1", "Argentina"),
				new Tuple2<String, String>("key2", "American Samoa"),
				new Tuple2<String, String>("key3", "Germany")),
				3);
		pairRDD.aggregateByKey(0, (v1, v2) -> {  
			if(v2.startsWith("A")){
				v1+=1;  
			}  
			return v1; }, (v1, v2) -> v1+v2).foreach(value -> System.out.println(value));
	}

}
