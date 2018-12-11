package com.bramesh.config;

public enum WaitTimeConfig {
	IMPLICITWAIT(10),PAGELOADWAIT(20),EXPLICITWAIT(20),FLUENTWAIT(10),POOLINGEVERY(1);
	
	private int waitTime;
	private static boolean updateFromProperty = false;
	
	private WaitTimeConfig(int waitTime){
		this.waitTime = waitTime;
	}
	
	public int getWaitTime(){
		if(!updateFromProperty){
			
			String implicitWait = System.getProperty("implicitwait");
			if(implicitWait!=null && !implicitWait.equals(""))
				IMPLICITWAIT.waitTime = Integer.parseInt(implicitWait);
			
			String pageLoadWait = System.getProperty("pageloadwait");
			if(pageLoadWait!=null && !pageLoadWait.equals(""))
				PAGELOADWAIT.waitTime = Integer.parseInt(pageLoadWait);
			
			String explicitWait = System.getProperty("explicitwait");
			if(explicitWait!=null && !explicitWait.equals(""))
				EXPLICITWAIT.waitTime = Integer.parseInt(explicitWait);
			
			String fluentWait = System.getProperty("fluentwait");
			if(fluentWait!=null && !fluentWait.equals(""))
				FLUENTWAIT.waitTime = Integer.parseInt(fluentWait);
			
			String poolingEvery = System.getProperty("poolingevery");
			if(poolingEvery!=null && !poolingEvery.equals(""))
				POOLINGEVERY.waitTime = Integer.parseInt(poolingEvery);
			
		}
		return waitTime;
	}
	
}
