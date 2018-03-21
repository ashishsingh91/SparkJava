package com.ashish.spark.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkMapPartitionsWithIndex {

	public static void main(String[] args) {
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"MapPartitionsWithIndex");
		JavaRDD<Integer> intRDD = javaSparkContext.parallelize(Arrays.asList(1,2,3,4,5,6,7,8,9,10),5);
		intRDD.mapPartitionsWithIndex((index, iterator) -> {  
			List<String> list = new ArrayList<String>();
			while (iterator.hasNext()) { 
				list.add("Element " + iterator.next() + " belongs to partition " + index);
			}  
			return list.iterator(); }, false).foreachPartition(value -> System.out.println(value.next())); 

	}

}
