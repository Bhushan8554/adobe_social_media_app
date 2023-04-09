// Navbar



//data fetch
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

fetch("http://localhost:8080/users")
  .then(response => response.json())
  .then(result => append(result))
  .catch(error => console.log('error', error));

}
 
 let append=(arr)=>{
    
     console.log(arr); 
     for(let i=0;i<arr.length;i++){
        let div=document.createElement("div");
        let name=document.createElement("h3");
        name.innerText=arr[i].name;
        let bio=document.createElement("p");
        bio.innerText=arr[i].bio;
        let email=document.createElement("p");
        email.innerText=arr[i].email;
        let up=document.createElement("p");
        up.innerText=arr[i].updated_at?arr[i].updated_at:arr[i].created_at;

        div.append(name,email,bio,up);
        document.getElementById("container").append(div);
     }

//    console.log(data)
 }


