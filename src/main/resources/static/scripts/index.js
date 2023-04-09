// Navbar



//data fetch
function fetchData(){
    fetch("/users")
      .then(response => response.json())
      .then(result => append(result))
      .catch(error => console.log('error', error));
    
    }
    function fetchDataPost(){
        fetch("/posts")
          .then(response => response.json())
          .then(result => appendPost(result))
          .catch(error => console.log('error', error));
        
    }
    function likePost(id){
        postMapp(`/posts/${id}/like`,"POST")
        fetchDataPost();
    
    }
    function dislikePost(id){
        postMapp(`/posts/${id}/unlike`,"POST")
        fetchDataPost();
    }
    
    function deleteUser(id){
        postMapp(`/users/${id}`,"DELETE")
        fetchData();
    }
    function deletePost(id){
        postMapp(`/posts/${id}`,"DELETE")
        fetchDataPost();
    }

    function viewPost(id){
        fetch(`/posts/${id}`)
        .then(response => response.json())
        .then(result => viewPost2(result))
        .catch(error => console.log('error', error));
    }
    function viewPost2(data){
        let cont=document.querySelector("#con");
        cont.innerHTML=null;
        let div=document.createElement("div");
            div.className="container";
            div.innerHTML=`<div class="row">
            <div class="col">
                <p>${data.content}</p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p>likes :- ${data.likes}</p>
            </div>
            <div class="col">
                <button class="btn btn-sm btn-primary" onclick="likePost(${data.id})"> like post</button>
            </div>
            <div class="col">
                <button class="btn btn-sm" onclick="dislikePost(${data.id})"> dislike post</button>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p>created at :- ${data.created_at}</p>
            </div>
            <div class="col">
                <p>updated at :- ${data.updated_at}</p>
            </div>
        </div>`;
    
        cont.append(div);
            
    }
    function viewUser(id){
        fetch(`/users/${id}`)
      .then(response => response.json())
      .then(result => viewUser2(result))
      .catch(error => console.log('error', error));
    
    }

    function viewUser2(data){
        //let d=postMapp(`/users/${id}`,"GET")
        console.log(data);
        let cont=document.querySelector("#con");
        cont.innerHTML=null;
        let div=document.createElement("div");
            div.className="container";
            div.innerHTML=`<div class="row">
            <div class="col">
                <h1>${data.name}</h1>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p>${data.email}</p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p>${data.bio}</p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p>created at :- ${data.created_at}</p>
            </div>
            <div class="col">
                <p>updated at :- ${data.updated_at}</p>
            </div>
        </div>`;
    
        cont.append(div);
            
    }

    function editPost(id){
        let data=postMapp(`/posts/${id}`,"GET");
        let cont=document.querySelector("#con");
        cont.innerHTML=null;
        cont.innerHTML=`<form onsubmit="updatePost(${id})">
        <h3>update Post Content</h3>
        <div class="form-group">
          <label for="bio">Content</label>
          <textarea class="form-control" id="content" rows="3" placeholder="content"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>`;
    }
    function updatePost(id){
        event.preventDefault();
        let content=document.querySelector("#content").value;
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        var raw = JSON.stringify({
        "content": content
        });
    
        var requestOptions = {
        method: 'PUT',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
        };
    
        fetch(`/posts/${id}`,requestOptions)
        .then(response => response.json())
        .then(result => alert(JSON.stringify(result)))
        .catch(error => alert('error', error));
    
    }

    function editUser(id){
        let data=postMapp(`/users/${id}`,"GET");
        let cont=document.querySelector("#con");
        cont.innerHTML=null;
        cont.innerHTML=`<form onsubmit="updateUser(${id})">
        <h3>update User</h3>
        <div class="form-group">
          <label for="name">Name</label>
          <input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name">
        </div>
        <div class="form-group">
          <label for="bio">Bio</label>
          <input type="text" class="form-control" id="bio" placeholder="Bio">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>`;
    }
    function updateUser(id){
        event.preventDefault();
        let name=document.querySelector("#name").value;
        let bio=document.querySelector("#bio").value;
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        var raw = JSON.stringify({
        "name": name,
        "bio": bio
        });
    
        var requestOptions = {
        method: 'PUT',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
        };
    
        fetch(`/users/${id}`,requestOptions)
        .then(response => response.json())
        .then(result => alert(JSON.stringify(result)))
        .catch(error => alert('error', error));
    
    
    }

    function userAnalytics(){
        let cont=document.querySelector("#con");
        cont.innerHTML=null;
        cont.innerHTML=`<div class="row">
        <div class="col" id="total">
            
        </div>
        <div class="col" id="top"></div>
        </div>`;
        
        fetch("/analytics/users/top-active")
        .then(response => response.json())
        .then(result => append2(result))
        .catch(error => console.log('error', error));

        fetch("/analytics/users")
        .then(response => response.json())
        .then(result => document.querySelector("#total").innerHTML=`<p>Total User </p>
        <h1>${result}</h1>`)
        .catch(error => console.log('error', error));

    }

    let append2=(arr)=>{
        
        // console.log(arr); 
        let cont=document.querySelector("#top");
        cont.innerHTML=null;
         for(let i=0;i<arr.length;i++){
            let div=document.createElement("div");
            div.className="toppost";
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
                <button class="btn btn-primary btn-sm" onclick="viewUser(${arr[i].id})">View</button>
            </div>
            <div class="col">
                <button class="btn btn-secondary btn-sm" onclick="editUser(${arr[i].id})">Edit</button>
            </div>
            <div class="col">
                <button class="btn btn-danger btn-sm" onclick="deleteUser(${arr[i].id})">Delete</button>
            </div>
        </div>`;
    
        cont.append(div);
            
         }
    
    
     }

    function postAnalytics(){
        let cont=document.querySelector("#con");
        cont.innerHTML=null;
        cont.innerHTML=`<div class="row">
        <div class="col" id="total">
            
        </div>
        <div class="col" id="top"></div>
        </div>`;
        
        fetch("/analytics/posts")
        .then(response => response.json())
        .then(result => document.querySelector("#total").innerHTML=`<p>Total posts </p>
        <h1>${result}</h1>`)
        .catch(error => console.log('error', error));

        fetch("/analytics/posts/top-liked")
        .then(response => response.json())
        .then(result => appendPost2(result))
        .catch(error => console.log('error', error));

    }
    let appendPost2=(arr)=>{
        
        // console.log(arr); 
        let cont=document.querySelector("#top");
        cont.innerHTML=null;
         for(let i=0;i<arr.length;i++){
            let div=document.createElement("div");
            div.className="toppost";
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
                <button class="btn btn-sm btn-primary" onclick="likePost(${arr[i].id})"> like post</button>
            </div>
            <div class="col">
                <button class="btn btn-sm" onclick="dislikePost(${arr[i].id})"> dislike post</button>
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
                <button class="btn btn-primary btn-sm" onclick="viewPost(${arr[i].id})">View</button>
            </div>
            <div class="col">
                <button class="btn btn-secondary btn-sm" onclick="editPost(${arr[i].id})">Edit</button>
            </div>
            <div class="col">
                <button class="btn btn-danger btn-sm" onclick="deletePost(${arr[i].id})">Delete</button>
            </div>
        </div>`;
    
        cont.append(div);
            
         }
    
    
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
                <button class="btn btn-sm btn-primary" onclick="likePost(${arr[i].id})"> like post</button>
            </div>
            <div class="col">
                <button class="btn btn-sm" onclick="dislikePost(${arr[i].id})"> dislike post</button>
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
                <button class="btn btn-primary btn-sm" onclick="viewPost(${arr[i].id})">View</button>
            </div>
            <div class="col">
                <button class="btn btn-secondary btn-sm" onclick="editPost(${arr[i].id})">Edit</button>
            </div>
            <div class="col">
                <button class="btn btn-danger btn-sm" onclick="deletePost(${arr[i].id})">Delete</button>
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
    
        fetch(`/posts?u_id=${id}`,requestOptions)
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
    
        fetch("/users",requestOptions)
        .then(response => response.json())
        .then(result => alert(JSON.stringify(result)))
        .catch(error => alert('error', error));
    
    
    }
    
    function postMapp(url,method){
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        var raw = JSON.stringify({
        
        });
    
        var requestOptions = {
        method: method,
        headers: myHeaders,
        redirect: 'follow'
        };
        let data;
        fetch(url,requestOptions)
        .then(response => response.json())
        .then(result => data=result)
        .catch(error => alert('error', error));
        return data;
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
                <button class="btn btn-primary btn-sm" onclick="viewUser(${arr[i].id})">View</button>
            </div>
            <div class="col">
                <button class="btn btn-secondary btn-sm" onclick="editUser(${arr[i].id})">Edit</button>
            </div>
            <div class="col">
                <button class="btn btn-danger btn-sm" onclick="deleteUser(${arr[i].id})">Delete</button>
            </div>
        </div>`;
    
        cont.append(div);
            
         }
    
    
     }
    
    
    
    
    
    
    