verduleriaApp

REST API

Proyecto Final de la Diplomatura en Desarrollo de Aplicaciones con Spring Boot (08/2023) - (12/2023)

Características de la Tienda de Verduras:

    * Venta por Bolsones (packs / promos)
    * Lunes | Miércoles | Viernes 
      (en horario a establecer automáticamente, de mañana/mediodía)
    * Toma de pedidos virtual, en día anterior (hasta 19/20hs)
    * Máximo de pedidos en un día: 15/20 pedidos.
    * Si el pedido se hace cuando ya se excedió la cantidad máxima,
     el Cliente decide si selecciona el siguiente día de entrega.
    * (Eventual: si Miercoles excede la cantidad, 
     opcional agregar dia de entrega Jueves)

Usuarios que usan la app: 
* ADMIN
* EMPLEADO1   
* EMPLEADO2
* CLIENTE

Principales características / necesidades de cada usuario:

ADMIN
* Suma de cantidades 
    (detalle de cuanto hay que comprar
     para siguiente entrega)
* CRUD de Stock
* Generar un mapa del recorrido de pedidos
* Obtener suma de ingresos brutos
    (de todos los combos vendidos)
    -Deducir gastos del Proveedor
     (lo comprado)
* Obtener ganancia neta

EMPLEADO1
(armador de combos)
* Ver cantidades a armar y nombres Cliente
* Actualizar stock

EMPLEADO2 
(repartidor)
* Ver nombre Cliente
* Ver Productos del Cliente
* Ver Metodo de pago
    (si fue transferencia
     o es en efectivo)
* Ver horario de entrega estimado

CLIENTE
* Seleccionar el Bolsón
* Indicar Dirección
    (Horario se asigna automáticamente)
* Indicar Método de pago


( Más info en DiagramaDeProyecto.pdf )












