Мои лабораторные работы для BSUIR/БГУИР (белорусский государственный университет информатики и радиоэлектроники).

Предмет - AiSD/АиСД (алгоритмы и структуры данных).

## Общая информация

* Каждая папка в репозитории - это отдельный проект Gradle, который должен быть открыт через IntelliJ IDEA или импортирован в Eclipse IDE с плагином Kotlin.
* Используемая версия Gradle - 8.4.
* Используемая версия Kotlin - 1.9.20.
* Используемая версия JDK - Eclipse Temurin 1.8.0_392.

## Условия работ

### Лабораторная работа 1

Необходимо разработать умную систему, которая будет принимать решения на основе различных факторов. Система должна быть способна обрабатывать информацию, предоставляемую ей в реальном времени, и осуществлять вычисления, анализировать данные и принимать решения на основе определенных критериев.

Реализовано. Программа просит ввести разные данные и в зависимости от них генерирует выход из "лабиринта" инопланетян. 3 комнаты захардкожены, остальные рандомные. Можно сказать, что программа сужает поиск на каждом шаге.

### Лабораторная работа 2

Необходимо создать редактор объектов, используя хеширование. Объекты являются контейнерами, которые могут содержать множество чисел и вложенный контейнер (или несколько вложенных контейнеров). 

Реализовано. Хеш-карта здесь не применена, потому что в качестве языка выбран Kotlin вместо Deplhi, что позволило всё разумно построить на объектах и списках. Глубина контейнеров и количество контейнеров (и чисел) на каждой глубине может быть бесконечным. В программе уже заложен пример добавки заготовленных контейнеров, а именно:

* Контейнер с контейнером с контейнером;
* Контейнер с двумя контейнерами;
* Контейнер с контейнером.

### Лабораторная работа 3

Необходимо создать бинарное дерево поиска и выполнить обходы в порядке RAB, ARB, ABR, после чего для каждого узла дерева нужно создать прошивку. Затем нужно удалить один элемент из дерева, пересобрать его и выполнить обходы и создание прошивок еще раз. 

Собственно, всё реализовано по условию. Деревья обходятся рекурсивно. Примеры чисел предлагаются при старте программы.

### Лабораторная работа 4

Необходимо создать взвешенный граф и выбрать из него две точки. Затем необходимо найти все пути между выбранными точками и выбрать самый короткий и самый длинный путь. После этого требуется определить центр графа. 

Реализовано. В качестве теста вводил значения:

* 3 узла;
* расстояния: 1 2 3 4 5 6;
* откуда: из 1;
* куда: в 2.
