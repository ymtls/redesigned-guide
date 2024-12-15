import java.awt.*;
import java.awt.event.*;

public class ArcApp extends Frame {

    private TextField startingAngleTextField;
    private TextField extentAngleTextField;
    private Button drawArcButton;
    private MyCanvas mainCanvas;
    private Label startAngleLabel, extentAngleLabel;

    public ArcApp() {
        setTitle("Arc");
        setSize(600, 500);
        setLayout(null);

        // Create canvas
        mainCanvas = new MyCanvas();
        mainCanvas.setName("mainCanvas");
        mainCanvas.setBounds(50, 50, 500, 300);
        mainCanvas.setBackground(Color.BLACK);

        // Create labels
        startAngleLabel = new Label("Starting Angle");
        startAngleLabel.setBounds(50, 370, 100, 30);
        startAngleLabel.setFont(new Font("Arial", Font.BOLD, 12));

        extentAngleLabel = new Label("Extent Angle");
        extentAngleLabel.setBounds(50, 410, 100, 20);
        extentAngleLabel.setFont(new Font("Arial", Font.BOLD, 12));

        // Create text fields
        startingAngleTextField = new TextField("45");
        startingAngleTextField.setName("startingAngleTextField");
        startingAngleTextField.setBounds(200, 370, 100, 30);

        extentAngleTextField = new TextField("290");
        extentAngleTextField.setName("extentAngleTextField");
        extentAngleTextField.setBounds(200, 410, 100, 30);

        // Create button
        drawArcButton = new Button("Draw");
        drawArcButton.setName("drawArcButton");
        drawArcButton.setBounds(350, 390, 100, 30);

        // Add action listener for button
        drawArcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int startAngle = Integer.parseInt(startingAngleTextField.getText());
                    int extentAngle = Integer.parseInt(extentAngleTextField.getText());
                    mainCanvas.setAngles(startAngle, extentAngle);
                    mainCanvas.repaint();
                } catch (NumberFormatException ex) {
                    System.out.println("Please enter valid integers for the angles.");
                }
            }
        });

        // Add components
        add(mainCanvas);
        add(startAngleLabel);
        add(extentAngleLabel);
        add(startingAngleTextField);
        add(extentAngleTextField);
        add(drawArcButton);

        // Close window on exit
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ArcApp();
    }

    class MyCanvas extends Canvas {
        private int startAngle = 45;
        private int extentAngle = 290;

        public void setAngles(int startAngle, int extentAngle) {
            this.startAngle = startAngle;
            this.extentAngle = extentAngle;
        }

        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.YELLOW);
            // Adjusted position to move arc to the top and center
            g.fillArc(150, 50, 200, 200, startAngle, extentAngle);
        }
    }
}
