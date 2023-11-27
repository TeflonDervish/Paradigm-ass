import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class BankClientGUI extends JFrame {
    private JTextField accountIdField, amountField;
    private JTextArea logArea;

    private Map<String, Double> accounts;
    public BankClientGUI() {
        setTitle("Банковское приложение");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        accounts = new HashMap<>();

        // Создание компонентов
        accountIdField = new JTextField(10);
        amountField = new JTextField(10);
        logArea = new JTextArea(10, 30);
        logArea.setEditable(false);

        JButton openAccountButton = new JButton("Открыть счет");
        JButton depositButton = new JButton("Внести средства");
        JButton withdrawButton = new JButton("Снять средства");
        JButton checkBalanceButton = new JButton("Проверить баланс");

        // Добавление слушателей событий
        openAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountId = accountIdField.getText();
                if (!accounts.containsKey(accountId)) {
                    accounts.put(accountId, 0.0);
                    log("Открыт счет для аккаунта " + accountId);
                } else {
                    log("Счет для аккаунта " + accountId + " уже существует.");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountId = accountIdField.getText();
                double amount = Double.parseDouble(amountField.getText());
                if (accounts.containsKey(accountId)) {
                    double currentBalance = accounts.get(accountId);
                    accounts.put(accountId, currentBalance + amount);
                    log("Внесены средства на счет " + accountId + ": " + amount);
                } else {
                    log("Счет для аккаунта " + accountId + " не найден.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountId = accountIdField.getText();
                double amount = Double.parseDouble(amountField.getText());
                if (accounts.containsKey(accountId)) {
                    double currentBalance = accounts.get(accountId);
                    if (currentBalance >= amount) {
                        accounts.put(accountId, currentBalance - amount);
                        log("Средства сняты со счета " + accountId + ": " + amount);
                    } else {
                        log("Недостаточно средств на счете " + accountId);
                    }
                } else {
                    log("Счет для аккаунта " + accountId + " не найден.");
                }
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountId = accountIdField.getText();
                if (accounts.containsKey(accountId)) {
                    double balance = accounts.get(accountId);
                    log("Баланс счета " + accountId + ": " + balance);
                } else {
                    log("Счет для аккаунта " + accountId + " не найден.");
                }
            }
        });

        // Размещение компонентов на панели
        JPanel panel = new JPanel();
        panel.add(new JLabel("ID счета: "));
        panel.add(accountIdField);
        panel.add(new JLabel("Сумма: "));
        panel.add(amountField);
        panel.add(openAccountButton);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(checkBalanceButton);

        // Размещение панели с компонентами на фрейме
        getContentPane().add(BorderLayout.CENTER, panel);
        getContentPane().add(BorderLayout.SOUTH, new JScrollPane(logArea));

        // Отображение фрейма
        setVisible(true);
    }

    private void log(String message) {
        logArea.append(message + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BankClientGUI();
            }
        });
    }
}
