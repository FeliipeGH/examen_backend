package com.fgh.examen_backend.dto;

public class Welcome {
    private String applicantName = "Felipe Guadarrama Herrera";
    private String versionApp = "0.0.1";

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getVersionApp() {
        return versionApp;
    }

    public void setVersionApp(String versionApp) {
        this.versionApp = versionApp;
    }

    @Override
    public String toString() {
        return "Welcome{" +
                "applicantName='" + applicantName + '\'' +
                ", versionApp='" + versionApp + '\'' +
                '}';
    }
}
