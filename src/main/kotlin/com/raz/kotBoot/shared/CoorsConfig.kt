package com.raz.kotBoot.shared

@Configuration
class DatabaseConfig {
    @Bean
    public fun corsConfigurer(): WebMvcConfigurer {
        return WebMvcConfigurer() {
    
            @Override
            public fun addCorsMappings(CorsRegistry registry): Void {
                registry.addMapping("/api/v1/").allowedOrigins("http://localhost:8080")
            }
        }
    }
}