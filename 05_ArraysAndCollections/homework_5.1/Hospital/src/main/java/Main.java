public class Main {

    private static final float[] testHospitalData = new float[]{
        32.1F, 33.1F, 32.5F, 33.5F, 34.5F, 36.5F, 38.5F, 39.5F, 33.3F, 32.7F,
        36.9F, 36.5F, 34.3F, 37.5F, 32.5F, 32.5F, 32.4F, 34.5F, 35.4F, 32.5F,
        34.5F, 39.4F, 32.5F, 36.5F, 36.4F, 39.6F, 37.5F, 32.5F, 37.5F, 39.4F
    };

    public static void main(String[] args) {

        float[] temperatureData = Hospital.generatePatientsTemperatures(15);
        //System.out.println(Hospital.getReport(temperatureData));
        System.out.println(Hospital.getReport(testHospitalData));

        //Пример вывода в консоль:
        //Температуры пациентов: 36.7 38.9 34.7
        //Средняя температура: 36.76
        //Количество здоровых: 1

        //Округлите среднюю температуру с помощью Math.round до 2 знаков после запятой.
    }
}
