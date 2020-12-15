public class Point {
    private int pointX;
    private int pointY;

    public Point(int pointX, int pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    public double distance(Point other) {
        int subX = this.pointX - other.pointX;
        int subY = this.pointY - other.pointY;
        int temp = subX * subX + subY * subY;
        return Math.sqrt(temp);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point other = (Point) obj;
            if ((this.pointX == other.pointX) && (this.pointY == other.pointY)) {
                return true;
            }
        }
        return false;
    }

    public void translationX(int x) {
        pointX += x;
    }

    public void translationY(int y) {
        pointY += y;
    }

    public String toString() {
        pointX = (int) Math.round(pointX * 10) / 10;
        pointY = (int) Math.round(pointY * 10) / 10;
        return "(" + pointX + "," + pointY + ")";
    }
}
