public class Perro extends Animal {
    private String dueno;

    public Perro(Integer edad, String dueno) {
        super(edad);
        this.dueno = dueno;
    }

    @Override
    public String hacer(String que) {
        return "El perro de " + dueno + " va a " + que;
    }

    @Override
    public String alimentarse() {
        return hacer("ir a su plato a comer");
    }

    @Override
    public String dormir() {
        return hacer("ir a su cuchita a dormir");
    }
    
    public String jugar() {
        return hacer("ir a jugar pelota");
    }
    
    public String romperAlgo() {
        return hacer("romper algo mientras juega");
    }
}
