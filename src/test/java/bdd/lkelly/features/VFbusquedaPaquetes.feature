Feature: Busqueda en Google
  Como usuario web,
  Quiero buscar un pauquete turistico en Viajes Falabella
  Para reponder mis dudas.

  @test
  Scenario: Busqueda Simple de Paquete Turistico Sin indicar Fecha
    Given estoy en un navegador con la pagina inicial de viajes falabella
    When introduzco "Buenos Aires" en el campo origen
    And  introduzco solo 1 destino "Isla de Pascua" en el campo destino
    And seleccionar Todavía no he decidido la fecha
    And realizo la busqueda presionando el boton Buscar
    Then el navegador me muestra los resultados