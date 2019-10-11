package com.web.shopping;


/*public class Singleton{
	private Singleton() {}
	private static volatile Singleton instance = null;
	public static Singleton getInstanced() {
		if(null == instance) {
			synchronized(Singleton.class) {
				if(null == instance) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}*/
public class Singleton{
	private Singleton() {
		
	}
	private static class LazyHolder{
		private static final Singleton instance = new Singleton();
	}
	public static final Singleton getInstance() {
		return LazyHolder.instance;
	}
}