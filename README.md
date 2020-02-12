# microservices-assignment

Download Git Repository.

###Config Server

Das ist unser Config Server, die Properties Files befinden sich alle in unserem git Repository config Ordner.

Starte den Config Server:
1.  cd /config-server
2. run application ./mvnw spring-boot:run
2. Build app via mvn clean install
3. Build image: docker build -t config-server .
4. Run image: docker run -p 8888:8888 config-server

###discovery-server

In dem Eureka Discovery Service werden unsere Microservices registriert und ermöglicht somit die Kommunikation zwischen den Services.

Starte den Discovery-Service:
1.  cd /discovery-server
2. run application ./mvnw spring-boot:run
2. Build app via mvn clean install
3. Build image: docker build -t discovery-server .
4. Run image: docker run -p 8761:8761 discovery-server

###todo-board-service

Im todo-board-service ist das Resolution Item implementiert. Das Resolution Item ist ein Vorsatz mit item_id, description, status, title und user_id.
Im todo-board Service ist eine MySql Datenbank implementiert. 

| REST       | Mapping         | Description  |
| ------------- |:-------------:| ----------------:|
| getTodoList()  | /todoresolutions | Liste mit allen Vorsätzen |
| getTodoList(@PathVariable("userId")Integer userId)| /todoresolutions/{userId}      |   Liste mit allen Vorsätzen eines Users |
| getResolutionItem(@PathVariable("itemId")Integer itemId) |/resolutions/{itemId}      |    einzelner Vorsatz per Id|
| addResolutionItem(@RequestBody ResolutionItem resolutionItem) |/todoresolutions/create      |    hinzufügen eines neuen Vorsatze, die user_id muss manuell eingegeben werden(Integer) vom erstellten User|
| updateResolutionItem(@RequestBody ResolutionItem resolutionItem, @PathVariable("itemId")Integer itemId, @PathVariable("userId") String userId) |/todoresolutions/{userId}/{itemId}     |    bearbeiten eines einzelnen Vorsatzes per Id|
| deleteResolutionItem(@PathVariable("itemId")Integer itemId) |/delete/{itemId}    |    löschen eines einzelnen Vorsatzes per Id|