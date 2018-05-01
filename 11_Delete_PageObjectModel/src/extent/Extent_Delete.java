package extent;

import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class Extent_Delete {
	public static ExtentReports ext;
	public static ExtentReports getReport(){
		if(ext==null){
			Date d=new Date();
			String FName = d.toString().replace(" ", "_").replace(":", "_")+".html";
			ext=new ExtentReports("D://report//"+FName,true,DisplayOrder.NEWEST_FIRST);
			ext.addSystemInfo("QA", "Manoj KUSHWAHA");
		}
		return ext;
	}

}
