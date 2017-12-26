package com.yang;

public class Address {
    private int postcode;
    private String addName;

    public Address(int postcode, String addName) {
        this.postcode = postcode;
        this.addName = addName;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }
}
