import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MainGUI {

    private JFrame frame;
    private JLabel[] labels;
    private static String imagePath = "MainClassifier/src/humanBody.jpg";
    private final int rows = 8; //You should decide the values for rows and cols variables
    private final int cols = 8;
    private final int chunks = rows * cols;
    private final int SPACING = 2;//spacing between split images

    public static void main(String[] args) throws URISyntaxException, Exception{
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new MainGUI().createAndShowUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void createAndShowUI() throws URISyntaxException, Exception{
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void initComponents() throws URISyntaxException, Exception {

        BufferedImage[] imgs = getImages();

        //set contentpane layout for grid
        frame.getContentPane().setLayout(new GridLayout(rows, cols, SPACING, SPACING));

        labels = new JLabel[imgs.length];

        //create JLabels with split images and add to frame contentPane
        for (int i = 0; i < imgs.length; i++) {
            labels[i] = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource())));
            frame.getContentPane().add(labels[i]);
        }
    }

    private BufferedImage[] getImages() throws URISyntaxException, Exception {
        File file = new File(imagePath); // I have bear.jpg in my working directory
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage image = null;
        try {
            image = (BufferedImage) Toolkit.getDefaultToolkit().getImage(getClass().getResource("MainClassifier/src/humanBody.jpg"));
        } catch (Exception e) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception(e);
        }
        int chunkWidth = image.getWidth() / cols; // determines the chunk width and height
        int chunkHeight = image.getHeight() / rows;
        int count = 0;
        BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                //Initialize the image array with image chunks
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                // draws the image chunk
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                gr.dispose();
            }
        }
        return imgs;
    }
}