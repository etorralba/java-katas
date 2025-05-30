import java.util.Scanner;
import java.util.Set;

public class TemperatureConverterRevised {

    public static void main(String[] args) {
        // Reading user input
        Scanner reader = new Scanner(System.in);
        Set<String> validUnits = Set.of("c", "f", "k");

        String sourceMetric = getAndValidateMetric(reader, validUnits); // Reading source metric

        System.out.println("Enter the temperature number:");
        String sourceTemp = reader.nextLine(); // Reading amount of metric
        double dSourceTemp = Double.parseDouble(sourceTemp);

        String destMetric = getAndValidateMetric(reader, validUnits); // Reading destination metric

        reader.close();

        // Convert input
        double conversion = convert(sourceMetric, destMetric, dSourceTemp);

        // Show result
        ConversionResult result = new ConversionResult(dSourceTemp, sourceMetric, conversion, destMetric); // Use of record to abstract the result logic
        System.out.println(result);
    }

    // Using "Record". It is a concise way to define an immutable data class. This is just a bundle of related values
    public record ConversionResult(double sourceTemp, String sourceMetric, double conversion, String destMetric) {
        @Override
        public String toString(){
            return "Result: " + sourceTemp + "°" + sourceMetric + " is: " + conversion + "°" + destMetric;
        }
    }

    private static String getAndValidateMetric(Scanner reader, Set<String> validUnits) {
        String metric = null;
        while (metric == null) {
            System.out.println("Enter the temperature to convert:");
            System.out.println("c - Celsius");
            System.out.println("f - Fahrenheit");
            System.out.println("k - Kelvin");

            String temp = reader.nextLine();
            if (!validUnits.contains(temp.toLowerCase())){
                System.out.println("Input should be one of this: c, f, k");
            } else {
                metric = temp.toLowerCase();
            }
        }
        return metric;
    }

    public static double convert(String source, String dest, Double temperature) {
        // Use of switch -> case
        return switch (source) {
            case "c" -> switch (dest){
                case "f" -> (temperature * ((double) 9 / 5) + 32);
                case "k" -> (temperature + 273.15);
                default -> temperature;
            };
            case "f" -> switch (dest){
                case "c" -> ((temperature - 32) * (double) 5 / 9);
                case "k" -> ((temperature - 32) * ((double) 5 / 9) + 273.15);
                default -> temperature;
            };
            case "k" -> switch (dest){
                case "c" -> (temperature - 273.1);
                case "f" -> ((temperature - 273.15) * ((double) 9 / 5) + 32);
                default -> temperature;
            };
            default -> throw new IllegalArgumentException("Invalid source unit");
        };
    }
}
