package Principal;

public class ComisionValidator {
    public boolean validacionComision(int comision, int digitosCuentaC) {
        int cuenta = 0;
        int temp = comision;

        while (temp != 0) {
            temp /= 10;
            cuenta++;
        }

        return cuenta == digitosCuentaC;
    }
}
