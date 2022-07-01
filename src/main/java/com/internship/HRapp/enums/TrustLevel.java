package com.internship.HRapp.enums;

public enum TrustLevel {
    LOW_TRUST("LOW_TRUST"),
    MID_TRUST("MID_TRUST"),
    HIGH_TRUST("HIGH_TRUST");
    private final String trustLevel;

    TrustLevel(String trustLevel){
        this.trustLevel=trustLevel;
    }
    public String getTrustLevel(){
        return this.trustLevel;
    }
}
