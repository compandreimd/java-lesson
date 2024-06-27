package oop;

import java.util.UUID;

public class LicPerson extends Person{
    private UUID licId;

    public LicPerson(String name, int age) {
        super(name, age, "");
    }

    public UUID getLicId() {
        return licId;
    }
    public void setLicId(UUID licId) {
        this.licId = licId;
    }

}
