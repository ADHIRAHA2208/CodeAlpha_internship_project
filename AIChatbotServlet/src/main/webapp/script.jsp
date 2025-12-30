function sendMessage() {
    console.log("Send clicked"); // debug

    let input = document.getElementById("userInput");
    let chatBox = document.getElementById("chatBox");

    let message = input.value.trim();
    if (message === "") return;

    chatBox.innerHTML += `<div class="user">${message}</div>`;

    fetch("chat", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "message=" + encodeURIComponent(message)
    })
    .then(res => res.text())
    .then(reply => {
        chatBox.innerHTML += `<div class="bot">${reply}</div>`;
        chatBox.scrollTop = chatBox.scrollHeight;
    });

    input.value = "";
}
