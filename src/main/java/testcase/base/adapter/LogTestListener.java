package testcase.base.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static org.testng.internal.Utils.log;

public class LogTestListener extends TestListenerAdapter {
    Logger logger = LoggerFactory.getLogger(LogTestListener.class);
    @Override
    public void onTestFailure(ITestResult tr) {
        logger.error("FFFFFFFFFFFFF");
    }


    @Override
    public void onTestSkipped(ITestResult tr) {

        logger.error("SSSSSSSSSSSSS",tr.getThrowable());
    }

    @Override
    public void onTestSuccess(ITestResult tr) {

        logger.info("............");
    }

}
