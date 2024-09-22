### Описание
Валидатор данных – библиотека, с помощью которой можно проверять соответствие входных данных заданным критериям. 
Библиотека содержит следущие методы для создания схем валидации:

string() - метод создает схему для проверки строк со следующими методами валидации:
        required() - строка не является пустой или null;
        minLength() - длина строки не меньше установленной аргументом;
        contains() - строка содержит строку, указанную в агрументе.
    
number() - метод создает схему для проверки чисел (тип int) со следующими методами валидации:
        required() - значение не является null;
        positive() - значение не меньшие или равно нулю;
        range() - значение находится в диапазоне, определенном двумя аргументами.

map() - метод создает схему для проверки Map со следующими методами валидации:
        required() - проверка, что Map не является null;
        sizeof() - размер Мap равен установленному аргументом;
        shape() - используется для определения свойств объекта Map и создания схемы для валидации их значений.

Проверка корректности происводится с помощью метода isValid();

### Пример проверки строк
        Validator v = new Validator();
        StringSchema schema = v.string();

        // Пока не вызван метод required(), null и пустая строка считаются валидным
        schema.isValid(""); // true
        schema.isValid(null); // true
        
        schema.required();
        schema.isValid(null); // false
        schema.isValid(""); // false
        schema.isValid(5); // false
        schema.isValid(<p>"what does the fox say"</p>); // true
        schema.isValid("hexlet"); // true
        
        schema.contains("wh").isValid("what does the fox say"); // true
        schema.contains("what").isValid("what does the fox say"); // true
        schema.contains("whatthe").isValid("what does the fox say"); // false
        
        schema.isValid("what does the fox say"); // false
        // Здесь уже false, так как добавлена еще одна проверка contains("whatthe")

### Пример проверки чисел
        Validator v = new Validator();
        
        NumberSchema schema = v.number();
        
        // Пока не вызван метод required(), null считается валидным
        schema.isValid(null); // true
        schema.positive().isValid(null); // true
        
        schema.required();
        
        schema.isValid(null); // false
        schema.isValid("5"); // false
        schema.isValid(10); // true
        
        // Потому что ранее мы вызвали метод positive()
        schema.isValid(-10); // false
        //  Ноль — не положительное число
        schema.isValid(0); // false
        
        schema.range(5, 10);
        
        schema.isValid(5); // true
        schema.isValid(10); // true
        schema.isValid(4); // false
        schema.isValid(11); // false

### Пример проверки Map
        Validator v = new Validator();
        
        MapSchema schema = v.map();
        
        schema.isValid(null); // true
        
        schema.required();
        
        schema.isValid(null) // false
        schema.isValid(new HashMap()); // true
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        schema.isValid(data); // true
        
        schema.sizeof(2);
        
        schema.isValid(data);  // false
        data.put("key2", "value2");
        schema.isValid(data); // true

### Пример вложенной проверки Map
        var v = new Validator();

        var schema = v.map();

        // shape позволяет описывать валидацию для значений каждого ключа объекта Map
        // Создаем набор схем для проверки каждого ключа проверяемого объекта
        // Для значения каждого ключа - своя схема
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        
        // Определяем схемы валидации для значений свойств "firstName" и "lastName"
        // Имя должно быть строкой, обязательно для заполнения
        schemas.put("firstName", v.string().required());
        // Фамилия обязательна для заполнения и должна содержать не менее 2 символов
        schemas.put("lastName", v.string().required().minLength(2));
        
        // Настраиваем схему `MapSchema`
        // Передаем созданный набор схем в метод shape()
        schema.shape(schemas);
        
        // Проверяем объекты
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        schema.isValid(human1); // true
        
        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        schema.isValid(human2); // false
        
        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        schema.isValid(human3); // false

### Установка
    git clone git@github.com:ppeter777/java-project-78.git
    cd java-project-78/app
    make install

### Запуск
    make run

### Hexlet tests and linter status:
[![Actions Status](https://github.com/ppeter777/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/ppeter777/java-project-78/actions)

[![Github Actions](https://github.com/ppeter777/java-project-78/actions/workflows/my_workflow.yml/badge.svg)](https://github.com/ppeter777/java-project-78/actions/workflows/my_workflow.yml)

<a href="https://codeclimate.com/github/ppeter777/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/44f40115831da34ea555/maintainability" /></a>

<a href="https://codeclimate.com/github/ppeter777/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/44f40115831da34ea555/test_coverage" /></a>




