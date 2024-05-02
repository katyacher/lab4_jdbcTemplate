<h3>Вариант 12 - Ювелирное изделие</h3>
 
<h2>Spring, работа с БД </h2>
 
  <p>Цель работы: ознакомиться с механизмами работы с базами данных в Spring Framework.</p>

  <h4>Общая постановка задачи. </h4>
 
 <p> В каждом варианте есть сущность базы данных. Необходимо: </p>
 	<ol>
  <li>  Описать класс сущности, который имеет как минимум три текстовых поля и два числовых (и, естественно, id). Она описывает некий товар (эта сущность и база будет использована в некоторых последующих работах).</li>
  <li>  Создать в СУБД PostgreSQL таблицу базы данных, соответствующую спроектированной сущности.
  <li>  Реализовать консольное Spring приложение (должно иметь простейший консольный пользовательский интерфейс), которое должно позволять:
    <ul>
       <li>  Вводить (консольный ввод) пользователю поля сущности и добавлять её в таблицу БД.</li>
       <li>  Выводить в консоль все записи из таблицы БД.</li>
      <li>  Редактировать запись таблицы БД по id.</li>
       <li>  Удалять запись по Id.</li>
       <li>  Осуществлять поиск по любому из признаков (на выбор студента поле для поиска). Например, поиск всех студентов, средний балл которых выше введенного пользователем).</li>
  	</ul></li>
  <li>   Способ работы с БД (JdbcTemplate, Hibernate, JPA или др.) студентом выбирается самостоятельно при одном ограничении: должен использоваться Spring Framework.</li>
 </ol>

 Сборка проекта:
 1. Скачать архив проекта
 2. Развернуть базу данных из дампа test_db.sql в вашем кластере PostgreSQL:
  psql -f test_db.sql -U postgres
  psql -d test_db -U postgres
 3. Чтобы ознакомиться с содержанием таблицы, можно выполнить следующие команды:  SELECT * FROM jewel;
 4. Зайти в директорию, содержащую файл pom.xml
 5. Открыть терминал в данной директории и выполнить команду mvn clean install spring-boot:repackage
 6. Для генерации java- документации выполнить команду mvn javadoc:javadoc
 7. Для запуска jar файла зайти в папку target, содержащую файл lab4.jar
 8. Выполнить команду java -jar lab4.jar


      
