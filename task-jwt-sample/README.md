# Testing with and without Authentication
## Step 1 - Create sample REST Controller with Storage APIs for Tasks
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

## Now add User Authorization/Authentication

Add dependency
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt -->
		<dependency>
		    <groupId>io.jsonwebtoken</groupId>
		    <artifactId>jjwt</artifactId>
		    <version>0.7.0</version>
		</dependency>
```

### Testing with Authentication and Authorization

Unauthenticated Request
```sh
curl http://localhost:8080/tasks

Result - {"timestamp":1513902888852,"status":403,"error":"Forbidden","message":"Access Denied","path":"/tasks"} 
```

New User Registration
```sh
curl -H "Content-Type: application/json" -X POST -d '{"username":"prafull", "password":"password"}' http://localhost:8080/users/sign-up

Result - 200 OK 
```

Login with New User now
```sh
curl -i -H "Content-Type: application/json" -X POST -d '{"username":"prafull", "password":"password"}' http://localhost:8080/login

Result - 200 OK 
ALong with a Response Header 
Authorization → Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwcmFmdWxsIiwiZXhwIjoxNTE0NzY3NzYwfQ.NfeBTIqz8BYo0pxCtk1QceSzR9Gl3iMNKi3ZShXjCm5Sj-8Q7SNn88phmZUiSpqaR9dWOfoMDoKTCSJZXTU5LA
```

Issue Get call with Authorization Header now -
```sh
curl -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwcmFmdWxsIiwiZXhwIjoxNTE0NzY3NzYwfQ.NfeBTIqz8BYo0pxCtk1QceSzR9Gl3iMNKi3ZShXjCm5Sj-8Q7SNn88phmZUiSpqaR9dWOfoMDoKTCSJZXTU5LA" -X POST -d '{"description": "Buy watermelon"}'  http://localhost:8080/tasks

Result - 200 OK, Description for the task is inserted now.
```

### Reference
https://dzone.com/articles/implementing-jwt-authentication-on-spring-boot-api[https://dzone.com/articles/implementing-jwt-authentication-on-spring-boot-api]
