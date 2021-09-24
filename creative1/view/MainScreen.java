package view;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import controller.DrawEventListener;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

public class MainScreen {
    private JFrame window;
    private DrawingCanvas canvas;
    private JRadioButton squareButton = new JRadioButton("Square");
    private JRadioButton circleButton = new JRadioButton("Circle");
    private JRadioButton triangleButton = new JRadioButton("Triangle");
    private JRadioButton redButton = new JRadioButton("Red");
    private JRadioButton greenButton = new JRadioButton("Green");
    private JRadioButton blueButton = new JRadioButton("Blue");
    private JRadioButton smallButton = new JRadioButton("Small");
    private JRadioButton mediumButton = new JRadioButton("Medium");
    private JRadioButton largeButton = new JRadioButton("Large");

    public MainScreen(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();

        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel);

        southPanel.setLayout(new GridLayout(3, 1));
        JPanel shapesPanel = new JPanel();
        shapesPanel.add(squareButton);
        shapesPanel.add(circleButton);
        shapesPanel.add(triangleButton);
        southPanel.add(shapesPanel);
        ButtonGroup shapesGroup = new ButtonGroup();
        shapesGroup.add(squareButton);
        shapesGroup.add(circleButton);
        shapesGroup.add(triangleButton);
        squareButton.setSelected(true);
        TitledBorder shapesTitle = BorderFactory.createTitledBorder("Shapes");
        shapesPanel.setBorder(shapesTitle);

        JPanel colorPanel = new JPanel();
        colorPanel.add(redButton);
        colorPanel.add(greenButton);
        colorPanel.add(blueButton);
        southPanel.add(colorPanel);
        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(redButton);
        colorGroup.add(greenButton);
        colorGroup.add(blueButton);
        redButton.setSelected(true);
        TitledBorder colorTitle = BorderFactory.createTitledBorder("Color");
        colorPanel.setBorder(colorTitle);

        JPanel sizePanel = new JPanel();
        sizePanel.add(smallButton);
        sizePanel.add(mediumButton);
        sizePanel.add(largeButton);
        southPanel.add(sizePanel);
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallButton);
        sizeGroup.add(mediumButton);
        sizeGroup.add(largeButton);
        smallButton.setSelected(true);
        TitledBorder sizeTitle = BorderFactory.createTitledBorder("Size");
        sizePanel.setBorder(sizeTitle);

        canvas = new DrawingCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        DrawEventListener listener = new DrawEventListener(this);
        squareButton.addActionListener(listener);
        circleButton.addActionListener(listener);
        triangleButton.addActionListener(listener);
        redButton.addActionListener(listener);
        greenButton.addActionListener(listener);
        blueButton.addActionListener(listener);
        smallButton.addActionListener(listener);
        mediumButton.addActionListener(listener);
        largeButton.addActionListener(listener);
        canvas.addMouseListener(listener);
    }

    public JRadioButton getSquareButton() {
        return squareButton;
    }

    public JRadioButton getCircleButton() {
        return circleButton;
    }

    public JRadioButton getTriangleButton() {
        return triangleButton;
    }

    public JRadioButton getRedButton() {
        return redButton;
    }

    public JRadioButton getGreenButton() {
        return greenButton;
    }

    public JRadioButton getBlueButton() {
        return blueButton;
    }

    public JRadioButton getSmallButton() {
        return smallButton;
    }

    public JRadioButton getMediumButton() {
        return mediumButton;
    }

    public JRadioButton getLargeButton() {
        return largeButton;
    }

    public DrawingCanvas getCanvas() {
        return canvas;
    }
}
