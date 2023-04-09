function fetchData(){
   var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify({
  "id": 5,
  "name": "tatya",
  "email": "tatya@gmail.com",
  "bio": "polfo"
});

var requestOptions = {
  method: 'GET',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("/users")
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
}

let append=(data)=>{
    console.log("4");
  console.log(data)
};