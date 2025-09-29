package es.unizar.webeng.lab2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import es.unizar.webeng.lab2.TimeDTO

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {
    @LocalServerPort
    private var port: Int = 0

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun testHomePage() {
                // Crear encabezado con el tipo de respuesta esperado (HTML)
        val headers = HttpHeaders()
        headers.set("Accept", "text/html")

        // Crear la solicitud con el encabezado configurado
        val entity = HttpEntity<String>(headers)

        // Realizar la solicitud a la ruta /
        val response = restTemplate.exchange("http://localhost:$port/", HttpMethod.GET, entity, String::class.java)

        // Verificar que el código de estado sea 404
        assertThat(response.statusCode).isEqualTo(HttpStatus.NOT_FOUND)

        // Verificar que el cuerpo de la respuesta contenga el mensaje de error de la página error.html
        assertThat(response.body).contains("¡Vaya! Algo salió mal.")
    }
}