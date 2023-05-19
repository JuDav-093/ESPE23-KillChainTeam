public class Rhombus {
    public static void main(String[] args) {
        int side = 5;
        int perimeter = calculatePerimeter(side);
        System.out.println("The perimeter of the rhombus is: " + perimeter);
    }
    public static int calculatePerimeter(int side) {
        int perimeter = 4 * side;
        return perimeter;
    }
}