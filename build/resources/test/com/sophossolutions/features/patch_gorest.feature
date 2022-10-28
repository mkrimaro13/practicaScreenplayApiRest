Feature: Automatizacion de Api Rest
  Yo como aprendiz
  Necesito automatizar la ejecucion de una api
  Para aprender a interactuar con los servicios

  Scenario Outline: Modificar la información de usuario con método Patch
    Given "Luis" establece la base url "https://gorest.co.in/" del servicio
    When consulta en el endpoint "public/v2/users/" por id "88" y propociona la informacion
      | name   | <name>   |
      | status | <status> |
    Then valida que la respuesta tenga el nombre "<name>" y el status "<status>" y el status code sea 200

    Examples:
      | name            | status   |
      | Luis Hernesto   | inactive |