# TodoService
A super simple super sweet super slick super service.

Get all Todos (should be empty at first)
```
GET -> localhost:4567/todos
```

Get a single Todo (404 at first)
```
GET -> localhost:4567/todo/:id
```

Add a Todo to the list (returns 201) (needs to be updated to use body instead of query params, but lazy)
```
POST -> localhost:4567/todo/?name=:name
```

Delete a Todo from the list (returns 204)
```
DELETE -> localhost:4567/todo/:id
```

"Hello World" (this is so simple, it should always work. Good way to test the service is running).
```
GET -> localhost:4567
```

Note: the "DATABASE" is non-existant, and it's all in memory. If you terminate the app, you lose your data. You've been warned :)


##Building the App

1. Make your code changes.
2. `./gradlew sJ`
3. java -jar build/libs/TodoService-1.0-SNAPSHOT-all.jar
