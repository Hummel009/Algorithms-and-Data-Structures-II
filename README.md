[![Code Smells][code_smells_badge]][code_smells_link]
[![Maintainability Rating][maintainability_rating_badge]][maintainability_rating_link]
[![Security Rating][security_rating_badge]][security_rating_link]
[![Bugs][bugs_badge]][bugs_link]
[![Vulnerabilities][vulnerabilities_badge]][vulnerabilities_link]
[![Duplicated Lines (%)][duplicated_lines_density_badge]][duplicated_lines_density_link]
[![Reliability Rating][reliability_rating_badge]][reliability_rating_link]
[![Quality Gate Status][quality_gate_status_badge]][quality_gate_status_link]
[![Technical Debt][technical_debt_badge]][technical_debt_link]
[![Lines of Code][lines_of_code_badge]][lines_of_code_link]

Мои лабораторные работы для BSUIR/БГУИР (белорусский государственный университет информатики и радиоэлектроники).

Предмет - AiSD/АиСД (алгоритмы и структуры данных).

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

<!----------------------------------------------------------------------------->

[code_smells_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=code_smells

[code_smells_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II

[maintainability_rating_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=sqale_rating

[maintainability_rating_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II

[security_rating_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=security_rating

[security_rating_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II

[bugs_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=bugs

[bugs_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II

[vulnerabilities_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=vulnerabilities

[vulnerabilities_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II

[duplicated_lines_density_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=duplicated_lines_density

[duplicated_lines_density_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II

[reliability_rating_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=reliability_rating

[reliability_rating_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II

[quality_gate_status_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=alert_status

[quality_gate_status_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II

[technical_debt_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=sqale_index

[technical_debt_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II

[lines_of_code_badge]: https://sonarcloud.io/api/project_badges/measure?project=Hummel009_Algorithms-and-Data-Structures-II&metric=ncloc

[lines_of_code_link]: https://sonarcloud.io/summary/overall?id=Hummel009_Algorithms-and-Data-Structures-II
