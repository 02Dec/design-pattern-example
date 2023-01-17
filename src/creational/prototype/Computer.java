package creational.prototype;

public class Computer implements Cloneable {
    private String os;
    private String office;
    private String antivirus;
    private String browse;
    private String others;

    public Computer(String os, String office, String antivirus, String browse, String others) {
        this.os = os;
        this.office = office;
        this.antivirus = antivirus;
        this.browse = browse;
        this.others = others;
    }

    @Override
    public Computer clone() {
        try {
            return (Computer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "os='" + os + '\'' +
                ", office='" + office + '\'' +
                ", antivirus='" + antivirus + '\'' +
                ", browse='" + browse + '\'' +
                ", others='" + others + '\'' +
                '}';
    }
}
