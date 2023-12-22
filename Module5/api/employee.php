<?php

	include("connection.php");

	$flag=$_REQUEST["flag"];
	
	switch ($flag) {
		case '1':
			# insert or create...
			saveStudent($conn);
			break;
		case '2':
			# update...
			updateStudent($conn);
			break;
		case '3':
			# delete...
			deleteStudent($conn);
			break;
		case '4':
			# select...
			selectStudent($conn);
			break;
		case '5':
			# select...
			selectSingleStudent($conn);
			break;
		case '6':
			login($conn);
			
			
		default:
			# code...
			break;
	}
	
	function login($conn)
	{
		$email=$_REQUEST["email"];
		$password = $_REQUEST["password"];
		
		$sql="select * from employee where email='$email'";
		
		$result = $conn->query($sql);
		$row = null;
		if ($result->num_rows > 0) {
			
			$row = $result->fetch_assoc();
			
			if($password == "123456")
			{
					
					//$res = array('status' => "failed", 'message' => "User already registered");
					$res = array('status' => "success", 'message' => "Login successfully", 'user' => $row);
					echo json_encode($res);
					return;
			}else{
				
					$res = array('status' => "failed", 'message' => "incorrect password", 'user' => null);
					echo json_encode($res);
					return;
			}
			
		    
		}else{
			//$res = array('status' => "failed", 'message' => "User already registered");
					$res = array('status' => "failed", 'message' => "User does not exists", 'user' => $row);
					echo json_encode($res);
					return;
		}
	}
	
	function saveStudent($conn){
		$name=$_REQUEST["name"];
		$email=$_REQUEST["email"];
		$mobile=$_REQUEST["mobile"];
		
		$sql="select * from employee where email='$email'";
		
		$result = $conn->query($sql);
	
		
		if ($result->num_rows > 0) {
		    $res = array('status' => "failed", 'message' => "User already registered");
			echo json_encode($res);
			return;
		}
		
		$sql="insert into employee(name, email, mobile) values ('$name','$email','$mobile')";

		if ($conn->query($sql) === TRUE) {
		    //echo "New record created successfully";

					$query="select * from employee where email='$email'";
		
					$response = $conn->query($query);

					if ($response->num_rows > 0) {
						
						$row = $response->fetch_assoc();
			
						$res = array('status' => "success", 'message' => "User registered successfully", 'user' => $row);

						echo json_encode($res);
					}

				

		} else {
		    echo "Error: " . $sql . "<br>" . $conn->error;
		}

		$conn->close();
	}
	
	
	function updateStudent($conn){
		$id=$_REQUEST["id"];
		$name=$_REQUEST["name"];
		
		$mobile=$_REQUEST["mobile"];
		$sql="update employee set name='$name',  mobile='$mobile' where id=$id";
		if ($conn->query($sql) === TRUE) {
		    $res = array('status' => "success", 'message' => "Record updated successfully");
			echo json_encode($res);
		} else {
		    echo "Error: " . $sql . "<br>" . $conn->error;
		}

		$conn->close();
	}
	function deleteStudent($conn){
		$id=$_REQUEST["id"];
		$sql="delete from employeet where id=$id";
		if ($conn->query($sql) === TRUE) {
	 	   $res = array('status' => "success", 'message' => "Record deleted successfully");
		   echo json_encode($res);
		} else {
		    echo "Error: " . $sql . "<br>" . $conn->error;
		}

		$conn->close();
	}
	function selectStudent($conn){
		$sql="select * from employee";
		$result = $conn->query($sql);
		if ($result->num_rows > 0) {
    // output data of each row
		    while($row = $result->fetch_assoc()) {
		      	$data["employee"][]=$row;
		    }
		    echo json_encode($data);
			
		} else {
		    echo "0 results";
		}
		$conn->close();
	}
	
	function selectSingleStudent($conn){
		
		$id=$_REQUEST["id"];
		
		$sql="select * from employee where id=$id";
		$result = $conn->query($sql);
		if ($result->num_rows > 0) {
			
			$row = $result->fetch_assoc();
			
		    echo json_encode($row);
			
		} else {
		    echo "0 results";
		}
		$conn->close();
	}
	
?>