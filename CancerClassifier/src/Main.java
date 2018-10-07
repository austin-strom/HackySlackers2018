import Interface.MainGUI;

public class Main {
    public static void main(String args[]){
        MainGUI gui = new MainGUI();
        gui.setSize(600,600);
        gui.setVisible(true);

    }
}

/*
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
 */