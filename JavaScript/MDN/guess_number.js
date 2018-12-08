//
var randomNumber = Math.floor(Math.random() * 100) + 1;
//console.log(randomNumber);
var guesses = document.querySelector('.guesses');
var lastResult = document.querySelector('.lastResult');
var lowOrHi = document.querySelector('.lowOrHi');

var guessSubmit = document.querySelector('.guessSubmit');
var guessField = document.querySelector('.guessField');

var guessCount =1;
var resetButton;
guessField.focus();

function checkGuess(){
	//console.log("This is a text.");
	var userGuess = Number(guessField.value);
	if (guessCount == 1){
		guesses.textContent = 'Last time guess numb:';
	}
	guesses.textContent += userGuess +' ';
	
	if (randomNumber == userGuess) {
		lastResult.textContent = 'Congratuation, you guess right!';
		lastResult.style.backgroundColor = 'green';
		lowOrHi.textContent = '';
		setGameOver();
	} else if (guessCount == 10) {
		lastResult.textContent = '!!!Game Over!!!';
		setGameOver();
	} else {
		lastResult.textContent = 'You guess wrong!';
		lastResult.style.backgroundColor = 'red';
		if (randomNumber > userGuess ) {
			lowOrHi.textContent = 'You guess smaller.';
		} else {
			lowOrHi.textContent = 'You guess higher.';
		}
	}
	
	guessCount++;
	guessField.value = '';
	guessField.focus();
	
}

function setGameOver(){
	guessField.disabled = true;
	guessSubmit.disabled = true;
	resetButton = document.createElement('button');
	resetButton.textContent = 'Star new Game.';
	document.body.appendChild(resetButton);
	resetButton.addEventListener('click',resetGame);
}

function resetGame(){
	guessCount = 1;
	var resetParas = document.querySelectorAll('.resultParas p');
	for (var i=0;i<resetParas.length;i++){
		resetParas[i].textContent = '';
	}
	
	resetButton.parentNode.removeChild(resetButton);
	
	guessField.disabled = false;
	guessSubmit.disabled = false;
	guessField.value = '';
	guessField.focus();
	
	lastResult.style.backgroundColor = 'write';
	randomNumber = Math.floor(Math.random() * 100) +1;
}

guessSubmit.addEventListener('click',checkGuess);