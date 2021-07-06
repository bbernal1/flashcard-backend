
## Flashcard Application backend using Java
## The associated frontend application can be found at https://github.com/bbernal1/flashcard-backend
## The backend API is hosted and the data can be accessed via the following URLs:
https://jpflashcards.herokuapp.com/flashcards



This application is used to retrieve data from a MongoDB database via the aforementioned URLs. 

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

version 1.0.0  
Major features of application are finished


