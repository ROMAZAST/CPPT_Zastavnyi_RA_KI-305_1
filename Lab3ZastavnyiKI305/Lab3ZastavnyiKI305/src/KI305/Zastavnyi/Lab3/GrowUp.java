package KI305.Zastavnyi.Lab3;
/**
 * Інтерфейс GrowUp визначає метод для зростання рослини.
 * Розширює інтерфейс CheckHumidity для перевірки вологості перед зростанням.
 */
public interface GrowUp extends CheckHumidity {

    /**
     * Метод Grow визначає процес зростання рослини.
     */
    void Grow();
}
