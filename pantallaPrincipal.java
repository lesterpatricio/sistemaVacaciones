package proyectoParcial;

import javax.swing.*;
import java.awt.*;

// Clase para la pantalla principal
class pantallaPrincipal extends JFrame {
    private JTextField campoNombre, campoApellido, campoResultado;
    private JComboBox<String> departamentoCombo, yearsCombo;
    private JPanel panelPrincipal;

    public pantallaPrincipal(String userName) {
        setTitle("Calculadora de Vacaciones FOTO GENESIS");
        setSize(550, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("logo3.png").getImage());


        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        // Panel para el logo
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/logo3.png")); // Carga el logo desde recursos
        Image image = logoIcon.getImage(); // Obtiene la imagen original
        Image scaledImage = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH); // Redimensiona la imagen
        logoIcon = new ImageIcon(scaledImage); // Crea un nuevo ImageIcon con la imagen escalada
        JLabel logo = new JLabel(logoIcon);
        logoPanel.add(logo);
        panelPrincipal.add(logoPanel);
        changeBackgroundColor(new Color(202, 188, 104));


        JLabel welcomeLabel = new JLabel("Bienvenido, " + userName);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(welcomeLabel);


        // Crear menú
        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Opciones");

        // Opción de color Azul
        JMenuItem azulMenuItem = new JMenuItem("Cambiar color a Azul");
        azulMenuItem.addActionListener(e -> changeBackgroundColor(new Color(30, 89, 151)));
        optionsMenu.add(azulMenuItem);

        // Opción de color Rojo
        JMenuItem redMenuItem = new JMenuItem("Cambiar color a Salmón");
        redMenuItem.addActionListener(e -> changeBackgroundColor(new Color(223, 165, 140)));
        optionsMenu.add(redMenuItem);

        // Opción de color Verde
        JMenuItem greenMenuItem = new JMenuItem("Cambiar color a Verde");
        greenMenuItem.addActionListener(e -> changeBackgroundColor(new Color(39, 106, 60)));
        optionsMenu.add(greenMenuItem);

        JMenuItem aboutMenuItem = new JMenuItem("Acerca de");
        aboutMenuItem.addActionListener(e -> showAboutDialog());
        optionsMenu.add(aboutMenuItem);

        menuBar.add(optionsMenu);
        setJMenuBar(menuBar);

        // Panel para los campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        campoNombre = new JTextField(20);
        campoApellido = new JTextField(20);
        departamentoCombo = new JComboBox<>(new String[]{"Atención al cliente", "Logística", "Gerentes"}); //AQUI IRIA UN NUEVO AREA
        yearsCombo = new JComboBox<>(new String[]{"1 año", "2 a 6 años", "7 o más años"});
        campoResultado = new JTextField(20);
        campoResultado.setEditable(false);

        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(campoNombre);
        inputPanel.add(new JLabel("Apellidos:"));
        inputPanel.add(campoApellido);
        inputPanel.add(new JLabel("Departamento:"));
        inputPanel.add(departamentoCombo);
        inputPanel.add(new JLabel("Años de servicio:"));
        inputPanel.add(yearsCombo);
        inputPanel.add(new JLabel("Días de vacaciones:"));
        inputPanel.add(campoResultado);

        panelPrincipal.add(inputPanel);
        changeBackgroundColor(new Color(202, 188, 104));

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton calculateButton = new JButton("Calcular Vacaciones");
        calculateButton.addActionListener(e -> calculateVacations());
        buttonPanel.add(calculateButton);

        JButton clearButton = new JButton("Limpiar campos");
        clearButton.addActionListener(e -> clearFields());
        buttonPanel.add(clearButton);

        JButton backButton = new JButton("Volver al inicio");
        backButton.addActionListener(e -> {
            new pantallaBienvenida();
            dispose();
        });
        buttonPanel.add(backButton);

        panelPrincipal.add(buttonPanel);
        changeBackgroundColor(new Color(202, 188, 104));   //AQUI SE CAMBIA TODO EL FONDO

        JLabel copyrightLabel = new JLabel("FOTO GENESIS, Lester Patricio, Programacion 2, Sección D");
        copyrightLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(copyrightLabel);

        add(panelPrincipal);
        setVisible(true);
    }

    private void calculateVacations() {
        if (campoNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String department = (String) departamentoCombo.getSelectedItem();
        String years = (String) yearsCombo.getSelectedItem();
        int vacationDays = 0;

        if (department.equals("Atención al cliente")) {
            if (years.equals("1 año")) vacationDays = 6;
            else if (years.equals("2 a 6 años")) vacationDays = 14;
            else if (years.equals("7 o más años")) vacationDays = 20;
        } else if (department.equals("Logística")) {
            if (years.equals("1 año")) vacationDays = 7;
            else if (years.equals("2 a 6 años")) vacationDays = 15;
            else if (years.equals("7 o más años")) vacationDays = 22;
        } else if (department.equals("Gerentes")) {
            if (years.equals("1 año")) vacationDays = 10;
            else if (years.equals("2 a 6 años")) vacationDays = 20;
            else if (years.equals("7 o más años")) vacationDays = 30;
        }
        
        // ACA SERIA PARA HABILITAR LA LOGICA DE UN NUEVO DEPTO
        //else if (department.equals("Recursos Humanos")) { // Nueva lógica para Recursos Humanos
           // if (years.equals("1 año")) vacationDays = 8;
           // else if (years.equals("2 a 6 años")) vacationDays = 16;
           // else if (years.equals("7 o más años")) vacationDays = 25;
        //}

        campoResultado.setText(String.valueOf(vacationDays));
    }

    private void clearFields() {
        campoNombre.setText("");
        campoApellido.setText("");
        departamentoCombo.setSelectedIndex(0);
        yearsCombo.setSelectedIndex(0);
        campoResultado.setText("");
    }

    // Método para cambiar el color de fondo
    private void changeBackgroundColor(Color color) {
        panelPrincipal.setBackground(color);
        // Actualizar el color de fondo de todos los componentes en el mainPanel
        for (Component comp : panelPrincipal.getComponents()) {
            comp.setBackground(color);
        }
    }

    private void showAboutDialog() {
        JOptionPane.showMessageDialog(this,
                "Calculadora de Vacaciones FOTO GENESIS\n\n" +
                        "Desarrollado por: Lester Patricio\n" +
                        "Ingeniería en Sistemas UMG\n" +
                        "Fecha: Septiembre 2024\n\n" +
                        "Este programa calcula los días de vacaciones\n" +
                        "para los empleados de FOTO GENESIS.",
                "Acerca de",
                JOptionPane.INFORMATION_MESSAGE);
    }
}