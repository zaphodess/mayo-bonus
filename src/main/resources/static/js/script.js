/**
 * 
 */

 async function renderProducts () {
  const url = '/api/v1/products';
  let response;
  
// via fetch API und async await
  response = await fetch( url, { method: 'GET' } );
  response = await response.json();
 // console.log( response );
  
  response.forEach (product => {
	  const entry = `<div class="card" id="data-${id}">
               		    <img class="card-img-top" src="/api/v1/images/byReferenceId/${referenceId}" alt="Your Product">
               		    <div class="card-body">
               		      <h5 class="card-title">${name}</h5>
               		      <p class="card-text">${description}</p>
               		      <p class="card-text"><small class="text-muted">Points: ${points}</small></p>
               		      <button type="button" class="btn btn-primary btn-sm pl-detail">Details</button>
               		    </div>
               		  </div>`;
	  
	  document.querySelector ( '#data-body' ).innerHTML += entry;
	  
  	}
  
  document.querySelectorAll('.card').forEach (div.card => { 
	  const id=.id.substr(5);
	 querySelector('.pl-detail').addEventListener('click',() => {showProductDetail(id)});
  }
  
  
  
  function showProductDetail (id){
	  console.log(id);
  }


function homepage (){
	documtent.querySelector('#content-main').innerHTML = 
	
	const login-state = `
	<h1>
		Willkommen im Mayo Bonus-Shop, ${user.name}!
	</h1>


	<div id="login">
		<h2>
			Congratulations!!!</br> </br> You have saved <span class='highlight'> ${co2Saving} </span> kg CO2 with Mayo!"
		</h2>
		<h2>
			This means you have earned <span class='highlight'> ${availablePoints} </span> valuable Mayo
			coins so far!!!!
		</h2>
	</div>`;

	const no-login-state = `<div id="no-login" style="visibility: hidden;>
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


