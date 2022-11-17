fun Ej2del11() {
    val listC = mutableListOf<Contenedor>()
    do {
        println("***BIENVENIDO AL SISTEMA DE GESTIÓN DE CONTENEDORES DE PUNTO DE VALENCIA***")
        println("¿Que opción desea?")
        println("1)Carga de un contenedor")
        println("2)Descarga de un contenedor")
        println("3)Numero y estado de los contenedores")
        print("Introduzca una opción por favor: ")
        var opcion: String? = readLine()
        if (opcion == "1") {
            do {


                println("***BIENVENIDO AL PROGRAMA DE CARGA DE CONTENEDORES***")
                print("Introduzca país de origen: ")
                var paisO: String? = readLine()
                var paisOrigen: String = paisO.toString()
                print("Introduzca país de destino: ")
                var paisD: String? = readLine()
                var paisDestino: String = paisD.toString()

                val cT = Contenedor(paisOrigen, paisDestino, Estados.TRANSITO)


                listC.add(cT)
                println("CONTENEDOR CARGADO CON EXITO")

                var salir0: Boolean = false
                print("¿Desea seguir cargando contenedores(S/N)? ")
                var conf: String? = readLine()
                if (conf == "N") {
                    salir0 = true
                }
            } while (!salir0)

        } else if (opcion == "2") {
            do {
                print("Introduzca el numero del contenedor que desea descargar: ")
                var tmp: String = readLine().toString()
                var numC: Int = tmp.toInt()
                println("***DESCARGANDO CONTENEDOR***")
                print("Seleccione la causa(RETENIDO/ENTREGADO): ")
                var causa: String? = readLine()
                if (causa == "RETENIDO") {
                    for ((c,a) in listC.withIndex()) {
                        if (numC == c) {
                            a.estado = Estados.RETENIDO
                            break
                        } else {
                            println("NUMERO DE CONTENEDOR NO EXISTENTE")
                        }
                    }
                } else if (causa == "ENTREGADO") {
                    print("¿Desea eliminar el contenedor?: ")
                    var tmp: String = readLine().toString()
                    if (tmp == "S" || tmp == "s") {
                        try {
                            listC.removeAt(numC)
                        } catch (e: ArrayIndexOutOfBoundsException) {
                            println("NO SE PUEDE ELIMINAR")
                        }
                    }
                }
                var salir2: Boolean = false
                print("Desea seguir haciendo operaciones(S/N)? ")
                var tmp3: String? = readLine()
                var resp: String = tmp3.toString()
                if (resp == "N") {
                    salir2 = true
                }
            } while (!salir2)
        } else if (opcion == "3") {
            for (c in listC) {
                c.ImprimirC()
            }

        } else {
            println("ERROR,OPCION NO DISPONIBLE")
        }
        var salir: Boolean = false
        print("¿Desea seguir consultando(S/N)? ")
        var conf: String? = readLine()
        if (conf == "N" || conf == "n") {
            salir = true
        }
    } while (!salir)
}

