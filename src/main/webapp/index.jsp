<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>Parkhaus - Team 6</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        *{
            text-align: center;
        }
    </style>
</head>

<body>
<h1>Parkhaus | Team 6</h1>
<nav>
    <ul>
        <li><a href="ticketerstell-servlet">Ticket erstellen</a></li>
    </ul>
    <ul> <li><a href="ticketerstell-servlet?password=admin7&username=admin">Ticket-Ersteller Admin Test</a></li>
    </ul>
    <ul>
        <li><a href="reinfahren-servlet">Reinfahren</a></li>
    </ul>
        <ul>
            <li><a href="kassenautomat">Kassenautomat</a></li>
        </ul>
        <ul>
            <li><a href="platz-servlet">Platz</a></li>
        </ul>
    <ul>
        <li><a href="preis-servlet">Preis</a></li>
    </ul>
    <ul>
        <li><a href="verlassen-servlet">Rausfahren</a></li>
    </ul>
    <ul>
        <li><a href="Zeit-servlet">Zeit ändern</a></li>
    </ul>
    <ul>
        <li><a href="statistik">Statistik</a></li>
    </ul>

    <ul>
        <li><a href="Reset">Reset</a></li>
    </ul>



</nav>
</body>
</html>
