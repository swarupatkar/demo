package com.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTestCase implements IRetryAnalyzer{
	
	int count =0;
	int maxRetryCount = 5;

	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if(count<maxRetryCount) {
				count++;
				result.setStatus(result.FAILURE);
				return true;
			}else {
				result.setStatus(result.SUCCESS);
			}			
		}		
		return false;
	}

}
