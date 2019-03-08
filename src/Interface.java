import javax.swing.*;

public class Interface {
    private JPanel interfacePanel;

    public JPanel getInterfacePanel() {
        return interfacePanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("InterfacePanel");
        frame.setContentPane(new Interface().getInterfacePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
