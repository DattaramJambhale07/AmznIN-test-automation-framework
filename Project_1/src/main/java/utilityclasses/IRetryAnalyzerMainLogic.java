package utilityclasses;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzerMainLogic implements IRetryAnalyzer 

{

	int initialcount = 0;				    	// This variable tracks how many times a test has already been retried
	int retrycount = 2;							// Maximum number of retry attempts allowed
	
	@Override									// This method is invoked automatically by TestNG after a test fails
	public boolean retry(ITestResult result) 
	{
		if(initialcount<retrycount)				// If the current retry attempt is less than the max allowed, retry the test
		{
			initialcount++;						// Increment retry attempt count
			return true;						// Return true to indicate that the test should be retried
			
		}
		return false;							// Return false if max retries reached, test will not be retried again
	}

	
	
}