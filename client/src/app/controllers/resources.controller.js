(function() {
    'use strict';

    angular.module('plunker')
        .controller('ResourcesController', ResourcesController);

    ResourcesController.$inject = [];

    function ResourcesController() {
        var resourcesVm = this;

        init();

        function init() {
            console.log('ResourcesController');
        }
    }

})();