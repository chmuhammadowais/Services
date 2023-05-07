/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


        const box = document.getElementById("popup_service_code");
        const ok_btn = document.getElementById("ok_btn");
        ok_btn.onclick = function() {
            box.style.display = "none";
            window.location = "/Services/Services.jsp";
        };
    
        function start() {
          let timerID = null;
          let x = 0;
          let y = 0;
          let degrees = 0;
           timerID = setInterval(move, 1);
        
          function move(){
            if(x>= 200){
                clearInterval(timerID);
            }
            else{
                x += 1;
                y += 1*1.5;
             
                box.style.top = y + "px";
                box.style.display = "flex";
            }
          }
        }