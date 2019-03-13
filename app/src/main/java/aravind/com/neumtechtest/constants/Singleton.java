package aravind.com.neumtechtest.constants;

import java.util.ArrayList;
import java.util.List;

import aravind.com.neumtechtest.models.JobInfoModel;

public class Singleton {

    private static volatile Singleton _singleton = new Singleton();

    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (_singleton == null)
                _singleton = new Singleton();
        }
        return _singleton;
    }

    private List<JobInfoModel> jobInfoModels = new ArrayList<>();

    public List<JobInfoModel> getJobInfoModels() {
        return jobInfoModels;
    }

    public void setJobInfoModels(List<JobInfoModel> jobInfoModels) {
        this.jobInfoModels = jobInfoModels;
    }
}