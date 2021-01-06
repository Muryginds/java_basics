import java.util.Arrays;

public class Hospital {

    public static final float MAX_TEMPERATURE = 40F;
    public static final float MAX_TEMPERATURE_OF_HEALTHY_PATIENT = 36.9F;
    public static final float MIN_TEMPERATURE_OF_HEALTHY_PATIENT = 36.2F;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] patients = new float[patientsCount];

        for (int i = 0; i < patientsCount; i++) {
            patients[i] = (float) (MAX_TEMPERATURE - 8 * Math.random());
        }

        return patients;
    }

    public static String getReport(float[] temperatureData) {

        StringBuilder stringResult = new StringBuilder();
        int healthyPatientsCount = 0;
        float patientsTemperatureSummary = 0;
        stringResult.append("Температуры пациентов:");

        String[] arrayFormattedToString = Arrays.toString(temperatureData).split(",\\s|\\]|\\[");
        Arrays.stream(arrayFormattedToString).forEach(elem->{
            if (elem != "") {
                stringResult.append(" " + elem.substring(0,4));
            }
        });

        for (float patientTemperature : temperatureData) {
            patientsTemperatureSummary += patientTemperature;

            if (patientTemperature >= MIN_TEMPERATURE_OF_HEALTHY_PATIENT &&
                patientTemperature <= MAX_TEMPERATURE_OF_HEALTHY_PATIENT) {
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
