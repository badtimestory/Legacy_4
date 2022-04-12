const fileAdd = document.getElementById('fileAdd');
const fileResult = document.getElementById('fileResult');
const del = document.getElementsByClassName('del');

let count = 0;
let num = 0;  // id 용도

fileAdd.addEventListener('click', function(){
  // 태그 생성
  if(count > 4) {
    alert("파일첨부는 최대 5개까지입니다.");
    return;
  }

  count++;
  console.log("fileAdd을 눌렀습니다, 현재 count: ", count);  
  
    let div = document.createElement('div');  // <div></div>
    div.setAttribute('id', 'del'+num);
    let file = document.createElement('input'); // <input>
    
    file.setAttribute("type", "file");  // <input type="file">
    file.setAttribute( "name", "files");  // <input type="file" name="files">
    
    let button = document.createElement('button');  // <button></button>
    button.setAttribute("type", "button");
    button.className = "del";
    button.setAttribute('data-num', 'del'+num);
    button.innerHTML = "DEL";

    div.append(file);
    div.append(button);
    
    fileResult.append(div);
    
    num++;
});

fileResult.addEventListener('click', function(event){
 let cn = event.target;

 // -------------------------
 // del button을 클릭했을 때
 // -------------------------

 // class의 이름이 여러 개 일때 원하는 클래스 이름이 있는지 확인
  if(cn.classList.contains('del')) { 
    // 선택자로 선택한 Element의 속성의 값을 가지고 오
    let delNum = cn.getAttribute("data-num");
    document.getElementById(delNum).remove();
    count--;
    console.log("del을 눌렀습니다. 현재 count: ", count);
  }
});

// ------------------------------------
const fileDeleteBtn = document.querySelectorAll(".fileDeleteBtn");
const files = document.querySelector("#files");

// 각각의 fileNum을 console에 출력 
files.addEventListener("click", function(event) {
  if(event.target.classList.contains("fileDeleteBtn")) {

    let check = confirm("삭제시 복구 불가능 삭제하시겠습니까?");

    if(!check) {
      return;
    }

    let fileNum = event.target.getAttribute('data-fileNum');
    
    // ajax parameter : fileNum, method : post, URL : fileDelete, Controller : fileDelete

    let xhttp = new XMLHttpRequest;

    xhttp.open("POST", "./fileDelete");
    
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send("fileNum="+fileNum);

    // 응답 처리
    xhttp.onreadystatechange = function() {
      if(this.readyState == 4 && this.status == 200) {
        console.log(this.responseText);
        let result = this.responseText.trim();
        if(result == '1') {
          console.log("file 삭제")
          event.target.parentNode.remove();
        }
       } else {

       }
    }
  }
});


