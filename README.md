# Turnieje projekt ZSI
This is another app written to pass the university course in collaboration with @piknikowa.
This is my first independently written spring app. For the front-end we used thymeleaf templates (it was @piknikowa part).
This is also my first contact with docker. Both app image and database image are publicly available on DockerHub. Whole app can be set with the help of **docker-compose.yml** attached to project.

## App constraints
At this moment app is adapted only to 1920x1080 screen resolution.

To work proparely app **needs external mysql serve**r with following settings:
- user: user
- password: 123
- host: localhost
- port: 3306
- database name: zawodnicy

These settings can be changed by editing file **/src/main/resources/static/db.properties**

structure and example data are placed in file **/zawodnicy.sql** exported directly from our database

## Purpose of the application
The purpose of the application is to display tournament ladders taking into account indyvidual points of participants.
App consists of 3 sites:
- home page with navigation
- tournament ladder page with participants divided by weight and age category
- registration page, that allows for adding new participant to the competition
