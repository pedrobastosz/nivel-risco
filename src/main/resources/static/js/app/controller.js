'use strict';

angular.module('crudApp').controller('controller',
    ['service', '$scope',  function( service, $scope) {

        var self = this;
        self.registro = {};
        self.registros=[];

        self.submit = submit;
        self.getAll = getAll;
        self.create = create;
        self.remove = remove;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        function submit() {
            console.log('Salvando novo registro', self.registro);
            create(self.registro);
        }

        function create(user) {
            service.create(user)
                .then(
                    function (response) {
                        console.log('Registro criado com sucesso');
                        self.successMessage = 'Registro criado com sucesso';
                        self.errorMessage='';
                        self.done = true;
                        self.registro={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Erro ao criar registro');
                        self.errorMessage = 'Erro ao criar registro: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function remove(user){
            service.remove(user)
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

        function getAll(){
            return service.getAll();
        }

        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.registro={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);