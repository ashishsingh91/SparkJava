package com.ashish.spark.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkMapPartitionsToPair {

	public static void main(String[] args) {
		
		JavaSparkContext javaSparkContext = SparkUtility.getJavaSparkContext(SparkConstant.MASTER_LOCAL, SparkConstant.APP_NAME+"MapPartitionsToPair");
		JavaRDD<Integer> intRDD = javaSparkContext.parallelize(Arrays.asList(1,2,3,4,5,6,7,8,9,10),5);
		
		JavaPairRDD<String, Integer> pairRDD = intRDD.mapPartitionsToPair(	t -> { 
			List<Tuple2<String,Integer>> list =new ArrayList<>(); 
			while(t.hasNext()) {
				int element=t.next();
				list.add(element%2==0? new Tuple2<String, Integer>("even",element): new Tuple2<String, Integer>("odd",element));
				} return list.iterator();});
		pairRDD.foreachPartition(value -> System.out.println(value.next()));
		pairRDD.foreach(value -> System.out.println(value));

	}

}
