package Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainGUI extends JFrame{

    private JFrame frame;
    private JLabel[] buttons;
    private static String imagePath = "MainClassifier/src/humanBody.jpg";
    private final int rows = 6; //You should decide the values for rows and cols variables
    private final int cols = 3;
    private final int chunks = rows * cols;
    private final int SPACING = 2;//spacing between split images
    private JButton head;
    private JButton chest;
    private JButton lowerAbdomen;
    private JButton pelvis;
    private JButton legs;
    private JButton feet;
    private JButton rightShoulder;
    private JButton leftShoulder;





    public MainGUI() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void initComponents() throws URISyntaxException, Exception {

        BufferedImage[] imgs = getImages();

        //set contentpane layout for grid
        frame.getContentPane().setLayout(new GridLayout(rows, cols, SPACING, SPACING));

        buttons = new JLabel[imgs.length];

        //create JLabels with split images and add to frame contentPane
        /*for (int i = 0; i < imgs.length; i++) {
            buttons[i] = new JLabel(String.valueOf(i));
            frame.getContentPane().add(buttons[i]);
        }*/
        ButtonHandler handler = new ButtonHandler();

        int i = 0;
        frame.getContentPane().add(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource()))));
        i++;

        head = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource())));
        head.setBorder(BorderFactory.createEmptyBorder());
        head.addActionListener(handler);
        head.setName("head");
        frame.getContentPane().add(head);
        i++;

        frame.getContentPane().add(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource()))));
        i++;

        leftShoulder = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource())));
        leftShoulder.setBorder(BorderFactory.createEmptyBorder());
        leftShoulder.addActionListener(handler);
        leftShoulder.setName("left shoulder");
        frame.getContentPane().add(leftShoulder);
        i++;

        chest = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource())));
        chest.setBorder(BorderFactory.createEmptyBorder());
        chest.addActionListener(handler);
        chest.setName("chest");
        frame.getContentPane().add(chest);
        i++;

        rightShoulder = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource())));
        rightShoulder.setBorder(BorderFactory.createEmptyBorder());
        rightShoulder.addActionListener(handler);
        rightShoulder.setName("right shoulder");
        frame.getContentPane().add(rightShoulder);
        i++;

        frame.getContentPane().add(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource()))));
        i++;


        lowerAbdomen = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource())));
        lowerAbdomen.setBorder(BorderFactory.createEmptyBorder());
        lowerAbdomen.addActionListener(handler);
        lowerAbdomen.setName("lower abdomen");
        frame.getContentPane().add(lowerAbdomen);
        i++;

        frame.getContentPane().add(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource()))));
        i++;

        frame.getContentPane().add(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource()))));
        i++;

        pelvis = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource())));
        pelvis.setBorder(BorderFactory.createEmptyBorder());
        pelvis.addActionListener(handler);
        pelvis.setName("pelvis");
        frame.getContentPane().add(pelvis);
        i++;

        frame.getContentPane().add(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource()))));
        i++;

        frame.getContentPane().add(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource()))));
        i++;

        legs = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource())));
        legs.setBorder(BorderFactory.createEmptyBorder());
        legs.addActionListener(handler);
        legs.setName("legs");
        frame.getContentPane().add(legs);
        i++;

        frame.getContentPane().add(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource()))));
        i++;

        frame.getContentPane().add(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource()))));
        i++;

        feet = new JButton((new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource()))));
        feet.setBorder(BorderFactory.createEmptyBorder());
        feet.addActionListener(handler);
        feet.setName("feet");
        frame.getContentPane().add(feet);
        i++;

        frame.getContentPane().add(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage(imgs[i].getSource()))));
        i++;

    }


    private BufferedImage[] getImages() throws URISyntaxException, Exception {
        FileInputStream fis = null;

        BufferedImage image = null;
        try {
            URL url = new URL(" https://github.com/austin-strom/HackySlackers2018/blob/master/CancerClassifier/src/Interface/humanBody.jpg?raw=true");
            image = ImageIO.read(url);
//            image = (BufferedImage) Toolkit.getDefaultToolkit().getImage(getClass().getResource("MainClassifier/src/humanBody.jpg"));
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

    public class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(((JComponent)e.getSource()).getName().equals("head")){
                InformationInput informationInput = new InformationInput();
                informationInput.setType("head");
                informationInput.setSize(600,600);
                informationInput.setVisible(true);
            }
            else if(((JComponent)e.getSource()).getName().equals("left shoulder")){
                JOptionPane.showMessageDialog(MainGUI.this, "Unfortunately this feature is not supported at this time.");

            }
            else if(((JComponent)e.getSource()).getName().equals("chest")){
                InformationInput informationInput = new InformationInput();
                informationInput.setType("head");
                informationInput.setSize(600,600);
                informationInput.setVisible(true);
            }
            else if(((JComponent)e.getSource()).getName().equals("right shoulder")){
                JOptionPane.showMessageDialog(MainGUI.this, "Unfortunately this feature is not supported at this time.");

            }
            else if(((JComponent)e.getSource()).getName().equals("lower abdomen")){
                InformationInput informationInput = new InformationInput();
                informationInput.setType("head");
                informationInput.setSize(600,600);
                informationInput.setVisible(true);
            }
            else if(((JComponent)e.getSource()).getName().equals("pelvis")){
                InformationInput informationInput = new InformationInput();
                informationInput.setType("head");
                informationInput.setSize(600,600);
                informationInput.setVisible(true);
            }
            else if(((JComponent)e.getSource()).getName().equals("legs")){
                JOptionPane.showMessageDialog(MainGUI.this, "Unfortunately this feature is not supported at this time.");

            }
            else if(((JComponent)e.getSource()).getName().equals("feet")){
                JOptionPane.showMessageDialog(MainGUI.this, "Unfortunately this feature is not supported at this time.");
            }

        }
    }
}