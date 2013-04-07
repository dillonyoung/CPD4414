package TraCarePackage;

import java.util.Date;


/**
 *
 * @author Dillon
 */
public class Report {

    private Database data;
    
    public Report() {
        this.data = new Database();
    }
    
    public ReportObject runReport(Date start, Date end, int userid) {
        
        // Declare variables
        ReportObject report = this.data.runReport(start, end, userid);
        
        return report;
    }
}
