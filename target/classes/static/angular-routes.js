app.config(function($routeProvider) {
	$routeProvider.when('/tasks/', {
		templateUrl : 'uiScreens/home.html',
		controller : 'ListOfTaskController'
	}).when('/task/new', {
		templateUrl : 'uiScreens/create.html',
		controller : 'CreateTaskController'
	}).when('/task/:id', {
		templateUrl : 'uiScreens/view.html',
		controller : 'ViewTaskController'
	}).when('/newlabel',{
		templateUrl : 'uiScreens/createLabel.html',
		controller : 'CreateLabelController'
	}).otherwise({
		redirectTo : '/tasks'
	});
});