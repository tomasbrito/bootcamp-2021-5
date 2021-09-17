@bootcamp4
Feature: Busqueda en Google
  Como usuario web,
  Quiero buscar en Google
  Para reponder mis dudas.

  @test
  Scenario: Busqueda Simple en youtube
    Given estoy en un navegador con la pagina inicial de youtube
    When introduzco la palabra "musica" en la barra
    And realizo la busqueda con el boton buscar
    Then el navegador me muestra los resultados
