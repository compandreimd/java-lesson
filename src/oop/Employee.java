package oop;

public class Employee extends Person{
    private String job;
    private int id;

    public int getEmployeeId() {
        return id;
    }

    public void setEmployeeId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String getLastName(){
        return job+" " + super.getLastName();
    }
}
