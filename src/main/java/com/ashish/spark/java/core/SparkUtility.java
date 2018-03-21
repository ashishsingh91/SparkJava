package com.ashish.spark.java.core;

import org.apache.spark.api.java.JavaSparkContext;

public class SparkUtility {

	
	public static JavaSparkContext getJavaSparkContext(String master, String appName){
		return new JavaSparkContext(master, appName);
	}

}
