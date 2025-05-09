# 📚 Java Exception Hierarchy

**Throwable** – Базовый класс для всех ошибок и исключений в Java.  
├── **Error** – Серьёзные ошибки, которые приложение не должно пытаться обрабатывать.  
│   ├── 🚫 OutOfMemoryError – Недостаточно памяти для создания нового объекта.  
│   ├── 🚫 StackOverflowError – Переполнение стека, чаще всего из-за бесконечной рекурсии.  
│   └── **VirtualMachineError** – Ошибки, указывающие на сбой или нехватку ресурсов JVM.  
│       ├── ⚙️ InternalError – Внутренняя ошибка виртуальной машины Java.  
│       └── ❓ UnknownError – Неизвестная ошибка, причина которой не установлена.  
└── **Exception** – Исключения, которые приложение может обработать.  
    ├── **RuntimeException** – Исключения, возникающие во время выполнения.  
    │   ├── 📏 ArrayIndexOutOfBoundsException – Выход за границы массива.  
    │   ├── 🔁 ClassCastException – Ошибка приведения типа.  
    │   ├── ⚠️ IllegalArgumentException – Метод получил некорректный аргумент.  
    │   ├── 🕳️ NullPointerException – Попытка обращения к `null` как к объекту.  
    │   └── 🔢 IndexOutOfBoundsException – Выход за пределы коллекции по индексу.  
    ├── 💾 IOException – Ошибка ввода/вывода.  
    ├── 🪞 ReflectiveOperationException – Ошибка при работе с рефлексией.  
    ├── 🗃️ SQLException – Ошибка доступа к базе данных.  
    ├── ⌛ TimeoutException – Превышено время ожидания операции.  
    ├── 📅 ParseException – Ошибка при разборе строки.  
    └── 🚫 CloneNotSupportedException – Попытка клонирования объекта, который не реализует `Cloneable`.