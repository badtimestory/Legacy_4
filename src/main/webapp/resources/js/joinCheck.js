const checkAll = document.getElementById('checkAll');
const check = document.getElementsByClassName('check');
const btn = document.getElementById('btn');
const rules = document.getElementById('rules');

// 전체동의 체크
checkAll.addEventListener('click', function() {
  for(c of check) {
    c.checked = checkAll.checked;
  }  
});

// 전부 동의체크하면 전체동의에 체크
// for(ch of check) {
//   ch.addEventListener('click', function() {
//     let final = true;

//     // 체크가 다되있으면 if문에 안들어옴
//     for(c of check){
//       if(!c.checked){
//         final = false;
//       }
//     }
//     checkAll.checked=final;
//   });
// }

// 전부 동의체크하면 전체동의에 체크
rules.addEventListener('click', function() {
	let final = true;
	
	for(c of check) {
		if(!c.checked) {
		final = false;
		}
	}
	checkAll.checked = final;
});

// 전체 약관에 동의하면 로그인 폼으로 이동
btn.addEventListener('click', function() {
  // let c = true;

  // for(ch of check){
  //   if(!ch.checked){
  //     c = false;
  //   }
  // }

  // if(c){
  //   location.href="./join";
  // } else {
  //   alert("약관에 동의가 필요합니다")
  // }

  if(checkAll.checked){
    location.href="./join";
  } else {
    alert("약관에 동의가 필요합니다")
  }

});
