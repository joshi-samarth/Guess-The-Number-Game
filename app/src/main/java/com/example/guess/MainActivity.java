package com.example.guess;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int randomNumber;
    private int remainingAttempts = 4;
    private EditText guessEditText;
    private TextView resultTextView;
    private TextView attemptsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessEditText = findViewById(R.id.guessEditText);
        resultTextView = findViewById(R.id.resultTextView);
        attemptsTextView = findViewById(R.id.attemptsTextView);

        // Generate a random number between 1 and 20
        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;

        // Display initial attempts count
        updateAttemptsLabel();

        Button guessButton = findViewById(R.id.guessButton);
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });

        Button showNumberButton = findViewById(R.id.showNumberButton);
        showNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumber();
            }
        });
    }

    private void checkGuess() {
        if (remainingAttempts > 0) {
            String guessText = guessEditText.getText().toString();

            if (!guessText.isEmpty()) {
                int userGuess = Integer.parseInt(guessText);

                if (userGuess == randomNumber) {
                    resultTextView.setText("Congratulations! You guessed the correct number!");
                    disableGuessButton();
                } else if (userGuess < randomNumber) {
                    resultTextView.setText("Your guessed number is small. Please enter a higher number!");
                } else {
                    remainingAttempts--;
                    updateAttemptsLabel();
                    if (remainingAttempts > 0) {
                        resultTextView.setText("Your guessed number is high. Please enter a lower number!");
                    } else {
                        resultTextView.setText("Sorry, you've run out of attempts. The correct number was " + randomNumber);
                        disableGuessButton();
                    }
                }
            } else {
                resultTextView.setText("Please enter a valid number");
            }
        } else {
            resultTextView.setText("Sorry, you've run out of attempts. The correct number was " + randomNumber);
            disableGuessButton();
        }
    }

    private void showNumber() {
        resultTextView.setText("The correct number is " + randomNumber);
        disableGuessButton();
    }

    private void updateAttemptsLabel() {
        attemptsTextView.setText("Attempts remaining: " + remainingAttempts);
    }

    private void disableGuessButton() {
        Button guessButton = findViewById(R.id.guessButton);
        guessButton.setEnabled(false);
    }
}
