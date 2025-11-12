# Mock PID API

A simple Spring Boot REST API that provides mock endpoints for user verification and medical check status.

## Endpoints

### 1. Check if User Exists
**POST** `/api/isUser`

Request body:
```json
{
  "email": "user@example.com"
}
```

Response: `true` or `false` (random)

### 2. Check Medical Status
**POST** `/api/userHasMedicalCheck`

Request body:
```json
{
  "email": "user@example.com",
  "medicalCheck": true
}
```

Response: `true` or `false` (random)

## Running Locally

### Using Maven:
```bash
./mvnw spring-boot:run
```

### Using Docker:
```bash
# Build the Docker image
docker build -t mock-pid-api .

# Run the container
docker run -p 8080:8080 mock-pid-api
```

The API will be available at `http://localhost:8080`

## Testing the Endpoints

### Using curl:

```bash
# Test isUser endpoint
curl -X POST http://localhost:8080/api/isUser \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com"}'

# Test userHasMedicalCheck endpoint
curl -X POST http://localhost:8080/api/userHasMedicalCheck \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com","medicalCheck":true}'
```

## Deploying to Render

Render supports both Docker and native Java deployments. The project is configured for both.

### Option 1: Using render.yaml (Recommended)

1. Push your code to GitHub
2. Go to [Render Dashboard](https://dashboard.render.com/)
3. Click "New" → "Blueprint"
4. Connect your GitHub repository
5. Render will automatically detect the `render.yaml` file and configure your service

### Option 2: Manual Setup

1. Push your code to GitHub
2. Go to [Render Dashboard](https://dashboard.render.com/)
3. Click "New" → "Web Service"
4. Connect your GitHub repository
5. Configure the service:
   - **Name**: mock-pid-api
   - **Environment**: Java
   - **Build Command**: `./mvnw clean package -DskipTests`
   - **Start Command**: `java -jar target/mock-pid-api-0.0.1-SNAPSHOT.jar`
   - **Instance Type**: Free (or your preference)
6. Add environment variable:
   - **Key**: `PORT`
   - **Value**: `8080`
7. Click "Create Web Service"

### After Deployment

Your API will be available at: `https://your-service-name.onrender.com`

Test the deployed endpoints:
```bash
curl -X POST https://your-service-name.onrender.com/api/isUser \
  -H "Content-Type: application/json" \
  -d '{"email":"test@example.com"}'
```

## Notes

- The API returns random boolean values for both endpoints
- The `medicalCheck` parameter in the second endpoint is received but not used (as per mock behavior)
- Render's free tier may spin down after inactivity; the first request after inactivity may take longer
