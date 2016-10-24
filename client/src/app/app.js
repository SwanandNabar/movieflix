(function() {
    'use strict';

    angular
        .module('plunker', ['ngRoute'])
        .config(moduleConfig);

    function moduleConfig($routeProvider) {

        $routeProvider
            .when('/login',{
                templateUrl:'app/views/login.tmpl.html',
                controller: 'LoginController',
                controllerAs: 'loginVm'
            })
            .when('/users', {
                templateUrl: 'app/views/users.tmpl.html',
                controller: 'UsersController',
                controllerAs: 'usersVm'
            })
            .when('/users/:id', {
                templateUrl: 'app/views/user-detail.tmpl.html',
                controller: 'UserDetailController',
                controllerAs: 'userDetailVm'
            })
            .when('/resources', {
                templateUrl: 'app/views/resources.tmpl.html',
                controller: 'ResourcesController',
                controllerAs: 'resourcesVm'
            })
            .otherwise({
                redirectTo: '/login'
            });
    }

})();