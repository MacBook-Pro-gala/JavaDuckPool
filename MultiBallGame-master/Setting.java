import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import java.lang.reflect.Field;

public class Setting extends JFrame implements GameConstants {

    public Setting() {

        windowInit();
    }

    private void windowInit() {
        this.setTitle("设置");
        this.setSize(1500,1500);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JTextField placeTextField = new JTextField(10);
        placeTextField.setBounds(300,300,300,100);
        panel.add(placeTextField);
        JButton addPlaceButton = new JButton("设置最大鸭子个数");
        addPlaceButton.setBounds(650,300,500,100);
        panel.add(addPlaceButton);


        JTextField placeTextField2 = new JTextField(10);
        placeTextField2.setBounds(300,600,300,100);
        panel.add(placeTextField2);
        JButton addPlaceButton2 = new JButton("设置最大水仙花个数");
        addPlaceButton2.setBounds(650,600,500,100);
        panel.add(addPlaceButton2);


        JButton addPlaceButton4 = new JButton("未静音(Not mute)");
        addPlaceButton4.setBounds(450,900,600,100);
        panel.add(addPlaceButton4);

        addPlaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ee) {
                registerAddPlaceButtonEvent(placeTextField);
                Board.MAX_BALLS = Integer.parseInt(placeTextField.getText());
            }
        });
        addPlaceButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerAddPlaceButtonEvent2(placeTextField2);
                Board.MAX_Lilies = Integer.parseInt(placeTextField2.getText());
            }
        });
        addPlaceButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board.playmusic=Board.playmusic*-1;
                if(Board.playmusic==-1){
                addPlaceButton4.setText("已静音(Mute)");
            }
                else {
                    addPlaceButton4.setText("未静音(Not mute)");
                }
            }
        });
        this.getContentPane().add(panel);
    }


    private void registerAddPlaceButtonEvent(JTextField placeTextField) {

        if(placeTextField.getText() == null || placeTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input the int number",
                    "Duck Creation Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
            //MAX_BALLS = Integer.parseInt(placeTextField.getText());
        }
//        if(place.getId() == null) {
//            JOptionPane.showMessageDialog(this, "Unable to create the place",
//                    "Place Creation Error",JOptionPane.ERROR_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(this, "Place is created successfully",
//                    "New Place",JOptionPane.INFORMATION_MESSAGE);
//        }
    }
    private void registerAddPlaceButtonEvent2(JTextField placeTextField) {

        if(placeTextField.getText() == null || placeTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input the int number",
                    "lilies Creation Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {

        }
//        if(place.getId() == null) {
//            JOptionPane.showMessageDialog(this, "Unable to create the place",
//                    "Place Creation Error",JOptionPane.ERROR_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(this, "Place is created successfully",
//                    "New Place",JOptionPane.INFORMATION_MESSAGE);
//        }
    }
    private void registerAddPlaceButtonEvent3(JTextField placeTextField) {

        if(placeTextField.getText() == null || placeTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input the int number",
                    "Speed Creation Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {

        }
//        if(place.getId() == null) {
//            JOptionPane.showMessageDialog(this, "Unable to create the place",
//                    "Place Creation Error",JOptionPane.ERROR_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(this, "Place is created successfully",
//                    "New Place",JOptionPane.INFORMATION_MESSAGE);
//        }
    }


}
