(function() {
    'use strict';

    angular.module('plunker')
        .service('loginService', loginService);

        loginService.$inject = ['$http', '$q', 'CONFIG'];
}
)();