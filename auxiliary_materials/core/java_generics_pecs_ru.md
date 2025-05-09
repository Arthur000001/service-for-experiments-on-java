# 🎯 Принцип PECS в Java (Producer Extends, Consumer Super)

## 📌 Что такое PECS?
PECS — это правило для дженериков, которое помогает правильно использовать обобщения с коллекциями:
- **Producer Extends** — если вы **читаете** из коллекции, используйте `? extends Type`
- **Consumer Super** — если вы **пишете** в коллекцию, используйте `? super Type`

---

## ✅ Применение в методах

### Producer: `? extends Type` – Только чтение

```java
public void printNumbers(List<? extends Number> list) {
    for (Number n : list) {
        System.out.println(n);
    }
    // list.add(10); // ❌ Нельзя добавлять, тип точно не определён
}
```

### Consumer: `? super Type` – Только добавление

```java
public void addNumbers(List<? super Integer> list) {
    list.add(42); // ✅ Можно добавлять
    // Number n = list.get(0); // ❌ Нельзя читать как Number
}
```

---

## ✅ Применение к коллекциям

```java
List<? extends Number> producer = List.of(1, 2, 3);
Number n = producer.get(0);  // ✅ можно читать
// producer.add(4);          // ❌ нельзя добавлять

List<? super Integer> consumer = new ArrayList<>();
consumer.add(5);             // ✅ можно добавлять
Object o = consumer.get(0);  // ⚠️ читать можно только как Object
```

---

## 📊 Сводная таблица

| Тип коллекции          | Чтение | Запись | Применение                  |
|------------------------|--------|--------|-----------------------------|
| `List<T>`              | ✅      | ✅      | Универсальный               |
| `List<? extends T>`    | ✅      | ❌      | Только чтение (Producer)    |
| `List<? super T>`      | ❌      | ✅      | Только запись (Consumer)    |

---

## 💬 Подсказка
- Если метод **читает** из коллекции — `extends`
- Если метод **пишет** в коллекцию — `super`
