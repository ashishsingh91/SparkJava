package com.ashish.spark.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkMapPartitions {

	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"MapPartitions");
		JavaRDD<Integer> intRDD = javaSparkContext.parallelize(Arrays.asList(1,2,3,4,5,6,7,8,9,10),2);
		intRDD.mapPartitions(iterator -> {  
				List<Integer> intList =new ArrayList<>();  
				while(iterator.hasNext()) {
					intList.add(iterator.next()+1);  
				}  
				return intList.iterator(); 
				}).foreach(System.out::println);; 
	}

}
