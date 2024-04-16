# Guess The Number Game Created By Samarth Joshi
The Java code defines a class called MainActivity that extends AppCompatActivity. This class contains code for generating a random number and checking user guesses in an Android app. The XML code defines the user interface for the app, including a text view for instructions, an edit text for entering the guess, a button for submitting the guess, a text view for displaying the number of remaining attempts, a button for displaying the random number, and a text view for displaying the result of the user's guess.

Here's a breakdown of how the Java and XML code work together:

The MainActivity class initializes the activity by setting the content view to `activity_main.xml`. This tells the app to use the layout defined in the XML file for the user interface.<br>
The MainActivity class finds the views for the EditText, TextView, and Button widgets by calling findViewById and passing in the id of each view. This allows the Java code to interact with the views in the user interface.<br>
The MainActivity class generates a random number between 1 and 20 and displays the initial attempts count in the attemptsTextView.<br>
When the user clicks the guessButton, the checkGuess method is called. This method checks the user's guess against the random number and updates the resultTextView and attemptsTextView accordingly.<br>
When the user clicks the `showNumberButton`, the `showNumber` method is called. This method displays the random number and disables the `guessButton`.<br>
The `updateAttemptsLabel` method updates the attemptsTextView with the current number of remaining attempts.<br>
The `disableGuessButton` method disables the guessButton.<br>
In summary, the Java code defines the logic for generating a random number and checking user guesses, while the XML code defines the user interface for the app. The Java code interacts with the user interface by finding the views in the XML file and updating them as needed. Together, the Java and XML code create a complete Android app that generates a random number and allows the user to guess the number.
