# TFS_QA_Homework3

DataSetGenerator class создает excel файл со случайными данными пользователей, полученных через API 

Испльзована JDK 10.0.2

- Код для компиляции:

```bash
mvn compile
```

- Код для запуска:

```bash
mvn run DataSetGenerator
```

### Работа с БД

- Код для создания таблиц

```mysql
CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `secondName` varchar(100) NOT NULL,
  `patronymicName` varchar(100) NOT NULL,
  `gender` enum('MALE','FEMALE') NOT NULL,
  `birthDate` date NOT NULL,
  `ruTIN` char(12) NOT NULL,
  `country` varchar(100) NOT NULL,
  `region` varchar(100) NOT NULL,
  `zip` int(10) UNSIGNED NOT NULL,
  `city` varchar(100) NOT NULL,
  `street` varchar(100) NOT NULL,
  `house` varchar(10) NOT NULL,
  `flat` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `users` ADD PRIMARY KEY (`id`);
ALTER TABLE `users` ADD FULLTEXT KEY `firstName` (`firstName`,`secondName`,`patronymicName`);
```

- Данные для подключения хранятся в файле:

```bash
resources/db.properties
```
