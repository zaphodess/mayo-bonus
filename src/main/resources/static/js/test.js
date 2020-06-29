/**
 * 
 */


const x = document.querySelector('#y');

x.addEventListener('click', () => renderProducts());

function renderProducts () {

const products = await fetch ('api...).then (result => result.json());
products.forEach(product => {
const {id, name, description, points} = product;
const html =  `<div class="card">...`;
}
}