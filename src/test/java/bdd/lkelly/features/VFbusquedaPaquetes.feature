Feature: Busqueda en Google
  Como usuario web,
  Quiero buscar un pauquete turistico en Viajes Falabella
  Para reponder mis dudas.

  @test
  Scenario: Busqueda de Paquete Turistico Sin indicar Fecha
    Given estoy en un navegador con la pagina inicial de viajes falabella
    When introduzco "Buenos Aires" en el campo origen
    And  introduzco solo 1 destino "Isla de Pascua" en el campo destino
    And selecciono boton "TodaviaNoElegiFecha"
    And realizo la busqueda presionando el boton Buscar
    Then el navegador me muestra los resultados de busqueda de paquetes a "isla-de-pascua" desde "buenos-aires"

  @test
  Scenario: Busqueda de Paquete Turistico Vuelo Mas Auto
    Given estoy en un navegador con la pagina inicial de viajes falabella
    When selecciono boton "VueloMasAuto"
    And introduzco "Buenos Aires" en el campo origen
    And  introduzco solo 1 destino "Bariloche" en el campo destino
    And seleccionar fecha ida "6" del "12" de "2021"
    And seleccionar fecha vuelta "16" del "12" de "2021"
    And realizo la busqueda presionando el boton Buscar
    Then el navegador me muestra los resultados de vuelos disponibles