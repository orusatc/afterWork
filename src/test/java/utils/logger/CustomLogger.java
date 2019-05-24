package utils.logger;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.lang.reflect.Method;

public class CustomLogger {

    private static final Logger log = Logger.getLogger("");


    public static void setLog(){

        }

    public static void setTestStatus(Method method){
        ITestResult result = Reporter.getCurrentTestResult();
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                Logger.getLogger(method.getDeclaringClass().getName()).info(method.getName() +  "------SUCCESS");
                break;
            case ITestResult.FAILURE:
                Logger.getLogger(method.getDeclaringClass().getName()).error(method.getName() + "-------FAILED");
                break;
            case ITestResult.SKIP:

                Logger.getLogger(method.getDeclaringClass().getName()).error(method.getName() + "-------SKIPPED");
                break;
            default:
                Logger.getLogger("Something get wrong with your code");
        }
    }
}
