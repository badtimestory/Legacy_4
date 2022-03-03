const checkAll = document.getElementById('checkAll');
const check = document.getElementsByClassName('check');

// 전체동의 체크
checkAll.addEventListener('click', function() {
  for(c of check) {
    c.checked = checkAll.checked;
  }  
});

// 전부 동의체크하면 전체동의에 체크
for(ch of check) {
  ch.addEventListener("click", function() {
    let final = true;

    // 체크가 다되있으면 if문에 안들어옴
    for(c of check){
      if(!c.checked){
        final = false;
      }
    }

    checkAll.checked=final;

  });
}


