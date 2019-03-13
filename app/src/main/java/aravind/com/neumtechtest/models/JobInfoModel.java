package aravind.com.neumtechtest.models;

public class JobInfoModel {
    private String jobName;
    private String jobDesc;
    private double latitude;
    private double longitude;
    private String time;
    private String distance;
    private String when;
    private String dateMonth;

    public JobInfoModel(String jobName, String jobDesc, double latitude, double longitude, String time, String distance, String when, String dateMonth) {
        this.jobName = jobName;
        this.jobDesc = jobDesc;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
        this.distance = distance;
        this.when = when;
        this.dateMonth = dateMonth;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getDateMonth() {
        return dateMonth;
    }

    public void setDateMonth(String dateMonth) {
        this.dateMonth = dateMonth;
    }
}
