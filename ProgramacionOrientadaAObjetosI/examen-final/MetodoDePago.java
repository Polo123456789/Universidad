public interface MetodoDePago {
    /**
     * @return Verdadero si el pago se realizo correctamente
     */
    public boolean realizarPago(Pago p);
}
