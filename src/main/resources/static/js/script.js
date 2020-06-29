/**
 * 
 */

( async () => {
  const url = '/api/v1/products';
  let response;
  
// via fetch API und async await
  response = await fetch( url, { method: 'GET' } );
  response = await response.json();
 // console.log( response );
  
  response.forEach (product => {
	  const entry = `<tr id="data-${product.id}">
	     <th scope="row">${product.id}</th>
	     <td>${product.name}</td>
	     <td>${product.description}</td>
	     <td>${product.points}</td>
	     <td><button type="button" class="btn btn-primary btn-sm pl-detail">Details</button></td>
	     <td><button type="button" class="btn btn-warning btn-sm pl-update" onclick="updateProduct(${product.id})">Update</button></td>
	     <td><button type="button" class="btn btn-danger btn-sm pl-delete" onclick="deleteProduct(${product.id},this)">Delete</button></td>
	     </tr>`;
	  
	  document.querySelector ( '#data-body' ).innerHTML += entry;
	  
  })

  document.querySelectorAll('tbody tr').forEach (tr => { 
	  const id=tr.id.substr(5);
	  tr.querySelector('.pl-detail').addEventListener('click',() => {showProductDetail(id)});
  });
  
  function showProductDetail (id){
	  console.log(id);
  }
  
})();

function homepage (){
	documtent.querySelector('#content-main').innerHTML = `
	<h1>
		Willkommen im Mayo Bonus-Shop, Newbie!
	</h1>


	<div id="login">
		<h2>
			Congratulations!!!</br> </br> You have saved <span class='highlight'> ${co2Saving} </span> kg CO2 with Mayo!"
		</h2>
		<h2>
			This means you have earned <span class='highlight'> ${availablePoints} </span> valuable Mayo
			coins so far!!!!
		</h2>
	</div>

	<div id="no-login">
		<h2>
			Please <a href='login.html'>sign in</a> or <a href='register.html'>register</a>.
		</h2>
		<h3>This is why you absolutely have to join the Mayo community:</h3>
		<ul>
			<li>It's so much nicer to travel together</li>
			<li>You're going to meet lots of very nice new people</li>
			<li>You'll help save the planet</li>
			<li>You can earn Mayo coins and spend them here</li>
		</ul>
	</div>
	`;
}


