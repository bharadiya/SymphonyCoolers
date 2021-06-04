package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Utility.GetScreenShots;

public class TestNGListeners implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Execution Started for " + result.getName());
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed Testcase " + result.getName());
		GetScreenShots s = new GetScreenShots();
		s.getScreenShotWindowSize();
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped Testcase " + result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//System.out.println("Testcase finished for " + context);

	}

}
