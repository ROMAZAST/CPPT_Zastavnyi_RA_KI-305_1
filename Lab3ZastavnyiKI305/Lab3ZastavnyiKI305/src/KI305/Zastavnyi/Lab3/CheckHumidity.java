package KI305.Zastavnyi.Lab3;

/**
 * Інтерфейс CheckHumidity визначає метод для перевірки вологості перед зростанням рослини.
 */
public interface CheckHumidity {

    /**
     * Метод HumidityToGrow повертає true, якщо вологість відповідає умовам для зростання рослини, інакше - false.
     *
     * @return true, якщо вологість дозволяє рослині рости, false - якщо недостатньо вологості.
     */
    boolean HumidityToGrow();
}
