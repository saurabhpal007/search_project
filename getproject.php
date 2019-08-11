<?php

$conn=mysqli_connect("localhost","root","","pro");

if(isset($_GET['key'])){
	$key=$_GET['key'];
	

	$query="SELECT * FROM `protable` WHERE `title` LIKE '%$key%' OR `descp` LIKE '%$key%'" ; 
	
	$result=mysqli_query($conn,$query);	
	
		$response =array();
		while($row=mysqli_fetch_assoc($result)){
		array_push($response,
		array(
			'id'=>$row['id'],
			'title'=>$row['title'],
			'descp'=>$row['descp'],
			'time'=>$row['time'],
			'user_id'=>$row['user_id'])	);	
						
			}	
			echo json_encode($response);
}			
		
	

mysqli_close($conn);

?>