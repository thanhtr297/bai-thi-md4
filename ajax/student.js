function displayStudent() {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/students",
        success: function (data){
        getStudent(data)
        }
    })
}


function getStudent(data) {
            let content = `
         <table class="table table-striped" style="margin: 10px 10px"> <tr>
                    <th scope="col">Stt</th>
                    <th scope="col">Name</th>
                    <th scope="col">DateOfBirth</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Classes</th>
                    <th scope="col" colspan="2">Action</th>
                </tr>`
            for (let i = 0; i < data.length; i++) {
                content += `<tr>
                    <td scope="row"> ${i+1} </td>    
                    <td scope="row">  ${data[i].name} </td>    
                    <td scope="row"> ${data[i].dob} </td>    
                    <td scope="row"> ${data[i].email} </td>    
                    <td scope="row"> ${data[i].address} </td>    
                    <td scope="row"> ${data[i].phone} </td>    
                    <td scope="row"> ${data[i].classes.name} </td>    
                    <td>  
                    <button class="btn btn-info" onclick="updateStudent(${data[i].id})" >Update</button>
                    <button class="btn btn-danger" onclick="deleteStudent(${data[i].id})" >Delete</button>
                    </td>   
                </tr>`
            }
            document.getElementById("students").innerHTML=content
}


function createStudent() {
    localStorage.setItem("idStudent","0")
    window.location.href = "save.html"
}
function updateStudent(id) {
    localStorage.setItem("idStudent",id)
    window.location.href = "save.html"
}

function displayClasses() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/classes",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<option value = ${data[i].id}>${data[i].name}</option>`;
            }
            document.getElementById("classes").innerHTML = content;
        }
    })
}

function findById() {
    let id = localStorage.getItem("idStudent")
    $.ajax({
        type : "GET",
        url :`http://localhost:8080/api/students/${id}`,
        success : function (data) {
            $("#name").val(`${data.name}`);
            $("#email").val(`${data.email}`);
            $("#phone").val(`${data.phone}`);
            $("#address").val(`${data.address}`);
            $("#dob").val(`${data.dob}`);
            $("#classes").val(`${data.classes.id}`);
            // localStorage.setItem("idUpdate", data.id);

        }
    })
}
function saveStudent() {
    let newStudent;
    let name = $("#name").val();
    let idClasses = $("#classes").val();
    let email = $("#email").val();
    let phone = $("#phone").val();
    let address = $("#address").val();
    let dob = $("#dob").val();
    let id = +localStorage.getItem("idStudent");

    if (id !== 0) {
        newStudent = {
            id : id,
            name : name,
            dob: dob,
            phone: phone,
            email: email,
            address: address,
            classes : {
                id : idClasses
            }
        }
    } else {
        newStudent = {
            name : name,
            dob: dob,
            phone: phone,
            email: email,
            address: address,
            classes : {
                id : idClasses
            }
        }
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newStudent),
        url: "http://localhost:8080/api/students",
        success: function () {
            alert("save success")
            localStorage.setItem("idStudent", "0")
            window.location.href="display.html"
        }
    })
    event.preventDefault();
}
function deleteStudent(id) {
    if (confirm("Are you sure delete?")) {
        $.ajax({
            url: `http://localhost:8080/api/students/${id}`,
            type: "DELETE",
            success: function () {
                alert("Delete success!")
                displayStudent()
            }
        });
    }
    event.preventDefault();

}

function search() {
    let search = document.getElementById("searchName").value
    $.ajax({
        url: `http://localhost:8080/api/students/search/${search}`,
        type: "GET",
        success: function (data) {
            getStudent(data)
        }
    })
    event.preventDefault();
}
function back() {
   location.href = "display.html"
}