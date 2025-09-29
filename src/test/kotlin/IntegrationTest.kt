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
        val headers = HttpHeaders()
        headers.set("Accept", "text/html")

        val entity = HttpEntity<String>(headers)

        val response = restTemplate.exchange("http://localhost:$port/", HttpMethod.GET, entity, String::class.java)

        assertThat(response.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
        assertThat(response.body).contains("¡Vaya! Algo salió mal.")
    }

    @Test
    fun testTimeEndpoint() {
        val response = restTemplate.getForEntity("http://localhost:$port/time", TimeDTO::class.java)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).isNotNull
        assertThat(response.body?.time).isNotNull
        assertThat(response.body?.time?.year).isGreaterThan(2000) // Asegurarse de que el año sea razonable
    }
}