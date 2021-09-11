public class PagoConTarjeta implements MetodoDePago {
    public static final Integer maximoPago = 10000;

    /**
     * Al no poder desarrollar un sistema que procese los pagos, verifica
     * unicamente que el monto sea mayor a 0 y menor que el maximo que se
     * permite procesar por tarjeta
     */
    @Override
    public boolean realizarPago(Pago p) {
        return p.getMonto() < maximoPago && p.getMonto() > 0;
    }
}
