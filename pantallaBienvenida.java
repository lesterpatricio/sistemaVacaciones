package proyectoParcial;

import javax.swing.*;
import java.awt.*;

// Clase para la pantalla de bienvenida
class pantallaBienvenida extends JFrame {
    private JTextField nombreCampo;

    public pantallaBienvenida() {
        setTitle("Bienvenido al sistema FOTO GENESIS");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("logo3.png").getImage());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Panel para el logo
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/logo3.png")); // Cargar el logo desde recursos
        Image image = logoIcon.getImage(); // Obtiene la imagen original
        Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Redimensiona la imagen
        logoIcon = new ImageIcon(scaledImage); // Crea un nuevo ImageIcon con la imagen escalada
        JLabel logo = new JLabel(logoIcon);
        logoPanel.add(logo);
        panel.add(logoPanel); // Añadir panel del logo al panel principal



        nombreCampo = new JTextField();
        nombreCampo.setPreferredSize(new Dimension(200, 25)); // Establecer un tamaño preferido más pequeño para el campo de texto
        panel.add(new JLabel("Introduce tu nombre:"));
        panel.add(nombreCampo);


        JButton nextButton = new JButton("Siguiente");
        nextButton.addActionListener(e -> {
            if (!nombreCampo.getText().isEmpty()) {
                new terminosCondiciones(nombreCampo.getText());
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, introduce tu nombre.");
            }
        });
        panel.add(nextButton);


        JLabel copyrightLabel = new JLabel("FOTO GENESIS, Lester Patricio, Programacion 2, Sección D");
        panel.add(copyrightLabel);


        add(panel);
        setVisible(true);
    }
}