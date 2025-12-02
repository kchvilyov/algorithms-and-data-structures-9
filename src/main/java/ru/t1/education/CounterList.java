package ru.t1.education;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Создаёт объекты, которые оборачивают List
 * и считает вызовы метода add этих объектов при помощи обработчика вызовов.
 * @param <E> - тип составляющих списка.
 */
public class CounterList<E> {
    private final List<E> delegate = new ArrayList<>();
    private static int addCount = 0;

    public static int getAddCount() {
        return addCount;
    }

    /**
     * Сбрасывает счётчик вызовов способа add.
     */
    public static void reset() {
        addCount = 0;
    }

    @SuppressWarnings("unchecked")
    /**
     * Создаёт подвижного представителя, воплощающего List.class.
     * Все вызовы способов этого представителя проходят через Обработчик Вызова(InvocationHandler).
     * Если вызван способ добавить(add), увеличиваем счётчик.
     * Все способы (включая add, size, get и т.д.) поручаются настоящему объекту delegate (внутренний ArrayList).
     * @return представитель для List
     */
    public List<E> getProxy() {
        return (List<E>) Proxy.newProxyInstance(
            CounterList.class.getClassLoader(),
            new Class[]{List.class},
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // Считаем вызовы метода add
                    if (method.getName().equals("add")) {
                        addCount++;
                    }
                    // Передаём все вызовы на выполнение настоящему внутреннему списку
                    return method.invoke(delegate, args);
                }
            }
        );
    }
}