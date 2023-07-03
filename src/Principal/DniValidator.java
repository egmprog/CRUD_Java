package Principal;

public class DniValidator {
    public boolean validacionDni(int dni, int digitosCuenta) {
        int cuenta = 0;
        int temp = dni;

        while (temp != 0) {
            temp /= 10;
            cuenta++;
        }

        return cuenta == digitosCuenta;
    }
}
