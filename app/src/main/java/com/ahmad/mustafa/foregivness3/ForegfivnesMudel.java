package com.ahmad.mustafa.foregivness3;

/**
 * Created by ahmad on 01/03/17.
 */

public class ForegfivnesMudel {

    public ForegfivnesMudel() {

    }

    public ForegfivnesMudel(String forgivnesType) {
        this.forgivnesType = forgivnesType;
    }

    public ForegfivnesMudel(String forgivnesType, int counterType) {
        this.forgivnesType = forgivnesType;
        this.counterType = counterType;
    }

    private String forgivnesType;
    private int counterType;

    public String getForgivnesType() {
        return forgivnesType;
    }

    public void setForgivnesType(String forgivnesType) {
        this.forgivnesType = forgivnesType;
    }

    public int getCounterType() {
        return counterType;
    }

    public void setCounterType(int counterType) {
        this.counterType = counterType;
    }
}
