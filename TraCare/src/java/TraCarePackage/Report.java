package TraCarePackage;

import java.util.Date;

/**
 * Report Class
 * @author Dillon Young (C0005790)
 */
public class Report {

    // Declare variables
    private Database data;
    
    
    /**
     * The constructor for the Report class
     */
    public Report() {
        this.data = new Database();
    }
    
    
    /**
     * Runs the report based on the supplied values
     * @param start The start date to be used by the report
     * @param end The end date to be used by the report
     * @param userid The user ID to be used by the report
     * @return Returns a reference to the report
     */
    public ReportObject runReport(Date start, Date end, int userid) {
        
        // Run the report
        ReportObject report = this.data.runReport(start, end, userid);
        
        // Return the report
        return report;
    }
}
