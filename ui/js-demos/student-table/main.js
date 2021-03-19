let idCounter = 1;

window.onload = function() {
    console.log("testtttt")
}

function* idGenerator() {
    while(true) {
        yield idCounter++;
    }
}


function addStudent() {

    // Get input field values
    let studentNameInputField = document.getElementById('student-name');
    let studentName = studentNameInputField.value;
    let studentMajor = document.getElementById('student-major').value;

    // Validate the values (ensure they are not empty strings)
    if (studentName && studentMajor) {

        // Create a row and cells for the students table
        let row = document.createElement('tr');
        let studentIdCell = document.createElement('td');
        let studentNameCell = document.createElement('td');
        let studentMajorCell = document.createElement('td');

        // Append cells to the row
        row.appendChild(studentIdCell);
        row.appendChild(studentNameCell);
        row.appendChild(studentMajorCell);

        // Append the row to the pre-existing table
        document.getElementById('student-table-body').appendChild(row);

        // Add student info to the newly appended row
        studentIdCell.innerText = idGenerator().next().value;
        studentNameCell.innerText = studentName;
        studentMajorCell.innerText = studentMajor;

        // Clear the input for the fields, for future values to be provided
        studentNameInputField.value = '';
        document.getElementById('student-major').value = '';
    }

}

// Create an event listener that will fire off when the button is clicked
document.getElementById('add-student').addEventListener('click', addStudent); // <--- example of a callback