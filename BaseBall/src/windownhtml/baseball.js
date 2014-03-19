var count;
var something;
var strikeCount;
var ballCount;
var answer_1;
var answer_2;
var answer_3;
var loadSnd = new Audio("../soundnimg/Cheering .wav");
var throwSnd = new Audio("../soundnimg/Pitch Basebal.wav");
var congSnd = new Audio("../soundnimg/APPLAUSE.wav");
var loseSnd = new Audio("../soundnimg/Crowd Boo.wav");

//load 될 때
window.onload = function() {
	//초기화
	loadSnd.play();
	count = 1;
	strikeCount = 0;
	ballCount = 0;
	something = "";
	document.getElementById("challenge").value = " 차 도전 / 10회";
	
	creatAnswer();

	//숫자선택
	for (i = 1; i <= 9; i++) {
		var btn1 = document.getElementById("num" + i);
		btn1.addEventListener("click", function() {
			select(this.value);
		});
	}

	//숫자입력 후 clear버튼
	var clearBtn = document.getElementById("clear");
	clearBtn.addEventListener("click", function() {
		document.getElementById("selected_1").value = "";
		document.getElementById("selected_2").value = "";
		document.getElementById("selected_3").value = "";
	});

	//숫자입력 후 throw버튼
	var throwBtn = document.getElementById("throw");
	throwBtn.addEventListener("click", function() {
		throwBall();
		throwSnd.play();
	});

	//재시작버튼 (초기화)
	var restartBtn = document.getElementById("restart");
	restartBtn.addEventListener("click", function() {
		document.getElementById("selected_1").value = "";
		document.getElementById("selected_2").value = "";
		document.getElementById("selected_3").value = "";
		document.getElementById("results").value = "";
		document.getElementById("challenge").value = " 차 도전 / 10회";
		something = "";
		count = 1;
		creatAnswer();
	});
}

//정답값 생성(random)
function creatAnswer() {
	//   
	var answers = []

	while (true) {
		var randNum = parseInt(Math.floor(Math.random() * 10) + 1); // 1-10
		if (randNum < 10 && answers.indexOf(randNum) < 0) {
			answers.push(randNum);
		}

		if (answers.length == 3)
			break;
	}

	answer_1 = answers[0];
	answer_2 = answers[1];
	answer_3 = answers[2];

	console.log(answer_1);
	console.log(answer_2);
	console.log(answer_3);
	console.log("-------");
}

//숫자선택 후 보여주기
function select(select_num) {
	//
	var selected_1 = document.getElementById("selected_1").value;
	var selected_2 = document.getElementById("selected_2").value;
	var selected_3 = document.getElementById("selected_3").value;

	if (selected_1 == "") {
		document.getElementById("selected_1").value = select_num;
	} else if (selected_2 == "") {
		document.getElementById("selected_2").value = select_num;
	} else if (selected_3 == "") {
		document.getElementById("selected_3").value = select_num;
	}
}

//던지는 기능
function throwBall() {
	//
	document.getElementById("challenge").value = count + " 차 도전 / 10회";
	strikeCount = 0;
	ballCount = 0;

	var selected_1 = document.getElementById("selected_1").value;
	var selected_2 = document.getElementById("selected_2").value;
	var selected_3 = document.getElementById("selected_3").value;

	//동일 숫자 입력 or 빈칸 입력 경고
	if (selected_1 == "" || selected_2 == "" || selected_3 == "") {
		alert("숫자 3개를 입력하세요!")
	} else if(selected_1 == selected_2 || selected_1 == selected_3 || selected_2 == selected_3) {
		alert("같은 숫자는 입력할 수 없습니다. 다시 입력하세요!")
	} else {
		//
		//정답값 확인
		if (answer_1 == selected_1) {
			strikeCount++;
		} else if (answer_1 == selected_2 || answer_1 == selected_3) {
			ballCount++;
		}
		if (answer_2 == selected_2) {
			strikeCount++;
		} else if (answer_2 == selected_1 || answer_1 == selected_3) {
			ballCount++;
		}
		if (answer_3 == selected_3) {
			strikeCount++;
		} else if (answer_3 == selected_1 || answer_3 == selected_2) {
			ballCount++;
		}

		//textarea에서 보여주기
		something = something + selected_1 + " " + selected_2 + " "
				+ selected_3 + " --> " + "Strike :" + strikeCount + ", ball : "
				+ ballCount + "\n";
		document.getElementById("results").value = something;
		count++;

		//승패결정
		if (strikeCount == 3) {
			alert("당신이 이겼습니다!");
			congSnd.onplaying = function ()
			{
				  alert("당신이 졌습니다! 메롱^ㅜ^");
				}
			congSnd.play();
		} else if (count == 11 && strikeCount != 3) {
			loseSnd.onplaying = function ()
			{
			  alert("당신이 졌습니다! 메롱^ㅜ^");
			}
			loseSnd.play();
		}
	}
}




