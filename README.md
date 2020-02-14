# microservices-assignment

> Unsere Application ermöglicht es verschiedenen Usern Vorsätze anzulegen, die sie erledigen wollen. Jeder User kann Vorsätze anlegen, anschauen, bearbeiten und löschen. Außerdem kann er sich alle Vorsätze von allen Usern anschauen, um sich inspirieren zu lassen. Desweiteren gibt es die Möglichkeit einen neuen User hinzuzufügen oder bestehende zu löschen. 

## Project Requirements 

**1. 3 microservices**
* todo-board-service

  > Vorsätze 
* user-service
  > User 
* success-board-service / UI Service

  > User und Vorsätze zusammenführen + UI

**2. communication between 2 microservices**
* Im success-board-service wird mit den beiden Microservices user-service und Todo-board-service kommuniziert.

**3. use of a database** 
* Im user-service wird eine Postgres Datenbank genutzt
* Im todo-board-service wird eine MySQL Datenbank genutzt

**4. implementation of 2 resilience patterns**
  > Im success-board-service sind folgende Resilience Patterns implementiert:
* Circuit Breaker Pattern (Fallback) und 
* Retry Pattern

**5. demonstrate/show scaling capabilities**
* Open Feign implementiert
* Jeder Service hat ein Dockerfile und kann in einem Docker Container laufen
* DB laufen in einem Docker Container
* Mehrere Instanzen können laufen --> Instanz wird automatisch gewählt
* URL ist kein Hinderniss --> Services können über den Namen kommunizieren

**6. use of spring cloud services**
* Euraka Discovery Service
* Spring Config


**To Dos und die einzelnen Microservices:**

Download Git Repository.

## Config Server

Das ist der Config Server, die Properties Files befinden sich alle in dem git Repository configs Ordner.

Starte den Config Server:
1. `cd /config-server`
2. Build app via `mvn clean install`
3. Build image: `docker build -t config-server .`
4. Run image: `docker run -p 8888:8888 config-server`

## discovery-server

In dem Eureka Discovery Service werden unsere Microservices registriert und ermöglicht somit die Kommunikation zwischen den Services.

Starte den Discovery-Service:
1. `cd /discovery-server`
2. Build app via `mvn clean install`
3. Build image: `docker build -t discovery-server .`
4. Run image: `docker run -p 8761:8761 discovery-server`

## todo-board-service

Im todo-board-service ist das Resolution Item implementiert. Das Resolution Item ist ein Vorsatz mit item_id, description, status, title und user_id.
Im todo-board Service ist eine MySql Datenbank implementiert. 

| REST       | Mapping         | Description  |
| ------------- |-------------| ----------------|
| getTodoList()  | /todoresolutions | Liste mit allen Vorsätzen |
| getTodoList(@PathVariable("userId")Integer userId)| /todoresolutions/{userId}      |   Liste mit allen Vorsätzen eines Users |
| getResolutionItem(@PathVariable("itemId")Integer itemId) |/resolutions/{itemId}      |    einzelner Vorsatz per Id|
| addResolutionItem(@RequestBody ResolutionItem resolutionItem) |/todoresolutions/create      |    hinzufügen eines neuen Vorsatze, die user_id muss manuell eingegeben werden(Integer) vom erstellten User|
| updateResolutionItem(@RequestBody ResolutionItem resolutionItem, @PathVariable("itemId")Integer itemId, @PathVariable("userId") String userId) |/todoresolutions/{userId}/{itemId}     |    bearbeiten eines einzelnen Vorsatzes per Id|
| deleteResolutionItem(@PathVariable("itemId")Integer itemId) |/delete/{itemId}    |    löschen eines einzelnen Vorsatzes per Id|

Starte den todo-board-Service:
1. `cd /todo-board-service`
2. Run a MySql Database in a Docker container: `docker run -e MYSQL_ROOT_PASSWORD=ThePassword -e MYSQL_USER=springuser -e MYSQL_PASSWORD=ThePassword -e MYSQL_DATABASE=db_resolution_ms -e MYSQL_ROOT_HOST=% --name mysqlDocker --publish 3306:3306 mysql`
3. Build app via `mvn clean install`
4. Build image: `docker build -t todo-board-service .`
5. Run image: `docker run -p 8090:8082 -e "SPRING_PROFILES_ACTIVE=mysql" todo-board-service`

## user-service

Im User-Service ist der User implementiert. Das ResolutionUser Model definiert den User mit res_user_id und res_user_name.
Im USer Service ist eine PostgreSQL Datenbank implementiert.

| REST       | Mapping         | Description  |
| ------------- |-------------| ----------------|
| getUserList() | /users | Liste mit allen Usern |
| Optional<ResolutionUser> getUser(@PathVariable("userId") Integer userId)| /users/{userId}    |Einzelner User |
| addUser(@RequestBody ResolutionUser resolutionUser) |/users/add|hinzufügen eines einzelnen Users|
| updateResolutionItem(@RequestBody ResolutionUser resolutionUser, @PathVariable("userId") Integer userId) |/users/update/{userId}    |bearbeiten eines einzelnen Users per Id|
| deleteResolutionItem(@PathVariable("userId") Integer userId) |/users/delete/{userId}|löschen eines einzelnen Users per Id|

Starte den user-Service:
1. `cd /user-service`
2. Run a Postgres Database in a Docker container: `docker run -e POSTGRES_USER=springuser -e POSTGRES_PASSWORD=Password -e POSTGRES_DB=db_user_ms --name postgresDocker --publish 5432:5432 postgres`
3. Build app via `mvn clean install`
4. Build image: `docker build -t user-service .`
5. Run image: `docker run -p 8070:8083 -e "SPRING_PROFILES_ACTIVE=postgres" user-service`

## success-board-service / ui-service

Der success-board-service führt die anderen beiden Services in einer UI zusammen. Um die Ui umzusetzten wird Thymeleaf genutzt.

| REST       | Mapping         | Description  |
| ------------- |-------------| ----------------|
| showIndex() | / | Startseite |
| showAllUser(Model model)| /resolutionuser|Liste alles User|
| createNewUser(Model model) |/resolutionuser/createUser|hinzufügen eines neuen Users|
| saveNewUser(@ModelAttribute("resolutionUser") ResolutionUser resolutionUser) |/resolutionuser/saveUser    |neuen User in DB speichern|
| findAllResolutions(Model model) |/resolutionuser/all|Liste alles Vorsätze|
| createNewResolution(Model model) |/resolutionuser/create|hinzufügen eines neuen Vorsatzes|
| saveResolution(@ModelAttribute("resolutionItem") ResolutionItem resolutionItem) |/resolutionuser/save|neuen Vorsatz in der DB speichern|
| findRatingById(@PathVariable("userId") Integer userId, Model model) |/resolutionuser/{userId}|Vorsätze pro User anzeigen|
| ModelAndView showEditItemPage(@PathVariable("itemId") Integer itemId) |/resolutionuser/update/{itemId}|Einzelnen Vorsatz bearbeiten|
| deleteItem(@PathVariable("itemId") Integer itemId, HttpServletRequest request) |/resolutionuser/delete/{itemId}|einzelnen Vorsatz löschen|
| deleteUser(@PathVariable("userId") Integer userId, HttpServletRequest request) |/resolutionuser/deleteUser/{userId}|einzelnen User löschen|


Starte den success-board-Service:
1. `cd /success-board-service`
2. Build app via `mvn clean install`
3. Build image: `docker build -t success-board-service .`
4. Run image: `docker run -p 8080:8081 success-board-service`
5. Visit `http://localhost:8080`



