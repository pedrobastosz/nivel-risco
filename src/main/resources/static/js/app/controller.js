'use strict';

angular.module('crudApp').controller('controller',
    ['service', '$scope',  function( service, $scope) {

        var self = this;
        self.user = {};
        self.users=[];

        self.submit = submit;
        self.getAllUsers = getAllUsers;
        self.createUser = createUser;
        self.removeUser = removeUser;
        self.editUser = editUser;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^.*$/;
        self.onlyNumbers = /^.*$/;
        self.somenteLista = /^.*$/;
        
        function submit() {
            console.log('Salvando novo registro', self.user);
            createUser(self.user);
        }

        function createUser(user) {
            console.log('About to create user' + user.nome);
            service.createUser(user)
                .then(
                    function (response) {
                        console.log('Registro criado com sucesso');
                        self.successMessage = 'Registro criado com sucesso';
                        self.errorMessage='';
                        self.done = true;
                        self.user={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Erro ao criar registro');
                        self.errorMessage = 'Erro ao criar registro: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function removeUser(user){
            console.log('About to remove User with id '+ user);
            service.removeUser(user)
                .then(
                    function(){
                        self.successMessage='Registro deletado com sucesso';
                        self.errorMessage='';
                        self.done = true;
                    },
                    function(errResponse){
                        console.error('Erro ao deletar registro');
                        self.errorMessage = 'Erro ao deletar registro: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function getAllUsers(){
            return service.getAllUsers();
        }

        function editUser(id) {
            self.successMessage='';
            self.errorMessage='';
            service.getUser(id).then(
                function (user) {
                    self.user = user;
                },
                function (errResponse) {
                    console.error('Error while removing user ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.user={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);