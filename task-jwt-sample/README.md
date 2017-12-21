# Step 1
## Create sample REST COntroller with Storage APIs for Tasks
No Dependency on Security needed for now.
On Root folder execute following command to start the server
```sh
./mvnw spring-boot:run
```

Execute following to check running application from Terminal
GET Tasks
```sh
curl http://localhost:8080/tasks

Response - []
```

POST Task
```sh
curl -H "Content-Type: application/json" -X POST -d '{ "description": "Buy some milk(shake)"}' http://localhost:8080/tasks

Response - {"id":1,"description":"Buy some milk(shake)"}
```

GET Tasks
```sh
curl http://localhost:8080/tasks

Response - [{"id":1,"description":"Buy some milk(shake)"}]
```

GET Task with id 1
```sh
curl http://localhost:8080/tasks/1

Response - {"id":1,"description":"Buy some milk(shake)"}
```