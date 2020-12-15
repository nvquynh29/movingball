import java.util.Random;

public abstract class Shape {
    protected String color;
    protected boolean filled;
    protected int speed;
    protected int frameWidth = 900, frameHeight = 600;
    protected boolean moveUp, moveRight;

    Random rd = new Random();

    public Shape() {

    }

    public Shape(String color, boolean filled, int speed) {
        this.color = color;
        this.filled = filled;
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }


    public abstract int getArea();

    public abstract int getPerimeter();

    public abstract void handleWidthCollision();

    public abstract void handleHeightCollision();

    public abstract void move();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Shape) {
            if (getClass() == obj.getClass()) {
                if (this instanceof Circle) {
                    Circle c1 = (Circle) this;
                    Circle c2 = (Circle) obj;
                    return c1.equals(c2);
                } else {
                    Rectangle rect1 = (Rectangle) this;
                    Rectangle rect2 = (Rectangle) obj;
                    return rect1.equals(rect2);
                }
            }
        }
        return false;
    }

    public String toString() {
        return "Shape[color=" + color + ",filled=" + filled + "]";
    }
}
