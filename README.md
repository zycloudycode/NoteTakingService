# REST API for Note

REST API that allows users to create, update, read, and delete notes.

## Frameworks Used

- Gradle
- Spring Boot
- JPA
- H2 Database
- Junit

## Getting Started

1. Make sure nothing is running on port 80 for your Tomcat.
2. Open terminal.
3. Go to project directory.
4. Run `chmod +x gradlew`.
5. Run `./gradlew clean assemble` or `gradlew clean assemble`.
6. Run `./gradlew bootRun` or `gradlew bootRun`.
7. The API can be accessed at `http://localhost/api/notes`

## Supported Functionalities

Users can create or update a note, read one or all notes, and delete one or all notes.

### Create A New Note

Users can create a new note through `POST /api/notes`. The call returns the status code `HTTP/1.1 200` with the note added.

### Get An Existing Note

Users can get a single note through `GET /api/notes/{id}`. The call returns the status code `HTTP/1.1 200` with the requested. If a note with requested id does not exist, the call returns the status code `HTTP/1.1 404` with an error message.

### Get All Existing Notes

Users can get all notes through `GET /api/notes`. The call returns the status code `HTTP/1.1 200` with a list contains all notes.

### Get All Notes With Param

User can get all notes with bodies matching an optional parameter called query through `GET /api/notes?query=...`. The call returns the status code `HTTP/1.1 200` with a list contains all found notes.

### Update A Note

Users can get all notes through `PUT /api/notes/{id}`. The call return the status code `HTTP/1.1 200` and the updated note. If a note with requested id does not exist, the call returns the status code `HTTP/1.1 404` with an error message.

### Delete A Note

Users can delete a note through `DELETE /api/notes/{id}`. The call return the status code `HTTP/1.1 204` and delete the requested note. If a note with requested id does not exist, the call returns the status code `HTTP/1.1 404` with an error message.

### Delete All Notes

Users can delete all notes through `DELETE /api/notes`. The call return the status code `HTTP/1.1 204` and delete all notes.
