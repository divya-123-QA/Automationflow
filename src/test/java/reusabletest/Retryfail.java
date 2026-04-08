package reusabletest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryfail implements IRetryAnalyzer{


int count=0;
int i=1;
@Override
public boolean retry(ITestResult result) {
	// TODO Auto-generated method stub
	if(count<i) {
		count++;
		return true;
		
	}
	return false;
}
}