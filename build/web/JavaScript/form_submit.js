/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let form = document.getElementById("form");
let err_text = document.getElementById("err_text");
console.log(type);

form.addEventListener('submit', (e) => {
    if (type !== "Electric Repair" && type !== "Furniture Repair" && type !== "Plumbing Repair" && type !== "Air Conditioning Repair" && type !== "House Heating Repair" && type !== "Construction Repair" && type !== "General Repair" && type !== "House Cleaning") {
        err.innerText = "Error Submitting the form";
        e.preventDefault();
    } 
});
