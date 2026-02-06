const output = document.getElementById("output");

document.getElementById("btnCreate").addEventListener("click", () => {
    const title = document.getElementById("taskTitleInput").value;
    if (!title) return alert("Please enter a task title");

    fetch("http://localhost:8080/tasks", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({title})
    })
        .then(res => res.json())
        .then(data => show(data));
});


document.getElementById("btnReadById").addEventListener("click", () => {
    const id = document.getElementById("taskIdInput").value;
    if (!id) return alert("Please enter an ID");

    fetch(`http://localhost:8080/tasks/${id}`)
        .then(res => res.json())
        .then(data => show(data));
});


document.getElementById("btnReadAllTasks").addEventListener("click", () => {
    fetch("http://localhost:8080/tasks")
        .then(res => res.json())
        .then(data => show(data));
});

document.getElementById("btnUpdate").addEventListener("click", () => {
    const id = document.getElementById("taskIdInput").value;
    const status = document.getElementById("taskStatusSelect").value;

    if (!id) return alert("Please enter an ID");

    fetch(`http://localhost:8080/tasks/${id}`, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({status})
    })
        .then(res => res.json())
        .then(data => show(data));
});


document.getElementById("btnDelete").addEventListener("click", () => {
    const id = document.getElementById("taskIdInput").value;
    if (!id) return alert("Please enter an ID");

    fetch(`http://localhost:8080/tasks/${id}`, {method: "DELETE"})
        .then(() => show({message: `Task ${id} deleted`}));
});


function show(data) {
    output.textContent = JSON.stringify(data, null, 2);
}

