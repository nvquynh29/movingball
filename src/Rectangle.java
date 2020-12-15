import java.awt.*;

public class Rectangle extends Shape {
    protected Point topLeft;
    protected int width;
    protected int length;
    protected Color rgbColor;

    public Rectangle() {
        int red = rd.nextInt(256);
        int green = rd.nextInt(256);
        int blue = rd.nextInt(256);
        rgbColor = new Color(red, green, blue);

        width = (rd.nextInt(16) + 5) * 10;
        length = (rd.nextInt(16) + 5) * 10;
        topLeft = new Point(rd.nextInt(frameWidth - 2 * width), rd.nextInt(frameHeight - 2 * length));
        speed = (rd.nextInt(4) + 1) * 5;
        moveUp = rd.nextBoolean();
        moveRight = rd.nextBoolean();
    }

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(int width, int length, String color, boolean filled) {
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    public Rectangle(Point topLeft, int width, int length, String color, boolean filled) {
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public int getArea() {
        return this.width * this.length;
    }

    public int getPerimeter() {
        return 2 * (this.width + this.length);
    }

    public void draw(Graphics g) {
        g.setColor(rgbColor);
        g.fillRect(topLeft.getPointX(), topLeft.getPointY(), width, length);
    }

    public void move() {
        handleWidthCollision();
        handleHeightCollision();
        if (moveRight) {
            topLeft.translationX(speed);
        } else {
            topLeft.translationX(-speed);
        }

        if (moveUp) {
            topLeft.translationY(speed);
        } else {
            topLeft.translationY(-speed);
        }
    }

    @Override
    public void handleWidthCollision() {
        if (topLeft.getPointX() < 0) {
            moveRight = true;
        } else if (topLeft.getPointX() > (frameWidth - width)) {
            moveRight = false;
        }
    }

    @Override
    public void handleHeightCollision() {
        if (topLeft.getPointY() < length / 4) {
            moveUp = true;
        } else if (topLeft.getPointY() > (frameHeight - length)) {
            moveUp = false;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            Rectangle other = (Rectangle) obj;
            if (topLeft.equals(other.getTopLeft())) {
                if ((width == other.getWidth()) && (length == other.getLength())) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        width = (int) Math.round(width * 10) / 10;
        length = (int) Math.round(length * 10) / 10;
        return "Rectangle[topLeft=" + topLeft.toString() + ",width=" + width
                + ",length=" + length + ",color=" + color + ",filled=" + filled + "]";
    }

}
