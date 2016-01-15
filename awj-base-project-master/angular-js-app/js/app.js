var app = angular.module('blog', [ ]);

app.controller('HomeController', ['$scope', function($scope) {
  $scope.helloWorld = 'Aplicatii Web cu suport Java!';

}]);

var url = "http://localhost:8080/persoana";
   $scope.persoane = [];
   $scope.keys = [];
  $scope.obj={};
   $scope.person = {};
   $scope.editPersoana = {};

   $scope.animale = [];
   $scope.keys = [];
  $scope.obj={};
   $scope.animal = {};
   $scope.editAnimale = {};

   $scope.carti = [];
   $scope.keys = [];
  $scope.obj={};
   $scope.carte = {};
   $scope.editCarti = {};

 
 
 
   $http.get('http://localhost:8080/persoana').then(
     function successCallback(response) {
    $scope.obj=response;
     $scope.persoane = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addPersoana = function(persoana) {
        persoana.id = parseInt(persoana.id);
        console.log(persoana.id);
        $http({
            method: 'POST',
            url: url,
            data: persoana
        }).then(function successCallback(response) {
            console.log(response);
            $scope.persoane.push(persoana);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deletePersoana = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.persoane = $scope.persoane.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdatePerson = function(person) {
        $scope.editPersoana = person;
    };


    $scope.updatePersoana = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editPersoana
        }).then(function successCallback(response) {
            $scope.editPersoana = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editPersoana = {};
            console.log(response);
        });
    };
  }]);

   $http.get('http://localhost:8080/animale').then(
     function successCallback(response) {
    $scope.obj=response;
     $scope.persoane = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addAnimale = function(animale) {
        animale.id = parseInt(animale.id);
        console.log(animale.id);
        $http({
            method: 'POST',
            url: url,
            data: animale
        }).then(function successCallback(response) {
            console.log(response);
            $scope.animale.push(animale);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteAnimale = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.animale = $scope.animale.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateAnimale = function(animal) {
        $scope.editAnimale = animale;
    };


    $scope.updateAnimale = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editAnimale
        }).then(function successCallback(response) {
            $scope.editAnimale = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editAnimale = {};
            console.log(response);
        });
    };
  }]);

   $http.get('http://localhost:8080/persoana').then(
     function successCallback(response) {
    $scope.obj=response;
     $scope.persoane = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addCarti = function(carti) {
        carti.id = parseInt(carti.id);
        console.log(carti.id);
        $http({
            method: 'POST',
            url: url,
            data: carti
        }).then(function successCallback(response) {
            console.log(response);
            $scope.carti.push(carti);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteCarti = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.persoane = $scope.carti.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateCarti = function(carte) {
        $scope.editCarti = carte;
    };


    $scope.updateCarti = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editCarti
        }).then(function successCallback(response) {
            $scope.editCarti = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editCarti = {};
            console.log(response);
        });
    };
  }]);