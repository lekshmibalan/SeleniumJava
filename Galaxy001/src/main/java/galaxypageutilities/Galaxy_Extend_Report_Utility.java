package galaxypageutilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Galaxy_Extend_Report_Utility {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("Galaxy Application");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("organization", "KRAN Consulting");
		extentReports.setSystemInfo("Name", "Lekshmi L");
		extentReports.setSystemInfo("Server", "Testing Server");
		extentReports.setSystemInfo("URL", "http://172.150.0.60:8093/");
		return extentReports;
	}
}
