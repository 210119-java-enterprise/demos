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

async function buildQuiz() {
    console.log('building quiz...');

    let questionPromise = await getQuestions;
    let questions = await questionPromise();
    
    // Convenience reference for our quiz div
    let quizContainer = document.getElementById('quiz');
    
    // Create an array which can hold the HTML we will eventually render
    const output = [];

    // Loop through questions to build HTML for each question
    questions.forEach((currentQuestion, questionNumber) => {

        // create an array for storing this question's answers
        const answers = [];

        // for each answer in this question create a label for it and add it to the answers array
        for (let letter in currentQuestion['questionAnswers']) {
            answers.push(`
            <label>
                <input type="radio" name="question-${questionNumber}" value="${letter}"/>
                ${letter.charAt(letter.length - 1).toLowerCase()}: ${currentQuestion['questionAnswers'][letter]}
            </label>
            <br/>
            `);
        }

        // add this question and its answers to the output array
        output.push(`
        <br/>
        <div class="question">${currentQuestion['questionText']}</div>
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

async function showResults() {

    let questionPromise = await getQuestions;
    let questions = await questionPromise();
    
    // Convenience reference for our resultsContainer
    let resultsContainer = document.getElementById('results');

    // Gather user selected answers from the quiz into an array
    let selectedAnswers = document.querySelectorAll('div.answers > label > input[name^="question-"]:checked');

    // Create a variable to keep track of the number correct
    let numCorrect = 0;

    // For each question in quizQuestions
    questions.forEach((currentQuestion, questionNumber) => {

        let userAnswerLabel = ((selectedAnswers[questionNumber] || {}).parentElement || {});
        let userAnswerUnmod = (selectedAnswers[questionNumber] || {}).value;
        let userAnswer = userAnswerUnmod.charAt(userAnswerUnmod.length - 1).toLowerCase();


        // style user selections based on correctness
        if(userAnswer === currentQuestion.correctAnswer) {
            numCorrect++;
            (userAnswerLabel.style || {}).color = 'darkgreen';
        } else {
            (userAnswerLabel.style || {}).color = 'red';
        }
        
    });

    // Calculate the user's score
    let userScore = ((numCorrect / questions.length) * 100).toFixed(2);

    // Display the calculated score onto the page
    resultsContainer.innerText = `${numCorrect} correct out of ${questions.length} (${userScore})`;
    
}

let getQuestions = (async function() {

    let myQuestions;

    // using a closure to eliminate the need for a global variable 
    // and for passing questions around as a parameter everywhere
    return async function() {
        if(myQuestions) {
            console.log('questions already fetched. not doing it again...');
            return myQuestions;
        } else {

            try {
                console.log('fetching questions for the first time!')
                // you CANNOT use the 'await' keyword outside of an async function
                let response = await fetch('http://quizzardapi-env-1.eba-3m7rumy3.us-east-1.elasticbeanstalk.com/questions');
                myQuestions = await response.json();
                console.log(myQuestions);
                return myQuestions;
            } catch {
                console.error('Could not retrieve data from API!');
            }
        }
    }

})();

// AJAX implementation
// function retrieveQuestions() {
    
//     console.log('fetching quiz questions...');
//     let xhr = new XMLHttpRequest();
//     xhr.open('GET', 'http://quizzardapi-env-1.eba-3m7rumy3.us-east-1.elasticbeanstalk.com/questions');
//     xhr.send();
//     xhr.onreadystatechange = function () {
//         if (xhr.readyState === 4 && xhr.status === 200) {
//             quizQuestions = JSON.parse(xhr.responseText);
//             buildQuiz();
//         }
//     }
// }
