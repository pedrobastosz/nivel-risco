<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Cliente com limite e nivel de risco</span></div>
                <div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Nome do cliente</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.registro.nome" id="nome" class="username form-control input-sm" placeholder="Entre com o nome do cliente" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="age">Valor do limite de crédito</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.registro.limiteCredito" id="limiteCredito" class="form-control input-sm" placeholder="Entre com o valor do limite de crédito" required />
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="salary">Tipo de risco</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.registro.tipoRisco" id="tipoRisco" class="form-control input-sm" placeholder="Entre com o tipo de risco (A, B ou C)" required />
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
                            <div class="col-md-7">
                                <input type="submit"  value="Adicionar" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                                <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Limpar campos</button>
                            </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Lista de clientes com limite e nivel de risco</span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>Nome do cliente</th>
		                <th>Valor do limite de crédito</th>
		                <th>Tipo de risco</th>
		                <th>Valor taxa de juros</th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAll()">
		                <td>{{u.nome}}</td>
		                <td>{{u.limiteCredito}}</td>
		                <td>{{u.tipoRisco}}</td>
                                <td>{{u.taxaJuros}}</td>
		                <td><button type="button" ng-click="ctrl.remove(u)" class="btn btn-danger custom-width">Remover</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>