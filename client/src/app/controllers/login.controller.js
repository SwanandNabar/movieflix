(function () {
    'use strict';

    angular
        .module('plunker')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthenticationService', 'FlashService'];
    function LoginController($location, AuthenticationService, FlashService) {
        var loginVm = this;

        loginVm.login = login;

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function login() {
            loginVm.dataLoading = true;
            AuthenticationService.Login(loginVm.username, loginVm.password, function (response) {
                if (response.success) {
                    AuthenticationService.SetCredentials(loginVm.username, loginVm.password);
                    $location.path('/');
                } else {
                    FlashService.Error(response.message);
                    loginVm.dataLoading = false;
                }
            });
        };
    }

})();