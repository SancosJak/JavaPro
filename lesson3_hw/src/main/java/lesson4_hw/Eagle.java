package lesson4_hw;

public class Eagle implements Animal{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String makesSound() {
        return "Screech";
    }
}
