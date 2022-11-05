import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int duration = scanner.nextInt();
        int foodCost = scanner.nextInt();
        int flightCost = scanner.nextInt();
        int hotelCost = scanner.nextInt();
        
        int stayLength = duration - 1;
        int totalFoodCost = foodCost * duration;
        int totalFlightCost = flightCost * 2;
        int totalHotelCost = stayLength * hotelCost;

        int total = totalFoodCost + totalFlightCost + totalHotelCost;
        System.out.println(total);
    }
}
