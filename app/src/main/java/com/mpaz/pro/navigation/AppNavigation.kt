package com.mpaz.pro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mpaz.pro.data.Sesion
import com.mpaz.pro.model.Rol
import com.mpaz.pro.ui.screens.LoginScreen
import com.mpaz.pro.ui.screens.RegistroScreen
import com.mpaz.pro.ui.screens.docente.DocAsignarScreen
import com.mpaz.pro.ui.screens.docente.DocInformeScreen
import com.mpaz.pro.ui.screens.docente.DocInicioScreen
import com.mpaz.pro.ui.screens.docente.DocIntentosScreen
import com.mpaz.pro.ui.screens.docente.DocOAScreen
import com.mpaz.pro.ui.screens.docente.DocResultadosScreen
import com.mpaz.pro.ui.screens.estudiante.EstActividadScreen
import com.mpaz.pro.ui.screens.estudiante.EstAsignaturasScreen
import com.mpaz.pro.ui.screens.estudiante.EstContenidoScreen
import com.mpaz.pro.ui.screens.estudiante.EstInicioScreen
import com.mpaz.pro.ui.screens.estudiante.EstPruebaScreen
import com.mpaz.pro.ui.screens.estudiante.EstResultadosScreen
import com.mpaz.pro.ui.screens.utp.UtpDetalleScreen
import com.mpaz.pro.ui.screens.utp.UtpInicioScreen
import com.mpaz.pro.ui.screens.utp.UtpListaScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.LOGIN) {

        // ---------- Acceso ----------
        composable(Rutas.LOGIN) {
            LoginScreen(
                onLoginExitoso = { rol ->
                    val destino = when (rol) {
                        Rol.ESTUDIANTE -> Rutas.EST_INICIO
                        Rol.DOCENTE -> Rutas.DOC_INICIO
                        Rol.UTP -> Rutas.UTP_INICIO
                    }
                    // popUpTo evita volver al login con el boton "atras".
                    navController.navigate(destino) {
                        popUpTo(Rutas.LOGIN) { inclusive = true }
                    }
                },
                onIrARegistro = { navController.navigate(Rutas.REGISTRO) }
            )
        }

        composable(Rutas.REGISTRO) {
            RegistroScreen(
                onRegistrado = { navController.popBackStack() },
                onVolver = { navController.popBackStack() }
            )
        }

        // ---------- Estudiante ----------
        composable(Rutas.EST_INICIO) {
            EstInicioScreen(
                onVerAsignaturas = { navController.navigate(Rutas.EST_ASIGNATURAS) },
                onVerResultados = { navController.navigate(Rutas.EST_RESULTADOS) },
                onCerrarSesion = { cerrarSesion(navController) }
            )
        }
        composable(Rutas.EST_ASIGNATURAS) {
            EstAsignaturasScreen(
                onAbrir = { navController.navigate(Rutas.EST_CONTENIDO) },
                onVolver = { navController.popBackStack() }
            )
        }
        composable(Rutas.EST_CONTENIDO) {
            EstContenidoScreen(
                onActividad = { navController.navigate(Rutas.EST_ACTIVIDAD) },
                onPrueba = { navController.navigate(Rutas.EST_PRUEBA) },
                onVolver = { navController.popBackStack() }
            )
        }
        composable(Rutas.EST_ACTIVIDAD) {
            EstActividadScreen(
                onPrueba = { navController.navigate(Rutas.EST_PRUEBA) },
                onVolver = { navController.popBackStack() }
            )
        }
        composable(Rutas.EST_PRUEBA) {
            EstPruebaScreen(
                onVerResultados = { navController.navigate(Rutas.EST_RESULTADOS) },
                onVolver = { navController.popBackStack() }
            )
        }
        composable(Rutas.EST_RESULTADOS) {
            EstResultadosScreen(onVolver = { navController.popBackStack() })
        }

        // ---------- Docente ----------
        composable(Rutas.DOC_INICIO) {
            DocInicioScreen(
                onObjetivos = { navController.navigate(Rutas.DOC_OA) },
                onAsignar = { navController.navigate(Rutas.DOC_ASIGNAR) },
                onIntentos = { navController.navigate(Rutas.DOC_INTENTOS) },
                onResultados = { navController.navigate(Rutas.DOC_RESULTADOS) },
                onInforme = { navController.navigate(Rutas.DOC_INFORME) },
                onCerrarSesion = { cerrarSesion(navController) }
            )
        }
        composable(Rutas.DOC_OA) {
            DocOAScreen(onVolver = { navController.popBackStack() })
        }
        composable(Rutas.DOC_ASIGNAR) {
            DocAsignarScreen(onVolver = { navController.popBackStack() })
        }
        composable(Rutas.DOC_INTENTOS) {
            DocIntentosScreen(onVolver = { navController.popBackStack() })
        }
        composable(Rutas.DOC_RESULTADOS) {
            DocResultadosScreen(
                onInforme = { navController.navigate(Rutas.DOC_INFORME) },
                onVolver = { navController.popBackStack() }
            )
        }
        composable(Rutas.DOC_INFORME) {
            DocInformeScreen(onVolver = { navController.popBackStack() })
        }

        // ---------- Jefatura UTP ----------
        composable(Rutas.UTP_INICIO) {
            UtpInicioScreen(
                onRevisar = { navController.navigate(Rutas.UTP_LISTA) },
                onCerrarSesion = { cerrarSesion(navController) }
            )
        }
        composable(Rutas.UTP_LISTA) {
            UtpListaScreen(
                onAbrir = { navController.navigate(Rutas.UTP_DETALLE) },
                onVolver = { navController.popBackStack() }
            )
        }
        composable(Rutas.UTP_DETALLE) {
            UtpDetalleScreen(onVolver = { navController.popBackStack() })
        }
    }
}

// Borra la sesion y vuelve al login limpiando el historial de pantallas.
fun cerrarSesion(navController: NavHostController) {
    Sesion.cerrar()
    navController.navigate(Rutas.LOGIN) {
        popUpTo(navController.graph.id) { inclusive = true }
    }
}
