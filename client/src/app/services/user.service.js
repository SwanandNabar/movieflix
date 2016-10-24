(function() {
    'use strict';

    angular.module('plunker')
        .service('userService', userService);

    userService.$inject = ['$http', '$q', 'CONFIG'];

    function userService($http, $q, CONFIG) {

        var self = this;

        self.getUsers = getUsers;
        self.getUserById = getUserById;

        function getUsers() {
            return $http.get(CONFIG.API_HOST + '/users')
                .then(successFn, errorFn);
        }

        function getUserById(id) {
            return $http.get(CONFIG.API_HOST + '/users/' + id)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }

})();