import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Layer extends JFrame implements Runnable {
    private List<Shape> shapes = new ArrayList<>();
    private int frameWidth = 900, frameHeight = 600;
    private int layerX = 300, layerY = 50;


    public Layer() {
        setBounds(layerX, layerY, frameWidth, frameHeight);
        setVisible(true);
        setResizable(false);
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {
                char ch = e.getKeyChar();
                switch (ch) {
                    case 'c': {
                        Circle circle = new Circle();
                        circle.draw(getGraphics());
                        shapes.add(circle);
                        break;
                    }
                    case 'r': {
                        Rectangle rectangle = new Rectangle();
                        rectangle.draw(getGraphics());
                        shapes.add(rectangle);
                        break;
                    }
                    case 's': {
                        Square square = new Square();
                        square.draw(getGraphics());
                        shapes.add(square);
                        break;
                    }
                    case 'd': {
                        removeCircles();
                        break;
                    }
                    case 'x': {
                        removeDuplicates();
                        break;
                    }
                }
            }
        });
        setFocusable(true);

        Thread thread = new Thread(this);
        thread.start();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeCircles() {
        List<Shape> toRemove = new ArrayList<>();

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                toRemove.add(shape);
            }
        }
        shapes.removeAll(toRemove);
    }

    public String getInfo() {
        String result = "Layer of crazy shapes: \n";
        for (Shape shape : shapes) {
            result += shape.toString() + "\n";
        }
        return result;
    }

    public void removeDuplicates() {
        int size = shapes.size();
        for (int i = 0; i < size - 1; ++i) {
            Shape root = shapes.get(i);
            for (int j = i + 1; j < size; ++j) {
                Shape other = shapes.get(j);
                if (other.equals(root)) {
                    shapes.remove(j);
                    j--;
                    size--;
                }
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, frameWidth, frameHeight);
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                c.draw(g);
            } else if (shape instanceof Rectangle){  // Sua square truoc
                Rectangle rectangle = (Rectangle) shape;
                rectangle.draw(g);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < shapes.size(); ++i) {
                shapes.get(i).move();
            }

            repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
