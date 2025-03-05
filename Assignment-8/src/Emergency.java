
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Emergency {

    private String callerName;
    private String callerPhoneNumber;
    private String callerAddress;
    private String emergencyLocation;
    private String emergencyType;
    private String emergencyDescription;
    private String emergencyTime;
    private String responseType;
    private String responseStatus;
    private String responseTime;
    private String priorityLevel;
    private boolean isActive;
    private boolean isWireless;
    private String GPSCoordinates;
    private String PSAP;

    public Emergency(String callerName, String callerPhoneNumber, String emergencyLocation,
                     String emergencyType, String emergencyDescription, boolean isWireless) {
        this.callerName = callerName;
        this.callerPhoneNumber = callerPhoneNumber;
        this.emergencyLocation = emergencyLocation;
        this.emergencyType = emergencyType;
        this.emergencyDescription = emergencyDescription;
        this.isWireless = isWireless;
        this.isActive = true;
        this.priorityLevel = "High"; // by Default 
        this.responseStatus = "Pending";
        this.emergencyTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void updateResponseStatus(String newStatus) {
        this.responseStatus = newStatus;
        if (newStatus.equals("Resolved")) {
            this.isActive = false;
            this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }

    public void assignResponder(String responseType) {
        this.responseType = responseType;
    }

    public void resolveEmergency() {
        this.updateResponseStatus("Resolved");
    }

    public String getEmergencyDetails() {
        return "Emergency Report: \n" +
               "Caller: " + callerName + "\n" +
               "Phone Number: " + callerPhoneNumber + "\n" +
               "Location: " + emergencyLocation + "\n" +
               "Type: " + emergencyType + "\n" +
               "Description: " + emergencyDescription + "\n" +
               "Emergency Time: " + emergencyTime + "\n" +
               "Priority: " + priorityLevel + "\n" +
               "Response Type: " + responseType + "\n" +
               "Response Status: " + responseStatus + "\n" +
               "Response Time: " + responseTime + "\n" +
               "Active: " + isActive;
    }

    public boolean isEmergencyActive() {
        return isActive;
    }

}

