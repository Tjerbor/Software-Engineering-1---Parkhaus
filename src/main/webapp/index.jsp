
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>

    <title>Parkhaus - Team 6</title>

</head>
<style>
    .toast{
        background-color: #ff0000;
        color: blanchedalmond;
    }
    .container-k {
        width: 97%;
        margin: 0 auto;
    }
    body {
        background-image: url('images/main_page.png');
        background-size: cover;
    }
</style>
<body>
<header style="background-color: #333; color: white; padding: 20px;">
    <div class="header-content" style="display: flex; align-items: center; justify-content: space-between;">
        <div class="logo">
            <img src="images/parkhaus_Logo_Berlin.png" alt="Logo" width="100">Parkhaus | Team 6 (SE1)
        </div>
        <nav>

            <ul style="list-style: none; display: flex; gap: 20px;">
                <a href="Parkhaus.jsp"><button class="button-small">Home</button></a>
                <li><a href="about.jsp"><button class="button-small">About</button></a></li>
                <li><a href="services.jsp"><button class="button-small">Services</button></a></li>
                <li><a href="contact.jsp"><button class="button-small">Contact</button></a></li>
            </ul>
        </nav>
    </div>

    <style> a:hover {
        background-color: plum;
    }</style>
</header>

<script>
    function updateClock() {
        var now = new Date(); // aktuelle Zeit abrufen
        var day = now.getDate(); // Tag abrufen
        var month = now.getMonth() + 1; // Monat abrufen (Januar = 0, Februar = 1, ...)
        var year = now.getFullYear(); // Jahr abrufen
        var hours = now.getHours(); // Stunden abrufen
        var minutes = now.getMinutes(); // Minuten abrufen
        var seconds = now.getSeconds(); // Sekunden abrufen
        var timeString = day + '.' + month + '.' + year + ' ' + hours + ':' + minutes + ':' + seconds; // Zeitformat erstellen
        document.getElementById('clock').style.textAlign = 'right'; //Zeitausgabe rechts
        document.getElementById('clock').innerHTML = timeString; // Zeit in das HTML-Element schreiben
    }
    setInterval(updateClock, 1000); // Die Uhrzeit alle Sekunde aktualisieren
</script>


<section>

    <div style="text-align:center;">
        <h1 class="uhr-btn" id="clock"></h1>
    </div>
</section>
<div class="btn-container" style="display: flex; flex-direction: column; align-items: center; margin-top: 20px;">
    <a href="platz-servlet"><button class="purple-button button-medium">Platz/Auslastung</button></a>
    <a href="preis-servlet"><button class="purple-button button-medium">Ticket Preise</button></a>
    <a href="ticketerstell-servlet"><button class="purple-button button-large">Ticket Ziehen</button></a>
    <a href="ticketerstell-servlet?password=admin7&username=admin"><button class="purple-button button-large">Ticket erstellen Adminpanel</button></a>
    <a href="reinfahren-servlet"><button class="purple-button button-medium">Reinfahren</button></a>
    <a href="Zeit-servlet"><button class="purple-button button-medium">Parkdauer ändern</button></a>
    <a href="verlassen-servlet"><button class="purple-button button-medium">Rausfahren</button></a>
    <a href="statistik"><button class="purple-button button-medium">Parkhaus-Statistik</button></a>
    <a href="Reset"><button class="purple-button button-small">Reset Parkhaussystem</button></a>


</div>

<!-- Style Button -->
<style>
    .purple-button {
        background-color: purple;
        color: white;
        border-radius: 20px;
        border: none;
        padding: 10px 20px;
        margin-bottom: 10px;
    }

    .button-large {
        font-size: 20px;
    }

    .button-medium {
        font-size: 16px;
    }

    .button-small {
        font-size: 12px;
    }
    .footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
        background-color: #333;
        color: white;
        padding: 20px;
        text-align: center;
    }
     a:hover {
         background-color: plum;
     }

</style>

<!-- Footer Style -->
<style>
    body {
        margin: 0;
        padding-bottom: 60px; /* Set a padding bottom to create space for the footer */
    }

    .footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
        background-color: #333;
        color: white;
        padding: 20px;
        text-align: center;
    }
</style>

<div class="content">
    <!-- Your page content here -->
</div>

<footer class="footer">
    <div class="footer-content">
        <p>© 2023 Parkhaus Team 6. All rights reserved.</p>
        <p>Contact us: parkhaus@team6.com</p>
    </div>
</footer>

</body>
</html>
