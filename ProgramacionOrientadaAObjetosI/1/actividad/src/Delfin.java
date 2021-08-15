public class Delfin extends Animal {
    public Delfin(Integer edad) {
        super(edad);
    }

    @Override
    protected String hacer(String que) {
        return "El delfin " + que;
    }

    public String nadar() {
        return hacer("va a nadar");
    }
}
