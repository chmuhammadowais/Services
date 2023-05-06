/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let box = document.getElementById("prog_cont");
 
function start() {
    let timerID = null;
    let x = 0;
    let y = 0;
    let degrees = 0;
     timerID = setInterval(move, 1/2);
  
    function move(){
      if(x>= 200){
          clearInterval(timerID);
      }
      else{
          x += 1;
          y += 1.5;
       
          box.style.top = y + "px";
          box.style.display = "flex";
      }
    }
  }

let btn = document.getElementById("ok");
btn.addEventListener("click", function(){
    window.location = "/Services/Services.jsp";
});


let canvas;
let status = document.getElementById("status").value;
console.log("status = " + status);

if(status == "Initialize"){
    canvas = document.getElementById('C1');

}
else if(status == "InProgress"){
    canvas = document.getElementById('C2');

}
else if(status == "Complete"){
    canvas = document.getElementById('C3');
  
}

console.log(canvas.id);
let context = canvas.getContext("2d");
context.beginPath();
context.lineWidth = 10;
context.strokeStyle = "gray";
context.fillStyle = "white";
context.arc(25, 25, 15, 0, 2 * Math.PI);
context.stroke();
context.fill();