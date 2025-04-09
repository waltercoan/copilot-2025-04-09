package br.com.kasolution.exercicio2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testVerificarParOuImpar_Par() {
        // Testa um número par
        int numero = 4;
        String resultado = Main.verificarParOuImpar(numero);
        assertEquals("O número 4 é par.", resultado);
    }

    @Test
    public void testVerificarParOuImpar_Impar() {
        // Testa um número ímpar
        int numero = 5;
        String resultado = Main.verificarParOuImpar(numero);
        assertEquals("O número 5 é ímpar.", resultado);
    }
}