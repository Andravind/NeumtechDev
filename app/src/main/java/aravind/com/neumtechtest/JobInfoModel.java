package aravind.com.neumtechtest;

public class JobInfoModel {
    private String jobName;
    private String jobDesc;
    private double latitude;
    private double longitude;
    private String Address;

    public JobInfoModel(String jobName, String jobDesc, double latitude, double longitude, String address) {
        this.jobName = jobName;
        this.jobDesc = jobDesc;
        this.latitude = latitude;
        this.longitude = longitude;
        Address = address;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
