/**
 * File: SslServerApplicationTests.java
 * Author: [Kevin Hernandez]
 * Date: [9/28/23]
 * Version: 1.0
 * Description: This file contains unit tests for the SslServerApplication class. 
 *              It uses the Spring Boot testing framework to load the application context and 
 *              ensure that all required beans and dependencies are properly configured.
 */
package com.snhu.sslserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest  // Annotation indicating that this class is a Spring Boot test and should load the application context
class SslServerApplicationTests {

    /**
     * Method: contextLoads
     * Description: This test method ensures that the application context loads successfully 
     *              without any missing beans or dependencies. If the context fails to load, 
     *              this method will throw an exception and the test will fail.
     */
    @Test
    void contextLoads() {
        // The test passes if the application context loads successfully without throwing any exceptions
    }

}
