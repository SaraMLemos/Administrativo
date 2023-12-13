package com.mycompany.telamoduloadministrativo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Classe que representa uma tela de módulo administrativo de uma clínica médica
 */
public class TelaModuloAdministrativo extends JFrame {

    // Constantes para armazenar valores que se repetem ou que podem ser alterados facilmente
    private static final String TITULO = "Tela de Módulo Administrativo de uma Clínica Médica";
    private static final int LINHAS = 5;
    private static final int COLUNAS = 2;
    private static final int HORIZONTAL_GAP = 10;
    private static final int VERTICAL_GAP = 10;
    private static final Font FONTE_TITULO = new Font("Arial", Font.BOLD, 24);
    private static final Font FONTE_LABEL = new Font("Arial", Font.PLAIN, 14);
    private static final Color COR_BOTAO = new Color(0, 128, 0);

    // Declaração dos componentes da interface gráfica
    private JLabel labelTitulo;
    private JLabel labelNome;
    private JLabel labelCpf;
    private JLabel labelTelefone;
    private JLabel labelEndereco;
    private JLabel labelEmail;
    private JTextField fieldNome;
    private JTextField fieldCpf;
    private JTextField fieldTelefone;
    private JTextField fieldEndereco;
    private JTextField fieldEmail;
    private JButton buttonCadastrar;
    private JButton buttonLimpar;
    private JButton buttonSair;
    private JPanel panelTitulo;
    private JPanel panelFormulario;
    private JPanel panelBotoes;

    // Construtor da classe
    public TelaModuloAdministrativo() {
        // Chamada do construtor da superclasse
        super(TITULO);

        // Criação e configuração dos componentes
        initComponents();

        // Adição dos listeners aos botões
        initListeners();

        // Configuração do frame
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Método para criar e configurar os componentes da interface gráfica
    private void initComponents() {
        labelTitulo = new JLabel("Cadastro de Pacientes");
        labelTitulo.setFont(FONTE_TITULO);
        labelNome = new JLabel("Nome:");
        labelNome.setFont(FONTE_LABEL);
        labelCpf = new JLabel("CPF:");
        labelCpf.setFont(FONTE_LABEL);
        labelTelefone = new JLabel("Telefone:");
        labelTelefone.setFont(FONTE_LABEL);
        labelEndereco = new JLabel("Endereço:");
        labelEndereco.setFont(FONTE_LABEL);
        labelEmail = new JLabel("E-mail:");
        labelEmail.setFont(FONTE_LABEL);
        fieldNome = new JTextField(30);
        fieldCpf = new JTextField(15);
        fieldTelefone = new JTextField(15);
        fieldEndereco = new JTextField(40);
        fieldEmail = new JTextField(30);
        buttonCadastrar = new JButton("Cadastrar");
        buttonCadastrar.setBackground(COR_BOTAO);
        buttonLimpar = new JButton("Limpar");
        buttonLimpar.setBackground(COR_BOTAO);
        buttonSair = new JButton("Sair");
        buttonSair.setBackground(COR_BOTAO);

        panelTitulo = new JPanel();
        panelTitulo.add(labelTitulo);
        panelFormulario = new JPanel(new GridLayout(LINHAS, COLUNAS, HORIZONTAL_GAP, VERTICAL_GAP));
        panelFormulario.add(labelNome);
        panelFormulario.add(fieldNome);
        panelFormulario.add(labelCpf);
        panelFormulario.add(fieldCpf);
        panelFormulario.add(labelTelefone);
        panelFormulario.add(fieldTelefone);
        panelFormulario.add(labelEndereco);
        panelFormulario.add(fieldEndereco);
        panelFormulario.add(labelEmail);
        panelFormulario.add(fieldEmail);
        panelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotoes.add(buttonCadastrar);
        panelBotoes.add(buttonLimpar);
        panelBotoes.add(buttonSair);

        this.add(panelTitulo, BorderLayout.NORTH);
        this.add(panelFormulario, BorderLayout.CENTER);
        this.add(panelBotoes, BorderLayout.SOUTH);
    }

    // Método para adicionar os listeners aos botões
    private void initListeners() {
        buttonCadastrar.addActionListener((ActionEvent e) -> {
            cadastrarPaciente();
        });

        buttonLimpar.addActionListener((ActionEvent e) -> {
            limparCampos();
        });

        buttonSair.addActionListener((ActionEvent e) -> {
            sair();
        });
    }

    /**
     * Método para cadastrar um paciente
     */
    private void cadastrarPaciente() {
        // Obter os dados dos campos de texto
        String nome = fieldNome.getText();
        String cpf = fieldCpf.getText();
        String telefone = fieldTelefone.getText();
        String endereco = fieldEndereco.getText();
        String email = fieldEmail.getText();

        // Validar os dados
        if (nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || endereco.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Criar um objeto Paciente com os dados
        Paciente paciente = new Paciente(nome, cpf, telefone, endereco, email);

        // Salvar o paciente em algum banco de dados ou arquivo (não implementado)
        // ...

        // Exibir uma mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        // Limpar os campos de texto
        limparCampos();
    }

    /**
     * Método para limpar os campos de texto
     */
    private void limparCampos() {
        fieldNome.setText("");
        fieldCpf.setText("");
        fieldTelefone.setText("");
        fieldEndereco.setText("");
        fieldEmail.setText("");
    }

    /**
     * Método para sair do programa
     */
    private void sair() {
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }

    // Classe interna para representar um paciente
    private class Paciente {
        // Atributos da classe
        private String nome, cpf, telefone, endereco, email;

        // Construtor da classe
        public Paciente(String nome, String cpf, String telefone, String endereco, String email) {
            this.nome = nome;
            this.cpf = cpf;
            this.telefone = telefone;
            this.endereco = endereco;
            this.email = email;
        }

        // Métodos getters e setters da classe (não implementados)
        // ...
    }

    // Método principal para executar o programa
    public static void main(String[] args) {
        // Criar uma instância da classe TelaModuloAdministrativo
        new TelaModuloAdministrativo();
    }
}
