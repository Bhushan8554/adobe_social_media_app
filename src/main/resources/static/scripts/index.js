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


function addUserInData(){
    event.preventDefault();
    let id=document.querySelector("#id").value;
    let name=document.querySelector("#name").value;
    let email=document.querySelector("#email").value;
    let bio=document.querySelector("#bio").value;
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    var raw = JSON.stringify({
    "id": id,
    "name": name,
    "email": email,
    "bio": bio
    });

    var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
    };

    fetch("http://localhost:8080/users",requestOptions)
    .then(response => response.json())
    .then(result => alert(JSON.stringify(result)))
    .catch(error => alert('error', error));


}

 
 let append=(arr)=>{
    
    // console.log(arr); 
    let cont=document.querySelector("#con");
    cont.innerHTML=null;
     for(let i=0;i<arr.length;i++){
        let div=document.createElement("div");
        div.className="container";
        div.innerHTML=`<div class="row">
        <div class="col">
            <h1>${arr[i].name}</h1>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <p>${arr[i].email}</p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <p>${arr[i].bio}</p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <p>created at :- ${arr[i].created_at}</p>
        </div>
        <div class="col">
            <p>updated at :- ${arr[i].updated_at}</p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <button class="btn btn-primary btn-sm" onclick="viewUser()">View</button>
        </div>
        <div class="col">
            <button class="btn btn-secondary btn-sm" onclick="editUser()">Edit</button>
        </div>
        <div class="col">
            <button class="btn btn-danger btn-sm" onclick="deleteUser()">Delete</button>
        </div>
    </div>`;

    cont.append(div);
        // let name=document.createElement("h3");
        // name.innerText=arr[i].name;
        // let bio=document.createElement("p");
        // bio.innerText=arr[i].bio;
        // let email=document.createElement("p");
        // email.innerText=arr[i].email;
        // let up=document.createElement("p");
        // up.innerText=arr[i].updated_at?arr[i].updated_at:arr[i].created_at;
        // let btn=document.createElement("button");
        // btn.innerText="View";
        // let btn2=document.createElement("button");
        // btn2.innerText="Edit";
        // let btn3=document.createElement("button");
        // btn3.innerText="Delete";

        // div.append(name,email,bio,up,btn,btn2,btn3);
        // document.getElementById("container").append(div);


     }


 }





