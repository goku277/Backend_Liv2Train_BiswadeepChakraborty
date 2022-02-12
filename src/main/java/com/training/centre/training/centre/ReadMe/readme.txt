Firstly, I have constructed the essential packages to create this amazing training center project.
These packages are : Entity, Repo, Controller, Services, Model -> DAO (Used as the request body to isolate the Entity and the
db related data like columns)

There is one-to-one mapping from Address entity to Training entity, so the primary key of Address Entity served as the
foreign key in the Training Entity, in order to fulfil the POST API ACTION -> to insert and save the data to the database.

The interfaces AddressRepo and TrainingCenterRepo.

DAO and DTO are the two Request body and the response body used in the service layer.

Converter package contains few classes that work as a converter in this project to change the entity to dao and dto
respectively and vice-versa.

Controller -> TrainingCenterController -> The REST APIs are created and here and the spring validation annotation
is also used there (@Valid)

Exception handling is used here -> Spring framework's @ExceptionHandling is used
The inbuilt ExceptionHandling used in this project are -> InputMismatch, ArrayBoundsOutOfException, NumberFormatException

The Custom response ErrorResponseHandler is used to create a error response model and this class is being manipulated by the
@ExceptionHandler


Steps to setup this project:

1 -> Please clone or download and extract this project in your local directory

2 -> Please open your intellij ide -> then click open project, browse project's location select the black-marked folder
from the file chooser. Then open the project in your intellij ide, successfully.

3 -> On successful importing the dependencies will be downloaded by the Ide itself.

4 -> Postgresql can be configured in the system as per the username and password respectively.

5 -> The please run the project using -> 1. mvn clean install from the terminal(linux/ubuntu), or from the cmd(windows10)
                                         2. java -jar target/<<project_name>>_SNAPSHOT.jar

                                         or by simply right click and running the Application.java class which is
                                         outside of the every internal packages that are created here in this project.
6 -> The postman collection is also attached here in this  project, to test and verify the backend-features.