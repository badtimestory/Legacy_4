// 전역 변수
const id = document.getElementById('id');
const idResult = document.getElementById('idResult');

const pw = document.getElementById('pw');
const pw2 = document.getElementById('pw2');
const pwResult = document.getElementById('pwResult');
const pwResult2 = document.getElementById('pwResult2');

const name = document.getElementById('name');
const phone = document.getElementById('phone');
const email = document.getElementById('email');
const nameResult = document.getElementById('nameResult');
const phoneResult = document.getElementById('phoneResult');
const emailResult = document.getElementById('emailResult');


const frm = document.getElementById('frm');
const btn = document.getElementById('btn');

let idCheck = false;  // check OK : true
let pwCheck = false;  // check X : false
let nameCheck = false;
let phoneCheck = false;
let emailCheck = false;

id.addEventListener('blur', function() {
  idCheck = false;
  let v = id.value;

  if(v == "") { // v.length == 0)
    idResult.innerHTML = "ID를 입력하세요";
    idCheck == false;
  } else {
    idResult.innerHTML = "확인";
    idCheck = true;
  }
});

pw.addEventListener('keyup', function() {
  let length = pw.value.length;
  let message = "잘못된 비밀번호";
  if(length >= 8 && length <= 12) {
    message = "올바른 비밀번호";
  }
  pwResult.innerHTML = message;
});

pw.addEventListener('change', function() {
  pwCheck = false;
  pw2.value = '';
  pwResult2.innerHTML='';
  pw2.focus();
});


pw2.addEventListener('blur', function(){
  let v1 = pw.value;
  let v2 = pw2.value;
  let message = "비밀번호가 일치하지 않습니다.";
  if(v1 == v2) {
    message = "비밀번호가 일치합니다."
    pwCheck = true;
  } else {
    pwCheck = false;
  }
  pwResult2.innerHTML = message;
});

name.addEventListener('blur', function() {
  if(name.value == "") {
    nameCheck = false;
    nameResult.innerHTML = "이름을 입력하세요";
  } else {
    nameCheck = true;
  }
});

phone.addEventListener('blur', function() {
  if(phone.value == "") {
    phoneCheck = false;
    phoneResult.innerHTML = "전화번호를 입력하세요";
  } else {
    phoneCheck = true;
  }
});

email.addEventListener('blur', function() {
  if(email.value == "") {
    emailCheck = false;
    emailResult.innerHTML = "이메일을 입력하세요";
  } else {
    emailCheck = true;
  }
});

btn.addEventListener('click', function() {
  if(idCheck && pwCheck && nameCheck && phoneCheck && emailCheck) {
    frm.submit();
  } else {
    alert('필수요건을 확인하세요');
  }
});

