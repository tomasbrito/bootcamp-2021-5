# gherkin -> lenguaje de especificacion
# sintaxis, semantica
  Feature: Busqueda en Viajes falabella
    Como usuario web,
    Quiero buscar en viajes falabella
    Para recordarme poner las fechas.

  @test
  Scenario: No hay fefchas ingresadas
    Given estoy en un navegador con la pagina inicial de viajes falabella en la seccion Vuelo Auto
    When introduzco la palabra "cordoba" en la barra de origen
    And introduzco la palabra "rosario" en la barra de destino
    And realizo la busqueda aprentando el boton buscar
    Then el navegador me muestra un mensaje en los campos de fecha