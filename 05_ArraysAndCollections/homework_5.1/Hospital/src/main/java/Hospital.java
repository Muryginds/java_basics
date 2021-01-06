import java.text.DecimalFormat;

public class Hospital {

    public static  final DecimalFormat FORMATTER = new DecimalFormat("#0.0");

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] patients = new float[patientsCount];

        for (int i = 0; i < patientsCount; i++) {
            patients[i] = (float) (40 - 8 * Math.random());
        }

        return patients;
    }

    public static String getReport(float[] temperatureData) {

        StringBuilder stringResult = new StringBuilder();
        int healthyPatientsCount = 0;
        float patientsTemperatureSummary = 0;
        stringResult.append("Температуры пациентов:");
        for (float patientTemperature : temperatureData) {
            stringResult.append(" " + FORMATTER.format(patientTemperature));
            patientsTemperatureSummary += patientTemperature;

            if (patientTemperature >= 36.2F && patientTemperature <= 36.9F) {
                System.out.println(patientTemperature);
                healthyPatientsCount++;
            }
        }

        stringResult.append(
            "\nСредняя температура: "
                + Math.round(patientsTemperatureSummary / temperatureData.length * 10F) / 10F +
                "\nКоличество здоровых: " + healthyPatientsCount);

        return stringResult.toString();
    }
}
