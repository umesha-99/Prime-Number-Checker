// Function to check if a number is prime
function isPrime(number) {
    // Check if the entered number is less than or equal to 1, which is not prime
    if (number <= 1) {
        return false;
    }

    // Iterate through numbers from 2 to (number - 1)
    for (let i = 2; i < number; i++) {
        // If the number is divisible by i, it's not prime
        if (number % i === 0) {
            return false;
        }
    }
    // If no divisors were found, the number is prime
    return true;
}

// Function to handle the button click event
function checkPrime() {

    // Get references to HTML elements
    const numberInput = document.getElementById('numberInput');
    const resultDiv = document.getElementById('result');

    // Parse the user's input into an integer
    const userInput = parseInt(numberInput.value);

    // Check if the input is not a valid number using is Not-a-Number function.
    if (isNaN(userInput)) {
        resultDiv.textContent = 'Please enter a valid number.';
    } else if (isPrime(userInput)) {
        // If the input is a prime number, display the result
        resultDiv.textContent = `${userInput} is a prime number.`;
    } else {
        // If the input is not a prime number, display the result
        resultDiv.textContent = `${userInput} is not a prime number.`;
    }
}

// Attach the click event handler to the button with the id 'checkButton'
document.getElementById('checkButton').addEventListener('click', checkPrime);