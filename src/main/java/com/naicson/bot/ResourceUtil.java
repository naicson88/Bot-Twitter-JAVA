package com.naicson.bot;

import java.net.URL;

public class ResourceUtil {
	
	@SuppressWarnings("rawtypes")
	public static URL getResource(String resourceName, Class clazz) {
		URL resourceURL = Thread.currentThread().getContextClassLoader().getResource(resourceName);
		
		if(resourceURL == null) {
			resourceURL = ResourceUtil.class.getClassLoader().getResource(resourceName);
		}
		
		if(resourceURL == null) {
			ClassLoader classLoader = clazz.getClassLoader();
			if(classLoader != null) {
				resourceURL = classLoader.getResource(resourceName);
			}			
		}
		
		if((resourceURL == null) && (resourceName != null) && (resourceName.charAt(0) != '/')) {
			return getResource('/' +  resourceName, clazz);
		}
		
		return resourceURL;
	}
}
