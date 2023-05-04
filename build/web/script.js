/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let email = document.getElementById("email");
let pass = document.getElementById("password");
let form = document.getElementById("form");
let err = document.getElementById("err");

form.addEventListener('submit', (e) => {
    if(email.value === null || email.value === "" || pass.value === null || pass.value ===""){
        err.innerText = "Please Check Credentials";
        e.preventDefault();
    }
    
});
