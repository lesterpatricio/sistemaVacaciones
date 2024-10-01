package proyectoParcial;

import javax.swing.*;
import java.awt.event.ItemEvent;

// Clase para la pantalla de términos y condiciones
class terminosCondiciones extends JFrame {
    public terminosCondiciones(String userName) {
        setTitle("Términos y Condiciones");
        setSize(550, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("logo3.png").getImage());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel(new ImageIcon("logo3.png"));
        panel.add(logo);

        JLabel userLabel = new JLabel("Usuario: " + userName);
        panel.add(userLabel);

        JTextArea termsArea = new JTextArea(10, 40);


        termsArea.setText("TÉRMINOS Y CONDICIONES DE USO DEL SISTEMA \"FOTO GENESIS\"\n\n" +
                "1. Introducción\n" +
                "Bienvenido a Foto GENESIS. Al utilizar este software, aceptas y te comprometes a cumplir con los términos y condiciones aquí expuestos. \n" +
                "Si no estás de acuerdo con alguno de estos términos, te recomendamos no utilizar el sistema.\n\n" +
                "2. Descripción del Servicio\n" +
                "Foto GENESIS es un sistema que permite a los usuarios gestionar y editar fotografías, aplicando diferentes filtros y funciones avanzadas para mejorar y personalizar imágenes. El uso del sistema está sujeto a los términos indicados en este documento.\n\n" +
                "3. Uso Aceptable\n" +
                "El usuario se compromete a utilizar Foto GENESIS de manera legal y adecuada, conforme a las siguientes disposiciones:\n" +
                "- No se permite el uso del sistema para actividades ilícitas o en violación de cualquier ley local, nacional o internacional.\n" +
                "- No se permite modificar o manipular el software de ninguna manera que comprometa su funcionamiento.\n" +
                "- El usuario no deberá transmitir contenido ofensivo, dañino o inapropiado a través del sistema.\n\n" +
                "4. Propiedad Intelectual\n" +
                "Todos los derechos de autor, marcas registradas y otros derechos de propiedad intelectual relacionados con Foto GENESIS y sus contenidos (incluidos pero no limitados a diseño, texto, gráficos y software) son propiedad exclusiva de Foto GENESIS o de sus licenciantes. El usuario no tiene derecho a reproducir, distribuir, o de cualquier otra manera explotar comercialmente este contenido sin permiso previo y por escrito.\n\n" +
                "5. Recopilación de Datos\n" +
                "Foto GENESIS puede recopilar y utilizar datos proporcionados por los usuarios con el fin de mejorar la funcionalidad del sistema. Estos datos serán tratados conforme a la política de privacidad vigente.\n\n" +
                "6. Limitación de Responsabilidad\n" +
                "Foto GENESIS no será responsable por daños directos o indirectos que resulten del uso o la imposibilidad de uso del sistema. Foto GENESIS no garantiza que el software esté libre de errores o que funcione sin interrupciones.\n\n" +
                "7. Modificaciones a los Términos\n" +
                "Nos reservamos el derecho de modificar estos términos y condiciones en cualquier momento. Se notificará a los usuarios sobre cualquier cambio relevante, y su uso continuado del sistema constituirá la aceptación de los nuevos términos.\n\n" +
                "8. Terminación del Servicio\n" +
                "Foto GENESIS se reserva el derecho de suspender o cancelar el acceso al sistema en caso de violación de estos términos.\n\n" +
                "9. Jurisdicción y Ley Aplicable\n" +
                "Estos términos se regirán e interpretarán de acuerdo con las leyes aplicables en el país donde se utiliza el software. Cualquier controversia que surja en relación con el uso de Foto GENESIS se someterá a la jurisdicción de los tribunales competentes.\n\n" +
                "10. Aceptación de los Términos\n" +
                "Al marcar la casilla \"Acepto los términos y condiciones\", confirmas que has leído, entendido y aceptado todos los términos anteriores. Si no aceptas estos términos, no podrás acceder al sistema Foto GENESIS.");
        termsArea.setEditable(false);
        panel.add(new JScrollPane(termsArea));

        JCheckBox acceptCheckBox = new JCheckBox("Acepto los términos y condiciones");
        panel.add(acceptCheckBox);

        JButton continueButton = new JButton("Continuar");
        continueButton.setEnabled(false);
        JButton rejectButton = new JButton("No aceptar");

        acceptCheckBox.addItemListener(e -> {
            continueButton.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
            rejectButton.setEnabled(e.getStateChange() != ItemEvent.SELECTED);
        });

        continueButton.addActionListener(e -> {
            new pantallaPrincipal(userName);
            dispose();
        });

        rejectButton.addActionListener(e -> {
            new pantallaBienvenida();
            dispose();
        });

        panel.add(continueButton);
        panel.add(rejectButton);

        add(panel);
        setVisible(true);
    }
}