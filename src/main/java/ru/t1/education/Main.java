package ru.t1.education;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void test(List<?> list) {
        // Метод ничего не знает о задаче — просто использует список
        // Это заглушка — может вызывать add, может нет.
        // Для задания — просто логируем.
        System.out.println("test method called with list of size: " + list.size());
    }

    public static void main(String[] args) {
        List<Integer> realList = new ArrayList<>();
        CounterList<Integer> countingList = new CounterList<>(realList);

        // Добавим 5 чисел — но через наш счётчик
        for (int i = 1; i <= 5; i++) {
            countingList.add(i);
        }

        // Сбросим счётчик, если нужно, но add уже вызывался — так что счёт идёт
        // Но по условию: считать **все вызовы add** до и после?
        // Уточнение: "после завершения метода test" — значит, считаем вызовы add, которые произошли **всего**, включая до test?

        // Однако задание: "вызовите метод test, передав туда список"
        // Значит, список уже должен быть с 5 элементами. Значит, `add` уже вызван 5 раз.

        // Сбросим счётчик перед test, если test может вызывать add?
        // Но в условии не сказано, что test вызывает add. Но он может.

        // Чтобы соответствовать: "сколько раз (в сумме) вызывались любые перегрузки add" — **вообще все вызовы**, значит, накопительно.

        // Но `static` счётчик будет считать все вызовы `add` на **любом** экземпляре `CounterList` — что и нужно.

        // Вызовем test
        test(countingList);

        // Теперь выведем общее количество вызовов add
        System.out.println(CounterList.getAddCount());
    }
}
