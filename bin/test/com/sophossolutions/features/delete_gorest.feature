Feature: Automatizacion de Api Rest
  Yo como aprendiz
  Necesito automatizar la ejecucion de una api
  Para aprender a interactuar con los servicios

  Scenario: Eliminar la información de un usuario con método Delete
    Given "Maria" establece la base url "https://gorest.co.in/" del servicio
    When consulta en el endpoint "public/v2/users/" por id "5612" y elimina la informacion
    Then valida que el status code sea 204
