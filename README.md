# Example project using Spring-Dotenv

1. Look at build.gradle.kts

```kotlin
dependencies {
    implementation(platform("me.paulschwarz:spring-dotenv-bom:5.0.1"))
    developmentOnly("me.paulschwarz:springboot4-dotenv")
}
```

2. Look at resources/application.yml

```yaml
app:
  message: ${APP_MESSAGE:Hello from application.yml}
  repeat: ${APP_REPEAT:4}
```

3. Look at .env.example

```dotenv
APP_MESSAGE=Hello from .env
APP_REPEAT=10
```

4. Look at .gitignore

Never commit .env to source control. It's not part of your *code*, it's just a local convenience for having environment variables and system properties configured to test and run your application during local development. It is *not* a substitute for environment variables/system properties on a running server!

```gitignore
### Local only ###
.env
```

**Note** that this .env.example does absolutely nothing until you copy/paste it to a file called `.env` which you can place in the root of your project.