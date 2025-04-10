package br.com.kasolution.exercicio8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaixaEletronico {
    private static ContaBancaria contaAtiva;

    public static void main(String[] args) {
        // Criando uma conta de teste
        ContaBancaria conta = new ContaBancaria("12345", "senha123", 1000.0);

        // Tela de Login
        JFrame frame = new JFrame("Caixa Eletrônico - Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, conta);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, ContaBancaria conta) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Conta:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 120, 25);
        panel.add(loginButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(10, 110, 250, 25);
        panel.add(messageLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroConta = userText.getText();
                String senha = new String(passwordText.getPassword());

                if (conta.getNumeroConta().equals(numeroConta) && conta.autenticar(senha)) {
                    contaAtiva = conta;
                    messageLabel.setText("Login bem-sucedido!");
                    // Redirecionar para o menu principal
                    JOptionPane.showMessageDialog(panel, "Bem-vindo ao Caixa Eletrônico!");
                    mostrarMenuPrincipal();
                } else {
                    messageLabel.setText("Conta ou senha inválida!");
                }
            }
        });
    }

    private static void mostrarMenuPrincipal() {
        JFrame menuFrame = new JFrame("Caixa Eletrônico - Menu Principal");
        menuFrame.setSize(400, 300);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuFrame.add(menuPanel);

        JButton saldoButton = new JButton("Consultar Saldo");
        saldoButton.setBounds(100, 30, 200, 30);
        menuPanel.add(saldoButton);

        JButton saqueButton = new JButton("Saque");
        saqueButton.setBounds(100, 70, 200, 30);
        menuPanel.add(saqueButton);

        JButton depositoButton = new JButton("Depósito");
        depositoButton.setBounds(100, 110, 200, 30);
        menuPanel.add(depositoButton);

        JButton transferenciaButton = new JButton("Transferência");
        transferenciaButton.setBounds(100, 150, 200, 30);
        menuPanel.add(transferenciaButton);

        JButton pagamentoButton = new JButton("Pagamento de Contas");
        pagamentoButton.setBounds(100, 190, 200, 30);
        menuPanel.add(pagamentoButton);

        saldoButton.addActionListener(e -> consultarSaldo());
        saqueButton.addActionListener(e -> mostrarTelaSaque());
        depositoButton.addActionListener(e -> mostrarTelaDeposito());
        // Adicione os listeners para as outras operações aqui

        menuFrame.setVisible(true);
    }

    private static void consultarSaldo() {
        JOptionPane.showMessageDialog(null, "Saldo atual: R$ " + contaAtiva.getSaldo());
    }

    private static void mostrarTelaSaque() {
        JFrame saqueFrame = new JFrame("Caixa Eletrônico - Saque");
        saqueFrame.setSize(300, 200);
        saqueFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel saquePanel = new JPanel();
        saquePanel.setLayout(null);
        saqueFrame.add(saquePanel);

        JLabel valorLabel = new JLabel("Valor do Saque:");
        valorLabel.setBounds(10, 20, 120, 25);
        saquePanel.add(valorLabel);

        JTextField valorText = new JTextField(20);
        valorText.setBounds(130, 20, 120, 25);
        saquePanel.add(valorText);

        JButton confirmarButton = new JButton("Confirmar");
        confirmarButton.setBounds(10, 60, 120, 25);
        saquePanel.add(confirmarButton);

        JLabel mensagemLabel = new JLabel("");
        mensagemLabel.setBounds(10, 100, 250, 25);
        saquePanel.add(mensagemLabel);

        confirmarButton.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(valorText.getText());
                if (contaAtiva.sacar(valor)) {
                    mensagemLabel.setText("Saque realizado com sucesso!");
                } else {
                    mensagemLabel.setText("Saldo insuficiente!");
                }
            } catch (NumberFormatException ex) {
                mensagemLabel.setText("Valor inválido!");
            }
        });

        saqueFrame.setVisible(true);
    }

    private static void mostrarTelaDeposito() {
        JFrame depositoFrame = new JFrame("Caixa Eletrônico - Depósito");
        depositoFrame.setSize(300, 200);
        depositoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel depositoPanel = new JPanel();
        depositoPanel.setLayout(null);
        depositoFrame.add(depositoPanel);

        JLabel valorLabel = new JLabel("Valor do Depósito:");
        valorLabel.setBounds(10, 20, 120, 25);
        depositoPanel.add(valorLabel);

        JTextField valorText = new JTextField(20);
        valorText.setBounds(130, 20, 120, 25);
        depositoPanel.add(valorText);

        JButton confirmarButton = new JButton("Confirmar");
        confirmarButton.setBounds(10, 60, 120, 25);
        depositoPanel.add(confirmarButton);

        JLabel mensagemLabel = new JLabel("");
        mensagemLabel.setBounds(10, 100, 250, 25);
        depositoPanel.add(mensagemLabel);

        confirmarButton.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(valorText.getText());
                if (valor > 0) {
                    contaAtiva.depositar(valor);
                    mensagemLabel.setText("Depósito realizado com sucesso!");
                } else {
                    mensagemLabel.setText("Valor inválido! Insira um valor positivo.");
                }
            } catch (NumberFormatException ex) {
                mensagemLabel.setText("Valor inválido!");
            }
        });

        depositoFrame.setVisible(true);
    }
}