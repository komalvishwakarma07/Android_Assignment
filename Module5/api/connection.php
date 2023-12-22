<?php

	$servername = "localhost";		// 127.0.0.1	
	$username = "root";
	$password = "";
	$dbname = "tops";
	

	// Create connection
	$conn = new mysqli($servername, $username, $password, $dbname);
	// Check connection
	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	} 
	// echo "Success";

?>