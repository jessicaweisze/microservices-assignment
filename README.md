# microservices-assignment

Download Git Repository.

## Config Server

Das ist unser Config Server, die Properties Files befinden sich alle in unserem git Repository config Ordner.

Starte den Config Server:
1.  cd /config-server
2. run application ./mvnw spring-boot:run
2. Build app via mvn clean install
3. Build image: docker build -t config-server .
4. Run image: docker run -p 8888:8888 config-server

## discovery-server

In dem Eureka Discovery Service werden unsere Microservices registriert und ermöglicht somit die Kommunikation zwischen den Services.

Starte den Discovery-Service:
1.  cd /discovery-server
2. run application ./mvnw spring-boot:run
2. Build app via mvn clean install
3. Build image: docker build -t discovery-server .
4. Run image: docker run -p 8761:8761 discovery-server

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
1.  cd /todo-board-service
2. Run a MySql Database in a Docker container: docker run -e MYSQL_ROOT_PASSWORD=ThePassword -e MYSQL_USER=springuser -e MYSQL_PASSWORD=ThePassword -e MYSQL_DATABASE=db_resolution_ms -e MYSQL_ROOT_HOST=% --name mysql1 --publish 3306:3306 mysql
3. run application ./mvnw spring-boot:run
4. Build app via mvn clean install
5. Build image: docker build -t todo-board-service .
6. Run image: docker run -p 8090:8082 -e "SPRING_PROFILES_ACTIVE=mysql" todo-board-service

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