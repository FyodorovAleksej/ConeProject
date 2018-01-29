package by.fyodorov.coneproject.register;

/**
 * class with parameters of ConeEntity
 */
public class ConeParams {
    private double perimeter;
    private double square;
    private double volume;

    /**
     * creating params of cone
     * @param perimeter perimeter of Cone
     * @param square full area of Cone
     * @param volume volume of Cone
     */
    public ConeParams(double perimeter, double square, double volume) {
        this.perimeter = perimeter;
        this.square = square;
        this.volume = volume;
    }


    public double getPerimeter() {
        return perimeter;
    }
    public double getSquare() {
        return square;
    }
    public double getVolume() {
        return volume;
    }


    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
    public void setSquare(double square) {
        this.square = square;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
}
