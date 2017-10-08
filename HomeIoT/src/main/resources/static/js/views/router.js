var app = angular.module('routerApp', ['ui.router'
]); //사용할 모듈을 불러온다.//
////////////////////
app.config(['$stateProvider', function($stateProvider){
	$stateProvider
	.state('home', {
		url: '/home',
		templateUrl: 'home',
	})
	.state('temphumi',{
		url: '/temphumi',
		templateUrl: 'temphumi',
	})
	.state('light',{
		url: '/light',
		templateUrl: 'light',
	})
}]);