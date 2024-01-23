[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=code_smells)](https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=sqale_rating)](https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=security_rating)](https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=bugs)](https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=vulnerabilities)](https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=duplicated_lines_density)](https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=reliability_rating)](https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=alert_status)](https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=sqale_index)](https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=ncloc)](https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II)

Мои лабораторные работы для BSUIR/БГУИР (белорусский государственный университет информатики и радиоэлектроники).

Предмет - AiSD/АиСД (алгоритмы и структуры данных).

## Общая информация

Этот репозиторий - проект Gradle, который должен быть открыт через IntelliJ IDEA.

| Технология                                    | Версия |
|-----------------------------------------------|--------|
| Версия системы автоматической сборки Gradle   | 8.5    |
| Версия Java, используемая для запуска Gradle  | 8+     |
| Версия Java, используемая для запуска проекта | 8+     |
| Версия Java, используемая для сборки проекта  | 8+     |
| Версия Kotlin                                 | 1.9.22 |

## Установка

Установка моих проектов Gradle и основы работы с ними примерно одинаковы, так что
смотрите [общую инструкцию](https://github.com/Hummel009/The-Rings-of-Power#readme).

## Условия

### Лабораторная работа 1

Необходимо разработать умную систему, которая будет принимать решения на основе различных факторов. Система должна быть
способна обрабатывать информацию, предоставляемую ей в реальном времени, и осуществлять вычисления, анализировать данные
и принимать решения на основе определенных критериев.

Реализовано. Программа просит ввести разные данные и в зависимости от них генерирует выход из "лабиринта" инопланетян. 3
комнаты захардкожены, остальные рандомные. Можно сказать, что программа сужает поиск на каждом шаге.

### Лабораторная работа 2

Необходимо создать редактор объектов, используя хеширование. Объекты являются контейнерами, которые могут содержать
множество чисел и вложенный контейнер (или несколько вложенных контейнеров).

Реализовано. Хеш-карта здесь не применена, потому что в качестве языка выбран Kotlin вместо Deplhi, что позволило всё
разумно построить на объектах и списках. Глубина контейнеров и количество контейнеров (и чисел) на каждой глубине может
быть бесконечным. В программе уже заложен пример добавки заготовленных контейнеров, а именно:

* Контейнер с контейнером с контейнером;
* Контейнер с двумя контейнерами;
* Контейнер с контейнером.

### Лабораторная работа 3

Необходимо создать бинарное дерево поиска и выполнить обходы в порядке RAB, ARB, ABR, после чего для каждого узла дерева
нужно создать прошивку. Затем нужно удалить один элемент из дерева, пересобрать его и выполнить обходы и создание
прошивок еще раз.

Собственно, всё реализовано по условию. Деревья обходятся рекурсивно. Примеры чисел предлагаются при старте программы.

### Лабораторная работа 4

Необходимо создать взвешенный граф и выбрать из него две точки. Затем необходимо найти все пути между выбранными точками
и выбрать самый короткий и самый длинный путь. После этого требуется определить центр графа.

Реализовано. В качестве теста вводил значения:

* 3 узла;
* расстояния: 1 2 3 4 5 6;
* откуда: из 1;
* куда: в 2.
