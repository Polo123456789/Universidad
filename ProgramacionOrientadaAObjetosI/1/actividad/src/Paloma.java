public class Paloma extends Animal {
    public Paloma(Integer edad) {
        super(edad);
    }

    @Override
    protected String hacer(String que) {
        return "La paloma " + que;
    }

    public String volar() {
        return hacer("va a volar");
    }
}
