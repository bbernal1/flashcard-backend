## Flashcard Application backend using Java
### Summary
This is a pet project to display skills in using Java and Angular to create a fullstack application. I have an interest in learning Japanese and discovered spaced repetition(SRS) flashcard applications such as Anki and Memrise which help in learning the language. Therefore, I decided to create my own SRS flashcard application in order to practice my programming skills and relate it to my interest in Japanese language learning.

**The backend API is hosted and the data can be accessed/modified via the following URLs:**  
GET:
https://jpflashcards.herokuapp.com/flashcards
This URL is used to retrieve all of the flashcards in the 

DELETE:
https://jpflashcards.herokuapp.com/flashcards/flashcards/{id}
This URL is used to delete a card that has the {id} number

POST:
https://jpflashcards.herokuapp.com/flashcards
This URL is used to add a new flashcard to the database

PUT:
https://jpflashcards.herokuapp.com/flashcard/{quality}
This URL is used to update the flashcard that is passed in the request body with a new {quality} rating

**The associated frontend application can be found at https://github.com/bbernal1/flashcard-frontend**

### Program Structure
The program is written using the Sprint Boot framework with support for MongoDB database operations. The Flashcard class models a document in the collection in the Flashcards database. The CRUD methods in the controller are used to retrieve, modify, and delete documents from the collection.

**Class:** com.jpcards.backend.BackendApplication.java  
**Description:** This class is responsible for running the Spring Boot application

**Class:** com.jpcards.backend.restservice.FlashcardController.java  
**Description:** This class is annotated with @RestController and it contains the handler methods for the API calls.

**Class:** com.jpcards.backend.repository.CardRepository.java  
**Description:** This class extends the MongoRepository class which has default CRUD methods for a mongoDB collection

**Class:** com.jpcards.backend.domain.Flashcard.java  
**Description:** This class contains the @Document annotation with the name of the collection, named 'jp', in the mongoDB database. The class properties matches the MongoDB document structure for the flashcards along with getters and setters for these properties.

**Class:** com.jpcards.backend.algo.Sm2Impl.java  
**Description:** This class contains methods used in the calculation of due dates for the card review feature. The review due dates are calculated using the SM2 Algorithm from https://www.supermemo.com/en/archives1990-2015/english/ol/sm2. An implementation of the algorithm is discussed in the following section

### Algorithm
1. Calculate and store the new easiness rating for the card. The easiness rating is calculated using a quality value which is retrieved from https://jpflashcards.herokuapp.com/flashcard/{quality}. The formula used is: easiness = Math.min(Math.max(1.3, easiness + 0.1 - (5.0 - {quality}) * (0.08 + (5.0 - {quality}) * 0.02)),2.5)
2. Calculate the new repetition value for the card. The repetition is calculated by the following:  
if (quality < 3) {  
    reptition = 0  
}  
else {  
    repetitions = repetitions + 1  
}  
3. Calculate the new intervval value for the card. The interval is the amount of days that must pass until the card is due for review. The interval is calculated by the following:  
if (repetitions <= 1) {  
    interval = 1;  
}  
else if (reps == 2) {  
    this.flashcard.setInterval(6);  
}  
else {  
    this.flashcard.setInterval((int)Math.round(this.flashcard.getInterval() * this.flashcard.getEasiness()));  
}  
4. Calculate and set the new due date by the following:  
dueDate = dueDate + interval

### MongoDB Database structure
The database name is 'Flashcards'. The Flashcards database has one collection in it called 'jp'. The idea is to have one collection represent one deck of flashcards. The collection contains documents that have the following fields:  
ObjectId id;  
String word;  
String translation;  
Double easiness;  
Int32 repetitions;  
Int32 interval;  
TimeStamp dueDate;

### Version History
version 0.1.0  
Started project and created MongoDB database

version 0.2.0  
Added domain class 

version 0.3.0  
Added API for retrieving all cards in database

version 1.0.0  
Major features of application are finished


