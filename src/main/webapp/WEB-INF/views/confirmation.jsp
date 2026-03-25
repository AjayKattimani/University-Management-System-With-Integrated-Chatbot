<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f8f9fa; /* light grey background */
  }

  .container {
    margin: 100px auto;
    padding: 20px;
    background-color: #ffffff; /* white container background */
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* subtle shadow */
    max-width: 600px;
    text-align: center;
  }

  h1 {
    color: #007bff; /* blue heading */
    font-size: 24px;
    margin-bottom: 20px;
  }

  p {
    font-size: 18px;
    color: #333333; /* dark grey text */
    line-height: 1.6;
  }
</style>
</head>
<body>

<div class="container">
  <h1>Thank You for Your Application!</h1>
  <p>Your application for the position has been successfully received. We appreciate your interest in joining our team and will review your submission carefully. You will hear from us soon with further steps.</p>
</div>

<script>
  setTimeout(function() {
    window.location.href = "/careers";
  }, 5000);
</script>

</body>
</html>
