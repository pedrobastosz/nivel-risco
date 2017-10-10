'use strict';

angular.module('crudApp').factory('service',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAll: loadAll,
                getAll: getAll,
                getUser: getUser,
                createUser: createUser,
                removeUser: removeUser
            };

            return factory;

            function loadAll() {
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API)
                    .then(
                        function (response) {
                            $localStorage.registros = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAll(){
                var temp = $localStorage.registros;
                return temp;
            }

            function getUser(id) {
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createUser(user) {
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API, user)
                    .then(
                        function (response) {
                            loadAll();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Erro ao criar registror : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeUser(registro) {
                var deferred = $q.defer();
                $http.delete(urls.USER_SERVICE_API + "/" + registro.nome + "/" + registro.limiteCredito + "/" + registro.tipoRisco)
                    .then(
                        function (response) {
                            loadAll();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);