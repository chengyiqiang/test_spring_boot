document.write("asef");

function rec(){
    var mymessage=confirm("女士???")         ;
    if(mymessage==true)
    {
        document.write("你是女士!");
    }
    else
    {
        document.write("你是男士!");
    }
}

function hello() {
    var myname = prompt("请输入你的姓名","小明？？");
    if (myname == "xixi"){
        alert("mylove");
    }else {
        alert("goout");
    }
}
function newWindow() {
    window.open('http://www.imooc.com','_blank','width=300,' +
        'height=200,menubar=no,toolbar=no, status=no,scrollbars=yes');
}


function setName() {
    document.getElementById("bottom-text").value = ("赋予值~~~" + new Date());
}

var timer;
function getInterval(){
    timer = setInterval(setName,10000);
    alert(timer);
}

