# simple-calculator
Изначально данный проект был простым (в рамках ООП) решением тестового задания Java Mentor, которое можно посмотреть в файле "тестовое-задание-java-mentor":
https://github.com/HuKuTa94/simple-calculator/blob/main/тестовое-задание-java-mentor.txt

Затем, у проекта появились участники (contributors), которые предложили улучшения проекта. Было решено сделать данный проект учебным по совместной разработке приложения, составить ТЗ и реализовать все пункты.

Техническое задание на разработку приложения арабско-римского, физических величин калькулятора.


1. Арабско-Римский Калькулятор

1.1 Приложение должно быть построено по принципам (допускаются некоторые упрощения) чистой архитектуры с domain/core слоем приложения (гексогональная архитектура Ports & Adapters). 

Слой domain должен содержать следующий функционал приложения:
- Данные передаются в одну строку
- Арифметические операции: сложение, вычитание, умножение, деление (результат операции возвращается в int для римских чисел, в double для арабских)
- Допускается ввод только целых чисел от 1 (для римских и арабских чисел)
- Допускается ввод только двух чисел и одной арифметической операции
- Запрещается ввод арабского и римского числа в одной строке, приложение должно выбрасывать исключение
- При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно, при вводе арабских - ответ ожидается арабскими
- При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение


1.2 GUI оболочка должна быть реализована с помощью Java FX. Общий вид приложения должен быть похож на стандартный калькулятор Windows. У калькулятора должна быть кнопка переключения режима (арабский - в GUI отображаются арабские числа, римский -в GUI отображаются римские числа). У всех режимов имеется редактируемое текстовое поле для ввода чисел операции и вывода результата. Так же имеются кнопки с числами и операциями для ввода данных с помощью них. 
Кнопки с числами (от 0 до 9) индивидуальны для каждого режима калькулятора. 

Общие кнопки, которые одинаковы для всех режимов калькулятора:
- Очистить все (очищает текстовое поле)
- Удалить последний символ (удаляет один символ в текущей позиции курсора, как клавиша backspace на клавиатуре)
- Сложение + (добавляет в текстовое поле символ +)
- Вычитание - (добавляет в текстовое поле символ -)
- Умножение * (добавляет в текстовое поле символ *)
- Деление / (добавляет в текстовое поле символ /)
- Получить результат = (получает и выводит результат арифметической операции в текстовое поле, в зависимости от режима калькулятора)

Арабский режим:
- Графический интерфейс должен содержать в себе 10 кнопок с числами от 0 до 9, которые добавляют соответствующие цифры в текстовое поле
- Текстовое поле выводит результат арабскими числами
- Ввод чисел и операции осуществляется с помощью клавиатуры (в текстовое поле) или с помощью кнопок графического интерфейса
- *Для арабского режима возможен ввод только арабских цифр (только символы 0, 1, 2, 3, 4, 5, 6, 7, 8, 9. Клавиатура не должна реагировать на нажатие других символов, кроме арифметических операций)

Римский режим:
- Графический интерфейс должен содержать в себе 7 кнопок с числами: I, V, X, L, C, D, M, которы добавляют соответствующие символы в текстовое поле
- Текстовое поле выводит результат римскими числами
- Ввод чисел и операции осуществляется с помощью клавиатуры (в текстовое поле) или с помощью кнопок графического интерфейса
- *Для римского режима возможен ввод только римских чисел (только символы I,V,X,L,C,D,M. Клавиатура не должна реагировать на нажатие других символов, кроме арифметических операций)

*Валидация ввода чисел с клавиатуры в текстовое поле (для всех режимов):
- Текстовое поле ожидает ввод первого числа, поэтому клавиатура не должна реагировать на нажатие других символов кроме как числовых (в зависимости от режима калькулятора)
- После ввода первого числа ожидается только ввод символа арифметической операции
- После ввода одного из символа арифметической операции (+,-,* или /), клавиатура больше не реагирует на нажатие этих символов
- Затем ожидается ввод второго числа 
- Когда все числа введены, клавиатура может реагировать на нажатие клавиши "=" (равносильно нажатию кнопки = на GUI)
- Клавиша backspace всегда доступна для нажатий в любой момент (как и кнопка удаления последнего символа backspace на GUI)

*пункты повышенной сложности, которые не обязательно реализовывать.


Рекомендации по выполнению ТЗ:
- Использовать Maven в проекте
- Сначала реализовать domain слой приложения, продумать стркутуру пакетов, разделить функционал приложения на классы, подготовить внутренние интерфейсы (Ports), которые будут реализовывать внешние слои (Adapters) на javaFX.
- Приступить к написанию графического интерфейса на javaFX в соответствующем пакете, реализовать интерфейсы (Ports) из внутреннего слоя (domain), чтобы была возможность передавать данные из текстового поля и выводить в него результат
- Сопровождать разработку unit тестами


P.S. Данное ТЗ может дополняться и изменяться. 
