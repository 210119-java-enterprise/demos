window.onload = () => {

    // Dynamically create HTML elements needed for the page
    let quizDiv = document.createElement('div');
    let resultsDiv = document.createElement('div');
    let buttonDiv = document.createElement('div');
    let submitBtn = document.createElement('button');

    // Set attributes on the newly created elements
    quizDiv.setAttribute('id', 'quiz');
    resultsDiv.setAttribute('id', 'results');
    buttonDiv.setAttribute('id', 'button-container');
    buttonDiv.style.padding = '2px';
    buttonDiv.style.cssFloat = 'left';
    submitBtn.setAttribute('id', 'submit');
    submitBtn.setAttribute('class', 'btn btn-primary');

    // Add some text to display within the submit button
    submitBtn.innerText = 'Submit Quiz';

    // Add the newly created elements to the body of the page
    buttonDiv.appendChild(submitBtn);
    document.body.prepend(resultsDiv);
    document.body.prepend(buttonDiv);
    document.body.prepend(quizDiv);

    // Add event listeners for validating and grading the quiz
    buttonDiv.addEventListener('mouseover', isQuizValid);
    submitBtn.addEventListener('click', showResults);

    buildQuiz();
    
};

function buildQuiz() {
    console.log('building quiz...');
    
    // Convenience reference for our quiz div
    let quizContainer = document.getElementById('quiz');
    
    // Create an array which can hold the HTML we will eventually render
    const output = [];

    // Loop through questions to build HTML for each question
    quizQuestions.forEach((currentQuestion, questionNumber) => {

        // create an array for storing this question's answers
        const answers = [];

        // for each answer in this question create a label for it and add it to the answers array
        for (let letter in currentQuestion.answers) {
            answers.push(`
            <label>
                <input type="radio" name="question-${questionNumber}" value="${letter}"/>
                ${letter}: ${currentQuestion.answers[letter]}
            </label>
            <br/>
            `);
        }

        // add this question and its answers to the output array
        output.push(`
        <br/>
        <div class="question">${currentQuestion.question}</div>
        <div class="answers">${answers.join('')}</div>
        `);

    });

    // combine our output array into one string of HTML and put it on the page
    quizContainer.innerHTML = output.join('');

}

function isQuizValid() {
    console.log('validating quiz...');
    
    let submitBtn = document.getElementById('submit');
    let selectedAnswers = document.querySelectorAll('div.answers > label > input[name^="question-"]:checked');
    let myQuestions = document.querySelectorAll('div.question');

    if(selectedAnswers.length != myQuestions.length) {
        submitBtn.setAttribute('disabled', true);
    } else {
        submitBtn.removeAttribute('disabled');
    }
}

function showResults() {
    
    // Convenience reference for our resultsContainer
    let resultsContainer = document.getElementById('results');

    // Gather user selected answers from the quiz into an array
    let selectedAnswers = document.querySelectorAll('div.answers > label > input[name^="question-"]:checked');

    // Create a variable to keep track of the number correct
    let numCorrect = 0;

    // For each question in quizQuestions
    quizQuestions.forEach((currentQuestion, questionNumber) => {

        console.log(selectedAnswers);
        let userAnswerLabel = ((selectedAnswers[questionNumber] || {}).parentElement || {});
        let userAnswer = (selectedAnswers[questionNumber] || {}).value;

        // style user selections based on correctness
        if(userAnswer === currentQuestion.correctAnswer) {
            numCorrect++;
            (userAnswerLabel.style || {}).color = 'darkgreen';
        } else {
            (userAnswerLabel.style || {}).color = 'red';
        }
        
    });

    // Calculate the user's score
    let userScore = ((numCorrect / quizQuestions.length) * 100).toFixed(2);

    // Display the calculated score onto the page
    resultsContainer.innerText = `${numCorrect} correct out of ${quizQuestions.length} (${userScore})`;
    
}

let quizQuestions = [
    {
        question: 'Which of the following is NOT a falsy value',
        answers: {
            a: '{}',
            b: '0',
            c: '""',
            d: 'NaN'
        },
        correctAnswer: 'a'
    },
    {
        question: '7 + 7 + "7" = ?',
        answers: {
            a: 147,
            b: 21,
            c: '"777"',
            d: '"147"'
        },
        correctAnswer: 'd'
    },
    {
        question: 'NaN == NaN',
        answers: {
            a: 'true',
            b: 'false',
            c: 'undefined',
            d: 'SyntaxError'
        },
        correctAnswer: 'b'
    },
    {
        question: '!!{}',
        answers: {
            a: 'true',
            b: 'false',
            c: '{}',
            d: 'SyntaxError'
        },
        correctAnswer: 'a'
    },
    {
        question: 'Which of the following declarative keywords are subject to hoisting?',
        answers: {
            a: 'let',
            b: 'const',
            c: 'var',
            d: '(no keywords used)'
        },
        correctAnswer: 'c'
    }
];