# Turnieje projekt ZSI
This is another application written to pass a university course, developed in collaboration with @piknikowa.
It is my first independently written Spring application. For the front end, we used Thymeleaf templates (this part was handled by @piknikowa).
It is also my first experience with Docker. Both the application image and the database image are publicly available on DockerHub. The entire application can be set up using the **docker-compose.yml** file included in the project.

## App constraints
At this moment app is adapted only to 1920x1080 screen resolution.

To work properly app **requires an external MySQL server** with following settings:
- user: user
- password: 123
- host: localhost
- port: 3306
- database name: zawodnicy

These settings can be changed by editing file **/src/main/resources/static/db.properties**

The database structure and example data are stored in **/zawodnicy.sql** exported directly from our database

## Purpose of the application
The purpose of the application is to display tournament ladders taking into account individual points of participants.
App consists of 3 sites:
- *Home page* - with navigation
- *Tournament ladder page* - with participants divided by weight and age category
- *Registration page* - allowing for adding new participant to the competition
