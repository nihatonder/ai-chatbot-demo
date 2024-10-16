# AI Chatbot Demo

This project is a chatbot application integrated with OpenAI's language model, designed to provide event information and allow users to register for upcoming events. The application features a RESTful API, a web-based chat interface, and services that provide mock data for events and handle event registration.

## Technologies Used
- Java 21 with Spring Boot 3.x
- OpenAI API Integration (Spring AI Library)
- HTML, JavaScript (Axios for HTTP requests), and CSS for the web interface

## Project Structure
- **AIController**: Handles incoming requests to the chatbot, interacts with OpenAI's language model, and returns responses to the web interface.
- **MockEventService**: Provides a list of mock events categorized by type (e.g., Party, Sport, Tech Talk).
- **OpenAIConfig**: Configures the OpenAI function callbacks for upcoming events and event registration.
- **Application**: Entry point for the Spring Boot application.

## Environment Variables
- `SPRING_AI_OPENAI_API_KEY`: Set this environment variable with your OpenAI API key to allow the application to interact with OpenAI services.

## How to Run the Project
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   ```
2. **Navigate to the Project Directory**:
   ```bash
   cd adesso-ai-chatbot
   ```
3. **Build the Project**:
   ```bash
   ./mvnw clean install
   ```
4. **Run the Application**:
   ```bash
   ./mvnw spring-boot:run
   ```
5. **Access the Web Interface**:
    - Open your browser and navigate to `http://localhost:8080`.

## Web Interface
The web interface allows users to interact with the chatbot in a friendly way. Users can:
- Ask about different types of upcoming events.
- Request to register for specific events.

### Example Interactions
- **User**: "What are the party events at adesso?"
    - **Bot**: "The upcoming party events at adesso are: Happy Hour on October 18, 2024, and New Year Party on December 21, 2024."

- **User**: "Register me for the IoT Solutions seminar at adesso."
    - **Bot**: "You have been successfully registered for the IoT Solutions seminar on December 19, 2024, at adesso."