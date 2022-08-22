import java.lang.RuntimeException;

public class UgyldigListeindeks extends RuntimeException {

    UgyldigListeindeks(int x){
        super("Ugyldig indeks: " + x);
    }
    
}
