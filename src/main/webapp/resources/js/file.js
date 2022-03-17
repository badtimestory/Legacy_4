const fileAdd = document.getElementById('fileAdd');
const fileResult = document.getElementById('fileResult');
const delButton = document.getElementById('delButton');

let count = 0;

fileAdd.addEventListener('click', function(){
  // 태그 생성
  if(count >= 5) {
    alert("파일첨부는 최대 5개까지");
    return;
  }

    let div = document.createElement('div');  // <div>
    let file = document.createElement('input'); // <input>
    
    file.setAttribute("type", "file");  // <input type="file">
    file.setAttribute( "name", "files");  // <input type="file" name="files">
    
    let button = document.createElement('button');  // <button>
    button.setAttribute("type", "button");
    button.innerHTML = "DEL";

    div.append(file);
    div.append(button); // </button>
    
    fileResult.append(div); // </div>

    count++;  
});


