# gherkin -> lenguaje de especificacion
# sintaxis, semantica
  @bootcamp4
  Feature: Busqueda en Google
    Como usuario web,
    Quiero buscar en Google
    Para reponder mis dudas.

  @test
  Scenario: Busqueda Simple con barra Google
    Given estoy en un navegador con la pagina inicial de google
    When introduzco la palabra "arbol" en la barra
    And realizo la busqueda con Enter
    Then el navegador me muestra los resultados

   @notest
  Scenario: Busqueda Simple con boton Buscar Con Google
    Given estoy en un navegador con la pagina inicial de google
    When introduzco la palabra "arbol" en la barra
    And realizo la busqueda con el boton "Buscar Con Google"
    Then el navegador me muestra los resultados