package homework;

public class HW2 {
    private String name;
    private String last;
    private double lm = 0;
    private int count = 0;

    public void addPayment(double payment){
        lm = (lm * (count++) + payment)/count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLast() {
        return last;
    }

    public double getMedia(){
        return lm;
    }

    @Override
    public String toString() {
        return name + " " + last + " " + lm;
    }

    public static void main(String[] args) {
        HW2 h = new HW2();
        h.setName("Jhon");
        h.setLast("Too");
        System.out.println(h);
        h.addPayment(100);
        System.out.println(h);
        h.addPayment(130);
        System.out.println(h);
        h.addPayment(200);
        System.out.println(h);
        h.addPayment(120);
        System.out.println(h);

    }
}
