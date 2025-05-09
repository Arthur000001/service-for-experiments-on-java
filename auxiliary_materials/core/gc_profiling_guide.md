
# 🔍 Java GC & Performance Profiling в IntelliJ IDEA

## 📦 Цель
Профилировать Java-приложение локально и наглядно увидеть работу сборщика мусора, использование CPU и аллокации памяти.

---

## ⚙️ Подготовка

### Пример кода:
```java
package core.garbage_collector;

import java.util.ArrayList;
import java.util.List;

public class GcTest {
    public static void main(String[] args) throws InterruptedException {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new byte[10_000_000]); // 10MB
            if (list.size() > 50) list.clear();
            Thread.sleep(50);
        }
    }
}
```

### VM options:
```bash
-XX:+UseG1GC -Xms512m -Xmx512m -Xlog:gc* -XX:MaxGCPauseMillis=100 # G1 GC (по умолчанию в JDK 9+)
-XX:+UseSerialGC -Xms512m -Xmx512m -Xlog:gc* # Serial GC (однопоточный)
-XX:+UseParallelGC -Xms512m -Xmx512m -Xlog:gc* # Parallel GC (многопоточный throughput-ориентированный)
-XX:+UseZGC -Xms512m -Xmx512m -Xlog:gc* # ZGC (низкие паузы, нужен JDK 15+)
-XX:+UseShenandoahGC -Xms512m -Xmx512m -Xlog:gc* # Shenandoah GC (низкие паузы, нужен JDK с поддержкой, чаще всего OpenJDK от Red Hat/Adoptium)
```

---

## ▶ Запуск с профилировкой

1. Нажми правой кнопкой по классу → `Profile 'GcTest.main() with IntelliJ Profiler'`
2. После завершения откроется окно анализа.

---

## 🔥 Основные вкладки профайлера

### 1. Flame Graph
- Визуальное представление стека вызовов.
- **Горизонталь** = нагрузка (CPU/память)
- **Вертикаль** = глубина стека вызовов
- Наведи мышкой, чтобы увидеть имя метода и долю нагрузки.
- Переключи `Show:` в верхнем углу:
  - `CPU Time` — нагрузка на процессор
  - `Allocated Memory` — аллокации в памяти

### 2. Call Tree
- Иерархия вызовов с суммарным временем и аллокациями.
- Удобно, чтобы понять, кто вызывает тяжёлые методы.

### 3. Method List
- Список всех методов с сортировкой по:
  - CPU Time
  - Allocated Memory
- Полезно для выявления «тяжёлых» точек.

### 4. Timeline
- Отображает **GC-активность во времени**
- Видны сборки мусора, пики памяти и т.д.
- Включается метрика `GC Activity` вручную (если скрыта).

### 5. Events
- Список всех ключевых событий (GC, JFR Hooks и др.)

---

## 🧠 Рекомендации

- Анализируй `Allocated Memory`, чтобы понять, кто генерирует больше всего объектов.
- Используй `Timeline`, чтобы отследить частоту GC.
- Всегда смотри в `Method List`, чтобы найти горячие точки.
- Комбинируй несколько вкладок для полной картины.
