public class Animal {
    private Integer edad;

    Animal(Integer edad) {
        this.edad = edad;
    }

    protected String hacer(String que) {
        return "El animal " + que;
    }

    public String alimentarse() {
        return hacer("se va a alimentar");
    }

    public String dormir() {
        return hacer("se ira a dormir");
    }

}
