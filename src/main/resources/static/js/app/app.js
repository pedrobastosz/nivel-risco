var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/',
    USER_SERVICE_API : 'http://localhost:8080/cadastro/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                
                url: '/',
                templateUrl: 'partials/list',
                controller:'controller',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, service) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        service.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

