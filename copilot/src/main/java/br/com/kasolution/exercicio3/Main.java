package br.com.kasolution.exercicio3;

public class Main {

    /**
     * Método para validar um endereço de email.
     * @param email O email a ser validado.
     * @return true se o email for válido, false caso contrário.
     */
    public static boolean validarEmail(String email) {
        // Expressão regular para validar o formato do email.
        String regex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(regex);
    }

    public static void main(String[] args) {
        // Testando o método validarEmail com um email válido.
        String email = "exemplo@dominio.com";
        boolean valido = validarEmail(email);
        System.out.println("O email \"" + email + "\" é válido? " + valido);

        // Testando o método validarEmail com um email inválido.
        String emailInvalido = "email_invalido@";
        boolean invalido = validarEmail(emailInvalido);
        System.out.println("O email \"" + emailInvalido + "\" é válido? " + invalido);
    }
}