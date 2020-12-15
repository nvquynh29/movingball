import java.awt.*;

public class Circle extends Shape {
    protected Point center;
    protected int radius;
    private Color color;

    public Circle() {
        int radius = (rd.nextInt(11) + 4) * 5;
        this.radius = radius;
        center = new Point(rd.nextInt(frameWidth - 2 * radius), rd.nextInt(frameHeight - 2 * radius));
        moveRight = rd.nextBoolean();
        moveUp = rd.nextBoolean();
        speed = (rd.nextInt(4) + 1) * 5;

        int red = rd.nextInt(256);
        int green = rd.nextInt(256);
        int blue = rd.nextInt(256);
        this.color = new Color(red, green, blue);
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle(int radius, int speed, String color, boolean filled) {
        super(color, filled, speed);
        this.radius = radius;
    }

    public Circle(Point center, int speed, int radius, String color, boolean filled) {
        super(color, filled, speed);
        this.center = center;
        this.radius = radius;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(center.getPointX() - radius, center.getPointY() - radius, radius * 2, radius * 2);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getArea() {
        return 0;
//        return this.radius * this.radius * Math.PI;
    }

    public int getPerimeter() {
        return 0;
//        return 2 * this.radius * Math.PI;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            Circle other = (Circle) obj;
            if (center.equals(other.getCenter())) {
                if (radius == other.getRadius()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void move() {
        handleWidthCollision();
        handleHeightCollision();
        if (moveRight) {
            center.translationX(speed);
        } else {
            center.translationX(-speed);
        }

        if (moveUp) {
            center.translationY(speed);
        } else {
            center.translationY(-speed);
        }
    }

    public void handleWidthCollision() {
        if (center.getPointX() < (radius + speed)) {
            moveRight = true;
        } else if (center.getPointX() > (frameWidth - radius - speed)) {
            moveRight = false;
        }
    }

    public void handleHeightCollision() {
        if (center.getPointY() < (2 * radius)) {
            moveUp = true;
        } else if (center.getPointY() > (frameHeight - radius - speed)) {
            moveUp = false;
        }
    }

    public String toString() {
        radius = (int) Math.round(radius * 10) / 10;
        return "Circle[center=" + center.toString() + ",radius=" + radius + ",color="
                + color + ",filled=" + filled + "]";
    }
}
