package pageutilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class Extend_Report_Utility {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("SEEPZ-RISE");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("organization", "KRAN Consulting");
		extentReports.setSystemInfo("Name", "Lekshmi L");
		extentReports.setSystemInfo("Server", "Testing Server");
		extentReports.setSystemInfo("URL", "https://rise-testing.kran.co.in/cas/login");
		return extentReports;
	}
}