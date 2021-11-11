package stats;

public class StatsService {
    // Сумма всех продаж
    public long calculateSum(long[] sales) {
        long sum = 0;
        for (long sale : sales) {
            sum = sale + sum;
        }
        return sum;
    }

    // Средняя сумма продаж в месяц
    public long findAverage(long[] sales) {
        long averageSum = calculateSum(sales) / sales.length;
        return averageSum;
    }

    // Номер месяца, в котором был пик продаж
    public int maxSales(long[] sales) {
        int maxMonth = 0;
        int month = 0;
        for (long sale : sales) {
            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1;
        }
        return maxMonth + 1;
    }

    // Номер месяца, в котором был минимум продаж
    public int minSales(long[] sales) {
        int minMonth = 0;
        int month = 0;
        for (long sale : sales) {
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1;
        }
        return minMonth + 1;
    }

    // Кол-во месяцев, в которых продажи были ниже среднего
    public int monthsSalesLessAverage(long[] sales) {
        int counterMonthLessAverage = 0;
        long average = findAverage(sales);
        for (long sale : sales) {
            if (sale < findAverage(sales)) {
                counterMonthLessAverage = counterMonthLessAverage + 1;
            }
        }
        return counterMonthLessAverage;
    }

    // Кол-во месяцев, в которых продажи были выше среднего
    public int monthsSalesMoreAverage(long[] sales) {
        int counterMonthMoreAverage = 0;
        long average = findAverage(sales);
        for (long sale : sales) {
            if (sale > findAverage(sales)) {
                counterMonthMoreAverage = counterMonthMoreAverage + 1;
            }
        }
        return counterMonthMoreAverage;
    }
}
