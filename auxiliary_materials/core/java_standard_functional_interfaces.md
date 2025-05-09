# Java Standard Functional Interfaces

Из пакета `java.util.function`:

## 1. Основные

- `Function<T, R>` – принимает `T`, возвращает `R`.
- `BiFunction<T, U, R>` – принимает `T` и `U`, возвращает `R`.
- `UnaryOperator<T>` – унаследован от `Function<T, T>`.
- `BinaryOperator<T>` – унаследован от `BiFunction<T, T, T>`.

## 2. Предикаты

- `Predicate<T>` – возвращает `boolean`.
- `BiPredicate<T, U>` – принимает два аргумента, возвращает `boolean`.

## 3. Консьюмеры (потребители)

- `Consumer<T>` – принимает `T`, ничего не возвращает.
- `BiConsumer<T, U>` – принимает два аргумента, ничего не возвращает.

## 4. Сапплаеры (поставщики)

- `Supplier<T>` – не принимает аргументов, возвращает `T`.

## 5. Примитивные аналоги

- `IntFunction<R>`, `DoubleFunction<R>` и т.п.
- `IntPredicate`, `LongPredicate`, `DoublePredicate`
- `IntConsumer`, `LongConsumer`, `DoubleConsumer`
- `IntSupplier`, `LongSupplier`, `DoubleSupplier`
- `IntUnaryOperator`, `DoubleUnaryOperator`, и т.п.

## Пример

```java
Function<String, Integer> length = s -> s.length();
Predicate<Integer> isPositive = n -> n > 0;
Consumer<String> printer = s -> System.out.println(s);
Supplier<Double> random = () -> Math.random();
```