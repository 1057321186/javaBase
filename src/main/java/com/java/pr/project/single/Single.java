package com.java.pr.project.single;

public class Single {
	private static Single single;
	private Single(){}
	public static Single getInstance(){
		single = new Single();
		return single;
				
	}
}
