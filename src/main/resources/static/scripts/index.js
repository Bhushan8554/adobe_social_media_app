// Navbar



//data fetch
function fetchData(){
fetch("http://localhost:8080/users")
  .then(response => response.json())
  .then(result => append(result))
  .catch(error => console.log('error', error));

}
function fetchDataPost(){
    fetch("http://localhost:8080/posts")
      .then(response => response.json())
      .then(result => appendPost(result))
      .catch(error => console.log('error', error));
    
}

let appendPost=(arr)=>{
    
    // console.log(arr); 
    let cont=document.querySelector("#con");
    cont.innerHTML=null;
     for(let i=0;i<arr.length;i++){
        let div=document.createElement("div");
        div.className="container";
        div.innerHTML=`<div class="row">
        <div class="col">
            <p>${arr[i].content}</p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <p>likes :- ${arr[i].likes}</p>
        </div>
        <div class="col">
            <button class="btn btn-sm btn-primary" onclick="likePost()"> like post</button>
        </div>
        <div class="col">
            <button class="btn btn-sm" onclick="dislikePost()"> dislike post</button>
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
            <button class="btn btn-primary btn-sm" onclick="viewPost()">View</button>
        </div>
        <div class="col">
            <button class="btn btn-secondary btn-sm" onclick="editPost()">Edit</button>
        </div>
        <div class="col">
            <button class="btn btn-danger btn-sm" onclick="deletePost()">Delete</button>
        </div>
    </div>`;

    cont.append(div);
        
     }


 }


function showAddPostForm(){
    let cont=document.querySelector("#con");
    cont.innerHTML=null;
    cont.innerHTML=`<form onsubmit="addPostInData()">
    <h3>Add Post</h3>
    <div class="form-group">
      <label for="exampleInputEmail1">User Id</label>
      <input type="number" class="form-control" id="id" aria-describedby="emailHelp" placeholder="Enter user id">
    </div>
    <div class="form-group">
      <label for="bio">Content</label>
      <textarea class="form-control" id="content" rows="3" placeholder="content"></textarea>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>`;
}

function addPostInData(){
    event.preventDefault();
    let id=document.querySelector("#id").value;
    let content=document.querySelector("#content").value;
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    var raw = JSON.stringify({
    "content": content
    });

    var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
    };

    fetch(`http://localhost:8080/posts?u_id=${id}`,requestOptions)
    .then(response => response.json())
    .then(result => alert(JSON.stringify(result)))
    .catch(error => alert('error', error));


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
        
     }


 }





