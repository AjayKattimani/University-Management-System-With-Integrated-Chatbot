<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chat Bot</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #ddebe6;
    margin: 0;
    padding: 0;
  }
  #chat-area {
    width: 600px;
    height: 300px;
    overflow-y: scroll;
    border: 1px solid #ccc;
    margin: 10px;
    padding: 5px;
    background-color: #fff;
  }
  #input-field {
    width: 500px;
    height: 45px;
    margin: 0 10px;
    padding: 5px;
    border: 1px solid #ccc;
    background-color: #fff;
  }
  #send-btn, #read-btn {
    background-color: #15b0d7;
    border: none;
    color: #fff;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 5px 10px;
    cursor: pointer;
    border-radius: 5px;
  }
</style>
</head>
<body>
    <div id="chat-area"></div>
    <input type="text" id="input-field" placeholder="Type your message here...">
    <button class="btn" id="send-btn">Send</button>
    <button class="btn" id="read-btn">Read</button>

    <script>
        let knowledge = {
            "hi": "Hello",
            "hello": "Hi",
            "good morning": "Very good morning"
        };

        document.getElementById('send-btn').addEventListener('click', sendMessage);

        document.getElementById('input-field').addEventListener('keypress', function(event) {
            if (event.key === 'Enter') {
                sendMessage();
            }
        });

        document.getElementById('read-btn').addEventListener('click', () => {
            // Read the latest response from the bot
            let latestResponse = document.getElementById('chat-area').lastElementChild.textContent;
            speak(latestResponse);
        });

        function sendMessage() {
            let inputField = document.getElementById('input-field');
            let message = inputField.value.trim();
            if (message !== '') {
                bot('You: ' + message);
                answer(message);
                inputField.value = '';
            }
        }

        async function answer(question) {
            let response = await getResponse(question) || "Sorry, I don't understand.";
            bot('Bot: ' + response);
            speak(response);
        }

        async function getResponse(question) {
            // First, check if the question exists in the knowledge object
            let response = knowledge[question.toLowerCase()] || null;
            if (response) return response;
            
            // If not found in knowledge, attempt to fetch from Source.txt
            try {
                let fileResponse = await fetch('Source.txt');
                let fileData = await fileResponse.text();
                let lines = fileData.split('\n');
                for (let line of lines) {
                    let [q, r] = line.trim().split('_');
                    if (q.toLowerCase() === question.toLowerCase()) {
                        return r;
                    }
                }
                return "Sorry, I don't understand."; // If question not found in Source.txt
            } catch (error) {
                console.error('Error fetching from Source.txt:', error);
                return "Sorry, I encountered an error."; // Return error message
            }
        }

        function bot(message) {
            let chatArea = document.getElementById('chat-area');
            let messageElement = document.createElement('p');
            messageElement.textContent = message;
            chatArea.appendChild(messageElement);
        }

        function speak(text) {
            let utterance = new SpeechSynthesisUtterance(text);
            speechSynthesis.speak(utterance);
        }
    </script>
</body>
</html>
