import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SumaPrefijos {
    public static void main(String[] args) {
        String inputFileName = "car_sales.csv";
        String outputFileName = "Suma_de_prefijos.csv";

        List<Main> salesData = new ArrayList<>();
        List<Double> SumaPrefijos = new ArrayList<>();
        double totalSum = 0.0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            String line;
            reader.readLine(); 

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String firstName = parts[1].trim();
                String lastName = parts[2].trim();
                String model = parts[3].trim();
                double sales = Double.parseDouble(parts[4].trim().replace("$", "").replace(",", ""));

                totalSum += sales;
                SumaPrefijos.add(totalSum);

                salesData.add(new Main(id, firstName, lastName, model, sales));
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            writer.write("id,first_name,last_name,model,sales,SumaPrefijos\n");

            for (int i = 0; i < salesData.size(); i++) {
                Main sale = salesData.get(i);
                writer.write(String.format("%d,%s,%s,%s,%.2f,%.2f\n",
                        sale.id, sale.firstName, sale.lastName, sale.model, sale.sales, SumaPrefijos.get(i)));
            }

            writer.close();

            System.out.println("Tabla de sumas prefijas generada y guardada en " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
