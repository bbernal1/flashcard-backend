
## Flashcard Application using Java
The backend API can be accessed via the following URLs:  
https://jpflashcards.herokuapp.com/flashcards

This is a pet project to display skills in using Java and Angular to create a fullstack application. I personally have an interest in learning Japanese and discovered Spaced Repetition applications such as Anki and Memrise which help in learning vocabulary. Therefore, I thought I could combine my passion for programming and create an application of my own that uses a Spaced Repetition algorithm to help me learn Japanese. This app is primarily for learning purposes and as a result will be constantly changing as my skills in Java increase.

This application is used to retrieve data from a MongoDB database which persists the flashcard information. This application then uses RESTful APIs to send the required data to the frontend Angular application which is found at https://github.com/bbernal1/flashcard-frontend

#### The MongoDB Document structure is as follows:
ObjectId id;
String word;
String translation;
 Double easiness;
Int32 repetitions;
Int32 interval;
TimeStamp dueDate;

#### The class that maps to the MongoDB document:
com.jpcards.backend.domain.Flashcard

#### Instructions for running program
1. Git clone project
2. Import as Maven project.
3. Run Frontend Application at https://github.com/bbernal1/flashcard-frontend
3. Run spring boot application which contains embedded application server.

## Features
### Retrieve All Cards API
Any URL should redirect to Homepage. This page contains information about the app and links to the Card Review mode and SRS Review mode
### Review All Cards
This section of the application will review all cards

### Review Scheduled Cards
This section will review cards that are due today or past due

### Version History
version 0.1.0
Started project and created MongoDB database

version 0.2.0
Added domain class 

version 0.3.0
Added API for retrieving all cards in database


