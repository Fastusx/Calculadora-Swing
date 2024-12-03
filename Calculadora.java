import javax.swing.*;
import java.awt.*;

public class Calculadora {
    final private JFrame frame;
    private final Font FONTE = new Font("Lucida Grande", Font.PLAIN, 28);
    JTextField resultado = new JTextField();
    private int soma;
    private int subt;
    private int mult;
    private float divi;
    private String ante;

    public Calculadora() {
        frame = new JFrame();

        frame.setTitle("Minha janela");
//        frame.setSize(600, 600);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        resultado.setFont(FONTE);
        resultado.setHorizontalAlignment(JTextField.RIGHT);

        c.ipady = 20;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;

        frame.setTitle("Calculadora");
        frame.add(resultado, c);

        adicionarBotao("AC", 3, 0, 1, false);
        adicionarBotao("7", 0, 1, 1, true);
        adicionarBotao("8", 1, 1, 1, true);
        adicionarBotao("9", 2, 1, 1, true);
        adicionarBotao("+", 3, 1, 1, false);
        adicionarBotao("4", 0, 2, 1, true);
        adicionarBotao("5", 1, 2, 1, true);
        adicionarBotao("6", 2, 2, 1, true);
        adicionarBotao("–", 3, 2, 1, false);
        adicionarBotao("1", 0, 3, 1, true);
        adicionarBotao("2", 1, 3, 1, true);
        adicionarBotao("3", 2, 3, 1, true);
        adicionarBotao("x", 3, 3, 1, false);
        adicionarBotao("0", 0, 4, 2, true);
        adicionarBotao("=", 2, 4, 1, false);

        frame.pack();
        frame.setResizable(false);
    }

    public JButton adicionarBotao(String texto, int x, int y, int largura, boolean adcEvento) {
        JButton btn = new JButton(texto);

        btn.setFont(FONTE);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = largura;

        frame.add(btn, c);

        if (adcEvento) {
            btn.addActionListener(e -> {
                resultado.setText(resultado.getText() + texto);
            });
        }
        else{
            if (!texto.equals("=") && !texto.equals("AC")) {
                String n = resultado.getText();
                btn.addActionListener(f -> {
                    resultado.setText("");

                    switch (texto) {
                        case "+":
                            soma = Integer.parseInt(n) + Integer.parseInt(resultado.getText());
                            ante = "+";

                            resultado.setText("");
                            break;
                        case "-":
                            subt = Integer.parseInt(n) - Integer.parseInt(resultado.getText());
                            ante = "-";
                            resultado.setText("");
                            break;
                        case "X":
                            mult = Integer.parseInt(n) * Integer.parseInt(resultado.getText());
                            ante = "X";
                            resultado.setText("");
                            break;
                        case "/":
                            divi = Float.parseFloat(n) / Float.parseFloat(resultado.getText());
                            ante = "/";
                            resultado.setText("");
                            break;

                    }
                });
            }
           if (texto.equals("=")){
               btn.addActionListener(m ->{
               switch (ante) {
                   case "+":
                        resultado.setText(String.valueOf(soma));
                        ante = "";
                        break;
                   case "-":
                       resultado.setText(String.valueOf(subt));
                       ante = "";
                       break;
                   case "X":
                       resultado.setText(String.valueOf(mult));
                       ante = "";
                       break;
                   case "/":
                       resultado.setText(String.valueOf(divi));
                       ante = "";
                       break;
               }

               });
               }

           }
        return btn;
    }

    public void mostrar() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculadora janela = new Calculadora();
        janela.mostrar();
    }
}
