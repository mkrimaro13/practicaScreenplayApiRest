Feature: Automatizacion de Api Rest
  Yo como aprendiz
  Necesito automatizar la ejecucion de una api
  Para aprender a interactuar con los servicios

  Scenario Outline: Crear un usuario con metodo Post
    Given "Manuela" establece la base url "https://gorest.co.in/" del servicio
    When proporciona la informacion del usuario "public/v2/users/"
      | name   | <name>   |
      | gender | <gender> |
      | email  | <email>  |
      | status | <status> |
    Then valida que la respuesta tenga el nombre "<name>" y el status code sea 201

    Examples:
      | name         | gender | email            | status |
      | asdne | Male   | correo@falso.com | inactive |
      | Carlosqw Perez | Male   | correo1@falso0.com | inactive |