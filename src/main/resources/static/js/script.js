/**
 * 
 */

( async () => {
  const url = '/api/v1/products';
  let response;
  
//via fetch API und async await
  response = await fetch( url, { method: 'GET' } );
  response = await response.json();
 // console.log( response );
  
  response.forEach (product => {
	  const entry = `<tr id="data-${product.id}">
	     <th scope="row">${product.id}</th>
	     <td>${product.name}</td>
	     <td>${product.description}</td>
	     <td>${product.points}</td>
	     <td>${product.image}</td>
	     <td><button type="button" class="btn btn-primary btn-sm" onclick="showProduct(${product.id})">Details</button></td>
	     <td><button type="button" class="btn btn-warning btn-sm" onclick="updateProduct(${product.id})">Update</button></td>
	     <td><button type="button" class="btn btn-danger btn-sm" onclick="deleteProduct(${product.id},this)">Delete</button></td>
	     </tr>`;
	  
	  
	  document.querySelector ( '#data-body' ).innerHTML += entry;
	  
  })
  
} )();
