import java.util.Objects;
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        // Reading user input
        Scanner reader = new Scanner(System.in);
        String[] chars = {"c", "f", "k"};

        String sourceMetric = getAndValidateMetric(reader, chars); // Reading source metric

        System.out.println("Enter the temperature number:");
        String sourceTemp = reader.nextLine(); // Reading amount of metric
        Double dSourceTemp = Double.parseDouble(sourceTemp);

        String destMetric = getAndValidateMetric(reader, chars); // Reading destination metric

        reader.close();

        // Convert input
        double conversion = convert(sourceMetric, destMetric, dSourceTemp);

        // Show result
        String message = "Result: " + sourceTemp + "°" + sourceMetric + " is: " + conversion + "°" + destMetric;
        System.out.println(message);
    }

    private static String getAndValidateMetric(Scanner reader, String[] chars) {
        String metric = null;
        while (metric == null) {
            System.out.println("Enter the temperature to convert:");
            System.out.println("c - Celsius");
            System.out.println("f - Fahrenheit");
            System.out.println("k - Kelvin");
            String temp = reader.nextLine();
            if (!charInList(temp, chars)) {
                System.out.println("Input should be one of this: c, f, k");
            } else {
                metric = temp;
            }
        }
        return metric;
    }

    private static boolean charInList(String c, String[] list) {
        for (String s : list) {
            if (Objects.equals(c, s)) {
                return true;
            }
        }
        return false;
    }

    public static double convert(String source, String dest, Double temperature) {
        if (Objects.equals(source, "c")) {
            if (Objects.equals(dest, "f")) {
                // c to f
                return (temperature * ((double) 9 / 5) + 32);
            } else {
                // c to k
                return (temperature + 273.15);
            }
        } else if (Objects.equals(source, "f")) {
            if (Objects.equals(dest, "c")) {
                // f to c
                return ((temperature - 32) * (double) 5 / 9);
            } else {
                // f to k
                return ((temperature - 32) * ((double) 5 / 9) + 273.15);
            }
        } else if (Objects.equals(source, "k")) {
            if (Objects.equals(dest, "c")) {
                // k to c
                return (temperature - 273.1);
            } else {
                // k to f
                return ((temperature - 273.15) * ((double) 9 / 5) + 32);
            }
        }
        return 0.0;
    }
}
