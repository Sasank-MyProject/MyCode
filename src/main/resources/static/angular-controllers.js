app.controller('taskManager', function($scope, $http) {

});

app.controller('ListOfTaskController', function($scope, $http, $location) {

	$http.get("/tasks").then(function(response) {
		$scope.listOfPost = response.data;
	});

	$scope.deleteTask = function(id) {
		$http({
			method : "DELETE",
			url : "/task/" + id
		}).then(function(response) {
			alert(response.data["message"]);
			window.location.reload();
		}, function(error) {

		});
	}
});

app.controller('CreateTaskController', function($scope, $http) {
	
	$http.get("/labels").then(function(response) {
		$scope.labels = response.data;		
	});
	

	$scope.fields = {
	};
	
	$scope.createTask = function() {
		$http({
			method : "POST",
			url : "/task/",
			data : $scope.fields,
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function(result) {
			alert("Task Created Successfully");
			window.history.back();
		}, function(error) {
			console.log(error);
		});
	}
	
});

app.controller('ViewTaskController', function($scope, $http, $routeParams) {

	$scope.id = $routeParams.id;
	$http.get("/task/" + $scope.id).then(function(response) {
		$scope.fields = response.data;
	});
});

app.controller('CreateLabelController',function($scope, $http){
	$scope.fields = {
			label: ''
		};
	
	$scope.createlabel = function(fields) {
		$http({
			method : "POST",
			url : "/labels/",
			data : fields,
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function(result) {
			alert("Label Created Successfully");
			window.history.back();
		}, function(error) {
			console.log(error);
		});
	}
});