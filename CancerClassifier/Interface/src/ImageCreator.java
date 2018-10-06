import javax.swing.*;
import java.awt.*;

public class ImageCreator extends Panel {

    Image img;

    public ImageCreator(){
        this.img = Toolkit.getDefaultToolkit().createImage("MainClassifier/src/humanBody.jpg");

    }

    @Override
    public void paint(Graphics g){
        g.drawImage(img,0,0,null);
    }
}
