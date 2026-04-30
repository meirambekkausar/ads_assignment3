import java.util.Scanner;
public class ShippingOptimization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of packages: ");
        int numberOfPackages = sc.nextInt();

        int[] packageWeights = new int[numberOfPackages];
        System.out.println("Enter the weights:");
        for (int i = 0; i < numberOfPackages; i++) {
            packageWeights[i] = sc.nextInt();
        }

        System.out.print("Enter number of days: ");
        int days = sc.nextInt();

        // Determine the search range for Binary Search
        int minCapacity = 0, maxCapacity = 0;
        for (int weight : packageWeights) {
            // The truck must at least fit the heaviest package
            if (weight > minCapacity) minCapacity = weight;
            // The max capacity =  sum of all packages
            maxCapacity += weight;
        }

        //  Binary Search
        int result = maxCapacity;
        while (minCapacity <= maxCapacity) {
            int mid = minCapacity+ (maxCapacity - minCapacity) / 2;

            if (isCapacitySufficient(packageWeights, days,  mid)) {
                result = mid;     // This capacity is it
                maxCapacity = mid - 1;   // Try smaller capacity
            } else {
                minCapacity = mid + 1;    // Try increasing
            }
        }

        System.out.println("Minimal shipping capacity: " + result);
    }

    //  to check if a specific capacity can finish in 'days'
    public static boolean isCapacitySufficient(int[] weights, int days, int capacity) {
        int daysUsed = 1;
        int currentDailyWeight = 0;

        for (int weight : weights) {
            if (currentDailyWeight + weight > capacity) {
                daysUsed++;       // Ship it on the next day
                currentDailyWeight = weight;
            } else {
                currentDailyWeight += weight;
            }
        }
        return daysUsed <= days;
    }
}