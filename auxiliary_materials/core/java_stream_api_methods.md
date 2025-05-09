# Java Stream API Overview

## 1. Создание Stream'ов
- `stream()` – для коллекций.
- `Stream.of(...)` – из фиксированного набора.
- `Arrays.stream(array)` – из массива.
- `Stream.generate(...)`, `Stream.iterate(...)` – бесконечные стримы.

## 2. Промежуточные (intermediate) операции
Эти операции **возвращают новый Stream** и **не завершают** его.

- `filter(Predicate)` – фильтрация элементов.
- `map(Function)` – преобразование каждого элемента.
- `flatMap(Function)` – "расплющивание" вложенных стримов.
- `distinct()` – удаление дубликатов.
- `sorted()` – естественная сортировка.
- `sorted(Comparator)` – сортировка с компаратором.
- `limit(n)` – ограничить количество.
- `skip(n)` – пропустить n первых элементов.
- `peek(Consumer)` – отладка/логирование элементов.

## 3. Терминальные операции
Эти операции **завершают** стрим и возвращают результат.

- `collect(Collector)` – сбор результата в коллекцию.
- `forEach(Consumer)` – выполнить действие для каждого элемента.
- `toArray()` – вернуть массив.
- `reduce(...)` – агрегирование.
- `count()` – количество элементов.
- `min(Comparator)`, `max(Comparator)` – минимум/максимум.
- `anyMatch(Predicate)` – есть ли хотя бы один элемент, подходящий под условие.
- `allMatch(Predicate)` – все ли элементы соответствуют условию.
- `noneMatch(Predicate)` – ни один не соответствует.
- `findFirst()` – вернуть первый элемент.
- `findAny()` – вернуть любой элемент (параллелизм).

## 4. Работа с примитивами
- `mapToInt()`, `mapToLong()`, `mapToDouble()` – для чисел.
- `sum()`, `average()`, `min()`, `max()` – статистика по примитивам.

## 5. Collectors (из `java.util.stream.Collectors`)
- `toList()`, `toSet()`, `toMap()` – преобразование в коллекции.
- `joining()` – объединение строк.
- `groupingBy(...)` – группировка.
- `partitioningBy(...)` – разбиение по true/false.
- `counting()` – подсчёт.
- `summingInt()`, `averagingDouble()` – статистика.

## Пример

```java
List<String> filtered = list.stream()
    .filter(s -> s.length() > 3)
    .sorted()
    .collect(Collectors.toList());
```